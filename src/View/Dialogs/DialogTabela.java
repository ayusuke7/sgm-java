package View.Dialogs;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogTabela extends javax.swing.JDialog {

    private boolean confirma = false;
    private ArrayList<String> listagem;

    public DialogTabela(java.awt.Frame parent, boolean modal, DefaultTableModel model) {
        super(parent, modal);
        initComponents();
        tabela.setModel(model);
        tabela.getColumnModel().getColumn(0).setMaxWidth(50);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel12 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        lbOK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem");
        setResizable(false);

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jToolBar1.setBackground(new java.awt.Color(53, 59, 72));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Pesquisar");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 17));
        jLabel12.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 17));
        jToolBar1.add(jLabel12);

        txtPesquisa.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtPesquisa.setCaretColor(new java.awt.Color(53, 59, 72));
        txtPesquisa.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        txtPesquisa.setMinimumSize(new java.awt.Dimension(6, 25));
        txtPesquisa.setPreferredSize(new java.awt.Dimension(6, 25));
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });
        jToolBar1.add(txtPesquisa);

        lbOK.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        lbOK.setForeground(new java.awt.Color(255, 255, 255));
        lbOK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Ok_32px_1.png"))); // NOI18N
        lbOK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbOK.setEnabled(false);
        lbOK.setMaximumSize(new java.awt.Dimension(40, 27));
        lbOK.setMinimumSize(new java.awt.Dimension(40, 27));
        lbOK.setPreferredSize(new java.awt.Dimension(40, 27));
        lbOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOKMouseClicked(evt);
            }
        });
        jToolBar1.add(lbOK);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:

        lbOK.setEnabled(true);

        if (evt.getClickCount() > 1) {
            setConfirma(true);
            int index = tabela.getSelectedRow();
            ArrayList lista = new ArrayList();

            for (int i = 0; i < tabela.getColumnCount(); i++) {
                lista.add((String) tabela.getValueAt(index, i));
            }

            setListagem(lista);
            dispose();
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tabela.getRowCount(); i++) {
            String value = tabela.getValueAt(i, 1).toString();
            if (value.toLowerCase().contains(txtPesquisa.getText().toLowerCase())) {
                tabela.changeSelection(i, 0, false, false);
            }
        }
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void lbOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOKMouseClicked
        // TODO add your handling code here:

        if (lbOK.isEnabled()) {
            setConfirma(true);

            int index = tabela.getSelectedRow();
            ArrayList lista = new ArrayList();
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                lista.add((String) tabela.getValueAt(index, i));
            }
            setListagem(lista);
            dispose();
        }


    }//GEN-LAST:event_lbOKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbOK;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtPesquisa;
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

    /**
     * @return the listagem
     */
    public ArrayList getListagem() {
        return listagem;
    }

    /**
     * @param listagem the listagem to set
     */
    public void setListagem(ArrayList listagem) {
        this.listagem = listagem;
    }
}
