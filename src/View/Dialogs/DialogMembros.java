package View.Dialogs;

import Controller.ControllerGenerico;
import Controller.ControllerIgrejas;
import Controller.ControllerMembros;
import Model.Igreja;
import Model.Membro;
import Model.Renderer.DataSetTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogMembros extends javax.swing.JDialog {

    private final ControllerMembros contM;
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<Igreja> igrejas;

    private String selecionado;

    /**
     * Creates new form DialogMembros
     *
     * @param parent
     * @param modal
     */
    public DialogMembros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        contM = new ControllerMembros();
        ListarIgrejas();
        ListarMembros();
        ListarCargos();
    }

    private void ListarCargos() {

        ControllerGenerico ge = new ControllerGenerico();
        ArrayList<String[]> cargos = ge.Listar("SELECT * FROM Cargos");
        ArrayList<String[]> minist = ge.Listar("SELECT * FROM Ministerios");

        cargos.stream().forEach((s) -> {
            cbCargos.addItem(s[1]);
        });

        minist.stream().forEach((s) -> {
            cbMinisterios.addItem(s[0]);
        });

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

    private void ListarMembros() {

        String sql = "SELECT Id, Nome, Genero, DtNascimento, Cpf, EstadoCivil, "
                + "NomePai, NomeMae, Email, Endereco, Contatos, Bairro, Cidade, "
                + "Estado, Complemento, Cep, Cargo, Ministerio, Situacao, IdIgreja "
                + "FROM Membros ORDER BY Id";

        DefaultTableModel model = DataSetTableModel.Tabela(sql);
        tabela.setModel(model);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(150);

    }

    private boolean VerificaCampos() {

        boolean retorno = true;

        for (int i = 0; i < jPanel1.getComponentCount(); i++) {
            Component comp = jPanel1.getComponent(i);
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

        for (int i = 0; i < jPanel1.getComponentCount(); i++) {
            Component comp = jPanel1.getComponent(i);
            if (comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;
                tf.setText(null);
            } else if (comp instanceof JFormattedTextField) {
                JTextField tf = (JFormattedTextField) comp;
                tf.setText(null);
            }
        }
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
                case "CPF":
                    txtCpf.setText(value);
                    break;
                case "GENERO":
                    cbGenero.setSelectedItem(value);
                    break;
                case "ESTADOCIVIL":
                    cbEstadoCivil.setSelectedItem(value);
                    break;
                case "NOMEPAI":
                    txtNomePai.setText(value);
                    break;
                case "NOMEMAE":
                    txtNomeMae.setText(value);
                    break;
                case "EMAIL":
                    txtEmails.setText(value);
                    break;
                case "CONTATOS":
                    txtContatos.setText(value);
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
                case "CEP":
                    txtCep.setText(value);
                    break;
                case "COMPLEMENTO":
                    txtComplemento.setText(value);
                    break;
                case "IDIGREJA":
                    cbIgrejas.setSelectedIndex(Integer.parseInt(value) - 1);
                    break;
                case "CARGO":
                    cbCargos.setSelectedItem(value);
                    break;
                case "SITUACAO":
                    cbSituacao.setSelectedItem(value);
                    break;
                case "MINISTERIO":
                    cbMinisterios.setSelectedItem(value);
                    break;
                case "DTNASCIMENTO":
                    try {
                        txtDtNascimento.setDate((Date) df.parse(value));
                    } catch (ParseException ex) {
                        Logger.getLogger(DialogMembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtDtNascimento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomePai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeMae = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtEmails = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        cbEstados = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCidades = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtContatos = new javax.swing.JTextField();
        cbIgrejas = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cbCargos = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbMinisterios = new javax.swing.JComboBox<>();
        cbSituacao = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Membros");
        setMinimumSize(new java.awt.Dimension(815, 588));
        setResizable(false);

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setDividerSize(8);

        tabela.setAutoCreateRowSorter(true);
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setText("Nome*");

        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNome.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel11.setText("CPF");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCpf.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel12.setText("Data Nasc.");

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)", "Viúvo(a)", "Divorciado(a)" }));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel13.setText("Estado Civil");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel14.setText("Gênero");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setText("Nome Pai*");

        txtNomePai.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNomePai.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setText("Nome Mãe*");

        txtNomeMae.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNomeMae.setCaretColor(new java.awt.Color(53, 59, 72));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel15.setText("Contatos*");

        txtEmails.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtEmails.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel4.setText("Emails");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNovo.setBackground(new java.awt.Color(204, 204, 204));
        btnNovo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Plus_32px.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnNovo.setMaximumSize(new java.awt.Dimension(173, 40));
        btnNovo.setPreferredSize(new java.awt.Dimension(173, 40));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        jLabel18.setText("  ");
        jToolBar1.add(jLabel18);

        btnSalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnSalvar.setEnabled(false);
        btnSalvar.setMaximumSize(new java.awt.Dimension(173, 40));
        btnSalvar.setPreferredSize(new java.awt.Dimension(173, 40));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        jLabel19.setText("  ");
        jToolBar1.add(jLabel19);

        btnExcluir.setBackground(new java.awt.Color(204, 204, 204));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(173, 40));
        btnExcluir.setPreferredSize(new java.awt.Dimension(173, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel6.setText("Endereço*");

        txtEndereco.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtEndereco.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel7.setText("Bairro*");

        txtBairro.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtBairro.setCaretColor(new java.awt.Color(53, 59, 72));

        cbEstados.setMaximumRowCount(16);
        cbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACRE", "ALAGOAS", "AMAPA", "AMAZONAS", "BAHIA", "CEARA", "DISTRITO FEDERAL", "ESPIRITO SANTO", "GOIAS", "MARANHAO", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PARA", "PARAIBA", "PARANA", "PERNAMBUCO", "PIAUI", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "RONDONIA", "RORAIAMA", "SANTA CATARINA", "SAO PAULO", "SERGIPE", "TOCANTIS" }));
        cbEstados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel5.setText("UF/Estado");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel8.setText("Cidade*");

        txtCidades.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCidades.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel9.setText("CEP");

        txtCep.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtCep.setCaretColor(new java.awt.Color(53, 59, 72));

        txtComplemento.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtComplemento.setCaretColor(new java.awt.Color(53, 59, 72));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel10.setText("Complemento");

        txtContatos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtContatos.setCaretColor(new java.awt.Color(53, 59, 72));

        cbIgrejas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIgrejasItemStateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel16.setText("Igreja / Congregação");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setText("Posição/Cargo");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel20.setText("Ministério");

        cbMinisterios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo (em comunhão)", "Inativo (Afastado)" }));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel21.setText("Situação");

        lbFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFoto.setText("Foto");
        lbFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(188, 188, 188)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNomeMae, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomePai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtContatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmails, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(txtEndereco)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCep, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txtComplemento)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(cbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMinisterios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addComponent(cbIgrejas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbIgrejas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNomePai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMinisterios, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
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
            if (txtDtNascimento.getDate() != null) {
                Membro membro = new Membro();
                membro.setNome(txtNome.getText());
                membro.setDtNascimento(df.format(txtDtNascimento.getDate()));
                membro.setGenero(cbGenero.getSelectedItem().toString());
                membro.setEstadoCivil(cbEstadoCivil.getSelectedItem().toString());
                membro.setContatos(txtContatos.getText());
                membro.setCpf(txtCpf.getText());
                membro.setEmail(txtEmails.getText());
                membro.setNomePai(txtNomePai.getText());
                membro.setNomeMae(txtNomeMae.getText());
                membro.setEndereco(txtEndereco.getText());
                membro.setBairro(txtBairro.getText());
                membro.setCidade(txtCidades.getText());
                membro.setEstado(cbEstados.getSelectedItem().toString());
                membro.setCep(txtCep.getText());
                membro.setComplemento(txtComplemento.getText());
                membro.setIdIgreja(igrejas.get(cbIgrejas.getSelectedIndex()).getId());
                membro.setCargo(cbCargos.getSelectedItem().toString());
                membro.setSituacao(cbSituacao.getSelectedItem().toString());
                membro.setMinisterio(cbMinisterios.getSelectedItem().toString());

                switch (this.getTitle()) {
                    case "Cadastrando...":
                        if (contM.Cadastrar(membro)) {
                            Limpar();
                            ListarMembros();
                            btnExcluir.setEnabled(false);
                        }
                        break;
                    case "Editando...":
                        membro.setId(Integer.parseInt(selecionado));
                        if (contM.Editar(membro)) {
                            this.setTitle("Membros");
                            Limpar();
                            ListarMembros();
                            btnSalvar.setEnabled(false);
                            btnExcluir.setEnabled(false);
                        }
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Informe a Data Nascimento",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "Deseja excluir esse Membro?",
                "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            if (contM.Excluir(Integer.parseInt(selecionado))) {
                this.setTitle("Membros");
                Limpar();
                ListarMembros();
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Selecionar();

    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = cbIgrejas.getSelectedIndex();
        String sql = "SELECT Id, Nome, Genero, EstadoCivil FROM Membros "
                + "WHERE IdIgreja = " + igrejas.get(index).getId() + " "
                + "AND  Genero='Masculino' ORDER BY Id";
        DialogTabela dialog = new DialogTabela(new JFrame(), true, DataSetTableModel.Tabela(sql));
        dialog.setVisible(true);

        if (dialog.isConfirma()) {
            ArrayList lst = dialog.getListagem();
            txtNomePai.setText(lst.get(1).toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbIgrejasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIgrejasItemStateChanged
        // TODO add your handling code here:        
    }//GEN-LAST:event_cbIgrejasItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = cbIgrejas.getSelectedIndex();
        String sql = "SELECT Id, Nome, Genero, EstadoCivil FROM Membros "
                + "WHERE IdIgreja = " + igrejas.get(index).getId() + " "
                + "AND  Genero='Feminino' ORDER BY Id";
        DialogTabela dialog = new DialogTabela(new JFrame(), true, DataSetTableModel.Tabela(sql));
        dialog.setVisible(true);

        if (dialog.isConfirma()) {
            ArrayList lst = dialog.getListagem();
            txtNomeMae.setText(lst.get(1).toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lbFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFotoMouseClicked
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        String[] formatos = {"jpg", "png", "bmp"};
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagen JPG", formatos);
        busca.setDialogTitle("Selecione a Foto");
        busca.setFileFilter(filtro);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (busca.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ImageIcon image = new ImageIcon(busca.getSelectedFile().getPath());
            lbFoto.setText(null);
            lbFoto.setIcon(new ImageIcon(image.getImage().getScaledInstance(115, 140, Image.SCALE_DEFAULT)));
        }
    }//GEN-LAST:event_lbFotoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbCargos;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbIgrejas;
    private javax.swing.JComboBox<String> cbMinisterios;
    private javax.swing.JComboBox<String> cbSituacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidades;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtContatos;
    private javax.swing.JFormattedTextField txtCpf;
    private com.toedter.calendar.JDateChooser txtDtNascimento;
    private javax.swing.JTextField txtEmails;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtNomePai;
    // End of variables declaration//GEN-END:variables
}
