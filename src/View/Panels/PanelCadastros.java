package View.Panels;

import View.Dialogs.Utils.DialogCards;
import View.Dialogs.Utils.DialogLoading;
import javax.swing.JFrame;

/**
 *
 * @author AYU7-WN
 */
public class PanelCadastros extends javax.swing.JPanel {

    /**
     * Creates new form PanelIgrejas
     */
    public PanelCadastros() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        panelMembros = new javax.swing.JPanel();
        lbMembros = new javax.swing.JLabel();
        panelIgrejas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelPatrimonios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelUsuarios = new javax.swing.JPanel();
        lbUsuarios = new javax.swing.JLabel();
        panelUsuarios1 = new javax.swing.JPanel();
        lbEventos = new javax.swing.JLabel();
        panelCargos = new javax.swing.JPanel();
        lbCargos = new javax.swing.JLabel();
        panelAtas = new javax.swing.JPanel();
        lbCargos2 = new javax.swing.JLabel();
        panelClasses = new javax.swing.JPanel();
        lbClasses = new javax.swing.JLabel();
        panelCampanhas = new javax.swing.JPanel();
        lbCargos5 = new javax.swing.JLabel();
        paneFuncionarios = new javax.swing.JPanel();
        lbCargos4 = new javax.swing.JLabel();
        panelContatos = new javax.swing.JPanel();
        lbCargos1 = new javax.swing.JLabel();
        panelLembretes = new javax.swing.JPanel();
        lbCargos6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

        panelMembros.setBackground(new java.awt.Color(51, 217, 178));
        panelMembros.setPreferredSize(new java.awt.Dimension(220, 192));

