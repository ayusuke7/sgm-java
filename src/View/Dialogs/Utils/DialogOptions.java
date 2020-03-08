/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Dialogs.Utils;

import Utils.Propriedades;
import java.awt.Color;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

/**
 *
 * @author AYU7-WN
 */
public class DialogOptions extends javax.swing.JDialog {

    private boolean confirma = false;

    /**
     * Creates new form DialogOption
     *
     * @param parent
     * @param modal
     */
    public DialogOptions(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CarregarConfiguracoes();
    }

    private void CarregarConfiguracoes() {

        Properties propriedades = new Propriedades().loadProperties();
        String barras = propriedades.getProperty("prop.cor.barras", "");
        if (!barras.equals("")) {
            Color cor = Color.decode("#" + barras);
            jPanel1.setBackground(cor);
        }

        String bordas = propriedades.getProperty("prop.cor.bordas", "");
        if (!bordas.equals("")) {
            jPanel1.setBorder(new LineBorder(Color.decode("#" + bordas), 2, true));
        }
    }
    
    public void setTextButtons(String aprove, String cancel) {

        if (aprove == null) {
            jToolBar1.remove(btnSim);
        } else {
            btnSim.setText(aprove);
        }

        if (cancel == null) {
            jToolBar1.remove(btnNao);
        } else {
            btnNao.setText(cancel);
        }
    }

    public void setIconMessage(String mensagem) {
        lbMensagem.setText("<html><center>" + mensagem + "</center></html>");
    }

    public void setIconMessage(ImageIcon imagem, String mensagem) {
        lbMensagem.setText("<html><center>" + mensagem + "</center></html>");
        lbMensagem.setIcon(imagem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMensagem = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnSim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(335, 186));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(53, 59, 72));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        lbMensagem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbMensagem.setForeground(new java.awt.Color(255, 255, 255));
        lbMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMensagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Info_48px.png"))); // NOI18N
        lbMensagem.setText("Mensagem");
        lbMensagem.setIconTextGap(10);

        jToolBar1.setBackground(new java.awt.Color(53, 59, 72));
        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);

        btnSim.setBackground(new java.awt.Color(53, 59, 72));
        btnSim.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnSim.setForeground(new java.awt.Color(255, 255, 255));
        btnSim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Checkmark_32px.png"))); // NOI18N
        btnSim.setText("Sim");
        btnSim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnSim.setMaximumSize(new java.awt.Dimension(150, 45));
        btnSim.setMinimumSize(new java.awt.Dimension(150, 45));
        btnSim.setOpaque(false);
        btnSim.setPreferredSize(new java.awt.Dimension(150, 45));
        btnSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSim);

        jLabel1.setText(" ");
        jLabel1.setMaximumSize(new java.awt.Dimension(10, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(10, 14));
        jToolBar1.add(jLabel1);

        btnNao.setBackground(new java.awt.Color(53, 59, 72));
        btnNao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnNao.setForeground(new java.awt.Color(255, 255, 255));
        btnNao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Close-32.png"))); // NOI18N
        btnNao.setText("Não");
        btnNao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnNao.setMaximumSize(new java.awt.Dimension(150, 45));
        btnNao.setMinimumSize(new java.awt.Dimension(150, 45));
        btnNao.setOpaque(false);
        btnNao.setPreferredSize(new java.awt.Dimension(150, 45));
        btnNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimActionPerformed
        // TODO add your handling code here:
        setConfirma(true);
        this.dispose();
    }//GEN-LAST:event_btnSimActionPerformed

    private void btnNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnNaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNao;
    private javax.swing.JButton btnSim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbMensagem;
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
