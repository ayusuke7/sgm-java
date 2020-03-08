package View.Dialogs.Utils;

import Model.Renderer.CustomComboBox;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author AYU7-WN
 */
public class DialogFonts extends javax.swing.JDialog {

    
    private boolean confirma = false;
    private Font selecioFont;

    /**
     * Creates new form DialogFonts
     * @param parent
     * @param modal
     */
    public DialogFonts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ListarFontes();
        cbEstilo.setRenderer(new CustomComboBox());
        cbFontes.setRenderer(new CustomComboBox());
    }
    
    private void Selecionar(){
        
        String nome = cbFontes.getSelectedItem().toString();
        int estilo  = cbEstilo.getSelectedIndex();
        int taman   = (int) spnTamanho.getValue();
        
        Font f = new Font(nome, estilo, taman);
        jTextField1.setFont(f);
        
    }

    private void ListarFontes(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fonts[] = ge.getAvailableFontFamilyNames();

        //Lista Fontes
        for (String f : fonts) {
            cbFontes.addItem(f);
        }

    }
    
    public void SetarFonte(Font font){
        cbFontes.setSelectedItem(font.getName());
        cbEstilo.setSelectedIndex(font.getStyle());
        spnTamanho.setValue(font.getSize());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        cbFontes = new javax.swing.JComboBox<>();
        cbEstilo = new javax.swing.JComboBox<>();
        spnTamanho = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fontes");
        setResizable(false);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        cbFontes.setMaximumSize(new java.awt.Dimension(200, 40));
        cbFontes.setPreferredSize(new java.awt.Dimension(200, 40));
        cbFontes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFontesItemStateChanged(evt);
            }
        });
        jToolBar1.add(cbFontes);

        cbEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Negrito", "Italico" }));
        cbEstilo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstiloItemStateChanged(evt);
            }
        });
        jToolBar1.add(cbEstilo);

        spnTamanho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spnTamanho.setModel(new javax.swing.SpinnerNumberModel(18, 8, 72, 2));
        spnTamanho.setMaximumSize(new java.awt.Dimension(60, 40));
        spnTamanho.setPreferredSize(new java.awt.Dimension(60, 40));
        spnTamanho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnTamanhoStateChanged(evt);
            }
        });
        jToolBar1.add(spnTamanho);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Ok_32px_1.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Configuração de Fonte ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setConfirma(true);
        setSelecioFont(jTextField1.getFont());
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbFontesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFontesItemStateChanged
        // TODO add your handling code here:
        Selecionar();
    }//GEN-LAST:event_cbFontesItemStateChanged

    private void cbEstiloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstiloItemStateChanged
        // TODO add your handling code here:
        Selecionar();
    }//GEN-LAST:event_cbEstiloItemStateChanged

    private void spnTamanhoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTamanhoStateChanged
        // TODO add your handling code here:
        Selecionar();
    }//GEN-LAST:event_spnTamanhoStateChanged

    public boolean isConfirma() {
        return confirma;
    }

    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEstilo;
    private javax.swing.JComboBox<String> cbFontes;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JSpinner spnTamanho;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the selecioFont
     */
    public Font getSelecioFont() {
        return selecioFont;
    }

    /**
     * @param selecioFont the selecioFont to set
     */
    public void setSelecioFont(Font selecioFont) {
        this.selecioFont = selecioFont;
    }

 
}
