package View.Cards;

/**
 *
 * @author AYU7-WN
 */
public class CardAvisos extends javax.swing.JPanel {

    public CardAvisos(String aviso) {
        initComponents();
        lbNome.setText(aviso);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setMaximumSize(new java.awt.Dimension(124, 149));

        lbNome.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        lbNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Attention_32px.png"))); // NOI18N
        lbNome.setText("Aviso");
        lbNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNome.setIconTextGap(10);
        lbNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbNomeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbNome;
    // End of variables declaration//GEN-END:variables
}
