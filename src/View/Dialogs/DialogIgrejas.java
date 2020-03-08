package View.Dialogs;

import Controller.ControllerIgrejas;
import Model.Igreja;
import Model.Renderer.DataSetTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DialogIgrejas extends javax.swing.JDialog {

    private final ControllerIgrejas controler;
    private String selecionado;
    
    public DialogIgrejas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controler = new ControllerIgrejas();
        ListarIgrejas();
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
            }else if (comp instanceof JFormattedTextField) {
                JFormattedTextField tf = (JFormattedTextField) comp;
                tf.setText("");
            }
        }
        
        txtPaginas.setText("http://");
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
                    txtAreaTexto.setText(value);
                    break;
                case "TIPO":
                    cbTipo.setSelectedItem(value);
                    break;
            }
        }

        this.setTitle("Editando...");
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
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
        jLabel10 = new javax.swing.JLabel();
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
        txtAreaTexto = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Igrejas");
        setResizable(false);

        jSplitPane1.setDividerLocation(370);
        jSplitPane1.setDividerSize(8);

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
        jLabel9.setText("Contatos* (Telefone / Celular / Fax / WhatsApp)");

        txtContatos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtContatos.setCaretColor(new java.awt.Color(53, 59, 72));

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCnpj.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel10.setText("Texto / Divisa");

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

        txtAreaTexto.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtAreaTexto.setCaretColor(new java.awt.Color(53, 59, 72));

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

        jLabel13.setText("  ");
        jToolBar1.add(jLabel13);

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

        jLabel14.setText("  ");
        jToolBar1.add(jLabel14);

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

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPaginas)
                    .addComponent(txtContatos)
                    .addComponent(txtEmails)
                    .addComponent(txtAreaTexto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbEstados, 0, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(4, 4, 4)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAreaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(panelCampos);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
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
            igreja.setTexto(txtAreaTexto.getText());
            igreja.setTipo(cbTipo.getSelectedItem().toString());

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtAreaTexto;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidades;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtContatos;
    private javax.swing.JTextField txtEmails;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPaginas;
    // End of variables declaration//GEN-END:variables
}
