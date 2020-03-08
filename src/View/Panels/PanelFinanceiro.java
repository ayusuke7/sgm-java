package View.Panels;

import Controller.ControllerIgrejas;
import Controller.ControllerRelatorios;
import Model.Igreja;
import Model.Renderer.CustomComboBox;
import Model.Renderer.DataSetTableModel;
import View.Dialogs.Cadastros.DialogDizimos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class PanelFinanceiro extends javax.swing.JPanel {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final ControllerRelatorios relat;

    private ArrayList<Igreja> igrejas;
    private final String data;

    /**
     * Creates new form PanelFinanceiro
     */
    public PanelFinanceiro() {
        initComponents();
        ListarIgrejas();
        relat = new ControllerRelatorios();
        data = df.format(new Date());
        int mes = Integer.parseInt(data.substring(3, 5));
        lstMeses.setSelectedIndex(mes);
        cbIgrejas1.setRenderer(new CustomComboBox());
    }

    private void ListarIgrejas() {

        ControllerIgrejas ig = new ControllerIgrejas();
        igrejas = ig.Listar();

        if (!igrejas.isEmpty()) {
            igrejas.stream().forEach((i) -> {
                cbIgrejas1.addItem(i.getNome());
            });

            btnImprimir.setEnabled(true);
            jButton5.setEnabled(true);

        }

    }

    private void TabelaDizimoOfertas() {

        if (igrejas.size() > 0) {
            int IdIgreja = igrejas.get(cbIgrejas1.getSelectedIndex()).getId();
            int index = lstMeses.getSelectedIndex();

            String sql;

            if (lstMeses.getSelectedIndex() > 0) {

                String mesAno = index + "/" + jYearChooser1.getValue();

                if (index <= 9) {
                    mesAno = "0" + index + "/" + jYearChooser1.getValue();
                }

                sql = "SELECT Dizimos.Id, Nome, MesRef, Dizimo, Oferta, IdMembro\n"
                        + "FROM Dizimos INNER JOIN Membros\n"
                        + "ON Dizimos.IdMembro = Membros.Id\n"
                        + "WHERE Membros.IdIgreja=" + IdIgreja + "\n"
                        + "AND MesRef='" + mesAno + "'\n"
                        + "ORDER BY Nome";
            } else {
                sql = "SELECT Dizimos.Id, Nome, MesRef, Dizimo, Oferta, IdMembro\n"
                        + "FROM Dizimos INNER JOIN Membros\n"
                        + "ON Dizimos.IdMembro = Membros.Id\n"
                        + "WHERE Membros.IdIgreja=" + IdIgreja + "\n"
                        + "AND Mid(MesRef, 4) = '" + jYearChooser1.getValue() + "'\n"
                        + "ORDER BY Nome";
            }

            DefaultTableModel model = DataSetTableModel.Tabela(sql);

            if (model.getRowCount() > 0) {
                btnImprimir.setEnabled(true);
            } else {
                btnImprimir.setEnabled(false);
            }

            tabelaDizimos.setModel(model);
            tabelaDizimos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabelaDizimos.getColumnModel().getColumn(1).setPreferredWidth(200);

            CalculaValores();
        }

    }

    private void CalculaValores() {

        double dizimos = 0;
        double ofertas = 0;
        int rows = tabelaDizimos.getRowCount();

        for (int i = 0; i < rows; i++) {

            String tmpDiz = (String) tabelaDizimos.getValueAt(i, 3);
            String tmpOfe = (String) tabelaDizimos.getValueAt(i, 4);

            dizimos += Double.parseDouble(tmpDiz.replace(",", "."));
            ofertas += Double.parseDouble(tmpOfe.replace(",", "."));

        }

        lbLancamentos.setText("Lançametos: "+rows);        
        lbDizimos.setText("Dizimos: R$"+String.format("%.2f", dizimos));
        lbOfertas.setText("Ofertas: R$"+String.format("%.2f", ofertas));
        lbTotal.setText("Total R$: "+String.format("%.2f", (dizimos + ofertas)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbIgrejas1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDizimos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar2 = new javax.swing.JToolBar();
        jButton5 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMeses = new javax.swing.JList<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        lbLancamentos = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        lbDizimos = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        lbOfertas = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jToolBar4 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();

        setBackground(new java.awt.Color(255, 255, 255));

        cbIgrejas1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIgrejas1ItemStateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel16.setText("Financeiro para a Igreja/Congregação:");

        tabelaDizimos.setAutoCreateRowSorter(true);
        tabelaDizimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaDizimos.getTableHeader().setReorderingAllowed(false);
        tabelaDizimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDizimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDizimos);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Plus_32px.png"))); // NOI18N
        jButton5.setText("Novo");
        jButton5.setEnabled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(55, 59));
        jButton5.setMinimumSize(new java.awt.Dimension(55, 59));
        jButton5.setPreferredSize(new java.awt.Dimension(55, 59));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        btnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimir.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Print_32px.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setMaximumSize(new java.awt.Dimension(55, 59));
        btnImprimir.setMinimumSize(new java.awt.Dimension(55, 59));
        btnImprimir.setPreferredSize(new java.awt.Dimension(55, 59));
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jToolBar2.add(btnImprimir);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setText("Lançamentos de:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Bank_32px.png"))); // NOI18N
        jLabel1.setText("<html><p align=\"justify\"><b> Môdulo Financeiro:</b> Lançamento de Dizimos e Ofertas referentes as meses de arrecadação para a geração de relatórios mensais e anuais da Instituiação referente.</p></html>");
        jLabel1.setIconTextGap(10);

        lstMeses.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "TODO O PERIODO", "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstMeses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMeses.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstMesesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstMeses);

        jYearChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearChooser1PropertyChange(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(0, 51, 153));
        jToolBar1.setFloatable(false);
        jToolBar1.setMaximumSize(new java.awt.Dimension(1072, 30));
        jToolBar1.setMinimumSize(new java.awt.Dimension(222, 30));
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel2.setMaximumSize(new java.awt.Dimension(800, 14));
        jToolBar1.add(jLabel2);

        lbLancamentos.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        lbLancamentos.setForeground(new java.awt.Color(255, 255, 255));
        lbLancamentos.setText("Lançamentos: 0");
        lbLancamentos.setMaximumSize(new java.awt.Dimension(150, 20));
        lbLancamentos.setMinimumSize(new java.awt.Dimension(100, 17));
        lbLancamentos.setPreferredSize(new java.awt.Dimension(120, 17));
        jToolBar1.add(lbLancamentos);

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToolBar1.add(jSeparator4);

        lbDizimos.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        lbDizimos.setForeground(new java.awt.Color(255, 255, 255));
        lbDizimos.setText("Dizimos: 0,00");
        lbDizimos.setMaximumSize(new java.awt.Dimension(150, 20));
        lbDizimos.setMinimumSize(new java.awt.Dimension(100, 17));
        lbDizimos.setPreferredSize(new java.awt.Dimension(100, 17));
        jToolBar1.add(lbDizimos);

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToolBar1.add(jSeparator5);

        lbOfertas.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        lbOfertas.setForeground(new java.awt.Color(255, 255, 255));
        lbOfertas.setText("Ofertas: 0,00");
        lbOfertas.setMaximumSize(new java.awt.Dimension(150, 20));
        lbOfertas.setPreferredSize(new java.awt.Dimension(100, 17));
        jToolBar1.add(lbOfertas);

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToolBar1.add(jSeparator6);

        jToolBar4.setBackground(new java.awt.Color(0, 102, 51));
        jToolBar4.setFloatable(false);
        jToolBar4.setMaximumSize(new java.awt.Dimension(2, 30));
        jToolBar4.setMinimumSize(new java.awt.Dimension(2, 30));
        jToolBar4.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel4.setToolTipText("");
        jLabel4.setMaximumSize(new java.awt.Dimension(800, 14));
        jToolBar4.add(jLabel4);

        lbTotal.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(255, 255, 255));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("Total R$ Geral: 0,00");
        lbTotal.setMaximumSize(new java.awt.Dimension(200, 21));
        lbTotal.setMinimumSize(new java.awt.Dimension(150, 21));
        lbTotal.setPreferredSize(new java.awt.Dimension(120, 21));
        jToolBar4.add(lbTotal);

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToolBar4.add(jSeparator7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(cbIgrejas1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(2, 2, 2)
                .addComponent(cbIgrejas1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbIgrejas1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIgrejas1ItemStateChanged
        // TODO add your handling code here:
        TabelaDizimoOfertas();
    }//GEN-LAST:event_cbIgrejas1ItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        int IdIgreja = igrejas.get(cbIgrejas1.getSelectedIndex()).getId();
        DialogDizimos dialog = new DialogDizimos(null, true, IdIgreja);
        dialog.SelecionarMes(lstMeses.getSelectedIndex(), jYearChooser1.getValue());
        dialog.setVisible(true);

        if (dialog.isConfirma()) {
            TabelaDizimoOfertas();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:

        int mes = lstMeses.getSelectedIndex();
        int IdIgreja = igrejas.get(cbIgrejas1.getSelectedIndex()).getId();

        if (mes > 0) {
            String mesAno = mes + "/" + jYearChooser1.getValue();
            if (mes <= 9) {
                mesAno = "0" + mes + "/" + jYearChooser1.getValue();
            }
            relat.relatorioDizimos(IdIgreja, mesAno);
        } else {
            relat.relatorioDizimos(IdIgreja, jYearChooser1.getValue());
        }


    }//GEN-LAST:event_btnImprimirActionPerformed

    private void lstMesesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMesesValueChanged
        // TODO add your handling code here:
        TabelaDizimoOfertas();
    }//GEN-LAST:event_lstMesesValueChanged

    private void jYearChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearChooser1PropertyChange
        // TODO add your handling code here:
        TabelaDizimoOfertas();
    }//GEN-LAST:event_jYearChooser1PropertyChange

    private void tabelaDizimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDizimosMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() > 1) {

            int IdMembro = Integer.parseInt("" + tabelaDizimos.getValueAt(tabelaDizimos.getSelectedRow(), 5));
            int IdIgreja = igrejas.get(cbIgrejas1.getSelectedIndex()).getId();
            DialogDizimos dialog = new DialogDizimos(null, true, IdIgreja);
            dialog.SelecionarMembro(IdMembro);
            dialog.setVisible(true);

        }
    }//GEN-LAST:event_tabelaDizimosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbIgrejas1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar4;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lbDizimos;
    private javax.swing.JLabel lbLancamentos;
    private javax.swing.JLabel lbOfertas;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JList<String> lstMeses;
    private javax.swing.JTable tabelaDizimos;
    // End of variables declaration//GEN-END:variables
}
