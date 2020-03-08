package View.Dialogs.Utils;

import Controller.ControllerAgenda;
import Controller.ControllerMembros;
import Model.Evento;
import Model.Membro;
import Model.Renderer.CustomComboBox;
import Utils.Propriedades;
import View.Cards.CardAniversario;
import View.Cards.CardEventos;
import View.Cards.CardLembrete;
import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

/**
 *
 * @author AYU7-WN
 */
public class DialogCards extends javax.swing.JDialog {

    private final SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
    private ArrayList<Membro> membros;
    private ArrayList<Evento> eventos;
    private final String cards;
    private boolean confirma = false;

    private final int IdIgreja;
    private int eixoX, eixoY;

    private int pos = 1;

    private final String[] meses = {"JANEIRO", "FEVEREIRO", "MARÇO",
        "ABRIL", "MAIO", "JUNHO",
        "JULHO", "AGOSTO", "SETEMBRO",
        "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};

    /**
     * Creates new form DialogInfos
     *
     * @param parent
     * @param modal
     * @param cards
     * @param IdIgreja
     */
    public DialogCards(java.awt.Frame parent, boolean modal, String cards, int IdIgreja) {
        super(parent, modal);
        initComponents();
        this.IdIgreja = IdIgreja;
        this.cards = cards;
        pos = Integer.parseInt(df.format(new Date()).substring(2, 4));
        ListarCards(cards);
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

    private void ListarCards(String tipo) {

        PanelCards.removeAll();

        switch (tipo) {
            case "Nivers":
                btnAdd.setVisible(false);
                ListarNivers();
                break;
            case "Eventos":
                btnAdd.setVisible(false);
                ListarEventos();
                break;
            case "Lembretes":
                lbPrev.setVisible(false);
                lbNext.setVisible(false);
                ListarLembretes();
                break;
        }

        SwingUtilities.updateComponentTreeUI(PanelCards);

    }

    private void ListarNivers() {

        String mes = "" + pos;

        if (pos <= 9) {
            mes = "0" + pos;
        }

        String sql = "SELECT * FROM Membros "
                + "WHERE Format(DtNascimento,\"mm\") = '" + mes + "' "
                + "AND IdIgreja=" + IdIgreja + " "
                + "ORDER BY Nome";
        membros = new ControllerMembros().Listar(sql);
        membros.stream().forEach((m) -> {
            PanelCards.add(new CardAniversario(m));
        });
        lbTitulo.setText(membros.size() + " Aniversariantes no mês de " + meses[pos - 1]);
    }

    private void ListarEventos() {

        String mes = "" + pos;

        if (pos <= 9) {
            mes = "0" + pos;
        }

        String sql = "SELECT * FROM Eventos WHERE Format(Data,\"mm\") = '" + mes + "' ";

        eventos = new ControllerAgenda().Listar(sql);
        eventos.stream().forEach((e) -> {
            PanelCards.add(new CardEventos(e));
        });
        lbTitulo.setText(eventos.size() + " Compromissos no mês de " + meses[pos - 1]);
    }

    private void ListarLembretes() {

        File pasta = new File(System.getProperty("user.dir") + "/Lembretes");
        File[] lembretes = pasta.listFiles();
        for (File f : lembretes) {
            PanelCards.add(new CardLembrete(f));
        }

        lbTitulo.setText(lembretes.length + " Lembretes Fixados");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelCards = new javax.swing.JPanel();
        toolbarTitulo = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        lbPrev = new javax.swing.JLabel();
        lbNext = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbFinalizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informativos");
        setMinimumSize(new java.awt.Dimension(800, 420));
        setUndecorated(true);
        setResizable(false);

        panelBase.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        PanelCards.setBackground(new java.awt.Color(255, 255, 255));
        PanelCards.setLayout(new java.awt.GridLayout(0, 5));
        jScrollPane1.setViewportView(PanelCards);

        toolbarTitulo.setBackground(new java.awt.Color(53, 59, 72));
        toolbarTitulo.setFloatable(false);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Add_32px.png"))); // NOI18N
        btnAdd.setToolTipText("Adicionar Lembrete");
        btnAdd.setMaximumSize(new java.awt.Dimension(32, 32));
        btnAdd.setMinimumSize(new java.awt.Dimension(32, 32));
        btnAdd.setOpaque(false);
        btnAdd.setPreferredSize(new java.awt.Dimension(32, 32));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        toolbarTitulo.add(btnAdd);

        lbPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Prev_32px.png"))); // NOI18N
        lbPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPrevMouseClicked(evt);
            }
        });
        toolbarTitulo.add(lbPrev);

        lbNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Right_Button_32px.png"))); // NOI18N
        lbNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNextMouseClicked(evt);
            }
        });
        toolbarTitulo.add(lbNext);

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("TITULO");
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
            .addComponent(toolbarTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addComponent(toolbarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        PanelCards.add(new CardLembrete(null), 0);
        SwingUtilities.updateComponentTreeUI(PanelCards);
    }//GEN-LAST:event_btnAddActionPerformed

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

    private void lbPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPrevMouseClicked
        // TODO add your handling code here:

        if (pos > 1) {
            pos--;
        } else {
            pos = 12;
        }

        ListarCards(cards);
    }//GEN-LAST:event_lbPrevMouseClicked

    private void lbNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNextMouseClicked
        // TODO add your handling code here:

        if (pos < 12) {
            pos++;
        } else {
            pos = 1;
        }

        ListarCards(cards);
    }//GEN-LAST:event_lbNextMouseClicked

    public boolean isConfirma() {
        return confirma;
    }

    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCards;
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFinalizar;
    private javax.swing.JLabel lbNext;
    private javax.swing.JLabel lbPrev;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelBase;
    private javax.swing.JToolBar toolbarTitulo;
    // End of variables declaration//GEN-END:variables
}
