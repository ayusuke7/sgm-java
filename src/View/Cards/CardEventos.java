package View.Cards;

import Controller.ControllerGenerico;
import Model.Evento;
import View.Dialogs.Cadastros.DialogEventos;
import javax.sound.midi.ControllerEventListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class CardEventos extends javax.swing.JPanel {

    private final Evento evento;

    public CardEventos(Evento evento) {
        initComponents();
        this.evento = evento;
        lbNome.setText(evento.getNome());
        lbData.setText(evento.getData());
        lbNome.setToolTipText(evento.getData() + " às " + evento.getHora());
    }

    public Evento GetEvento() {
        return evento;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbExcluir = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(124, 149));
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(125, 140));

        lbNome.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        lbNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Schedule_50px.png"))); // NOI18N
        lbNome.setText("Compromisso");
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
        lbData.setText("12/12/2099");

        lbExcluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Cancel_18px.png"))); // NOI18N
        lbExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExcluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNomeMouseClicked
        // TODO add your handling code here:
        DialogEventos dialog = new DialogEventos(new JFrame(), true);
        dialog.SetEvento(evento);
        dialog.setVisible(true);

    }//GEN-LAST:event_lbNomeMouseClicked

    private void lbExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExcluirMouseClicked
        // TODO add your handling code here:

        if (lbExcluir.isEnabled()) {
            ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"));
            int op = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse Evento?\n" + evento.getNome(), "EXCLUIR",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ico);

            if (op == JOptionPane.YES_OPTION) {
                if (new ControllerGenerico().Excluir(evento.getId(), "Id", "Eventos")) {
                    lbNome.setEnabled(false);
                    lbData.setEnabled(false);
                    lbExcluir.setEnabled(false);
                }
            }
        }


    }//GEN-LAST:event_lbExcluirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbExcluir;
    private javax.swing.JLabel lbNome;
    // End of variables declaration//GEN-END:variables
}
