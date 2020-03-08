package View.Panels;

import Controller.ControllerRelatorios;
import Controller.ControllerGenerico;
import Controller.ControllerIgrejas;
import Model.Igreja;
import Model.Renderer.CustomComboBox;
import Model.Renderer.DataSetTableModel;
import View.Dialogs.Utils.DialogTabela;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class PanelRelatorios extends javax.swing.JPanel {

    private final CustomComboBox render = new CustomComboBox();
    private final ControllerRelatorios relat;
    private ArrayList<Igreja> igrejas;

    private final int[] colunas = {50, 300, 100};

    /**
     * Creates new form PanelRelatorios
     */
    public PanelRelatorios() {
        initComponents();
        relat = new ControllerRelatorios();
        ListarCargos();
        ListarIgrejas();

        cbIgrejas.setRenderer(render);
        cbCargos.setRenderer(render);
        cbMinisterios.setRenderer(render);

    }

    private void ListarIgrejas() {

        igrejas = new ControllerIgrejas().Listar();

        if (!igrejas.isEmpty()) {
            igrejas.stream().forEach((ig) -> {
                cbIgrejas.addItem(ig.getNome());
            });
            btnView.setEnabled(true);
            btnPDF.setEnabled(true);
            btnPrint.setEnabled(true);
        }

    }

    private void ListarCargos() {

        ControllerGenerico ge = new ControllerGenerico();
        ArrayList<String[]> cargos = ge.Listar("SELECT * FROM Cargos");
        ArrayList<String[]> minist = ge.Listar("SELECT * FROM Ministerios");

        //cbCargos.addItem("Todos os Registros");
        cargos.stream().forEach((s) -> {
            cbCargos.addItem(s[1]);
        });

        minist.stream().forEach((s) -> {
            cbMinisterios.addItem(s[0]);
        });

    }

    private void RelatGerais(int type) {

        int id = igrejas.get(cbIgrejas.getSelectedIndex()).getId();

        if (jRadioButton2.isSelected()) {
            relat.relatorioMembros(id, "Ministerio", cbMinisterios.getSelectedItem().toString(), type);
            // } else if (cbCargos.getSelectedIndex() > 0) {
            //   relat.relatorioMembros(id, "Cargo", cbCargos.getSelectedItem().toString(), view);
        } else {
            relat.relatorioMembros(id, "Cargo", cbCargos.getSelectedItem().toString(), type);
            // relat.relatorioMembros(id, view);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        cbIgrejas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        cbCargos = new javax.swing.JComboBox<>();
        cbMinisterios = new javax.swing.JComboBox<>();
        jRadioButton2 = new javax.swing.JRadioButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnView = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        lbFicha = new javax.swing.JLabel();
        lbCAnivers = new javax.swing.JLabel();
        lbCTransf = new javax.swing.JLabel();
        lbDizimos = new javax.swing.JLabel();
        lbClasses = new javax.swing.JLabel();
        lbCampanhas = new javax.swing.JLabel();
        lbEventos = new javax.swing.JLabel();
        lbPatrimonios = new javax.swing.JLabel();
        lbRelatMembros = new javax.swing.JLabel();
        lbCampanhas1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Relatórios para a Igreja :");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("por Posição");

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jRadioButton2.setText("por Ministér.");
        jRadioButton2.setToolTipText("Ministérios");

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Analyze_32px.png"))); // NOI18N
        btnView.setText("Visualizar");
        btnView.setEnabled(false);
        btnView.setFocusable(false);
        btnView.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jToolBar2.add(btnView);

        btnPDF.setBackground(new java.awt.Color(255, 255, 255));
        btnPDF.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_PDF_2_32px.png"))); // NOI18N
        btnPDF.setText("Salvar");
        btnPDF.setEnabled(false);
        btnPDF.setFocusable(false);
        btnPDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPDF.setMaximumSize(new java.awt.Dimension(55, 59));
        btnPDF.setMinimumSize(new java.awt.Dimension(55, 59));
        btnPDF.setPreferredSize(new java.awt.Dimension(55, 59));
        btnPDF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        jToolBar2.add(btnPDF);

        btnPrint.setBackground(new java.awt.Color(255, 255, 255));
        btnPrint.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Print_32px.png"))); // NOI18N
        btnPrint.setText("Imprimir");
        btnPrint.setEnabled(false);
        btnPrint.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar2.add(btnPrint);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("Individuais:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Gerais:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Edit_File_32px.png"))); // NOI18N
        jLabel2.setText("<html><p align=\"justify\"><b>Môdulo Relatórios :</b> Relatorios sobre Membros (Gerais e Individuais), Igrejas, Dizimos, Eventos e Patrimônio detalhados para emissão PDF e impressão</p></html>");
        jLabel2.setIconTextGap(10);

        lbFicha.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbFicha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Customer_50px.png"))); // NOI18N
        lbFicha.setText("<html><p align=\"center\">Ficha Individual de Cadastro</p></html>");
        lbFicha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbFicha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFicha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFicha.setMaximumSize(new java.awt.Dimension(100, 100));
        lbFicha.setMinimumSize(new java.awt.Dimension(100, 100));
        lbFicha.setPreferredSize(new java.awt.Dimension(100, 100));
        lbFicha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFichaMouseClicked(evt);
            }
        });

        lbCAnivers.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbCAnivers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCAnivers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Gift_64px_1.png"))); // NOI18N
        lbCAnivers.setText("<html><p align=\"center\">Cartão de Aniversário</p></html>");
        lbCAnivers.setToolTipText("Carta de Transferência");
        lbCAnivers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbCAnivers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCAnivers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCAnivers.setMaximumSize(new java.awt.Dimension(100, 100));
        lbCAnivers.setMinimumSize(new java.awt.Dimension(100, 100));
        lbCAnivers.setPreferredSize(new java.awt.Dimension(100, 100));
        lbCAnivers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCAnivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCAniversMouseClicked(evt);
            }
        });

        lbCTransf.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbCTransf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCTransf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Post_Office_50px_1.png"))); // NOI18N
        lbCTransf.setText("<html><p align=\"center\">Carta de Transferência</p></html>");
        lbCTransf.setToolTipText("Carta de Transferência");
        lbCTransf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbCTransf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCTransf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCTransf.setMaximumSize(new java.awt.Dimension(100, 100));
        lbCTransf.setMinimumSize(new java.awt.Dimension(100, 100));
        lbCTransf.setPreferredSize(new java.awt.Dimension(100, 100));
        lbCTransf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCTransf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCTransfMouseClicked(evt);
            }
        });

        lbDizimos.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbDizimos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDizimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Pricing_50px.png"))); // NOI18N
        lbDizimos.setText("Dízimos e Ofertas");
        lbDizimos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbDizimos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDizimos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbDizimos.setMaximumSize(new java.awt.Dimension(100, 100));
        lbDizimos.setMinimumSize(new java.awt.Dimension(100, 100));
        lbDizimos.setPreferredSize(new java.awt.Dimension(100, 100));
        lbDizimos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbDizimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDizimosMouseClicked(evt);
            }
        });

        lbClasses.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbClasses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClasses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Class_50px.png"))); // NOI18N
        lbClasses.setText("Classes");
        lbClasses.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbClasses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClasses.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbClasses.setMaximumSize(new java.awt.Dimension(100, 100));
        lbClasses.setMinimumSize(new java.awt.Dimension(100, 100));
        lbClasses.setPreferredSize(new java.awt.Dimension(100, 100));
        lbClasses.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClassesMouseClicked(evt);
            }
        });

        lbCampanhas.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbCampanhas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCampanhas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Trust_50px.png"))); // NOI18N
        lbCampanhas.setText("Campanhas");
        lbCampanhas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbCampanhas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCampanhas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCampanhas.setMaximumSize(new java.awt.Dimension(100, 100));
        lbCampanhas.setMinimumSize(new java.awt.Dimension(100, 100));
        lbCampanhas.setPreferredSize(new java.awt.Dimension(100, 100));
        lbCampanhas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCampanhas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCampanhasMouseClicked(evt);
            }
        });

        lbEventos.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbEventos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Schedule_50px.png"))); // NOI18N
        lbEventos.setText("Eventos");
        lbEventos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEventos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbEventos.setMaximumSize(new java.awt.Dimension(100, 100));
        lbEventos.setMinimumSize(new java.awt.Dimension(100, 100));
        lbEventos.setPreferredSize(new java.awt.Dimension(100, 100));
        lbEventos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEventosMouseClicked(evt);
            }
        });

        lbPatrimonios.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbPatrimonios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPatrimonios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Add_Tag_50px.png"))); // NOI18N
        lbPatrimonios.setText("Patrimônios");
        lbPatrimonios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbPatrimonios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPatrimonios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbPatrimonios.setMaximumSize(new java.awt.Dimension(100, 100));
        lbPatrimonios.setMinimumSize(new java.awt.Dimension(100, 100));
        lbPatrimonios.setPreferredSize(new java.awt.Dimension(100, 100));
        lbPatrimonios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbPatrimonios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPatrimoniosMouseClicked(evt);
            }
        });

        lbRelatMembros.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbRelatMembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRelatMembros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Index_50px.png"))); // NOI18N
        lbRelatMembros.setText("Membros");
        lbRelatMembros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbRelatMembros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRelatMembros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbRelatMembros.setMaximumSize(new java.awt.Dimension(100, 100));
        lbRelatMembros.setMinimumSize(new java.awt.Dimension(100, 100));
        lbRelatMembros.setPreferredSize(new java.awt.Dimension(100, 100));
        lbRelatMembros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbRelatMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRelatMembrosMouseClicked(evt);
            }
        });

        lbCampanhas1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        lbCampanhas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCampanhas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Hand_With_Pen_50px.png"))); // NOI18N
        lbCampanhas1.setText("Atas");
        lbCampanhas1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbCampanhas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCampanhas1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCampanhas1.setMaximumSize(new java.awt.Dimension(100, 100));
        lbCampanhas1.setMinimumSize(new java.awt.Dimension(100, 100));
        lbCampanhas1.setPreferredSize(new java.awt.Dimension(100, 100));
        lbCampanhas1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCampanhas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCampanhas1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMinisterios, 0, 250, Short.MAX_VALUE)
                                    .addComponent(cbCargos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lbCAnivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lbCTransf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                                    .addComponent(cbIgrejas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbRelatMembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbPatrimonios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDizimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lbCampanhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCampanhas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbIgrejas, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMinisterios)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPatrimonios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRelatMembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDizimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCampanhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCAnivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCTransf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbCampanhas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:        
        RelatGerais(1);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        RelatGerais(2);
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        RelatGerais(0);
    }//GEN-LAST:event_btnViewActionPerformed

    private void lbFichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFichaMouseClicked
        // TODO add your handling code here:

        if (igrejas.size() > 0) {

            int IdIgreja = igrejas.get(cbIgrejas.getSelectedIndex()).getId();
            String sql = "SELECT Id, Nome, Cargo FROM Membros WHERE IdIgreja = " + IdIgreja;
            DefaultTableModel model = DataSetTableModel.Tabela(sql);
            DialogTabela dialog = new DialogTabela(new JFrame(), true, model);
            dialog.TamanhoColunas(colunas);
            dialog.setVisible(true);

            if (dialog.isConfirma()) {
                ArrayList lista = dialog.getListagem();
                int id = Integer.parseInt(lista.get(0).toString());
                relat.fichaCadastral(id);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "NENHUm IGREJA/CONGREGACAO CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lbFichaMouseClicked

    private void lbPatrimoniosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPatrimoniosMouseClicked
        // TODO add your handling code here:

        if (igrejas.size() > 0) {
            int index = cbIgrejas.getSelectedIndex();
            relat.relatorioPatrimonios(igrejas.get(index).getId());
        } else {
            JOptionPane.showMessageDialog(null, "NENHUm IGREJA/CONGREGACAO CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lbPatrimoniosMouseClicked

    private void lbDizimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDizimosMouseClicked
        // TODO add your handling code here:

        if (igrejas.size() > 0) {
            int ano = jYearChooser1.getValue();
            String[] meses = {"TODO O PERIODO",
                "01/" + ano, "02/" + ano, "03/" + ano,
                "04/" + ano, "05/" + ano, "06/" + ano,
                "07/" + ano, "08/" + ano, "09/" + ano,
                "10/" + ano, "11/" + ano, "12/" + ano};

            String select = (String) JOptionPane.showInputDialog(null, "Relatório Referente à",
                    "Selecione o Periodo", JOptionPane.QUESTION_MESSAGE, null, meses, meses[0]);

            if (select != null) {
                int id = igrejas.get(cbIgrejas.getSelectedIndex()).getId();

                if (select.equals(meses[0])) {
                    relat.relatorioDizimos(id, jYearChooser1.getValue());
                } else {
                    relat.relatorioDizimos(id, select);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "NENHUm IGREJA/CONGREGACAO CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lbDizimosMouseClicked

    private void lbCTransfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCTransfMouseClicked
        // TODO add your handling code here:

        if (igrejas.size() > 0) {

            int IdIgreja = igrejas.get(cbIgrejas.getSelectedIndex()).getId();
            String sql = "SELECT Id, Nome, Cargo FROM Membros WHERE IdIgreja = " + IdIgreja;

            DefaultTableModel model = DataSetTableModel.Tabela(sql);
            DialogTabela dialog = new DialogTabela(new JFrame(), true, model);
            dialog.TamanhoColunas(colunas);
            dialog.setVisible(true);

            if (dialog.isConfirma()) {
                ArrayList lista = dialog.getListagem();
                int id = Integer.parseInt(lista.get(0).toString());
                relat.cartaTransferencia(id);
            }

        } else {
            JOptionPane.showMessageDialog(null, "NENHUm IGREJA/CONGREGACAO CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lbCTransfMouseClicked

    private void lbEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEventosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbEventosMouseClicked

    private void lbCAniversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCAniversMouseClicked
        // TODO add your handling code here:

        if (igrejas.size() > 0) {

            int IdIgreja = igrejas.get(cbIgrejas.getSelectedIndex()).getId();
            String sql = "SELECT Id, Nome, Cargo FROM Membros WHERE IdIgreja = " + IdIgreja;

            DefaultTableModel model = DataSetTableModel.Tabela(sql);
            DialogTabela dialog = new DialogTabela(new JFrame(), true, model);
            dialog.TamanhoColunas(colunas);
            dialog.setVisible(true);

            if (dialog.isConfirma()) {
                ArrayList<String> lista = dialog.getListagem();
                int id = Integer.parseInt(lista.get(0));
                relat.fichaAniversariante(id);
            }

        } else {
            JOptionPane.showMessageDialog(null, "NENHUm IGREJA/CONGREGACAO CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lbCAniversMouseClicked

    private void lbRelatMembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelatMembrosMouseClicked
        // TODO add your handling code here:

        if (igrejas.size() > 0) {

            String[] tipos = {"Todos", "Feminino", "Masculino"};
            String select = (String) JOptionPane.showInputDialog(null, "Listagem do Tipo:",
                    "Selecione o Tipo", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

            if (select != null) {
                int IdIgreja = igrejas.get(cbIgrejas.getSelectedIndex()).getId();
                if (select.equals(tipos[0])) {
                    relat.relatorioMembros(IdIgreja, 0);
                } else {
                    relat.relatorioMembros(IdIgreja, "Genero", select, 0);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "NENHUm IGREJA/CONGREGACAO CADASTRADA",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lbRelatMembrosMouseClicked

    private void lbClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClassesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbClassesMouseClicked

    private void lbCampanhasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCampanhasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCampanhasMouseClicked

    private void lbCampanhas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCampanhas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCampanhas1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnView;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCargos;
    private javax.swing.JComboBox<String> cbIgrejas;
    private javax.swing.JComboBox<String> cbMinisterios;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lbCAnivers;
    private javax.swing.JLabel lbCTransf;
    private javax.swing.JLabel lbCampanhas;
    private javax.swing.JLabel lbCampanhas1;
    private javax.swing.JLabel lbClasses;
    private javax.swing.JLabel lbDizimos;
    private javax.swing.JLabel lbEventos;
    private javax.swing.JLabel lbFicha;
    private javax.swing.JLabel lbPatrimonios;
    private javax.swing.JLabel lbRelatMembros;
    // End of variables declaration//GEN-END:variables
}
