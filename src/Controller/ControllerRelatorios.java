package Controller;

import Conexao.Conexao;
import Utils.LogsEventos;
import View.Dialogs.Utils.DialogLoading;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alexandre
 */
public class ControllerRelatorios {
    
    private final Conexao con;
    private final DialogLoading frm;
    private final String caminho, versao;
    
    public ControllerRelatorios() {
        
        this.con = new Conexao();
        this.frm = new DialogLoading(null, false);
        this.caminho = System.getProperty("user.dir") + "/Relatorios/";
        this.versao = "SGM, Gerenciamento de Membros para Igrejas";
        
    }
    // ----- METODOS RELATORIO DE MEMBROS ----- //
    private void relatorioMembros(String sql, int type) {
        
        frm.setVisible(true);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                con.Conectar();
                con.ExecutaSQL(sql);
                try {
                    if (con.rs.first()) {
                        try {
                            JRResultSetDataSource relatorio = new JRResultSetDataSource(con.rs);
                            JasperPrint jsp = JasperFillManager.fillReport(caminho + "relatoriodeMembros.jasper",
                                    new HashMap(), relatorio);
                            switch (type) {
                                case 1:
                                    JasperPrintManager.printPage(jsp, 0, true);
                                    break;
                                case 2:
                                    geraPDFrecibo(jsp);
                                    break;
                                default:
                                    JasperViewer jsv = new JasperViewer(jsp, false);
                                    jsv.setVisible(true);
                                    jsv.setZoomRatio(0.75f);
                                    jsv.setTitle(versao);
                                    break;
                            }
                            
                        } catch (JRException ex) {
                            LogsEventos.Gravar(ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!",
                                "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
                
                con.Desconectar();
                frm.dispose();
                
            }
        };
        
        t.start();
        
    }
    
    public void relatorioMembros(int IdIgreja, int type) {
        
        String sql = "SELECT Membros.Nome, Genero, EstadoCivil, Membros.Contatos,\n"
                + "Cargo, Igrejas.Nome AS NomeIgreja, Cnpj, Pagina, Texto\n"
                + "FROM Membros INNER JOIN Igrejas\n"
                + "ON Membros.IdIgreja=Igrejas.Id\n"
                + "WHERE Igrejas.Id=" + IdIgreja + "\n"
                + "ORDER BY Membros.Nome";
        
        relatorioMembros(sql, type);
    }
    
    public void relatorioMembros(int IdIgreja, String Coluna, String valor, int type) {
        
        String sql = "SELECT Membros.Nome, Genero, EstadoCivil, Membros.Contatos,\n"
                + "Cargo, Igrejas.Nome AS NomeIgreja, Cnpj, Pagina, Texto\n"
                + "FROM Membros INNER JOIN Igrejas\n"
                + "ON Membros.IdIgreja=Igrejas.Id\n"
                + "WHERE Igrejas.Id=" + IdIgreja + "\n"
                + "AND " + Coluna + " = '" + valor + "' ORDER BY Membros.Nome";
        
        relatorioMembros(sql, type);
        
    }
    
    // ----- METODOS RELATORIO DE PATRIMONIOS----- //
    public void relatorioPatrimonios(int IdIgreja) {
        
        frm.setVisible(true);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    con.Conectar();
                    String sql = "SELECT Patrimonios.Id, Patrimonios.Nome, Data,\n"
                            + "Patrimonios.Tipo, Valor, Quantidade, Descricao,\n"
                            + "Igrejas.Nome AS NomeIgreja, Texto, Cnpj, Contatos\n"
                            + "FROM Patrimonios INNER JOIN Igrejas\n"
                            + "ON Patrimonios.IdIgreja = Igrejas.Id\n"
                            + "WHERE Igrejas.Id = " + IdIgreja;
                    con.ExecutaSQL(sql);
                    if (con.rs.isBeforeFirst()) {
                        try {
                            JRResultSetDataSource relatorio = new JRResultSetDataSource(con.rs);
                            JasperPrint jsp = JasperFillManager.fillReport(caminho + "relatoriodePatrimonios.jasper",
                                    new HashMap(), relatorio);
                            JasperViewer jsv = new JasperViewer(jsp, false);
                            jsv.setZoomRatio(0.75f);
                            jsv.setTitle(versao);
                            jsv.setVisible(true);
                        } catch (JRException ex) {
                            LogsEventos.Gravar(ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!",
                                "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
                con.Desconectar();
                frm.dispose();
                
            }
        };
        
        t.start();
    }
    
    // ----- METODOS FICHA DE CADASTRO ----- //
    private void fichaCadastral(String sql) {
        
        frm.setVisible(true);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                con.Conectar();
                try {                    
                    con.ExecutaSQL(sql);
                    JRResultSetDataSource relatorio = new JRResultSetDataSource(con.rs);
                    JasperPrint jsp = JasperFillManager.fillReport(caminho + "fichadeMembro.jasper",
                            new HashMap(), relatorio);
                    JasperViewer jsv = new JasperViewer(jsp, false);
                    jsv.setVisible(true);
                    jsv.setZoomRatio(0.75f);
                    jsv.setTitle(versao);
                    
                } catch (JRException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
                con.Desconectar();
                frm.dispose();
            }
        };
        t.start();
    }
    
    public void fichaCadastral(int IdMembro) {
        String sql = "SELECT Membros.Nome, DtNascimento, Cpf, Genero,\n"
                + "EstadoCivil, Membros.Endereco, Membros.Bairro,\n"
                + "Membros.Cidade, Membros.Estado, Cargo, Ministerio,\n"
                + "Membros.Complemento, Emails, Situacao, Texto,\n"
                + "NomePai, NomeMae, Membros.Contatos, Membros.Email,\n"
                + "Membros.Cep,Igrejas.Nome AS NomeIgreja, Cnpj,\n"
                + "Igrejas.Contatos AS ContatosIgreja, Membros.Foto\n"
                + "FROM Membros INNER JOIN Igrejas\n"
                + "ON Membros.IdIgreja = Igrejas.Id\n"
                + "WHERE Membros.Id = " + IdMembro;
        fichaCadastral(sql);
    }
    
    public void fichaCadastral(int IdIgreja, boolean view){
        String sql = "SELECT Membros.Nome, DtNascimento, Cpf, Genero,\n"
                + "EstadoCivil, Membros.Endereco, Membros.Bairro,\n"
                + "Membros.Cidade, Membros.Estado, Cargo, Ministerio,\n"
                + "Membros.Complemento, Emails, Situacao, Texto,\n"
                + "NomePai, NomeMae, Membros.Contatos, Membros.Email,\n"
                + "Membros.Cep,Igrejas.Nome AS NomeIgreja, Cnpj,\n"
                + "Igrejas.Contatos AS ContatosIgreja, Membros.Foto\n"
                + "FROM Membros INNER JOIN Igrejas\n"
                + "ON Membros.IdIgreja = Igrejas.Id\n"
                + "WHERE Igrejas.Id = " + IdIgreja;
        fichaCadastral(sql);
    }
    
    // ----- METODOS RELATORIO DE DIZIMOS ----- //    
    public void relatorioDizimos(String sql) {
        
        frm.setVisible(true);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                con.Conectar();
                con.ExecutaSQL(sql);
                try {
                    if (con.rs.isBeforeFirst()) {
                        try {
                            JRResultSetDataSource relatorio = new JRResultSetDataSource(con.rs);
                            JasperPrint jsp = JasperFillManager.fillReport(caminho + "relatoriodeDizimos.jasper",
                                    new HashMap(), relatorio);
                            JasperViewer jsv = new JasperViewer(jsp, false);
                            jsv.setTitle(versao);
                            jsv.setZoomRatio(0.75f);
                            jsv.setVisible(true);
                        } catch (JRException ex) {
                            LogsEventos.Gravar(ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!",
                                "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
                con.Desconectar();
                frm.dispose();
            }
        };
        t.start();
    }
    
    public void relatorioDizimos(int IdIgreja, int Ano) {
        
        String sql = "SELECT Dizimos.Id, Membros.Nome, MesRef,\n"
                + "Dizimo, Oferta, Igrejas.Nome AS NomeIgreja,\n"
                + "Texto, Cnpj, Igrejas.Contatos\n"
                + "FROM (Dizimos INNER JOIN Membros\n"
                + "ON Dizimos.IdMembro = Membros.Id)\n"
                + "INNER JOIN Igrejas\n"
                + "ON Dizimos.IdIgreja = Igrejas.Id\n"
                + "WHERE Dizimos.IdIgreja= " + IdIgreja + "\n"
                + "AND Mid(MesRef, 4) = '" + Ano + "'\n"
                + "ORDER BY Membros.Nome";
        
        relatorioDizimos(sql);
    }
    
    public void relatorioDizimos(int IdIgreja, String MesAno) {
        
        String sql = "SELECT Dizimos.Id, Membros.Nome, MesRef,\n"
                + "Dizimo, Oferta, Igrejas.Nome AS NomeIgreja,\n"
                + "Texto, Cnpj, Igrejas.Contatos\n"
                + "FROM (Dizimos INNER JOIN Membros\n"
                + "ON Dizimos.IdMembro = Membros.Id)\n"
                + "INNER JOIN Igrejas\n"
                + "ON Dizimos.IdIgreja = Igrejas.Id\n"
                + "WHERE Dizimos.IdIgreja= " + IdIgreja + "\n"
                + "AND MesRef = '" + MesAno + "'\n"
                + "ORDER BY Membros.Nome";
        
        relatorioDizimos(sql);
        
    }    
    
    // ----- RELATORIOS INDIVIDUAIS ----- //
    public void cartaTransferencia(int IdMembro) {
        
        frm.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                con.Conectar();
                try {
                    String sql = "SELECT Membros.Nome, Cargo, Texto,\n"
                            + "Igrejas.Nome AS NomeIgreja,\n"
                            + "Igrejas.Contatos AS IgrejaContatos, Cnpj\n"
                            + "FROM Membros INNER JOIN Igrejas\n"
                            + "ON Membros.IdIgreja = Igrejas.Id\n"
                            + "WHERE Membros.Id = " + IdMembro;
                    con.ExecutaSQL(sql);
                    JRResultSetDataSource relatorio = new JRResultSetDataSource(con.rs);
                    JasperPrint jsp = JasperFillManager.fillReport(caminho + "CartadeTransferencia.jasper", new HashMap(), relatorio);
                    JasperViewer jsv = new JasperViewer(jsp, false);
                    jsv.setTitle(versao);
                    jsv.setZoomRatio(0.75f);
                    jsv.setVisible(true);
                    
                } catch (JRException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
                
                con.Desconectar();
                frm.dispose();
            }
        };
        t.start();
        
    }
    
    public void fichaAniversariante(int IdMembro) {
        
        frm.setVisible(true);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                con.Conectar();
                try {
                    String sql = "SELECT Membros.Nome AS NomeMembro,Igrejas.Nome AS NomeIgreja\n"
                            + "FROM Membros INNER JOIN Igrejas\n"
                            + "ON Membros.IdIgreja = Igrejas.Id\n"
                            + "WHERE Membros.Id = " + IdMembro;
                    con.ExecutaSQL(sql);
                    JRResultSetDataSource relatorio = new JRResultSetDataSource(con.rs);
                    JasperPrint jsp = JasperFillManager.fillReport(caminho + "fichadeaniversario.jasper", new HashMap(), relatorio);
                    JasperViewer jsv = new JasperViewer(jsp, false);
                    jsv.setZoomRatio(0.75f);
                    jsv.setTitle(versao);
                    jsv.setVisible(true);
                    
                } catch (JRException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
                con.Desconectar();
                frm.dispose();
            }
        };
        t.start();
        
    }
    
    public void geraPDFrecibo(JasperPrint jsp) {
        
        try {
            JFileChooser busca = new JFileChooser();
            busca.setApproveButtonText("Salvar");
            busca.setDialogTitle("Salvar PDF");
            busca.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            busca.setMultiSelectionEnabled(false);
            
            if (busca.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
                SimpleDateFormat df = new SimpleDateFormat("HHmmss");
                String file = busca.getSelectedFile()
                        + "\\" + jsp.getName() + "-" + df.format(new Date()) + ".pdf";
                JasperExportManager.exportReportToPdfFile(jsp, file);
                JOptionPane.showMessageDialog(null, "PDF GERADO COM SUCESSO",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (JRException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        
    }
}
