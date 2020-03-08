package View.Panels;

import Controller.ControllerAgenda;
import Controller.ControllerGenerico;
import Controller.ControllerIgrejas;
import Controller.ControllerMembros;
import Controller.ControllerRelatorios;
import Controller.ControllerVersiculos;
import Model.Evento;
import Model.Igreja;
import Model.Membro;
import Model.Renderer.DataSetTableModel;
import Utils.Propriedades;
import View.Dialogs.Utils.DialogCards;
import View.Dialogs.Utils.DialogTabela;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class PanelInicio extends javax.swing.JPanel {

    private final String path = System.getProperty("user.dir");
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final Date date = new Date();

    private ArrayList<Igreja> igrejas;
    private ArrayList<String[]> referencias;

    int pos = 0;

    /**
     * Creates new form PanelInicio
     */
    public PanelInicio() {
        initComponents();
        lbData.setText(df.format(date));

        IniHora();
        ListarIgrejas();
        ListarLembretes();
        
        CarregarConfiguracoes();
    }

    private void CarregarConfiguracoes(){
        Properties propriedades = new Propriedades().loadProperties();

        String backup = propriedades.getProperty("prop.home.versiculo", "false");
        if (backup.equals("true")) {
            ListarVersiculos();
        }
    }
    
    private void ListarVersiculos() {

        if (referencias == null) {
            referencias = new ControllerVersiculos().Referencias();
        }

        int sort = new Random().nextInt(referencias.size());
        String txt = Arrays.toString(referencias.get(sort));

        lbVersiculo.setText("<html><p align=\"center\">" + txt.replace("[", "")
                .replace("]", "") + "</p></html>");
    }

    private void ListarIgrejas() {

        igrejas = new ControllerIgrejas().Listar();

        lbNomeIgreja.setText(igrejas.get(pos).getNome());
        lbTexto.setText("<html><p align=\"center\">" +igrejas.get(pos).getTexto()+ "</p></html>");

        if (igrejas.size() > 0) {
            ListarCardsEventos();
            ListarDadosIgreja();
            if (igrejas.size() == 1) {
                lbPrev.setVisible(false);
                lbNext.setVisible(false);
            }
        } else {
            lbNivers.setVisible(false);
            lbEventos.setVisible(false);
        }

    }

    private void ListarDadosIgreja() {

        ControllerGenerico cont = new ControllerGenerico();
        String sql = "SELECT Membros.Nome, Genero FROM Membros "
                + "INNER JOIN Igrejas ON Membros.IdIgreja = Igrejas.Id\n"
                + "WHERE Igrejas.Id = " + igrejas.get(pos).getId() + " AND Genero = ";

        ArrayList<String[]> dadosM = cont.Listar(sql + "'Feminino'");
        ArrayList<String[]> dadosH = cont.Listar(sql + "'Masculino'");

        int total = dadosH.size() + dadosM.size();

        float percentH = 0;
        float percentM = 0;

        if (dadosH.size() > 0) {
            percentH = ((dadosH.size() * 100) / total);
        }

        if (dadosM.size() > 0) {
            percentM = ((dadosM.size() * 100) / total);
        }

        jLabel1.setText("Total: " + total + " Membros");

        jProgressBar1.setMaximum(total);
        jProgressBar1.setValue((int) percentH);
        jProgressBar1.setString(((int) percentH) + "% Homem");

        jProgressBar2.setMaximum(total);
        jProgressBar2.setValue((int) percentM);
        jProgressBar2.setString(((int) percentM) + "% Mulher");

        ListarCardsNivers();

    }

    private void ListarCardsNivers() {

        String mes = lbData.getText().substring(3, 5);
        String sqlmembros = "SELECT * FROM Membros WHERE Format(DtNascimento,\"mm\") = '" + mes + "' "
                + "AND IdIgreja=" + igrejas.get(pos).getId();

        ArrayList<Membro> membros = new ControllerMembros().Listar(sqlmembros);
        lbNivers.setText(membros.size() + " Aniversários");

    }

    private void ListarCardsEventos() {

        String mesAno = lbData.getText().substring(3);

        String sqleventos = "SELECT * FROM Eventos WHERE Mid(Data, 4) = '" + mesAno + "' ";
        ArrayList<Evento> eventos = new ControllerAgenda().Listar(sqleventos);
        if (eventos.size() > 0) {
            lbEventos.setText(eventos.size() + " Eventos");
            lbEventos.setVisible(true);
        }

    }

    private void ListarLembretes() {

        File pasta = new File(path + "/lembretes");

        if (pasta.exists()) {
            File[] files = pasta.listFiles();
            if (files.length > 0) {
                lbLembretes.setVisible(true);
                lbLembretes.setText(files.length + " Lembretes");
            } else {
                lbLembretes.setVisible(false);
            }
        }

    }

    private void IniHora() {

        Timer time = new Timer(1000, (ActionEvent e) -> {
            String data = new SimpleDateFormat("HH:mm:ss").format(new Date());
            lbHora.setText(data);
        });

        time.start();

    }

    private void DialogMembros(String tipo) {

        String sql = "SELECT Id, Nome, Genero, DtNascimento, Cpf, EstadoCivil, "
                + "NomePai, NomeMae, Email, Endereco, Contatos, Bairro, Cidade, "
                + "Estado, Complemento, Cep, Cargo, Ministerio, Situacao, IdIgreja, Foto "
                + "FROM Membros WHERE IdIgreja=" + igrejas.get(pos).getId();

        if (!tipo.equals("Todos")) {
            sql += " AND Genero ='" + tipo + "'";
        }

        DefaultTableModel model = DataSetTableModel.Tabela(sql);
        DialogTabela dialog = new DialogTabela(null, true, model);
        dialog.TamanhoColunas(new int[]{50, 250, 100});
        dialog.AutoRedimensionar(0);
        dialog.setVisible(true);
        
        if(dialog.isConfirma()){
            ArrayList<String> lst = dialog.getListagem();
            new ControllerRelatorios().fichaCadastral(Integer.parseInt(lst.get(0)));
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRelogio = new javax.swing.JPanel();
        lbHora = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbEventos = new javax.swing.JLabel();
        lbNivers = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        lbLembretes = new javax.swing.JLabel();
        lbNomeIgreja = new javax.swing.JLabel();
        lbTexto = new javax.swing.JLabel();
        lbPrev = new javax.swing.JLabel();
        lbNext = new javax.swing.JLabel();
        lbVersiculo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setOpaque(false);

        panelRelogio.setBackground(new java.awt.Color(51, 51, 51));
        panelRelogio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelRelogio.setOpaque(false);
        panelRelogio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHora.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        lbHora.setText("00:00:00");
        lbHora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbHora.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelRelogio.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lbData.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Circle_100px.png"))); // NOI18N
        lbData.setText("99/99/9999");
        lbData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbData.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panelRelogio.add(lbData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 130, 130));

        lbEventos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbEventos.setForeground(new java.awt.Color(255, 255, 255));
        lbEventos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Calendar_80px.png"))); // NOI18N
        lbEventos.setText("Eventos");
        lbEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEventos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbEventos.setMaximumSize(new java.awt.Dimension(130, 110));
        lbEventos.setMinimumSize(new java.awt.Dimension(130, 110));
        lbEventos.setPreferredSize(new java.awt.Dimension(130, 110));
        lbEventos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEventosMouseClicked(evt);
            }
        });
        panelRelogio.add(lbEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 130, 110));

        lbNivers.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbNivers.setForeground(new java.awt.Color(255, 255, 255));
        lbNivers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNivers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Gift_80px.png"))); // NOI18N
        lbNivers.setText("Aniversários");
        lbNivers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNivers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbNivers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbNivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNiversMouseClicked(evt);
            }
        });
        panelRelogio.add(lbNivers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 130, 110));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRelogio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jProgressBar1.setMaximumSize(new java.awt.Dimension(32767, 40));
        jProgressBar1.setStringPainted(true);
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseClicked(evt);
            }
        });
        panelRelogio.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 108, 20));

        jProgressBar2.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 11)); // NOI18N
        jProgressBar2.setForeground(new java.awt.Color(255, 102, 102));
        jProgressBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jProgressBar2.setMaximumSize(new java.awt.Dimension(32767, 40));
        jProgressBar2.setStringPainted(true);
        jProgressBar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar2MouseClicked(evt);
            }
        });
        panelRelogio.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 198, 108, 20));

        lbLembretes.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbLembretes.setForeground(new java.awt.Color(255, 255, 255));
        lbLembretes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLembretes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Note_80px.png"))); // NOI18N
        lbLembretes.setText("Lembretes");
        lbLembretes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLembretes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbLembretes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbLembretes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLembretesMouseClicked(evt);
            }
        });
        panelRelogio.add(lbLembretes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 130, -1));

        lbNomeIgreja.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbNomeIgreja.setForeground(new java.awt.Color(255, 255, 255));
        lbNomeIgreja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNomeIgreja.setText("NOME IGREJA");

        lbTexto.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTexto.setForeground(new java.awt.Color(255, 255, 255));
        lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTexto.setText("Texto");

        lbPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Prev_32px.png"))); // NOI18N
        lbPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPrevMouseClicked(evt);
            }
        });

        lbNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/icons8_Right_Button_32px.png"))); // NOI18N
        lbNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNextMouseClicked(evt);
            }
        });

        lbVersiculo.setFont(new java.awt.Font("Segoe Print", 0, 13)); // NOI18N
        lbVersiculo.setForeground(new java.awt.Color(255, 255, 255));
        lbVersiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNomeIgreja, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNext))
                    .addComponent(lbVersiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRelogio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRelogio, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNomeIgreja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbVersiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEventosMouseClicked
        // TODO add your handling code here:

        DialogCards dialog = new DialogCards(new JFrame(), true, "Eventos", igrejas.get(pos).getId());
        dialog.setVisible(true);
        ListarCardsEventos();
    }//GEN-LAST:event_lbEventosMouseClicked

    private void lbNiversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNiversMouseClicked
        // TODO add your handling code here:
        DialogCards dialog = new DialogCards(new JFrame(), true, "Nivers", igrejas.get(pos).getId());
        dialog.setVisible(true);
    }//GEN-LAST:event_lbNiversMouseClicked

    private void lbPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPrevMouseClicked
        // TODO add your handling code here:

        if (pos > 0) {
            pos--;
        } else {
            pos = igrejas.size() - 1;
        }

        ListarIgrejas();

    }//GEN-LAST:event_lbPrevMouseClicked

    private void lbNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNextMouseClicked
        // TODO add your handling code here:

        if (pos < igrejas.size() - 1) {
            pos++;
        } else {
            pos = 0;
        }

        ListarIgrejas();

    }//GEN-LAST:event_lbNextMouseClicked

    private void lbLembretesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLembretesMouseClicked
        // TODO add your handling code here:
        DialogCards dialog = new DialogCards(new JFrame(), true, "Lembretes", 0);
        dialog.setVisible(true);
        ListarLembretes();
    }//GEN-LAST:event_lbLembretesMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        DialogMembros("Todos");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jProgressBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseClicked
        // TODO add your handling code here:
        DialogMembros("Masculino");
    }//GEN-LAST:event_jProgressBar1MouseClicked

    private void jProgressBar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar2MouseClicked
        // TODO add your handling code here:
        DialogMembros("Feminino");
    }//GEN-LAST:event_jProgressBar2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEventos;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbLembretes;
    private javax.swing.JLabel lbNext;
    private javax.swing.JLabel lbNivers;
    private javax.swing.JLabel lbNomeIgreja;
    private javax.swing.JLabel lbPrev;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lbVersiculo;
    private javax.swing.JPanel panelRelogio;
    // End of variables declaration//GEN-END:variables
}
