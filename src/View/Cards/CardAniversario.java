package View.Cards;

import Controller.ControllerRelatorios;
import Model.Membro;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class CardAniversario extends javax.swing.JPanel {

    public boolean select = false;
    private final Membro membro;

    public CardAniversario(Membro membro) {
        initComponents();
        this.membro = membro;
        lbNome.setText("<html><p align=\"center\">" + membro.getNome() + "</p></html>");
        lbData.setText(membro.getDtNascimento().substring(0, 5));
        lbNome.setToolTipText(membro.getNome());
    }

    public Membro GetMembro() {
        return membro;
    }

    public void MostrarDados() {

        String dados = "Nome: " + membro.getNome()
                + "\nData Nascimento: " + membro.getDtNascimento()
                + "\nGenero: " + membro.getGenero()
                + "\nEstado Civil: " + membro.getEstadoCivil()
                + "\nContatos: " + membro.getContatos()
                + "\nEmail: " + membro.getEmail()
                + "\nEndereco: " + membro.getEndereco()
                + "\nBairro: " + membro.getBairro()
                + "\nCidade/UF: " + membro.getCidade() + " - " + membro.getEstado()
                + "\nComplemento: " + membro.getComplemento()
                + "\nSituação: " + membro.getSituacao();

        JOptionPane.showMessageDialog(null, dados, "INFORMACÕES", JOptionPane.INFORMATION_MESSAGE);

    }

    public void ImprimirCartao() {

        int op = JOptionPane.showConfirmDialog(null, "EMITIR CARTÃO DE ANIVERSÁRIO?",
                "CARTÃO DE ANIVERSARIO", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            new ControllerRelatorios().fichaAniversariante(membro.getId());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(150, 172));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(125, 140));

        lbNome.setFont(new java.awt.Font("Microsoft JhengHei", 0, 11)); // NOI18N
        lbNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Gift_64px_1.png"))); // NOI18N
        lbNome.setText("<html><p align=\"center\">Aniversáriante</p></html>");
        lbNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbNome.setIconTextGap(1);
        lbNome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNomeMouseClicked(evt);
            }
        });

        lbData.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbData.setText("12/12");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Print_18px.png"))); // NOI18N
        jLabel2.setToolTipText("Cartão de Aniversário");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(6, 6, 6))
            .addComponent(lbNome)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNomeMouseClicked
        // TODO add your handling code here:
        MostrarDados();
        
    }//GEN-LAST:event_lbNomeMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
       ImprimirCartao();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbNome;
    // End of variables declaration//GEN-END:variables
}
