package View.Dialogs.Utils;

import Utils.ImagePreview;
import Utils.ManipularArquivos;
import Utils.Propriedades;
import View.Forms.FrmPrincipal;
import com.bric.swing.ColorPicker;
import java.awt.Color;
import java.io.File;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AYU7-WN
 */
public class DialogConfiguracoes extends javax.swing.JDialog {

    private final String path = System.getProperty("user.dir");
    private final ManipularArquivos man = new ManipularArquivos();
    private final FrmPrincipal main;

    private final Propriedades props;
    private Properties propriedades;

    /**
     * Creates new form DialogConfiguracoes
     *
     * @param parent
     * @param modal
     * @param main
     */
    public DialogConfiguracoes(java.awt.Frame parent, boolean modal, FrmPrincipal main) {
        super(parent, modal);
        initComponents();
        this.main = main;
        ListarLogs();
        props = new Propriedades();

        CarregarConfigs();

    }

    private void CarregarConfigs() {

        propriedades = props.loadProperties();

        if (propriedades.getProperty("prop.home.backup", "false").equals("true")) {
            checkBKP.setSelected(true);
        }
        if (propriedades.getProperty("prop.home.logs", "false").equals("true")) {
            checkLOG.setSelected(true);
        }
        if (propriedades.getProperty("prop.home.menu", "false").equals("true")) {
            checkMenu.setSelected(true);
        }
        if (propriedades.getProperty("prop.home.versiculo", "false").equals("true")) {
            checkVersiculo.setSelected(true);
        }

        String barras = propriedades.getProperty("prop.cor.barras", "");
        if (!barras.equals("")) {
            String hex = "#" + propriedades.getProperty("prop.cor.barras");
            txtBarras.setText(hex);
            txtBarras.setBackground(Color.decode(hex));
        }

        String fontes = propriedades.getProperty("prop.cor.fontes", "");
        if (!fontes.equals("")) {
            String hex = "#" + propriedades.getProperty("prop.cor.fontes");
            txtFontes.setText(hex);
            txtFontes.setBackground(Color.decode(hex));
        }

        String bordas = propriedades.getProperty("prop.cor.bordas", "");
        if (!bordas.equals("")) {
            String hex = "#" + propriedades.getProperty("prop.cor.bordas");
            txtBordas.setText(hex);
            txtBordas.setBackground(Color.decode(hex));
        }

        txtImagem.setText(propriedades.getProperty("prop.home.planofundo", ""));

    }

    private void SalvarConfigs() {

        propriedades.setProperty("prop.home.planofundo", txtImagem.getText());
        propriedades.setProperty("prop.home.backup", "" + checkBKP.isSelected());
        propriedades.setProperty("prop.home.logs", "" + checkLOG.isSelected());
        propriedades.setProperty("prop.home.menu", "" + checkMenu.isSelected());
        propriedades.setProperty("prop.home.versiculo", "" + checkVersiculo.isSelected());
        propriedades.setProperty("prop.cor.barras", txtBarras.getText().replace("#", "").trim());
        propriedades.setProperty("prop.cor.fontes", txtFontes.getText().replace("#", "").trim());
        propriedades.setProperty("prop.cor.bordas", txtBordas.getText().replace("#", "").trim());

        if (props.setProperties(propriedades)) {
            this.dispose();
        }

    }

    private void ListarLogs() {

        DefaultListModel model = new DefaultListModel();

        File pasta = new File(path + "/logs");

        if (pasta.exists()) {
            File[] arquivos = pasta.listFiles();

            for (File f : arquivos) {
                model.addElement(f.getName());
            }

        }

        jList1.setModel(model);

    }

