package View.Dialogs.Utils;

import Utils.Propriedades;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogTabela extends javax.swing.JDialog {

    private boolean confirma = false;
    private ArrayList<String> listagem;
    private int eixoXY, eixoXX;

    public DialogTabela(java.awt.Frame parent, boolean modal, DefaultTableModel model) {
        super(parent, modal);
        initComponents();
        tabela.setModel(model);
        lbTitulo.setText("Listagem: " + model.getRowCount() + " registros");

        CarregarConfiguracoes();

    }

    private void CarregarConfiguracoes() {

        Properties propriedades = new Propriedades().loadProperties();
        String barras = propriedades.getProperty("prop.cor.barras", "");
        if (!barras.equals("")) {
            Color cor = Color.decode("#" + barras);
            jToolBar1.setBackground(cor);
            toolbarTitulo.setBackground(cor);
        }

        String bordas = propriedades.getProperty("prop.cor.bordas", "");
        if (!bordas.equals("")) {
            jPanel1.setBorder(new LineBorder(Color.decode("#" + bordas), 2, true));
        }
    }

    private void BuscaNaTabela() {
        for (int i = 0; i < tabela.getRowCount(); i++) {
            String value = tabela.getValueAt(i, 1).toString();
            if (value.toLowerCase().contains(txtPesquisa.getText().toLowerCase())) {
                tabela.changeSelection(i, 0, false, false);
            }
        }
    }

    private void SelecionaRegistro() {
        setConfirma(true);
        int index = tabela.getSelectedRow();
        ArrayList lista = new ArrayList();

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            lista.add((String) tabela.getValueAt(index, i));
        }

        setListagem(lista);
        dispose();
    }

    public void TamanhoColunas(int[] tams) {
        for (int i = 0; i < tams.length; i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(tams[i]);
        }
    }

    public void AutoRedimensionar(int op) {
        tabela.setAutoResizeMode(op);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        toolbarTitulo = new javax.swing.JToolBar();
        lbTitulo = new javax.swing.JLabel();
        lbFinalizar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel12 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        toolbarTitulo.setBackground(new java.awt.Color(53, 59, 72));
        toolbarTitulo.setFloatable(false);

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Titulo");
        lbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        lbTitulo.setMaximumSize(new java.awt.Dimension(510, 35));
        lbTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbTituloMouseDragged(evt);
            }
        });
        lbTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbTituloMousePressed(evt);
            }
        });
        toolbarTitulo.add(lbTitulo);

        lbFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Close_Window_24px.png"))); // NOI18N
        lbFinalizar.setToolTipText("Finalizar");
        lbFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFinalizar.setMaximumSize(new java.awt.Dimension(30, 24));
        lbFinalizar.setMinimumSize(new java.awt.Dimension(30, 24));
        lbFinalizar.setPreferredSize(new java.awt.Dimension(30, 24));
        lbFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFinalizarMouseClicked(evt);
            }
        });
        toolbarTitulo.add(lbFinalizar);

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

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Pesquisar :");
        jLabel12.setMaximumSize(new java.awt.Dimension(80, 17));
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 17));
        jToolBar1.add(jLabel12);

        txtPesquisa.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtPesquisa.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPesquisa.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtPesquisa.setMaximumSize(new java.awt.Dimension(400, 25));
        txtPesquisa.setOpaque(false);
        txtPesquisa.setPreferredSize(new java.awt.Dimension(400, 25));
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jToolBar1.add(txtPesquisa);

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Ok_32px.png"))); // NOI18N
        btnOK.setFocusable(false);
        btnOK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOK.setMaximumSize(new java.awt.Dimension(50, 30));
        btnOK.setMinimumSize(new java.awt.Dimension(50, 30));
        btnOK.setOpaque(false);
        btnOK.setPreferredSize(new java.awt.Dimension(50, 30));
        btnOK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOK);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:

        //btnOK.setEnabled(true);
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
        
        if (tabela.getSelectedRowCount() > 0) {
            SelecionaRegistro();
        }

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:

        if (tabela.getSelectedRowCount() > 0) {
            SelecionaRegistro();
        }

    }//GEN-LAST:event_btnOKActionPerformed

    private void lbFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFinalizarMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lbFinalizarMouseClicked

    private void lbTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTituloMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - eixoXX, y - eixoXY);
    }//GEN-LAST:event_lbTituloMouseDragged

    private void lbTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTituloMousePressed
        // TODO add your handling code here:
        eixoXX = evt.getX();
        eixoXY = evt.getY();
    }//GEN-LAST:event_lbTituloMousePressed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        BuscaNaTabela();
    }//GEN-LAST:event_txtPesquisaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tabela;
    private javax.swing.JToolBar toolbarTitulo;
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
    public ArrayList<String> getListagem() {
        return listagem;
    }

    /**
     * @param listagem the listagem to set
     */
    public void setListagem(ArrayList listagem) {
        this.listagem = listagem;
    }
}
