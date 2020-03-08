package View.Forms;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import Controller.ControllerIgrejas;
import Utils.Propriedades;
import View.Dialogs.Utils.DialogConfiguracoes;
import View.Dialogs.Utils.DialogLoading;
import View.Dialogs.Utils.DialogOptions;
import View.Dialogs.Utils.DialogSobre;
import View.Panels.PanelCadastros;
import View.Panels.PanelFerramentas;
import View.Panels.PanelFinanceiro;
import View.Panels.PanelInicio;
import View.Panels.PanelRelatorios;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

/**
 *
 * @author AYU7-WN
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private final GraphicsDevice gd;
    private final CardLayout conteiner;

    private PanelCadastros cadastros;
    private PanelRelatorios relatorios;
    private PanelFinanceiro financeiro;
    private PanelFerramentas ferramentas;
    private PanelInicio inicio;

    int eixoX, eixoY, finalizar = 0;

    public FrmPrincipal() {
        initComponents();

        conteiner = (CardLayout) Conteiner.getLayout();
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (new ControllerIgrejas().Listar().isEmpty()) {
            DialogLoading dialog = new DialogLoading(this, true, "Igrejas");
            dialog.setVisible(true);
        } else {
            MostrarPainel("Inicio");
        }

        CarregarConfiguracoes();

    }

    // --------- METODOS PRIVADOS -------------- //
    private void MarcarSelecao(String label) {

        for (int i = 0; i < Menu.getComponentCount(); i++) {
            Component comp = Menu.getComponent(i);
            if (comp instanceof JLabel) {
                JLabel lb = (JLabel) comp;
                if (lb.getText().equals(label)) {
                    lb.setFont(new Font("Century Gothic", Font.BOLD, 16));
                } else {
                    lb.setFont(new Font("Century Gothic", Font.PLAIN, 16));
                }
            }
        }
    }

    private void TransparenteFrame(boolean view) {

        if (gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            if (view) {
                this.setOpacity(0.7f);
            } else {
                this.setOpacity(1.0f);
            }
        }
    }

    private void MostrarPainel(String name) {

        switch (name) {
            case "Inicio":
                if (inicio == null) {
                    inicio = new PanelInicio();
                    Conteiner.add(inicio, name);
                }
                break;
            case "Cadastros":
                if (cadastros == null) {
                    cadastros = new PanelCadastros();
                    Conteiner.add(cadastros, name);
                }
                break;
            case "Relatórios":
                if (relatorios == null) {
                    relatorios = new PanelRelatorios();
                    Conteiner.add(relatorios, name);
                }
                break;
            case "Financeiro":
                if (financeiro == null) {
                    financeiro = new PanelFinanceiro();
                    Conteiner.add(financeiro, name);
                }
                break;
            case "Ferramentas":
                if (ferramentas == null) {
                    ferramentas = new PanelFerramentas();
                    Conteiner.add(ferramentas, name);
                }
                break;
            case "Sobre":
                break;
        }

        MarcarSelecao(name);
        conteiner.show(Conteiner, name);
        SwingUtilities.updateComponentTreeUI(Conteiner);

    }

    private void DialogConfiguracoes() {

        MarcarSelecao(lbConfiguracao.getText());
        DialogConfiguracoes dialog = new DialogConfiguracoes(this, false, this);
        dialog.setVisible(true);

    }

    private void DialogFinalizar() {

        if (finalizar > 0) {
            DialogOptions opt = new DialogOptions(this, true);
            opt.setIconMessage("Deseja realizar o Backup antes de finalizar do Sistema?");
            opt.setVisible(true);

            if (opt.isConfirma()) {

            }

        }

        System.exit(0);

    }

    // ---------- METODOS PUBLICOS ---------------- //
    public final void CarregarConfiguracoes() {

        Properties propriedades = new Propriedades().loadProperties();

        String wallpaper = propriedades.getProperty("prop.home.planofundo", "");
        if (!wallpaper.equals("")) {
            PlanoFundo(wallpaper);
        }

        String barras = propriedades.getProperty("prop.cor.barras", "");
        if (!barras.equals("")) {
            ColorPrincipal(Color.decode("#" + barras));
        }

        String fontes = propriedades.getProperty("prop.cor.fontes", "");
        if (!fontes.equals("")) {
            ColorFontes(Color.decode("#" + fontes));
        }

        String bordas = propriedades.getProperty("prop.cor.bordas", "");
        if (!bordas.equals("")) {
            ColorBordas(Color.decode("#" + bordas));
        }

        String backup = propriedades.getProperty("prop.home.backup", "false");
        if (backup.equals("true")) {
            finalizar = 1;
        }

        String menu = propriedades.getProperty("prop.home.menu", "false");
        if (menu.equals("true")) {
            Menu.setVisible(true);
            Linha.setVisible(true);
        } else {
            Menu.setVisible(false);
            Linha.setVisible(false);
        }

    }

    public final void UsuarioLogado(String nome) {
        lbImgUser.setText(nome);
    }

    public final void PlanoFundo(String path) {

        if (new File(path).exists()) {
            Conteiner.setOpaque(false);
            ImageIcon image = new ImageIcon(path);
            lbBackground.setIcon(new ImageIcon(image.getImage()
                    .getScaledInstance(1026, 618, Image.SCALE_DEFAULT)));
        }

    }

    public final void ColorFontes(Color cor) {

        lbTitulo.setForeground(cor);

        for (int i = 0; i < Menu.getComponentCount(); i++) {
            Component comp = Menu.getComponent(i);
            if (comp instanceof JLabel) {
                JLabel lb = (JLabel) comp;
                lb.setForeground(cor);
            }
        }

    }

    public final void ColorPrincipal(Color cor) {
        Menu.setBackground(cor);
        Icones.setBackground(cor);
        Topo.setBackground(cor);
        Conteiner.setBackground(cor);
    }

    public final void ColorBordas(Color cor) {

        LineBorder border = new LineBorder(cor, 2, true);
        Topo.setBorder(border);
        Base.setBorder(border);

        jSeparator1.setBackground(cor);
        jSeparator1.setForeground(cor);

        Linha.setBackground(cor);
        Linha.setForeground(cor);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        Topo = new javax.swing.JPanel();
        lbFinalizar = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbMinimizar1 = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        Icones = new javax.swing.JPanel();
        IcoInicio = new javax.swing.JLabel();
        IcoCadastros = new javax.swing.JLabel();
        IcoRelatorios = new javax.swing.JLabel();
        IcoFinanceiro = new javax.swing.JLabel();
        IcoFerramentas = new javax.swing.JLabel();
        IcoConfiguracao = new javax.swing.JLabel();
        IcoSobre = new javax.swing.JLabel();
        IcoLogout = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        lbRelatorios = new javax.swing.JLabel();
        lbFinanceiro = new javax.swing.JLabel();
        lbFerramentas = new javax.swing.JLabel();
        lbConfiguracao = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();
        lbSobre = new javax.swing.JLabel();
        lbCadastros = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        lbImgUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Linha = new javax.swing.JSeparator();
        Conteiner = new javax.swing.JPanel();
        lbBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1030, 660));
        setUndecorated(true);
        setResizable(false);

        Base.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        Base.setMinimumSize(new java.awt.Dimension(1030, 660));
        Base.setOpaque(false);
        Base.setPreferredSize(new java.awt.Dimension(1030, 660));
        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Topo.setBackground(new java.awt.Color(52, 73, 94));
        Topo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        Topo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Topo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TopoMouseDragged(evt);
            }
        });
        Topo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TopoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TopoMouseReleased(evt);
            }
        });

        lbFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Close_Window_24px.png"))); // NOI18N
        lbFinalizar.setToolTipText("Finalizar");
        lbFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFinalizarMouseClicked(evt);
            }
        });

        lbTitulo.setBackground(new java.awt.Color(53, 59, 72));
        lbTitulo.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Filled_Bookmark_Ribbon_32px.png"))); // NOI18N
        lbTitulo.setText("SGM, Sistema Gerenciamento de Membros");

        lbMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Minimize_Window_24px.png"))); // NOI18N
        lbMinimizar.setToolTipText("Minimizar");
        lbMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseClicked(evt);
            }
        });

        lbMinimizar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinimizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Menu_32px_1.png"))); // NOI18N
        lbMinimizar1.setToolTipText("Minimizar");
        lbMinimizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbMinimizar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMinimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TopoLayout = new javax.swing.GroupLayout(Topo);
        Topo.setLayout(TopoLayout);
        TopoLayout.setHorizontalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMinimizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFinalizar)
                .addGap(6, 6, 6))
        );
        TopoLayout.setVerticalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addGroup(TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbFinalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(lbMinimizar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Base.add(Topo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 40));

        Centro.setBackground(new java.awt.Color(52, 73, 94));
        Centro.setOpaque(false);
        Centro.setPreferredSize(new java.awt.Dimension(1026, 100));
        Centro.setLayout(new javax.swing.BoxLayout(Centro, javax.swing.BoxLayout.LINE_AXIS));

        Icones.setBackground(new java.awt.Color(52, 73, 94));
        Icones.setMaximumSize(new java.awt.Dimension(40, 32767));
        Icones.setMinimumSize(new java.awt.Dimension(40, 0));
        Icones.setPreferredSize(new java.awt.Dimension(40, 618));

        IcoInicio.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoInicio.setForeground(new java.awt.Color(255, 255, 255));
        IcoInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Home_32px.png"))); // NOI18N
        IcoInicio.setToolTipText("Inicio");
        IcoInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoInicio.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoInicio.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoInicio.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoInicioMouseClicked(evt);
            }
        });

        IcoCadastros.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoCadastros.setForeground(new java.awt.Color(255, 255, 255));
        IcoCadastros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Add_Folder_32px.png"))); // NOI18N
        IcoCadastros.setToolTipText("Cadastros");
        IcoCadastros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoCadastros.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoCadastros.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoCadastros.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoCadastros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoCadastrosMouseClicked(evt);
            }
        });

        IcoRelatorios.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        IcoRelatorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Edit_File_32px.png"))); // NOI18N
        IcoRelatorios.setToolTipText("Relatórios");
        IcoRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoRelatorios.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoRelatorios.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoRelatorios.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoRelatoriosMouseClicked(evt);
            }
        });

        IcoFinanceiro.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        IcoFinanceiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Wallet_32px.png"))); // NOI18N
        IcoFinanceiro.setToolTipText("Financeiro");
        IcoFinanceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoFinanceiro.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoFinanceiro.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoFinanceiro.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoFinanceiroMouseClicked(evt);
            }
        });

        IcoFerramentas.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoFerramentas.setForeground(new java.awt.Color(255, 255, 255));
        IcoFerramentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Maintenance_32px.png"))); // NOI18N
        IcoFerramentas.setToolTipText("Ferramentas");
        IcoFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoFerramentas.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoFerramentas.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoFerramentas.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoFerramentasMouseClicked(evt);
            }
        });

        IcoConfiguracao.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoConfiguracao.setForeground(new java.awt.Color(255, 255, 255));
        IcoConfiguracao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Settings_32px.png"))); // NOI18N
        IcoConfiguracao.setToolTipText("Configurações");
        IcoConfiguracao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoConfiguracao.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoConfiguracao.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoConfiguracao.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoConfiguracaoMouseClicked(evt);
            }
        });

        IcoSobre.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoSobre.setForeground(new java.awt.Color(255, 255, 255));
        IcoSobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Info_32px.png"))); // NOI18N
        IcoSobre.setToolTipText("Sobre");
        IcoSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoSobre.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoSobre.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoSobre.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoSobreMouseClicked(evt);
            }
        });

        IcoLogout.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        IcoLogout.setForeground(new java.awt.Color(255, 255, 255));
        IcoLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IcoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Exit_32px.png"))); // NOI18N
        IcoLogout.setToolTipText("Sair (Logout)");
        IcoLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IcoLogout.setMaximumSize(new java.awt.Dimension(10, 40));
        IcoLogout.setMinimumSize(new java.awt.Dimension(10, 40));
        IcoLogout.setName(""); // NOI18N
        IcoLogout.setPreferredSize(new java.awt.Dimension(10, 40));
        IcoLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcoLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout IconesLayout = new javax.swing.GroupLayout(Icones);
        Icones.setLayout(IconesLayout);
        IconesLayout.setHorizontalGroup(
            IconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IcoCadastros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoConfiguracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoSobre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(IcoLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        IconesLayout.setVerticalGroup(
            IconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconesLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(IcoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IcoSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        Centro.add(Icones);

        Menu.setBackground(new java.awt.Color(52, 73, 94));
        Menu.setMaximumSize(new java.awt.Dimension(230, 620));
        Menu.setPreferredSize(new java.awt.Dimension(230, 620));

        lbRelatorios.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        lbRelatorios.setText("Relatórios");
        lbRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRelatorios.setIconTextGap(10);
        lbRelatorios.setMaximumSize(new java.awt.Dimension(250, 45));
        lbRelatorios.setMinimumSize(new java.awt.Dimension(250, 45));
        lbRelatorios.setPreferredSize(new java.awt.Dimension(200, 40));
        lbRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRelatoriosMouseClicked(evt);
            }
        });

        lbFinanceiro.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        lbFinanceiro.setText("Financeiro");
        lbFinanceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFinanceiro.setIconTextGap(10);
        lbFinanceiro.setMaximumSize(new java.awt.Dimension(250, 45));
        lbFinanceiro.setMinimumSize(new java.awt.Dimension(250, 45));
        lbFinanceiro.setPreferredSize(new java.awt.Dimension(200, 40));
        lbFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFinanceiroMouseClicked(evt);
            }
        });

        lbFerramentas.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbFerramentas.setForeground(new java.awt.Color(255, 255, 255));
        lbFerramentas.setText("Ferramentas");
        lbFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFerramentas.setIconTextGap(10);
        lbFerramentas.setMaximumSize(new java.awt.Dimension(250, 45));
        lbFerramentas.setMinimumSize(new java.awt.Dimension(250, 45));
        lbFerramentas.setPreferredSize(new java.awt.Dimension(200, 40));

        lbConfiguracao.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbConfiguracao.setForeground(new java.awt.Color(255, 255, 255));
        lbConfiguracao.setText("Configuracões");
        lbConfiguracao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbConfiguracao.setIconTextGap(10);
        lbConfiguracao.setMaximumSize(new java.awt.Dimension(250, 45));
        lbConfiguracao.setMinimumSize(new java.awt.Dimension(250, 45));
        lbConfiguracao.setPreferredSize(new java.awt.Dimension(200, 40));
        lbConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbConfiguracaoMouseClicked(evt);
            }
        });

        lbLogout.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbLogout.setForeground(new java.awt.Color(255, 255, 255));
        lbLogout.setText("Logout");
        lbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogout.setIconTextGap(10);
        lbLogout.setMaximumSize(new java.awt.Dimension(250, 45));
        lbLogout.setMinimumSize(new java.awt.Dimension(250, 45));
        lbLogout.setPreferredSize(new java.awt.Dimension(200, 40));
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoutMouseClicked(evt);
            }
        });

        lbSobre.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbSobre.setForeground(new java.awt.Color(255, 255, 255));
        lbSobre.setText("Sobre");
        lbSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSobre.setIconTextGap(10);
        lbSobre.setMaximumSize(new java.awt.Dimension(250, 45));
        lbSobre.setMinimumSize(new java.awt.Dimension(250, 45));
        lbSobre.setPreferredSize(new java.awt.Dimension(200, 40));
        lbSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSobreMouseClicked(evt);
            }
        });

        lbCadastros.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbCadastros.setForeground(new java.awt.Color(255, 255, 255));
        lbCadastros.setText("Cadastros");
        lbCadastros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCadastros.setIconTextGap(10);
        lbCadastros.setMaximumSize(new java.awt.Dimension(250, 45));
        lbCadastros.setMinimumSize(new java.awt.Dimension(250, 45));
        lbCadastros.setPreferredSize(new java.awt.Dimension(200, 40));
        lbCadastros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCadastrosMouseClicked(evt);
            }
        });

        lbInicio.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbInicio.setForeground(new java.awt.Color(255, 255, 255));
        lbInicio.setText("Inicio");
        lbInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbInicio.setIconTextGap(10);
        lbInicio.setMaximumSize(new java.awt.Dimension(250, 45));
        lbInicio.setMinimumSize(new java.awt.Dimension(250, 45));
        lbInicio.setPreferredSize(new java.awt.Dimension(200, 40));
        lbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbInicioMouseClicked(evt);
            }
        });

        lbImgUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbImgUser.setForeground(new java.awt.Color(255, 255, 255));
        lbImgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Contacts_64px.png"))); // NOI18N
        lbImgUser.setText("Usuário");
        lbImgUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbImgUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbImgUser.setIconTextGap(1);
        lbImgUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbImgUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImgUserMouseClicked(evt);
            }
        });

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 15));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbImgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        Centro.add(Menu);

        Linha.setForeground(new java.awt.Color(255, 255, 255));
        Linha.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Centro.add(Linha);

        Conteiner.setBackground(new java.awt.Color(52, 73, 94));
        Conteiner.setMinimumSize(new java.awt.Dimension(720, 620));
        Conteiner.setPreferredSize(new java.awt.Dimension(720, 620));
        Conteiner.setLayout(new java.awt.CardLayout());
        Centro.add(Conteiner);

        Base.add(Centro, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 1027, 618));

        lbBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBackground.setPreferredSize(new java.awt.Dimension(1026, 618));
        Base.add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 1026, 618));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1030, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TopoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopoMouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - eixoY, y - eixoX);

    }//GEN-LAST:event_TopoMouseDragged

    private void TopoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopoMousePressed
        // TODO add your handling code here:

        eixoY = evt.getX();
        eixoX = evt.getY();

        TransparenteFrame(true);

    }//GEN-LAST:event_TopoMousePressed

    private void lbFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFinalizarMouseClicked
        // TODO add your handling code here:
        DialogFinalizar();
    }//GEN-LAST:event_lbFinalizarMouseClicked

    private void lbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(FrmPrincipal.ICONIFIED);
    }//GEN-LAST:event_lbMinimizarMouseClicked

    private void TopoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TopoMouseReleased
        // TODO add your handling code here:      
        TransparenteFrame(false);
    }//GEN-LAST:event_TopoMouseReleased

    private void lbImgUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImgUserMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lbImgUserMouseClicked

    private void lbMinimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizar1MouseClicked
        // TODO add your handling code here:
        Menu.setVisible(!Menu.isVisible());
        Linha.setVisible(!Linha.isVisible());
    }//GEN-LAST:event_lbMinimizar1MouseClicked

    private void IcoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoInicioMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Inicio");
    }//GEN-LAST:event_IcoInicioMouseClicked

    private void IcoCadastrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoCadastrosMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Cadastros");
    }//GEN-LAST:event_IcoCadastrosMouseClicked

    private void IcoRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoRelatoriosMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Relatórios");
    }//GEN-LAST:event_IcoRelatoriosMouseClicked

    private void IcoFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoFinanceiroMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Financeiro");
    }//GEN-LAST:event_IcoFinanceiroMouseClicked

    private void IcoFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoFerramentasMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Ferramentas");
    }//GEN-LAST:event_IcoFerramentasMouseClicked

    private void IcoConfiguracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoConfiguracaoMouseClicked
        // TODO add your handling code here:
        DialogConfiguracoes();
    }//GEN-LAST:event_IcoConfiguracaoMouseClicked

    private void IcoSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoSobreMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Sobre");
        DialogSobre sobre = new DialogSobre(null, true);
        sobre.setVisible(true);
    }//GEN-LAST:event_IcoSobreMouseClicked

    private void IcoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcoLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new FrmLogin(this, true).setVisible(true);
    }//GEN-LAST:event_IcoLogoutMouseClicked

    private void lbInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInicioMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Inicio");
    }//GEN-LAST:event_lbInicioMouseClicked

    private void lbCadastrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCadastrosMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Cadastros");
    }//GEN-LAST:event_lbCadastrosMouseClicked

    private void lbFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFinanceiroMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Financeiro");
    }//GEN-LAST:event_lbFinanceiroMouseClicked

    private void lbRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatoriosMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Relatórios");
    }//GEN-LAST:event_lbRelatoriosMouseClicked

    private void lbConfiguracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfiguracaoMouseClicked
        // TODO add your handling code here:
        DialogConfiguracoes();
    }//GEN-LAST:event_lbConfiguracaoMouseClicked

    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new FrmLogin(this, true).setVisible(true);
    }//GEN-LAST:event_lbLogoutMouseClicked

    private void lbSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSobreMouseClicked
        // TODO add your handling code here:
        MostrarPainel("Sobre");
        DialogSobre sobre = new DialogSobre(null, true);
        sobre.setVisible(true);
    }//GEN-LAST:event_lbSobreMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Conteiner;
    private javax.swing.JLabel IcoCadastros;
    private javax.swing.JLabel IcoConfiguracao;
    private javax.swing.JLabel IcoFerramentas;
    private javax.swing.JLabel IcoFinanceiro;
    private javax.swing.JLabel IcoInicio;
    private javax.swing.JLabel IcoLogout;
    private javax.swing.JLabel IcoRelatorios;
    private javax.swing.JLabel IcoSobre;
    private javax.swing.JPanel Icones;
    private javax.swing.JSeparator Linha;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Topo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCadastros;
    private javax.swing.JLabel lbConfiguracao;
    private javax.swing.JLabel lbFerramentas;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbFinanceiro;
    private javax.swing.JLabel lbImgUser;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbMinimizar1;
    private javax.swing.JLabel lbRelatorios;
    private javax.swing.JLabel lbSobre;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
