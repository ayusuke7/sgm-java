package View.Dialogs.Utils;

import Controller.ControllerLivros;
import Controller.ControllerVersiculos;
import Model.Livro;
import Model.Renderer.CustomComboBox;
import Model.Renderer.LinhaTableTextArea;
import Model.Versiculo;
import View.Forms.FrmApresentador;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogBiblia extends javax.swing.JDialog {

    private final ControllerLivros contLivro;
    private final ControllerVersiculos contVerso;

    private ArrayList<Livro> livros;
    private ArrayList<Versiculo> versos;

    private LinhaTableTextArea linha;
    private Font font;

    private boolean confirma = false;
    private String VersoSelecionado;
    
    /**
     * Creates new form DialogBiblia
     *
     * @param parent
     * @param modal
     */
    public DialogBiblia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        contLivro = new ControllerLivros();
        contVerso = new ControllerVersiculos();

        ListarLivros();
        jComboBox1.setRenderer(new CustomComboBox());
        //setIconImage(IconeAplication.getIcone());

    }

    private void ListarLivros() {

        livros = contLivro.Listar();

        livros.stream().forEach((l) -> {
            jComboBox1.addItem(l.getNomeLivro() + " - " + l.getAbreviacao());
        });

    }

    private void ListarVersiculos() {

        int IdLivro = livros.get(jComboBox1.getSelectedIndex()).getId();
        int Capitulo = (int) jSpinner1.getValue();
        versos = contVerso.Listar(IdLivro, Capitulo);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        model.addColumn("Versiculos");

        versos.stream().forEach((v) -> {
            model.addRow(new Object[]{v.getVersiculo() + " - " + v.getTexto()});
        });

        jTable1.setModel(model);
        if (linha == null) {            
            linha = new LinhaTableTextArea();
            font = jTable1.getFont();
        }
        linha.SetFonte(font);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(linha);

    }

    public void Selecionar(Livro livro, Versiculo verso) {

        jComboBox1.setSelectedItem(livro.getNomeLivro() + " - " + livro.getAbreviacao());
        jSpinner1.setValue(verso.getCapitulo());
        jTable1.changeSelection(verso.getVersiculo() - 1, 0, false, false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemFav = new javax.swing.JMenuItem();
        jMenuItemCop = new javax.swing.JMenuItem();
        jMenuItemSelect = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbNext = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItemFav.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFav.setText("Favoritar");
        jMenuItemFav.setEnabled(false);
        jPopupMenu1.add(jMenuItemFav);

        jMenuItemCop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCop.setText("Copiar");
        jMenuItemCop.setEnabled(false);
        jPopupMenu1.add(jMenuItemCop);

        jMenuItemSelect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0));
        jMenuItemSelect.setText("Selecionar");
        jMenuItemSelect.setEnabled(false);
        jMenuItemSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSelectActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemSelect);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Biblia JFA");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Back_32px.png"))); // NOI18N
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jToolBar1.add(jLabel17);

        jComboBox1.setMaximumRowCount(16);
        jComboBox1.setMaximumSize(new java.awt.Dimension(220, 30));
        jComboBox1.setMinimumSize(new java.awt.Dimension(100, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 30));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jToolBar1.add(jComboBox1);

        lbNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Forward_32px.png"))); // NOI18N
        lbNext.setText(" ");
        lbNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNextMouseClicked(evt);
            }
        });
        jToolBar1.add(lbNext);

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 150, 1));
        jSpinner1.setMaximumSize(new java.awt.Dimension(80, 30));
        jSpinner1.setMinimumSize(new java.awt.Dimension(80, 30));
        jSpinner1.setPreferredSize(new java.awt.Dimension(80, 30));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jToolBar1.add(jSpinner1);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Buscar: ");
        jLabel19.setToolTipText("");
        jLabel19.setMaximumSize(new java.awt.Dimension(80, 30));
        jLabel19.setMinimumSize(new java.awt.Dimension(80, 30));
        jToolBar1.add(jLabel19);

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.setMaximumSize(new java.awt.Dimension(200, 30));
        jTextField1.setName(""); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(250, 25));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jTextField1);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jLabel18.setMaximumSize(new java.awt.Dimension(40, 30));
        jLabel18.setMinimumSize(new java.awt.Dimension(40, 30));
        jToolBar1.add(jLabel18);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Screensharing_32px.png"))); // NOI18N
        jButton2.setToolTipText("Tela Cheia (F11)");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Imprimir");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenu3.setText("Cores");

        jMenuItem4.setText("Fundo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Fonte");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Grade");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenu2.add(jMenu3);

        jMenuItem3.setText("Fonte");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        ListarVersiculos();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        ListarVersiculos();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void lbNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNextMouseClicked
        // TODO add your handling code here:
        int index = jComboBox1.getSelectedIndex();

        if (index < jComboBox1.getModel().getSize() - 1) {
            index++;
        } else {
            index = 0;
        }

        jComboBox1.setSelectedIndex(index);

    }//GEN-LAST:event_lbNextMouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:

        int index = jComboBox1.getSelectedIndex();

        if (index > 0) {
            index--;
        } else {
            index = jComboBox1.getModel().getSize() - 1;
        }

        jComboBox1.setSelectedIndex(index);

    }//GEN-LAST:event_jLabel17MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String value = (String) jTable1.getValueAt(i, 0);

            if (value.toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                jTable1.changeSelection(i, 0, false, false);
                break;
            }

        }


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        DialogFonts dialog = new DialogFonts(null, true);
        dialog.SetarFonte(font);
        dialog.setVisible(true);

        if (dialog.isConfirma()) {
            font = dialog.getSelecioFont();
            ListarVersiculos();
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger() && evt.getButton() == 3) {
            jPopupMenu1.show(jTable1, evt.getX(), evt.getY());
            
            if (jTable1.getSelectedRowCount() > 0) {
                jMenuItemCop.setEnabled(true);
                jMenuItemFav.setEnabled(true);
                jMenuItemSelect.setEnabled(true);
            }
            
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Color fundo = JColorChooser.showDialog(null, "Cor do Fundo", Color.WHITE);
        jTable1.setBackground(fundo);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Color fonte = JColorChooser.showDialog(null, "Cor da Fonte", Color.BLACK);
        jTable1.setForeground(fonte);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Color grade = JColorChooser.showDialog(null, "Cor da Grade", Color.GRAY);
        jTable1.setGridColor(grade);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String texto = "";
        int limit = jTable1.getSelectedRowCount();
        
        if(limit == 0){
            limit = jTable1.getRowCount();
        }
        
        for (int i = 0; i < limit; i++) {
            texto += jTable1.getValueAt(i, 0) + "\n";
        }

        Color fonte = jTable1.getForeground();
        Color fundo = jTable1.getBackground();
        
        FrmApresentador frm = new FrmApresentador(texto, font, fonte, fundo);
        frm.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItemSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSelectActionPerformed
        // TODO add your handling code here:
        
        String select = jComboBox1.getSelectedItem()+":"+jSpinner1.getValue()+" - ";
        
        for(int index: jTable1.getSelectedRows()){
            select += jTable1.getValueAt(index, 0)+"\n";
        }

        setConfirma(true);
        setVersoSelecionado(select);
        dispose();
        
    }//GEN-LAST:event_jMenuItemSelectActionPerformed

    public boolean isConfirma() {
        return confirma;
    }

    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemCop;
    private javax.swing.JMenuItem jMenuItemFav;
    private javax.swing.JMenuItem jMenuItemSelect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbNext;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the VersoSelecionado
     */
    public String getVersoSelecionado() {
        return VersoSelecionado;
    }

    /**
     * @param VersoSelecionado the VersoSelecionado to set
     */
    public void setVersoSelecionado(String VersoSelecionado) {
        this.VersoSelecionado = VersoSelecionado;
    }
}
