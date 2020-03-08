package View.Dialogs.Cadastros;

import Controller.ControllerAtas;
import Controller.ControllerIgrejas;
import Controller.ControllerMembros;
import Model.Ata;
import Model.Igreja;
import Model.Membro;
import Model.Renderer.CustomComboBox;
import Model.Renderer.DataSetTableModel;
import Utils.LogsEventos;
import Utils.ManipularArquivos;
import View.Dialogs.Utils.DialogLista;
import View.Dialogs.Utils.DialogTabela;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class DialogAtas extends javax.swing.JDialog {
    
    private final String path = System.getProperty("user.dir");
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final ManipularArquivos arq = new ManipularArquivos();
    private final ControllerAtas controler = new ControllerAtas();
    
    private Ata ata;
    private ArrayList<Igreja> igrejas;
    
    String arquivo, meses[] = {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL",
        "MAIO", "JUNHO", "JULHO", "AGOSTO",
        "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};

    /**
     * Creates new form DialogAtas
     *
     * @param parent
     * @param modal
     * @param ata
     */
    public DialogAtas(java.awt.Frame parent, boolean modal, Ata ata) {
        super(parent, modal);
        initComponents();
        this.ata = ata;
        
        txtData.setDate(new Date());
        arquivo = arq.LerArquivo(new File(path + "/Relatorios/modelo_ata.html"));
        
        ListarIgrejas();
        
        if (ata.getId() > 0) {
            MostrarAta();
        } else {
            MontarAta();
        }
        
        HabilitarCampos(false);
    }
    
    private void ListarIgrejas() {
        igrejas = new ControllerIgrejas().Listar();
        
        igrejas.stream().forEach((ig) -> {
            cbIgrejas.addItem(ig.getNome());
        });
        
        //cbIgrejas.setRenderer(new CustomComboBox());
        
    }
    
    private String BuscarIgreja(int id) {
        
        String nome = "";
        
        for (Igreja ig : igrejas) {
            if (ig.getId() == id) {
                nome = ig.getNome();
            }
        }
        return nome;
    }
    
    private void MostrarAta() {
        
        txtCodigo.setText("" + ata.getId());
        txtTitulo.setText(ata.getTitulo());
        txtSecretario.setText(ata.getSecretario());
        txtDiacono.setText(ata.getPastor());
        
        if (!ata.getVotos().equals("")) {
            jCheckBox1.setSelected(true);
            txtVotos.setText(ata.getVotos());
        }
        
        txtDescricao.setText(ata.getDescricao());
        cbIgrejas.setSelectedItem(BuscarIgreja(ata.getId()));
        
        try {
            txtData.setDate((Date) df.parse(ata.getData()));
        } catch (ParseException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        
    }
    
    private void MontarAta() {
        
        String html = arquivo;
        
        int index = cbIgrejas.getSelectedIndex();
        Igreja ig = igrejas.get(index);
        
        html = html.replace("[igreja]", cbIgrejas.getSelectedItem().toString());
        html = html.replace("[endereco]", ig.getEndereco());
        html = html.replace("[bairro]", ig.getBairro());
        html = html.replace("[cidade]", ig.getCidade());
        html = html.replace("[estado]", ig.getEstado());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = sdf.format((Date) txtData.getDate());
        
        html = html.replace("[dia]", date.substring(0, 2));
        html = html.replace("[mes]", meses[Integer.parseInt(date.substring(3, 5)) - 1]);
        html = html.replace("[ano]", date.substring(6, 10));
        html = html.replace("[horas]", date.substring(10));
        html = html.replace("[codigo]", txtCodigo.getText());
        
        html = html.replace("[titulo]", txtTitulo.getText());
        html = html.replace("[secretario]", txtSecretario.getText());
        html = html.replace("[pastor]", txtDiacono.getText());
        
        html = html.replace("[votos]", txtVotos.getText());
        
        txtDescricao.setText(html);
        txtDescricao.setCaretPosition(0);
        txtVotos.setCaretPosition(0);
        
    }
    
    private void PesquisarAta() {
        
        String sql = "SELECT Id, Titulo, Data FROM Atas";
        DialogTabela dialog = new DialogTabela(null, true, DataSetTableModel.Tabela(sql));
        dialog.TamanhoColunas(new int[]{50, 300, 100});
        dialog.setVisible(true);
        
        if (dialog.isConfirma()) {
            String index = dialog.getListagem().get(0);
            ata = controler.Buscar(Integer.parseInt(index));
            MostrarAta();
            HabilitarCampos(true);
            btnExcluir.setEnabled(true);
        }
    }
    
    private void Limpar() {
        
        txtCodigo.setText("0000");
        txtTitulo.setText(null);
        txtSecretario.setText(null);
        txtDiacono.setText(null);
        jCheckBox1.setSelected(false);
        txtVotos.setText(null);
        txtDescricao.setText(ata.getDescricao());
        arquivo = arq.LerArquivo(new File(path + "/Relatorios/modelo_ata.html"));
        MontarAta();        
        HabilitarCampos(false);
        btnExcluir.setEnabled(false);
    }
    
    private void HabilitarCampos(boolean op) {
        
        jButton1.setEnabled(op);
        jButton2.setEnabled(op);
        jCheckBox1.setEnabled(op);        
        btnSalvar.setEnabled(op);
        txtVotos.setEnabled(op);        
        txtDescricao.setEditable(op);
    }
    
    private String BuscarMembros() {
        
        int id = igrejas.get(cbIgrejas.getSelectedIndex()).getId();
        String sql = "SELECT Id, Nome, Cargo FROM Membros WHERE IdIgreja=" + id;
        DialogTabela dialog = new DialogTabela(null, true, DataSetTableModel.Tabela(sql));
        dialog.TamanhoColunas(new int[]{50, 300, 100});
        dialog.setVisible(true);
        
        String retorno = "";
        
        if (dialog.isConfirma()) {
            ArrayList lst = dialog.getListagem();
            retorno = lst.get(1).toString();
        }
        
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        txtSecretario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtDiacono = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtVotos = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jToolBar1 = new javax.swing.JToolBar();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbIgrejas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JFormattedTextField();
        btnNovo = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtData = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modulo de Atas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(8);
        jSplitPane1.setOneTouchExpandable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtSecretario.setEditable(false);
        txtSecretario.setBackground(new java.awt.Color(255, 255, 255));
        txtSecretario.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        txtSecretario.setCaretColor(new java.awt.Color(53, 59, 72));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDiacono.setEditable(false);
        txtDiacono.setBackground(new java.awt.Color(255, 255, 255));
        txtDiacono.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        txtDiacono.setCaretColor(new java.awt.Color(53, 59, 72));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtVotos.setColumns(20);
        txtVotos.setLineWrap(true);
        txtVotos.setRows(5);
        txtVotos.setWrapStyleWord(true);
        txtVotos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVotosFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtVotos);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jCheckBox1.setText("Ata c/ Votação");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar Ata");
        btnSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalvar.setMaximumSize(new java.awt.Dimension(300, 35));
        btnSalvar.setPreferredSize(new java.awt.Dimension(110, 35));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Secretário");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Diácono/Pastor*");

        cbIgrejas.setMaximumSize(new java.awt.Dimension(2000, 32767));
        cbIgrejas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIgrejasItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nº");
        jLabel2.setMaximumSize(new java.awt.Dimension(30, 23));

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setForeground(new java.awt.Color(0, 0, 153));
        txtCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setText("0000");
        txtCodigo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtCodigo.setMaximumSize(new java.awt.Dimension(135, 2147483647));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Plus_24px.png"))); // NOI18N
        btnNovo.setToolTipText("Excluir");
        btnNovo.setFocusable(false);
        btnNovo.setMaximumSize(new java.awt.Dimension(30, 35));
        btnNovo.setMinimumSize(new java.awt.Dimension(40, 35));
        btnNovo.setPreferredSize(new java.awt.Dimension(110, 35));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        btnPesquisar.setMaximumSize(new java.awt.Dimension(30, 35));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Cancel_18px.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(30, 35));
        btnExcluir.setMinimumSize(new java.awt.Dimension(40, 35));
        btnExcluir.setPreferredSize(new java.awt.Dimension(110, 35));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Titulo*");
        jLabel7.setMaximumSize(new java.awt.Dimension(80, 19));

        txtTitulo.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        txtTitulo.setCaretColor(new java.awt.Color(53, 59, 72));
        txtTitulo.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        txtTitulo.setPreferredSize(new java.awt.Dimension(6, 28));
        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTituloFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Data*");
        jLabel4.setMaximumSize(new java.awt.Dimension(60, 19));

        txtData.setMaximumSize(new java.awt.Dimension(100, 30));
        txtData.setPreferredSize(new java.awt.Dimension(100, 20));
        txtData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataFocusLost(evt);
            }
        });
        txtData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDataPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbIgrejas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSecretario)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiacono)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbIgrejas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSecretario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiacono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtDescricao.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(txtDescricao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenu1.setText("Arquivo");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Novo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Visualizar");
        jMenu1.add(jMenuItem5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Imprimir");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

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

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setText("Pesquisar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtSecretario.setText(BuscarMembros());
        MontarAta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtDiacono.setText(BuscarMembros());
        MontarAta();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        ata.setIdIgreja(igrejas.get(cbIgrejas.getSelectedIndex()).getId());
        ata.setTitulo(txtTitulo.getText());
        ata.setData(df.format(txtData.getDate()));
        ata.setSecretario(txtSecretario.getText());
        ata.setPastor(txtDiacono.getText());
        ata.setVotos(txtVotos.getText());
        ata.setDescricao(txtDescricao.getText());
        
        if (ata.getId() > 0) {
            ata.setId(Integer.parseInt(txtCodigo.getText()));
            if (controler.Editar(ata)) {
                JOptionPane.showMessageDialog(null, "Ata "+ata.getId()+" Atualizada");
            }
            Limpar();
        } else if (controler.Cadastrar(ata)) {
            JOptionPane.showMessageDialog(null, "Ata "+txtCodigo.getText()+" Cadatrada");
            Limpar();
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        ImageIcon ico = new ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"));
        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir essa ATA "+ata.getId(), "EXCLUIR",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ico);
        
        if (op == JOptionPane.YES_OPTION) {
            if(controler.Excluir(ata.getId())){
                JOptionPane.showMessageDialog(null, "Ata "+ata.getId()+" Removida");
                Limpar();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void txtDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDataPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDataPropertyChange

    private void cbIgrejasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIgrejasItemStateChanged
        // TODO add your handling code here:
        MontarAta();
    }//GEN-LAST:event_cbIgrejasItemStateChanged

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        // TODO add your handling code here:
        MontarAta();
    }//GEN-LAST:event_txtTituloFocusLost

    private void txtDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusLost
        // TODO add your handling code here:
        MontarAta();
    }//GEN-LAST:event_txtDataFocusLost

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:

        String votos = "";
        
        if (jCheckBox1.isSelected()) {
            String sql = "SELECT * FROM Membros WHERE IdIgreja="
                    + igrejas.get(cbIgrejas.getSelectedIndex()).getId() + " ORDER BY Nome";
            
            ArrayList<Membro> membros = new ControllerMembros().Listar(sql);
            ArrayList<String> lista = new ArrayList<>();
            
            membros.stream().forEach((m) -> {
                lista.add(m.getNome());
            });
            
            DialogLista dialog = new DialogLista(null, true, lista);
            dialog.setVisible(true);
            
            if (dialog.isConfirma()) {
                ArrayList<String> s = dialog.getSelecionados();
                votos = "Ata finalizada com votação: " + s.size() + " Votos -> " + s.toString();
            } else {
                jCheckBox1.setSelected(false);
            }
            
        }
        
        txtVotos.setText(votos);
        txtVotos.setCaretPosition(0);
        MontarAta();

    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        //int id = igrejas.get(cbIgrejas.getSelectedIndex()).getId();

        PesquisarAta();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Limpar();
        txtCodigo.setText("" + (controler.UltimoRegistro() + 1));
        HabilitarCampos(true);
        MontarAta();
        txtTitulo.requestFocus();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        Limpar();
        txtCodigo.setText("" + (controler.UltimoRegistro() + 1));
        HabilitarCampos(true);
        MontarAta();
        txtTitulo.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        PesquisarAta();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtVotosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVotosFocusLost
        // TODO add your handling code here:
        MontarAta();
    }//GEN-LAST:event_txtVotosFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbIgrejas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFormattedTextField txtCodigo;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextPane txtDescricao;
    private javax.swing.JTextField txtDiacono;
    private javax.swing.JTextField txtSecretario;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextArea txtVotos;
    // End of variables declaration//GEN-END:variables
}
