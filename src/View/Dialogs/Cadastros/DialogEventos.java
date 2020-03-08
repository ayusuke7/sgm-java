package View.Dialogs.Cadastros;

import Controller.ControllerAgenda;
import Model.Evento;
import Model.Renderer.CustomComboBox;
import Utils.LogsEventos;
import Utils.Propriedades;
import com.sun.javafx.scene.control.skin.CustomColorDialog;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author AYU7-WN
 */
public class DialogEventos extends javax.swing.JDialog {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final ControllerAgenda cont = new ControllerAgenda();

    private ArrayList<Evento> eventos;
    private int eixoX, eixoY;

    public DialogEventos(java.awt.Frame parent, boolean modal) {
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

    public void SetEvento(Evento evento) {

        try {
            jCalendar.setDate(df.parse(evento.getData()));
            jComboBox1.setSelectedItem(evento.getNome());
        } catch (ParseException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

    }

    private void ListarEventos() {

        String sql = "SELECT * FROM Eventos WHERE Data='" + txtData.getText() + "'";
        eventos = cont.Listar(sql);

        jComboBox1.removeAllItems();
        jComboBox1.addItem("Novo Evento");

        eventos.stream().forEach((e) -> {
            jComboBox1.addItem(e.getNome());
        });

        jComboBox1.setRenderer(new CustomComboBox());
        jLabel3.setText(eventos.size() + " Eventos no dia");        

    }

    private void Resetar() {
        this.setTitle("Agenda");
        txtDescricao.setText(null);
        txtHora.setText("00:00");
        txtNome.setText(null);
        txtNome.setBackground(Color.white);
        txtDescricao.setBackground(Color.white);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtHora = new javax.swing.JFormattedTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnSalvar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        toolbarTitulo = new javax.swing.JToolBar();
        lbTitulo = new javax.swing.JLabel();
        lbFinalizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda");
        setMinimumSize(new java.awt.Dimension(635, 343));
        setUndecorated(true);
        setResizable(false);

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 59, 72), 2));

        jSplitPane1.setDividerLocation(318);
        jSplitPane1.setDividerSize(8);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setText("0 Eventos no dia");

        txtData.setEditable(false);
        txtData.setBackground(new java.awt.Color(255, 255, 255));
        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtData.setText("12/12/2099");
        txtData.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("Nome*");

        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNome.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescricao);

        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setText("00:00");
        txtHora.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalvar.setMaximumSize(new java.awt.Dimension(120, 40));
        btnSalvar.setMinimumSize(new java.awt.Dimension(120, 40));
        btnSalvar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        jLabel19.setText("  ");
        jToolBar1.add(jLabel19);

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(120, 40));
        btnExcluir.setMinimumSize(new java.awt.Dimension(120, 40));
        btnExcluir.setPreferredSize(new java.awt.Dimension(120, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel4.setText("Horário");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novo Evento" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNome)))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel1);

        toolbarTitulo.setBackground(new java.awt.Color(53, 59, 72));
        toolbarTitulo.setFloatable(false);
        toolbarTitulo.setPreferredSize(new java.awt.Dimension(126, 35));

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("AGENDA DE EVENTOS");
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

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addComponent(toolbarTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBaseLayout.createSequentialGroup()
                .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    //panelBaseTODO add your handling code here:

        Evento evento = new Evento();
        evento.setNome(txtNome.getText());
        evento.setData(txtData.getText());
        evento.setHora(txtHora.getText());
        evento.setDescricao(txtDescricao.getText());

        if (txtNome.getText().equals("")) {
            txtNome.setBackground(Color.yellow);
        } else if (txtDescricao.getText().equals("")) {
            txtDescricao.setBackground(Color.yellow);
        } else if (this.getTitle().equals("Editando...")) {
            int index = jComboBox1.getSelectedIndex();
            evento.setId(eventos.get(index - 1).getId());
            if (cont.Editar(evento)) {
                ListarEventos();
                Resetar();
            }
        } else if (cont.Cadastrar(evento)) {
            ListarEventos();
            Resetar();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"));
        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir esse Evento", "EXCLUIR",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ico);

        if (op == JOptionPane.YES_OPTION) {
            int index = jComboBox1.getSelectedIndex();
            if (cont.Excluir(eventos.get(index - 1).getId())) {
                ListarEventos();
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarPropertyChange
        // TODO add your handling code here:

        Date dt = jCalendar.getDate();
        txtData.setText(df.format(dt));
        ListarEventos();

        Date tmp = new Date();
        if (dt.before(tmp) && !df.format(dt).equals(df.format(tmp))) {
            btnSalvar.setEnabled(false);
        }

    }//GEN-LAST:event_jCalendarPropertyChange

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:

        int index = jComboBox1.getSelectedIndex();

        if (index > 0) {
            this.setTitle("Editando...");
            btnExcluir.setEnabled(true);
            txtDescricao.setText(eventos.get(index - 1).getDescricao());
            txtHora.setText(eventos.get(index - 1).getHora());
            txtNome.setText(eventos.get(index - 1).getNome());
        } else {
            Resetar();
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelBase;
    private javax.swing.JToolBar toolbarTitulo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
