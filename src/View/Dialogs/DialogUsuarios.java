package View.Dialogs;

import Controller.ControllerGenerico;
import Controller.ControllerUsuarios;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class DialogUsuarios extends javax.swing.JDialog {

    private final ControllerGenerico controler;
    private ArrayList<String[]> usuarios;

    /**
     * Creates new form DialogUsuarios
     *
     * @param parent
     * @param modal
     */
    public DialogUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controler = new ControllerGenerico();
        ListaUsuarios();
    }

    private void ListaUsuarios() {

        String sql = "SELECT Id, Nome, Senha, Dica FROM Usuarios";
        usuarios = controler.Listar(sql);

        jComboBox1.removeAllItems();
        jComboBox1.addItem("Novo Usuario");
        
        usuarios.stream().forEach((s) -> {
            jComboBox1.addItem(s[1]);
        });

    }

    private void Salvar() {

        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        String dica = txtDica.getText();

        ControllerUsuarios user = new ControllerUsuarios();
       
        if (this.getTitle().equals("Editando...")) {
            String id = usuarios.get(jComboBox1.getSelectedIndex() - 1)[0];
            if (user.Editar(Integer.parseInt(id), nome, senha, dica)) {
                txtNome.setText(null);
                txtSenha.setText(null);
                txtDica.setText(null);
                ListaUsuarios();
            }

        } else if (user.Cadastrar(nome, senha, dica)) {
            txtNome.setText(null);
            txtSenha.setText(null);
            txtDica.setText(null);
            ListaUsuarios();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtDica = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToolBar2 = new javax.swing.JToolBar();
        btnSalvar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(53, 59, 72));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");

        txtNome.setBackground(new java.awt.Color(53, 59, 72));
        txtNome.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtNome.setForeground(new java.awt.Color(255, 255, 255));
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNome.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha");

        txtSenha.setBackground(new java.awt.Color(53, 59, 72));
        txtSenha.setForeground(new java.awt.Color(255, 255, 255));
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtSenha.setCaretColor(new java.awt.Color(255, 255, 255));

        txtDica.setBackground(new java.awt.Color(53, 59, 72));
        txtDica.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txtDica.setForeground(new java.awt.Color(255, 255, 255));
        txtDica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtDica.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dica");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jToolBar2.setBackground(new java.awt.Color(53, 59, 72));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnSalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Save_32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(173, 40));
        btnSalvar.setPreferredSize(new java.awt.Dimension(173, 40));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSalvar);

        jLabel14.setText("  ");
        jToolBar2.add(jLabel14);

        btnExcluir.setBackground(new java.awt.Color(204, 204, 204));
        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Minus_32px.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setMaximumSize(new java.awt.Dimension(173, 40));
        btnExcluir.setPreferredSize(new java.awt.Dimension(173, 40));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar2.add(btnExcluir);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha)
                    .addComponent(jLabel3)
                    .addComponent(txtDica)
                    .addComponent(jComboBox1, 0, 237, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(txtDica, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (txtNome.getText().equals("")) {
            txtNome.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        }else if (txtSenha.getText().equals("")) {
            txtSenha.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        }else if (txtDica.getText().equals("")) {
            txtDica.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        }else{
            Salvar();
            txtNome.setBackground(new Color(53,59,72));
            txtSenha.setBackground(new Color(53,59,72));
            txtDica.setBackground(new Color(53,59,72));
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null,
                "Deseja excluir esse Usuários?\n" + jComboBox1.getSelectedItem(),
                "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {

            int index = jComboBox1.getSelectedIndex();
            int id = Integer.parseInt(usuarios.get(index - 1)[0]);

            if (controler.Excluir(id, "Id", "Usuarios")) {
                txtNome.setText(null);
                txtSenha.setText(null);
                txtDica.setText(null);
                ListaUsuarios();
            }

        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:

        int index = jComboBox1.getSelectedIndex();

        if (index > 0) {
            this.setTitle("Editando...");
            btnExcluir.setEnabled(true);
            String[] values = usuarios.get(index - 1);
            txtNome.setText(values[1]);
            txtSenha.setText(values[2]);
            txtDica.setText(values[3]);
        } else {
            btnExcluir.setEnabled(false);
            txtNome.setText(null);
            txtSenha.setText(null);
            txtDica.setText(null);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField txtDica;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
