package View.Dialogs.Cadastros;

import Controller.ControllerCargos;
import Controller.ControllerGenerico;
import Model.Renderer.DataSetTableModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogCargosMinst extends javax.swing.JDialog {

    private final ControllerCargos cont;
    private final ControllerGenerico gen;

    public DialogCargosMinst(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ListarTabelas();
        cont = new ControllerCargos();
        gen = new ControllerGenerico();
    }

    private void CadastrarRegistro(String tabela) {

        ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"));
        String value = (String) JOptionPane.showInputDialog(null, "Adicionar em " + tabela, "CADASTRAR",
                JOptionPane.OK_CANCEL_OPTION, ico, null, null);

        if (value != null && !value.equals("")) {
            if (cont.Cadastrar(value, tabela)) {
                ListarTabelas();
            }
        }

    }

    private void ExcluirRegistro() {

        if (jTable1.getSelectedColumnCount() > 0) {

            int index = jTable1.getSelectedRow();
            String id = (String) jTable1.getValueAt(index, 0);
            String cargo = (String) jTable1.getValueAt(index, 1);

            ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"));
            int op = JOptionPane.showConfirmDialog(null, "Deseja Excluir " + cargo, "EXCLUIR",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ico);

            if (op == JOptionPane.YES_OPTION) {
                if (gen.Excluir(Integer.parseInt(id), "Id", "Cargos")) {
                    ListarTabelas();
                }
            }

        } else if (jTable2.getSelectedColumnCount() > 0) {

            int index = jTable2.getSelectedRow();
            String id = (String) jTable2.getValueAt(index, 0);
            String minist = (String) jTable2.getValueAt(index, 1);

            ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"));
            int op = JOptionPane.showConfirmDialog(null, "Deseja Excluir " + minist, "EXCLUIR",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ico);

            if (op == JOptionPane.YES_OPTION) {
                if (gen.Excluir(Integer.parseInt(id), "Id", "Ministerios")) {
                    ListarTabelas();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Registro", "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void EditarRegistro() {

        if (jTable1.getSelectedRowCount() > 0) {

            int index = jTable1.getSelectedRow();
            String id = (String) jTable1.getValueAt(index, 0);
            String cargo = (String) jTable1.getValueAt(index, 1);

            ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"));
            String value = (String) JOptionPane.showInputDialog(null, "Cargo: " + cargo,
                    "EDITAR", JOptionPane.QUESTION_MESSAGE, ico, null, cargo);

            if (value != null && !value.equals("") && !value.equals(cargo)) {
                if (cont.Editar(Integer.parseInt(id), value, "Cargos")) {
                    ListarTabelas();
                }
            }

        } else if (jTable2.getSelectedRowCount() > 0) {

            int index = jTable2.getSelectedRow();
            String id = (String) jTable2.getValueAt(index, 0);
            String minist = (String) jTable2.getValueAt(index, 1);

            ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"));
            String value = (String) JOptionPane.showInputDialog(null, "Ministerio: " + minist,
                    "EDITAR", JOptionPane.QUESTION_MESSAGE, ico, null, minist);

            if (value != null && !value.equals("") && !value.equals(minist)) {
                if (cont.Editar(Integer.parseInt(id), value, "Ministerios")) {
                    ListarTabelas();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Registro", "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void ListarTabelas() {

        DefaultTableModel model1 = DataSetTableModel.Tabela("SELECT Id, Nome FROM Cargos");

        jTable1.setModel(model1);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);

        DefaultTableModel model2 = DataSetTableModel.Tabela("SELECT Id, Nome FROM Ministerios");

        jTable2.setModel(model2);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(40);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargos e Ministerios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(7);
        jSplitPane1.setOneTouchExpandable(true);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cargos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jSplitPane1.setTopComponent(jScrollPane1);

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ministérios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastrar");

        jMenuItem4.setText("Ministérios");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Cargos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem5.setText("Editar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem6.setText("Excluir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTable2.clearSelection();
        if (evt.getClickCount() > 1) {
            EditarRegistro();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jTable1.clearSelection();
        if (evt.getClickCount() > 1) {
            EditarRegistro();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        EditarRegistro();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        jTable2.clearSelection();
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        jTable1.clearSelection();
    }//GEN-LAST:event_jTable2MouseReleased

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        ExcluirRegistro();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        CadastrarRegistro("Cargos");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        CadastrarRegistro("Ministerios");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
