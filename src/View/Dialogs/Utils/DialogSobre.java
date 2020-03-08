/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Dialogs.Utils;

import Utils.Propriedades;
import java.awt.Color;
import java.util.Properties;
import javax.swing.border.LineBorder;

/**
 *
 * @author AYU7-WN
 */
public class DialogSobre extends javax.swing.JDialog {

    int eixoX, eixoY;
    /**
     * Creates new form DialogSobre
     * @param parent
     * @param modal
     */
    public DialogSobre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CarregarConfiguracoes();
    }

       
     private void CarregarConfiguracoes() {

        Properties propriedades = new Propriedades().loadProperties();
        String barras = propriedades.getProperty("prop.cor.barras", "");
        if (!barras.equals("")) {
            Color cor = Color.decode("#" + barras);
            toolbarTitulo.setBackground(cor);
            panelBase.setBorder(new LineBorder(cor, 2));
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        toolbarTitulo = new javax.swing.JToolBar();
        lbTitulo = new javax.swing.JLabel();
        lbFinalizar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        toolbarTitulo.setBackground(new java.awt.Color(53, 59, 72));
        toolbarTitulo.setFloatable(false);
        toolbarTitulo.setPreferredSize(new java.awt.Dimension(126, 35));

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("SOBRE");
        lbTitulo.setMaximumSize(new java.awt.Dimension(820, 35));
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

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("<html>SGM, Sistema para Gerenciamento de Igrejas e Congregações. Sistem possui<br/><br/>\n<p><b>Môdulos</b> de cadastro de membros, congregados, pastores, congregações, patrimonios, cargos, ministerios, fichas de aniversariantes e cartas de tranferencias, atas de reuniões e votações. agenda de eventos e etc..</p><br/>\n<p><b>Financeiro:</b> Lançamento de Dizimos e Ofertas por membros e campanhas</p><br/>\n<p><b>Relatórios:</b> Emissão de relatorios diversos de membros, patrimonios, igrejas, dizimos, campanhas e etc...</p></html>");

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTituloMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - eixoY, y - eixoX);
    }//GEN-LAST:event_lbTituloMouseDragged

    private void lbTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTituloMousePressed
        // TODO add your handling code here:
        eixoY = evt.getX();
        eixoX = evt.getY();
    }//GEN-LAST:event_lbTituloMousePressed

    private void lbFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFinalizarMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lbFinalizarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelBase;
    private javax.swing.JToolBar toolbarTitulo;
    // End of variables declaration//GEN-END:variables
}
