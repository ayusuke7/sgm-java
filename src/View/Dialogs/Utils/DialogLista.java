package View.Dialogs.Utils;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogLista extends javax.swing.JDialog {

    private ArrayList<String> selecionados;
    private boolean confirma = false;

    public DialogLista(java.awt.Frame parent, boolean modal, ArrayList<String> lista) {
        super(parent, modal);
        initComponents();
      
        DefaultListModel model = new DefaultListModel();
        
        lista.stream().forEach((s) -> {
            model.addElement(s);
        });
        
        jList1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem");
        setResizable(false);

        jToolBar1.setBackground(new java.awt.Color(34, 47, 62));
        jToolBar1.setFloatable(false);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" ");
        jLabel1.setMaximumSize(new java.awt.Dimension(250, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(250, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(250, 14));
        jToolBar1.add(jLabel1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Ok_32px.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(39, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(39, 30));
        jButton1.setOpaque(false);
        jButton1.setPreferredSize(new java.awt.Dimension(39, 30));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ArrayList lista = new ArrayList();

        jList1.getSelectedValuesList().stream().forEach((s) -> {
            lista.add(s);
        });
        
        if (lista.size() > 0) {
            setSelecionados(lista);
            setConfirma(true);
            dispose();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        
        int count = jList1.getSelectedIndices().length;
        
        jLabel1.setText(count+" selecionados");
        
        
    }//GEN-LAST:event_jList1ValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the selecionados
     */
    public ArrayList<String> getSelecionados() {
        return selecionados;
    }

    /**
     * @param selecionados the selecionados to set
     */
    public void setSelecionados(ArrayList<String> selecionados) {
        this.selecionados = selecionados;
    }

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
