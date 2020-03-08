package View.Dialogs.Utils;

import Utils.Propriedades;
import View.Dialogs.Cadastros.DialogPatrimonios;
import View.Dialogs.Cadastros.DialogEventos;
import View.Dialogs.Cadastros.DialogMembros;
import View.Dialogs.Cadastros.DialogCargosMinst;
import View.Dialogs.Cadastros.DialogIgrejas;
import View.Dialogs.Cadastros.DialogUsuarios;
import java.awt.Color;
import java.awt.Frame;
import java.util.Properties;
import javax.swing.border.LineBorder;

/**
 *
 * @author AYU7-WN
 */
public final class DialogLoading extends javax.swing.JDialog {

    public DialogLoading(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DialogLoading(Frame parent, boolean modal, String dialog) {
        super(parent, modal);
        initComponents();
        Thread tr = new Thread() {
            @Override
            public void run() {
                switch (dialog) {
                    case "Igrejas":
                        DialogIgrejas igrejas = new DialogIgrejas(parent, true);
                        dispose();
                        igrejas.setVisible(true);
                        break;
                    case "Membros":
                        DialogMembros membros = new DialogMembros(parent, true);
                        dispose();
                        membros.setVisible(true);
                        break;
                    case "Patrimonios":
                        DialogPatrimonios patri = new DialogPatrimonios(parent, true);
                        dispose();
                        patri.setVisible(true);
                        break;
                    case "Usuarios":
                        DialogUsuarios usuario = new DialogUsuarios(parent, true);
                        dispose();
                        usuario.setVisible(true);
                        break;
                    case "Eventos":
                        DialogEventos eventos = new DialogEventos(parent, true);
                        dispose();
                        eventos.setVisible(true);
                        break;
                    case "Cargos":
                        DialogCargosMinst cargos = new DialogCargosMinst(parent, true);
                        dispose();
                        cargos.setVisible(true);
                        break;
                    default:
                        dispose();
                        break;
                }
            }
        };
        tr.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/loading.gif"))); // NOI18N
        jLabel1.setText("Carregando");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
