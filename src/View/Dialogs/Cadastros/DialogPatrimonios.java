package View.Dialogs.Cadastros;

import Controller.ControllerIgrejas;
import Controller.ControllerPatrimonios;
import Model.Igreja;
import Model.Patrimonio;
import Model.Renderer.DataSetTableModel;
import Utils.Propriedades;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogPatrimonios extends javax.swing.JDialog {

    private final ControllerPatrimonios controler;
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<Igreja> igrejas;
    private String selecionado;

    private int eixoX, eixoY;
    
    /**
     * Creates new form DialogPatrimonios
     *
     * @param parent
     * @param modal
     */
    public DialogPatrimonios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controler = new ControllerPatrimonios();
        txtData.setDate(new Date());
        ListarIgrejas();
        ListarPatrimonios();
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
    
    private void ListarPatrimonios() {
        String sql = "SELECT Id, Nome, Data, Tipo, Quantidade, UnMedida, "
                + "Valor, Descricao, IdIgreja FROM Patrimonios";

        DefaultTableModel model = DataSetTableModel.Tabela(sql);
        tabela.setModel(model);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    private void ListarIgrejas() {

        ControllerIgrejas ig = new ControllerIgrejas();
        igrejas = ig.Listar();

        if (igrejas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUMA IGREJA CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
            btnNovo.setEnabled(false);
        } else {
            igrejas.stream().forEach((i) -> {
                cbIgrejas.addItem(i.getNome());
            });
        }

    }

    private boolean VerificaCampos() {

        boolean retorno = true;

        for (int i = 0; i < panelCampos.getComponentCount(); i++) {
            Component comp = panelCampos.getComponent(i);
            if (comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;
                if (tf.getText().equals("")) {
                    tf.setBackground(Color.yellow);
                    retorno = false;
                } else {
                    tf.setBackground(Color.white);
                }
            }

        }

        return retorno;
    }

    private void Limpar() {

        tabela.clearSelection();
        txtNome.setText(null);
        txtValor.setText(null);
        txtDescricao.setText(null);
        txtQtd.setText(null);

    }

    private void Selecionar() {

        this.setTitle("Editando...");
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(true);

        int index = tabela.getSelectedRow();
        selecionado = (String) tabela.getValueAt(index, 0);

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            String value = (String) tabela.getValueAt(index, i);

            switch (tabela.getColumnName(i)) {
                case "NOME":
                    txtNome.setText(value);
                    break;
                case "DATA":
                    try {
                        txtData.setDate((Date) df.parse(value));
                    } catch (ParseException ex) {
                        Logger.getLogger(DialogMembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "TIPO":
                    cbTipo.setSelectedItem(value);
                    break;
                case "QUANTIDADE":
                    txtQtd.setText(value);
                    break;
                case "UNMEDIDA":
                    cbUnMedida.setSelectedItem(value);
                    break;
                case "VALOR":
                    txtValor.setText(value);
                    break;
                case "DESCRICAO":
                    txtDescricao.setText(value);
                    break;
                case "IDIGREJA":
                    cbIgrejas.setSelectedIndex(Integer.parseInt(value) - 1);
                    break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        panelCampos = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbUnMedida = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtData = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JFormattedTextField();
        cbIgrejas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        toolbarTitulo = new javax.swing.JToolBar();
        lbTitulo = new javax.swing.JLabel();
        lbFinalizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patrimônios");
        setMinimumSize(new java.awt.Dimension(710, 482));
        setUndecorated(true);
        setResizable(false);

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 59, 72), 2));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(7);

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jSplitPane1.setLeftComponent(jScrollPane1);

        panelCampos.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Plus_32px.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNovo.setMaximumSize(new java.awt.Dimension(110, 40));
        btnNovo.setPreferredSize(new java.awt.Dimension(120, 40));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        jLabel13.setText("  ");
        jToolBar1.add(jLabel13);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalvar.setEnabled(false);
        btnSalvar.setMaximumSize(new java.awt.Dimension(110, 40));
        btnSalvar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        jLabel14.setText("  ");
        jToolBar1.add(jLabel14);

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(110, 40));
        btnExcluir.setPreferredSize(new java.awt.Dimension(120, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("Nome*");

        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNome.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setText("Valor R$");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValor.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtValor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra", "Bonificação", "Doação" }));
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setText("Tipo");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel4.setText("Quantidade");

        cbUnMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Un (Unidade)", "Dz (Duzia)", "Lt (Litro)", "Kg (Quilo)", "Mt (Metro)", "Pct (Pacote)" }));

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel5.setText("Data da aquisição");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel6.setText("Descrição");

        txtQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtQtd.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtQtd.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel7.setText("Igreja / Congregação");

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUnMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelCamposLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelCamposLayout.createSequentialGroup()
                                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(txtNome)
                    .addComponent(jScrollPane2)
                    .addComponent(cbIgrejas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbIgrejas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbUnMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(panelCampos);

        toolbarTitulo.setBackground(new java.awt.Color(53, 59, 72));
        toolbarTitulo.setFloatable(false);

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("PATRIMÔNIOS");
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
            .addComponent(toolbarTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        Limpar();
        this.setTitle("Cadastrando...");
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (VerificaCampos()) {

            if (txtData.getDate() != null) {

                Patrimonio patrimonio = new Patrimonio();
                patrimonio.setNome(txtNome.getText());
                patrimonio.setData(df.format(txtData.getDate()));
                patrimonio.setTipo(cbTipo.getSelectedItem().toString());
                patrimonio.setQuantidade(Integer.parseInt(txtQtd.getText()));
                patrimonio.setUnMedida(cbUnMedida.getSelectedItem().toString());
                patrimonio.setValor(txtValor.getText());
                patrimonio.setDescricao(txtDescricao.getText());
                patrimonio.setIdIgreja(igrejas.get(cbIgrejas.getSelectedIndex()).getId());

                if (this.getTitle().contains("Cadastrando...")) {
                    if (controler.Cadastrar(patrimonio)) {
                        Limpar();
                        ListarPatrimonios();
                        btnExcluir.setEnabled(false);
                    }
                } else {
                    patrimonio.setId(Integer.parseInt(selecionado));
                    if (controler.Editar(patrimonio)) {
                        this.setTitle("Patrimonios");
                        Limpar();
                        ListarPatrimonios();
                        btnSalvar.setEnabled(false);
                        btnExcluir.setEnabled(false);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe a data de aquisição",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir esse Patrimônio?",
                "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            if (controler.Excluir(Integer.parseInt(selecionado))) {
                this.setTitle("Igrejas");
                Limpar();
                ListarPatrimonios();
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        Selecionar();
    }//GEN-LAST:event_tabelaMouseClicked

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        // TODO add your handling code here:
        if (cbTipo.getSelectedIndex() > 0) {
            txtValor.setText("0,00");
            txtValor.setEditable(false);
        } else {
            txtValor.setEditable(true);
        }
    }//GEN-LAST:event_cbTipoItemStateChanged

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
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbIgrejas;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbUnMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTable tabela;
    private javax.swing.JToolBar toolbarTitulo;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtQtd;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
