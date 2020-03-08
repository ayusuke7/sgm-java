package View.Dialogs.Cadastros;

import Controller.ControllerDizimos;
import Controller.ControllerGenerico;
import Model.Lancamento;
import Model.Renderer.DataSetTableModel;
import View.Dialogs.Utils.DialogTabela;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogDizimos extends javax.swing.JDialog {

    private boolean confirma = false;
    private final int IdIgreja;
    private int IdDizimo;

    /**
     * Creates new form DialogDizimos
     *
     * @param parent
     * @param modal
     * @param IdIgreja
     */
    public DialogDizimos(java.awt.Frame parent, boolean modal, int IdIgreja) {
        super(parent, modal);
        initComponents();
        this.IdIgreja = IdIgreja;
    }

    public void SelecionarMembro(int id) {

        ArrayList<String> membro = new ControllerGenerico().Buscar(id, "Id", "Membros");

        if (!membro.isEmpty()) {
            txtNome.setText(membro.get(11));
            btnNovo.setEnabled(true);
            txtCodigo.setText("" + id);
            TabelaDizimoOfertas();
        }
    }

    public void SelecionarMes(int mes, int ano) {
        
        if (mes > 0) {
            cbMeses.setSelectedIndex(mes - 1);
        }
        
        if(!txtCodigo.getText().equals("")){
            jYearChooser1.setValue(ano);
        }
        
    }

    private void TabelaDizimoOfertas() {

        String sql = "SELECT Dizimos.Id, Nome, MesRef, Dizimo, Oferta \n"
                + "FROM Dizimos INNER JOIN Membros \n"
                + "ON Dizimos.IdMembro = Membros.Id \n"
                + "WHERE Membros.Id = " + txtCodigo.getText();

        DefaultTableModel model = DataSetTableModel.Tabela(sql);

        tabela.setModel(model);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);

    }

    private String MesReferente() {

        int index = cbMeses.getSelectedIndex() + 1;

        String mesAno = index + "/" + jYearChooser1.getValue();

        if (index <= 9) {
            mesAno = "0" + index + "/" + jYearChooser1.getValue();
        }

        return mesAno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDizimo = new javax.swing.JFormattedTextField();
        txtOferta = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        cbMeses = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dizimos e Ofertas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("ID / Membro");

        txtNome.setEditable(false);
        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNome.setCaretColor(new java.awt.Color(53, 59, 72));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Plus_24px.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNovo.setEnabled(false);
        btnNovo.setMaximumSize(new java.awt.Dimension(173, 40));
        btnNovo.setOpaque(false);
        btnNovo.setPreferredSize(new java.awt.Dimension(173, 40));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        jLabel15.setText("  ");
        jToolBar1.add(jLabel15);

        btnSalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalvar.setEnabled(false);
        btnSalvar.setMaximumSize(new java.awt.Dimension(120, 40));
        btnSalvar.setMinimumSize(new java.awt.Dimension(80, 39));
        btnSalvar.setOpaque(false);
        btnSalvar.setPreferredSize(new java.awt.Dimension(173, 40));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        jLabel14.setText("  ");
        jToolBar1.add(jLabel14);

        btnExcluir.setBackground(new java.awt.Color(204, 204, 204));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(120, 40));
        btnExcluir.setMinimumSize(new java.awt.Dimension(80, 39));
        btnExcluir.setOpaque(false);
        btnExcluir.setPreferredSize(new java.awt.Dimension(173, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setText("Dizimo");

        txtDizimo.setBackground(new java.awt.Color(255, 255, 204));
        txtDizimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtDizimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDizimo.setText("0,00");
        txtDizimo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        txtOferta.setBackground(new java.awt.Color(255, 255, 204));
        txtOferta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOferta.setText("0,00");
        txtOferta.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel4.setText("Oferta");

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setText("Mês e Ano de Lançamentos");

        jYearChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearChooser1PropertyChange(evt);
            }
        });

        cbMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        cbMeses.setOpaque(false);
        cbMeses.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesesItemStateChanged(evt);
            }
        });

        txtCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(66, 66, 66))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDizimo)
                            .addComponent(txtOferta)
                            .addComponent(cbMeses)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:

        this.setTitle("Cadastrando...");
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
        txtDizimo.setText("0,00");
        txtOferta.setText("0,00");
        txtDizimo.requestFocus();

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        Lancamento lanc = new Lancamento();
        lanc.setIdMembro(Integer.parseInt(txtCodigo.getText()));
        lanc.setMesRef(MesReferente());
        lanc.setDizimo(txtDizimo.getText());
        lanc.setOferta(txtOferta.getText());
        lanc.setIdIgreja(IdIgreja);

        ControllerDizimos cont = new ControllerDizimos();

        if (this.getTitle().contains("Cadastrando...")) {
            if (cont.Cadastrar(lanc)) {
                txtDizimo.setText("0,00");
                txtOferta.setText("0,00");
                TabelaDizimoOfertas();
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
                setConfirma(true);
            }
        } else {
            lanc.setId(IdDizimo);
            if (cont.Editar(lanc)) {
                txtDizimo.setText("0,00");
                txtOferta.setText("0,00");
                TabelaDizimoOfertas();
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
                setConfirma(true);
            }
        }

        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"));
        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir esse Evento", "EXCLUIR",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ico);

        if (op == JOptionPane.YES_OPTION) {
            if (new ControllerGenerico().Excluir(IdDizimo, "Id", "Dizimos")) {
                TabelaDizimoOfertas();
                setConfirma(true);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        

        String sql = "SELECT Id, Nome, Genero, EstadoCivil FROM Membros "
                + "WHERE IdIgreja = " + IdIgreja + " ORDER BY Nome";

        DialogTabela dialog = new DialogTabela(new JFrame(), true, DataSetTableModel.Tabela(sql));
        dialog.TamanhoColunas(new int[]{50, 300, 100});
        dialog.setVisible(true);

        if (dialog.isConfirma()) {
            ArrayList lst = dialog.getListagem();
            txtCodigo.setText((String) lst.get(0));
            txtNome.setText((String) lst.get(1));
            btnNovo.setEnabled(true);
            TabelaDizimoOfertas();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() > 1) {

            this.setTitle("Editando...");
            int index = tabela.getSelectedRow();

            IdDizimo = Integer.parseInt((String) tabela.getValueAt(index, 0));

            String mes = (String) tabela.getValueAt(index, 2);
            txtDizimo.setText((String) tabela.getValueAt(index, 3));
            txtOferta.setText((String) tabela.getValueAt(index, 4));
            int indexMes = Integer.parseInt(mes.substring(0, 2)) - 1;
            cbMeses.setSelectedIndex(indexMes);

            btnSalvar.setEnabled(true);
            btnExcluir.setEnabled(true);

        }


    }//GEN-LAST:event_tabelaMouseClicked

    private void cbMesesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesesItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbMesesItemStateChanged

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(txtCodigo.getText());
        SelecionarMembro(id);
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void jYearChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearChooser1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jYearChooser1PropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbMeses;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDizimo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtOferta;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the confirma
     */
    public boolean isConfirma() {
        return confirma;
    }

    /**
     * @param confirma the confirma to set
     */
    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }
}