        lbMembros.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbMembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMembros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Team_50px.png"))); // NOI18N
        lbMembros.setText("Membros");
        lbMembros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMembros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMembros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMembrosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMembrosLayout = new javax.swing.GroupLayout(panelMembros);
        panelMembros.setLayout(panelMembrosLayout);
        panelMembrosLayout.setHorizontalGroup(
            panelMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMembros, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMembrosLayout.setVerticalGroup(
            panelMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMembros, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelMembros);

        panelIgrejas.setBackground(new java.awt.Color(71, 71, 135));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_House_50px.png"))); // NOI18N
        jLabel2.setText("Igrejas");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelIgrejasLayout = new javax.swing.GroupLayout(panelIgrejas);
        panelIgrejas.setLayout(panelIgrejasLayout);
        panelIgrejasLayout.setHorizontalGroup(
            panelIgrejasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIgrejasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelIgrejasLayout.setVerticalGroup(
            panelIgrejasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIgrejasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelIgrejas);

        panelPatrimonios.setBackground(new java.awt.Color(52, 172, 224));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Add_Tag_50px.png"))); // NOI18N
        jLabel3.setText("Patrimônios");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPatrimoniosLayout = new javax.swing.GroupLayout(panelPatrimonios);
        panelPatrimonios.setLayout(panelPatrimoniosLayout);
        panelPatrimoniosLayout.setHorizontalGroup(
            panelPatrimoniosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatrimoniosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPatrimoniosLayout.setVerticalGroup(
            panelPatrimoniosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatrimoniosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelPatrimonios);

        panelUsuarios.setBackground(new java.awt.Color(170, 166, 157));

        lbUsuarios.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Customer_50px.png"))); // NOI18N
        lbUsuarios.setText("Usuários");
        lbUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelUsuarios);

        panelUsuarios1.setBackground(new java.awt.Color(255, 218, 121));

        lbEventos.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbEventos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Schedule_50px.png"))); // NOI18N
        lbEventos.setText("Eventos");
        lbEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEventos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbEventos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEventosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelUsuarios1Layout = new javax.swing.GroupLayout(panelUsuarios1);
        panelUsuarios1.setLayout(panelUsuarios1Layout);
        panelUsuarios1Layout.setHorizontalGroup(
            panelUsuarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarios1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbEventos, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelUsuarios1Layout.setVerticalGroup(
            panelUsuarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarios1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbEventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelUsuarios1);

        panelCargos.setBackground(new java.awt.Color(112, 111, 211));

        lbCargos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbCargos.setForeground(new java.awt.Color(255, 255, 255));
        lbCargos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Rubik's_Cube_50px.png"))); // NOI18N
        lbCargos.setText("Cargos e Ministérios");
        lbCargos.setToolTipText("Cargos e Ministérios");
        lbCargos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCargos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCargos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCargosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCargosLayout = new javax.swing.GroupLayout(panelCargos);
        panelCargos.setLayout(panelCargosLayout);
        panelCargosLayout.setHorizontalGroup(
            panelCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCargosLayout.setVerticalGroup(
            panelCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCargosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelCargos);

        panelAtas.setBackground(new java.awt.Color(255, 255, 204));
        panelAtas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCargos2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbCargos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Hand_With_Pen_50px.png"))); // NOI18N
        lbCargos2.setText("Atas");
        lbCargos2.setToolTipText("Cargos e Ministérios");
        lbCargos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCargos2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCargos2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCargos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCargos2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelAtas);

        panelClasses.setBackground(new java.awt.Color(153, 153, 255));

        lbClasses.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbClasses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClasses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Class_50px.png"))); // NOI18N
        lbClasses.setText("Classes");
        lbClasses.setToolTipText("Cargos e Ministérios");
        lbClasses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClasses.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbClasses.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClassesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelClassesLayout = new javax.swing.GroupLayout(panelClasses);
        panelClasses.setLayout(panelClassesLayout);
        panelClassesLayout.setHorizontalGroup(
            panelClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelClassesLayout.setVerticalGroup(
            panelClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelClasses);

        panelCampanhas.setBackground(new java.awt.Color(255, 153, 153));

        lbCargos5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbCargos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargos5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Trust_50px.png"))); // NOI18N
        lbCargos5.setText("Campanhas");
        lbCargos5.setToolTipText("Cargos e Ministérios");
        lbCargos5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCargos5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCargos5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCargos5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCargos5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCampanhasLayout = new javax.swing.GroupLayout(panelCampanhas);
        panelCampanhas.setLayout(panelCampanhasLayout);
        panelCampanhasLayout.setHorizontalGroup(
            panelCampanhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCampanhasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos5, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCampanhasLayout.setVerticalGroup(
            panelCampanhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCampanhasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos5, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelCampanhas);

        paneFuncionarios.setBackground(new java.awt.Color(204, 204, 255));

        lbCargos4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbCargos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargos4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Janitor_50px_1.png"))); // NOI18N
        lbCargos4.setText("Funcionários");
        lbCargos4.setToolTipText("Cargos e Ministérios");
        lbCargos4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCargos4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCargos4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCargos4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCargos4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneFuncionariosLayout = new javax.swing.GroupLayout(paneFuncionarios);
        paneFuncionarios.setLayout(paneFuncionariosLayout);
        paneFuncionariosLayout.setHorizontalGroup(
            paneFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneFuncionariosLayout.setVerticalGroup(
            paneFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(paneFuncionarios);

        panelContatos.setBackground(new java.awt.Color(0, 102, 102));

        lbCargos1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbCargos1.setForeground(new java.awt.Color(255, 255, 255));
        lbCargos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Contacts_50px.png"))); // NOI18N
        lbCargos1.setText("Contatos");
        lbCargos1.setToolTipText("Cargos e Ministérios");
        lbCargos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCargos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCargos1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCargos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCargos1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelContatosLayout = new javax.swing.GroupLayout(panelContatos);
        panelContatos.setLayout(panelContatosLayout);
        panelContatosLayout.setHorizontalGroup(
            panelContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelContatosLayout.setVerticalGroup(
            panelContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelContatos);

        panelLembretes.setBackground(new java.awt.Color(255, 255, 255));
        panelLembretes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        lbCargos6.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lbCargos6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargos6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Note_50px.png"))); // NOI18N
        lbCargos6.setText("Lembretes");
        lbCargos6.setToolTipText("Cargos e Ministérios");
        lbCargos6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCargos6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCargos6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCargos6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCargos6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLembretesLayout = new javax.swing.GroupLayout(panelLembretes);
        panelLembretes.setLayout(panelLembretesLayout);
        panelLembretesLayout.setHorizontalGroup(
            panelLembretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLembretesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLembretesLayout.setVerticalGroup(
            panelLembretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLembretesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCargos6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(panelLembretes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbMembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMembrosMouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Membros").setVisible(true);
    }//GEN-LAST:event_lbMembrosMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Igrejas").setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Patrimonios").setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUsuariosMouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Usuarios").setVisible(true);
    }//GEN-LAST:event_lbUsuariosMouseClicked

    private void lbEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEventosMouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Eventos").setVisible(true);
    }//GEN-LAST:event_lbEventosMouseClicked

    private void lbCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCargosMouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Cargos").setVisible(true);
    }//GEN-LAST:event_lbCargosMouseClicked

    private void lbCargos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCargos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCargos1MouseClicked

    private void lbCargos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCargos2MouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Atas").setVisible(true);        
    }//GEN-LAST:event_lbCargos2MouseClicked

    private void lbClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClassesMouseClicked
        // TODO add your handling code here:
        new DialogLoading(new JFrame(), true, "Classes").setVisible(true);  
    }//GEN-LAST:event_lbClassesMouseClicked

    private void lbCargos4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCargos4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCargos4MouseClicked

    private void lbCargos5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCargos5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCargos5MouseClicked

    private void lbCargos6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCargos6MouseClicked
        // TODO add your handling code here:
        DialogCards dialog = new DialogCards(new JFrame(), true, "Lembretes", 0);
        dialog.setVisible(true);
    }//GEN-LAST:event_lbCargos6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbCargos;
    private javax.swing.JLabel lbCargos1;
    private javax.swing.JLabel lbCargos2;
    private javax.swing.JLabel lbCargos4;
    private javax.swing.JLabel lbCargos5;
    private javax.swing.JLabel lbCargos6;
    private javax.swing.JLabel lbClasses;
    private javax.swing.JLabel lbEventos;
    private javax.swing.JLabel lbMembros;
    private javax.swing.JLabel lbUsuarios;
    private javax.swing.JPanel paneFuncionarios;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelCampanhas;
    private javax.swing.JPanel panelCargos;
    private javax.swing.JPanel panelClasses;
    private javax.swing.JPanel panelContatos;
    private javax.swing.JPanel panelIgrejas;
    private javax.swing.JPanel panelLembretes;
    private javax.swing.JPanel panelMembros;
    private javax.swing.JPanel panelPatrimonios;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JPanel panelUsuarios1;
    // End of variables declaration//GEN-END:variables
}
