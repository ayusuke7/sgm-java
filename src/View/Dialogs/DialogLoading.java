package View.Dialogs;

import java.awt.Frame;

/**
 *
 * @author AYU7-WN
 */
public final class DialogLoading extends javax.swing.JDialog {

    
    public DialogLoading(Frame parent, boolean modal){
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

        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jProgressBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 2, true));
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setString("Carregando...");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

}
