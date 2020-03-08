package View.Dialogs.Cadastros;

import Controller.ControllerIgrejas;
import Model.Igreja;
import Model.Renderer.DataSetTableModel;
import Utils.LogsEventos;
import Utils.Propriedades;
import View.Dialogs.Utils.DialogBiblia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;

/**
 *
 * @author AYU7-WN
 */
public class DialogIgrejas extends javax.swing.JDialog {

    private final SimpleDateFormat df = new ExcelStyleDateFormatter("dd/MM/yyyy");
    private final ControllerIgrejas controler;
    private String selecionado, foto;

    private int eixoX, eixoY;
    
    public DialogIgrejas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controler = new ControllerIgrejas();
        lbExcluir.setVisible(false);
        ListarIgrejas();
        
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

    private void ListarIgrejas() {

        DefaultTableModel model = DataSetTableModel.Tabela("SELECT * FROM Igrejas");

        tabela.setModel(model);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);

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

        for (int i = 0; i < panelCampos.getComponentCount(); i++) {
            Component comp = panelCampos.getComponent(i);
            if (comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;
                tf.setText("");
            } else if (comp instanceof JFormattedTextField) {
                JFormattedTextField tf = (JFormattedTextField) comp;
                tf.setText("");
            }
        }

        txtPaginas.setText("http://");
        foto = null;
        lbFoto.setText("Foto / Logo / Simbolo");
        lbFoto.setIcon(null);
        lbExcluir.setEnabled(false);
    }

    private void Selecionar() {

        int index = tabela.getSelectedRow();
        selecionado = (String) tabela.getValueAt(index, 0);

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            String value = (String) tabela.getValueAt(index, i);

            switch (tabela.getColumnName(i)) {
                case "NOME":
                    txtNome.setText(value);
                    break;
                case "ENDERECO":
                    txtEndereco.setText(value);
                    break;
                case "BAIRRO":
                    txtBairro.setText(value);
                    break;
                case "CIDADE":
                    txtCidades.setText(value);
                    break;
                case "ESTADO":
                    cbEstados.setSelectedItem(value);
                    break;
                case "CONTATOS":
                    txtContatos.setText(value);
                    break;
                case "EMAILS":
                    txtEmails.setText(value);
                    break;
                case "PAGINA":
                    txtPaginas.setText(value);
                    break;
                case "CEP":
                    txtCep.setText(value);
                    break;
                case "CNPJ":
                    txtCnpj.setText(value);
                    break;
                case "TEXTO":
                    txtDivisa.setText(value);
                    break;
                case "TIPO":
                    cbTipo.setSelectedItem(value);
                    break;
                case "FUNDACAO":
                    try {
                        txtFundacao.setDate((Date) df.parse(value));
                    } catch (ParseException ex) {
                        LogsEventos.Gravar(ex.getMessage());
                    }
                    break;
                case "FOTO":
                    SetFoto(value);
                    break;
            }
        }

        this.setTitle("Editando...");
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }

    private void SetFoto(String path) {

        ImageIcon scala = null;
        lbFoto.setText(null);
        foto = path;

        if (path != null && new File(path).exists()) {
            ImageIcon image = new ImageIcon(path);
            scala = new ImageIcon(image.getImage().getScaledInstance(
                    550,420,Image.SCALE_DEFAULT));
            lbExcluir.setVisible(true);
        } else {
            lbFoto.setText("Foto / Logo / Simbolo");
            lbExcluir.setVisible(false);
        }

        lbFoto.setIcon(scala);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelCampos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmails = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContatos = new javax.swing.JTextField();
        txtCnpj = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCidades = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbEstados = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPaginas = new javax.swing.JTextField();
        txtFundacao = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDivisa = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbExcluir = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();
        toolbarTitulo = new javax.swing.JToolBar();
        lbTitulo = new javax.swing.JLabel();
        lbFinalizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Igrejas");
        setMinimumSize(new java.awt.Dimension(806, 520));
        setUndecorated(true);
        setResizable(false);

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(53, 59, 72), 2, true));

        jSplitPane1.setDividerLocation(220);
        jSplitPane1.setDividerSize(7);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setText("Endereço*");

        txtEndereco.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtEndereco.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setText("Bairro*");

        txtBairro.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtBairro.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel7.setText("Paginas (Web/Site/Blog)");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel8.setText("Emails");

        txtEmails.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtEmails.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel9.setText("Contatos* (Telefone / Celular)");

        txtContatos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtContatos.setCaretColor(new java.awt.Color(53, 59, 72));

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCnpj.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNome.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("Nome*");

        txtCidades.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCidades.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel11.setText("CNPJ");

        cbEstados.setMaximumRowCount(16);
        cbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACRE", "ALAGOAS", "AMAPA", "AMAZONAS", "BAHIA", "CEARA", "DISTRITO FEDERAL", "ESPIRITO SANTO", "GOIAS", "MARANHAO", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PARA", "PARAIBA", "PARANA", "PERNAMBUCO", "PIAUI", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "RONDONIA", "RORAIAMA", "SANTA CATARINA", "SAO PAULO", "SERGIPE", "TOCANTIS" }));
        cbEstados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel4.setText("Cidade*");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sede / Principal", "Congregação", "Ponto de Pregação", "Grupo / Celula" }));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel5.setText("UF/Estado");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel12.setText("Tipo");

        txtCep.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCep.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel6.setText("CEP");

        txtPaginas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtPaginas.setText("http://");
        txtPaginas.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel16.setText("Data de Fundação");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel10.setText("Texto / Divisa");

        txtDivisa.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDivisa.setCaretColor(new java.awt.Color(53, 59, 72));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Plus_32px.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNovo.setMaximumSize(new java.awt.Dimension(120, 40));
        btnNovo.setMinimumSize(new java.awt.Dimension(120, 40));
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
        btnSalvar.setMaximumSize(new java.awt.Dimension(120, 40));
        btnSalvar.setMinimumSize(new java.awt.Dimension(120, 40));
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
        btnExcluir.setMaximumSize(new java.awt.Dimension(120, 40));
        btnExcluir.setMinimumSize(new java.awt.Dimension(120, 40));
        btnExcluir.setPreferredSize(new java.awt.Dimension(120, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(392, 392, 392))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCidades)
                                            .addGroup(panelCamposLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCamposLayout.createSequentialGroup()
                                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(txtFundacao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 92, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCep)
                                    .addComponent(txtBairro)
                                    .addComponent(txtCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(txtEmails))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtPaginas)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel12))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(txtDivisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addGap(4, 4, 4)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFundacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addGap(4, 4, 4)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", panelCampos);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbExcluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Cancel_18px.png"))); // NOI18N
        lbExcluir.setToolTipText("Excluir");
        lbExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExcluirMouseClicked(evt);
            }
        });
        jPanel2.add(lbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 20, 20));

        lbFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFoto.setText("Foto / Logo / Simbolo");
        lbFoto.setToolTipText("Foto Templo / Logo");
        lbFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFotoMouseClicked(evt);
            }
        });
        jPanel2.add(lbFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 550, 420));

        jTabbedPane1.addTab("Foto - Imagem", jPanel2);

        jSplitPane1.setRightComponent(jTabbedPane1);

        toolbarTitulo.setBackground(new java.awt.Color(53, 59, 72));
        toolbarTitulo.setFloatable(false);

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("IGREJAS E CONGREGAÇÕES");
        lbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
            .addComponent(toolbarTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1))
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

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:

        Selecionar();

    }//GEN-LAST:event_tabelaMouseClicked

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

            Igreja igreja = new Igreja();
            igreja.setNome(txtNome.getText());
            igreja.setCnpj(txtCnpj.getText());
            igreja.setEndereco(txtEndereco.getText());
            igreja.setBairro(txtBairro.getText());
            igreja.setCidade(txtCidades.getText());
            igreja.setEstado(cbEstados.getSelectedItem().toString());
            igreja.setContatos(txtContatos.getText());
            igreja.setEmails(txtEmails.getText());
            igreja.setCep(txtCep.getText());
            igreja.setPagina(txtPaginas.getText());
            igreja.setTexto(txtDivisa.getText());
            igreja.setTipo(cbTipo.getSelectedItem().toString());
            igreja.setFundacao(df.format(txtFundacao.getDate()));
            igreja.setFoto(foto);

            if (this.getTitle().contains("Cadastrando...")) {
                if (controler.Cadastrar(igreja)) {
                    Limpar();
                    ListarIgrejas();
                    btnExcluir.setEnabled(false);
                }
            } else {
                igreja.setId(Integer.parseInt(selecionado));
                if (controler.Editar(igreja)) {
                    this.setTitle("Igrejas");
                    Limpar();
                    ListarIgrejas();
                    btnSalvar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                }
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa " + cbTipo.getSelectedItem() + "?",
                "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            if (controler.Excluir(Integer.parseInt(selecionado))) {
                this.setTitle("Igrejas");
                Limpar();
                ListarIgrejas();
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void lbFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFotoMouseClicked
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Imagem",
                new String[]{"png", "jpg"});
        busca.setFileFilter(filtro);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (busca.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File arquivo = busca.getSelectedFile();
            SetFoto(arquivo.getAbsolutePath());
        }

    }//GEN-LAST:event_lbFotoMouseClicked

    private void lbExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExcluirMouseClicked
        // TODO add your handling code here:

        foto = null;
        lbFoto.setText("Foto / Logo / Simbolo");
        lbFoto.setIcon(null);
        lbExcluir.setVisible(false);

    }//GEN-LAST:event_lbExcluirMouseClicked

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DialogBiblia biblia = new DialogBiblia(null, true);
        biblia.setVisible(true);
        
        if(biblia.isConfirma()){
            txtDivisa.setText(biblia.getVersoSelecionado());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbExcluir;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTable tabela;
    private javax.swing.JToolBar toolbarTitulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidades;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtContatos;
    private javax.swing.JTextField txtDivisa;
    private javax.swing.JTextField txtEmails;
    private javax.swing.JTextField txtEndereco;
    private com.toedter.calendar.JDateChooser txtFundacao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPaginas;
    // End of variables declaration//GEN-END:variables
}
