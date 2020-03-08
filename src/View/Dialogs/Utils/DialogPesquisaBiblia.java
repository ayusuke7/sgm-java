/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Dialogs.Utils;

import Controller.ControllerLivros;
import Controller.ControllerVersiculos;
import Model.Livro;
import Model.Renderer.LinhaTableTextArea;
import Model.Versiculo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogPesquisaBiblia extends javax.swing.JDialog {

    private final ControllerLivros contLivros;
    private final ControllerVersiculos contVersos;
    private ArrayList<Livro> livros;
    private ArrayList<Versiculo> versos;

    /**
     * Creates new form DialogPesquisaBiblia
     *
     * @param parent
     * @param modal
     */
    public DialogPesquisaBiblia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.contLivros = new ControllerLivros();
        this.contVersos = new ControllerVersiculos();
        ListarLivros();
    }

    private void ListarLivros() {

        livros = contLivros.Listar();

        DefaultListModel model = new DefaultListModel();

        livros.stream().forEach((l) -> {
            model.addElement(l.getNomeLivro());
        });

        listLivros.setModel(model);

    }

    private void Pesquisar() {

        String sql;

        if (rbCompleto.isSelected()) {
            sql = "SELECT * FROM Versiculos WHERE Descricao LIKE '*" + tfPesquisa.getText() + "*';";
        } else if (rbVelhoTestamento.isSelected()) {
            sql = "SELECT * FROM Versiculos INNER JOIN Livros \n"
                    + "ON Versiculos.Livro = Livros.Livro \n"
                    + "WHERE Livros.testamento='Velho' \n"
                    + "AND Versiculos.Descricao \n"
                    + "LIKE '*" + tfPesquisa.getText() + "*';";
        } else if (rbNovoTestamento.isSelected()) {
            sql = "SELECT * FROM Versiculos INNER JOIN Livros \n"
                    + "ON Versiculos.Livro = Livros.Livro \n"
                    + "WHERE Livros.testamento='Novo' \n"
                    + "AND Versiculos.Descricao \n"
                    + "LIKE '*" + tfPesquisa.getText() + "*';";
        } else {
            sql = "SELECT * FROM Versiculos INNER JOIN Livros \n"
                    + "ON Versiculos.Livro = Livros.Livro \n"
                    + "WHERE Livros.Nome='" + listLivros.getSelectedValue() + "' \n"
                    + "AND Versiculos.Descricao \n"
                    + "LIKE '*" + tfPesquisa.getText() + "*';";
        }

        versos = contVersos.Listar(sql);

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        };

        modelo.addColumn("Versiculos");

        versos.stream().forEach((v) -> {
            modelo.addRow(new Object[]{contLivros.Buscar(v.getLivro()).getNomeLivro() + ", "
                + v.getCapitulo() + " : " + v.getVersiculo() + " - " + v.getTexto()});
        });

        tblaPesquisa.setModel(modelo);
        LinhaTableTextArea linha = new LinhaTableTextArea();
        linha.SetFonte(tblaPesquisa.getFont());
        tblaPesquisa.getColumnModel().getColumn(0).setCellRenderer(new LinhaTableTextArea());
        tblaPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jLabel3.setText("Resultados encontrados: " + versos.size() + " versiculos");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tfPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbCompleto = new javax.swing.JRadioButton();
        rbVelhoTestamento = new javax.swing.JRadioButton();
        rbNovoTestamento = new javax.swing.JRadioButton();
        rbLivros = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listLivros = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblaPesquisa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Avançada");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfPesquisa.setPreferredSize(new java.awt.Dimension(6, 30));
        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Palavras-Chave ou Trecho de Versiculos.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Opções:");

        jLabel3.setText("Resultados encontrados:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rbCompleto.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbCompleto);
        rbCompleto.setSelected(true);
        rbCompleto.setText("Biblia Completa");

        rbVelhoTestamento.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbVelhoTestamento);
        rbVelhoTestamento.setText("Velho Testamento");

        rbNovoTestamento.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbNovoTestamento);
        rbNovoTestamento.setText("Novo Testamento");

        rbLivros.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbLivros);
        rbLivros.setText("Por Livros");
        rbLivros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbLivrosItemStateChanged(evt);
            }
        });

        listLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listLivros.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        listLivros.setVisibleRowCount(22);
        listLivros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listLivrosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listLivros);

        tblaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaPesquisaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblaPesquisa);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(rbVelhoTestamento)
                    .addComponent(rbNovoTestamento)
                    .addComponent(rbLivros)
                    .addComponent(rbCompleto)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbVelhoTestamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNovoTestamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbLivros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbLivrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbLivrosItemStateChanged
        // TODO add your handling code here:
        listLivros.setSelectedIndex(0);
    }//GEN-LAST:event_rbLivrosItemStateChanged

    private void listLivrosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listLivrosValueChanged
        // TODO add your handling code here:

        if (!rbLivros.isSelected()) {
            rbLivros.setSelected(true);
        }
    }//GEN-LAST:event_listLivrosValueChanged

    private void tblaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaPesquisaMouseClicked
        // TODO add your handling code here:
        
        if (evt.getClickCount() > 1) {

            int index = tblaPesquisa.getSelectedRow();
            Livro liv = contLivros.Buscar(versos.get(index).getLivro());
            DialogBiblia biblia = new DialogBiblia(null, true);
            biblia.Selecionar(liv, versos.get(index));
            ///this.dispose();
            biblia.setVisible(true);
            
           
        }
    }//GEN-LAST:event_tblaPesquisaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!tfPesquisa.getText().equals("")) {
            Pesquisar();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        // TODO add your handling code here:
        if (!tfPesquisa.getText().equals("")) {
            Pesquisar();
        }
    }//GEN-LAST:event_tfPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listLivros;
    private javax.swing.JRadioButton rbCompleto;
    private javax.swing.JRadioButton rbLivros;
    private javax.swing.JRadioButton rbNovoTestamento;
    private javax.swing.JRadioButton rbVelhoTestamento;
    private javax.swing.JTable tblaPesquisa;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