    private void CheckAviso(boolean op) {
        if (op) {
            JOptionPane.showMessageDialog(null, "Marca essa Opção\nNecessita reinicio do Sistema",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        checkBKP = new javax.swing.JCheckBox();
        checkLOG = new javax.swing.JCheckBox();
        checkMenu = new javax.swing.JCheckBox();
        checkVersiculo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtImagem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btnBarras = new javax.swing.JButton();
        txtBarras = new javax.swing.JTextField();
        btnBordas = new javax.swing.JButton();
        txtBordas = new javax.swing.JTextField();
        btnFontes = new javax.swing.JButton();
        txtFontes = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações do Sistema");
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Configurações do Sistema");

        checkBKP.setBackground(new java.awt.Color(255, 255, 255));
        checkBKP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        checkBKP.setText("Ativar aviso de BACKUP ao finalizar o sistema");
        checkBKP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBKPItemStateChanged(evt);
            }
        });
        checkBKP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBKPActionPerformed(evt);
            }
        });

        checkLOG.setBackground(new java.awt.Color(255, 255, 255));
        checkLOG.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        checkLOG.setText("Ativar Rastreio de LOG");

        checkMenu.setBackground(new java.awt.Color(255, 255, 255));
        checkMenu.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        checkMenu.setText("Iniciar o sistema com Menu Expandido");

        checkVersiculo.setBackground(new java.awt.Color(255, 255, 255));
        checkVersiculo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        checkVersiculo.setText("Mostrar versiculo biblico na Home (Inicio)");
        checkVersiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVersiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkVersiculo)
                            .addComponent(checkMenu)
                            .addComponent(checkLOG)
                            .addComponent(checkBKP))
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkBKP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkLOG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkVersiculo)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GERAIS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Para o plano de fundo utilize imagens ou gifs com resolução equivalente a 1024x720");

        txtImagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtImagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImagemFocusLost(evt);
            }
        });
        txtImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImagemActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Search_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Cores deve se utilizar valores em (Hexadecimal) ou a Paleta de cores.");

        jLabel9.setText("<html>Reset para retornar configuração salvas, ou apague todos os valores salve e reinicie o sistema para configurações padrão!</html>");

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setFloatable(false);

        btnBarras.setBackground(new java.awt.Color(255, 255, 255));
        btnBarras.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnBarras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Color_Wheel_20px_1.png"))); // NOI18N
        btnBarras.setText("Principal");
        btnBarras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBarras.setMaximumSize(new java.awt.Dimension(90, 40));
        btnBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarrasActionPerformed(evt);
            }
        });
        jToolBar2.add(btnBarras);

        txtBarras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBarras.setForeground(new java.awt.Color(204, 204, 204));
        txtBarras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBarras.setMaximumSize(new java.awt.Dimension(80, 38));
        txtBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrasActionPerformed(evt);
            }
        });
        jToolBar2.add(txtBarras);

        btnBordas.setBackground(new java.awt.Color(255, 255, 255));
        btnBordas.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnBordas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Color_Wheel_20px_1.png"))); // NOI18N
        btnBordas.setText("Bordas");
        btnBordas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBordas.setMaximumSize(new java.awt.Dimension(90, 40));
        btnBordas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBordasActionPerformed(evt);
            }
        });
        jToolBar2.add(btnBordas);

        txtBordas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBordas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBordas.setMaximumSize(new java.awt.Dimension(80, 38));
        txtBordas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBordasActionPerformed(evt);
            }
        });
        jToolBar2.add(txtBordas);

        btnFontes.setBackground(new java.awt.Color(255, 255, 255));
        btnFontes.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnFontes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Color_Wheel_20px_1.png"))); // NOI18N
        btnFontes.setText("Fontes");
        btnFontes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnFontes.setMaximumSize(new java.awt.Dimension(90, 40));
        btnFontes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFontesActionPerformed(evt);
            }
        });
        jToolBar2.add(btnFontes);

        txtFontes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFontes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFontes.setMaximumSize(new java.awt.Dimension(80, 38));
        txtFontes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFontesActionPerformed(evt);
            }
        });
        jToolBar2.add(txtFontes);

        jButton2.setText("Reset");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("TEMA", jPanel2);

        jSplitPane1.setDividerLocation(100);
        jSplitPane1.setDividerSize(7);
        jSplitPane1.setOneTouchExpandable(true);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);

        jTabbedPane1.addTab("LOGS", jSplitPane1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("LICENÇA", jPanel3);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel3.setMaximumSize(new java.awt.Dimension(210, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(200, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 14));
        jToolBar1.add(jLabel3);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalvar.setFocusable(false);
        btnSalvar.setMaximumSize(new java.awt.Dimension(120, 40));
        btnSalvar.setPreferredSize(new java.awt.Dimension(173, 40));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged

        String select = jList1.getSelectedValue();
        File file = new File(path + "/Logs/" + select);

        String saida = man.LerArquivo(file);
        jTextArea1.setText(saida);

    }//GEN-LAST:event_jList1ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser(path + "/Imagens");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Imagem",
                new String[]{"png", "jpg", "bmp", "gif"});
        busca.setFileFilter(filtro);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);
        busca.setDialogTitle("Selecione uma Imagem");
        busca.setAccessory(new ImagePreview(busca));

        if (busca.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File arquivo = busca.getSelectedFile();
            txtImagem.setText(arquivo.getAbsolutePath());
            main.PlanoFundo(arquivo.getAbsolutePath());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        SalvarConfigs();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrasActionPerformed
        // TODO add your handling code here:

        String format = txtBarras.getText().trim();
        if (!format.equals("") && format.length() >= 6) {
            Color cor = Color.decode(format);
            main.ColorPrincipal(cor);
            txtBarras.setBackground(cor);
        }

    }//GEN-LAST:event_txtBarrasActionPerformed

    private void txtFontesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFontesActionPerformed
        // TODO add your handling code here:
        String format = txtFontes.getText().trim();
        if (!format.equals("") && format.length() >= 6) {
            Color cor = Color.decode(format);
            main.ColorFontes(cor);
            txtFontes.setBackground(cor);
        }
    }//GEN-LAST:event_txtFontesActionPerformed

    private void btnBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarrasActionPerformed
        // TODO add your handling code here:

        Color cor = ColorPicker.showDialog(null, txtBarras.getBackground());

        if (cor != null) {
            txtBarras.setBackground(cor);
            main.ColorPrincipal(cor);
            String hex = "#" + Integer.toHexString(cor.getRGB()).substring(2);
            txtBarras.setText(hex);
        }

    }//GEN-LAST:event_btnBarrasActionPerformed

    private void btnFontesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFontesActionPerformed
        // TODO add your handling code here:

        Color cor = ColorPicker.showDialog(null, txtBarras.getBackground());

        if (cor != null) {
            txtFontes.setBackground(cor);
            main.ColorFontes(cor);

            String hex = "#" + Integer.toHexString(cor.getRGB()).substring(2);
            txtFontes.setText(hex);
        }


    }//GEN-LAST:event_btnFontesActionPerformed

    private void txtBordasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBordasActionPerformed
        // TODO add your handling code here:
        String format = txtBordas.getText().trim();
        if (!format.equals("") && format.length() >= 6) {
            Color cor = Color.decode(format);
            main.ColorBordas(cor);
            txtBordas.setBackground(cor);
        }
    }//GEN-LAST:event_txtBordasActionPerformed

    private void btnBordasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBordasActionPerformed
        // TODO add your handling code here:
        Color cor = ColorPicker.showDialog(null, txtBarras.getBackground());

        if (cor != null) {
            txtBordas.setBackground(cor);
            main.ColorBordas(cor);

            String hex = "#" + Integer.toHexString(cor.getRGB()).substring(2);
            txtBordas.setText(hex);
        }
    }//GEN-LAST:event_btnBordasActionPerformed

    private void txtImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImagemActionPerformed
        // TODO add your handling code here:

        String arquivo = txtImagem.getText().trim();

        if (new File(arquivo).exists()) {
            main.PlanoFundo(arquivo);
        } else {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtImagem.setText(null);
        }

    }//GEN-LAST:event_txtImagemActionPerformed

    private void txtImagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImagemFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImagemFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtBarras.setText(null);
        txtBordas.setText(null);
        txtFontes.setText(null);
        txtImagem.setText(null);

        CarregarConfigs();
        main.CarregarConfiguracoes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkBKPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBKPItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_checkBKPItemStateChanged

    private void checkBKPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBKPActionPerformed
        // TODO add your handling code here:
        CheckAviso(checkBKP.isSelected());
    }//GEN-LAST:event_checkBKPActionPerformed

    private void checkVersiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVersiculoActionPerformed
        // TODO add your handling code here:
        CheckAviso(checkVersiculo.isSelected());
    }//GEN-LAST:event_checkVersiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarras;
    private javax.swing.JButton btnBordas;
    private javax.swing.JButton btnFontes;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkBKP;
    private javax.swing.JCheckBox checkLOG;
    private javax.swing.JCheckBox checkMenu;
    private javax.swing.JCheckBox checkVersiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtBordas;
    private javax.swing.JTextField txtFontes;
    private javax.swing.JTextField txtImagem;
    // End of variables declaration//GEN-END:variables
}
