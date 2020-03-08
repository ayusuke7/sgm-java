package Controller;

import Conexao.Conexao;
import Model.Igreja;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AYU7-WN
 */
public class ControllerIgrejas {

    private final Conexao con;

    public ControllerIgrejas() {
        con = new Conexao();
    }

    public boolean Cadastrar(Igreja igreja) {
        con.Conectar();
        try {
            PreparedStatement pst = con.con.prepareStatement("INSERT INTO Igrejas "
                    + "(Nome, Cnpj, Endereco, Bairro, Cidade, Estado, Cep, Contatos, "
                    + "Emails, Pagina, Texto, Tipo, Fundacao, Foto) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, igreja.getNome());
            pst.setString(2, igreja.getCnpj());
            pst.setString(3, igreja.getEndereco());
            pst.setString(4, igreja.getBairro());
            pst.setString(5, igreja.getCidade());
            pst.setString(6, igreja.getEstado());
            pst.setString(7, igreja.getCep());
            pst.setString(8, igreja.getContatos());
            pst.setString(9, igreja.getEmails());
            pst.setString(10, igreja.getPagina());
            pst.setString(11, igreja.getTexto());
            pst.setString(12, igreja.getTipo());
            pst.setString(13, igreja.getFundacao());
            pst.setString(14, igreja.getFoto());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(Igreja igreja) {

        con.Conectar();
        try {
            PreparedStatement pst = con.con.prepareStatement("UPDATE Igrejas SET "
                    + "Nome=?, Cnpj=?, Endereco=?, Bairro=?, Cidade=?, Estado=?, Cep=?, "
                    + "Contatos=?, Emails=?, Pagina=?, Texto=?, Tipo=?, Fundacao=?, Foto=?WHERE Id=?");
            pst.setString(1, igreja.getNome());
            pst.setString(2, igreja.getCnpj());
            pst.setString(3, igreja.getEndereco());
            pst.setString(4, igreja.getBairro());
            pst.setString(5, igreja.getCidade());
            pst.setString(6, igreja.getEstado());
            pst.setString(7, igreja.getCep());
            pst.setString(8, igreja.getContatos());
            pst.setString(9, igreja.getEmails());
            pst.setString(10, igreja.getPagina());
            pst.setString(11, igreja.getTexto());
            pst.setString(12, igreja.getTipo());
            pst.setString(13, igreja.getFundacao());
            pst.setString(14, igreja.getFoto());
            pst.setInt(15, igreja.getId());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return false;
    }

    public boolean Excluir(int id) {

        con.Conectar();

        try {
            PreparedStatement pst = con.con.prepareStatement("DELETE FROM Igrejas WHERE Id=?");
            pst.setInt(1, id);
            pst.execute();

            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public Igreja Buscar(int id) {

        con.Conectar();
        Igreja igreja = new Igreja();

        try {
            con.ExecutaSQL("SELECT * FROM Igrejas WHERE Id=" + id);
            if (con.rs.first()) {

                igreja.setId(con.rs.getInt("Id"));
                igreja.setNome(con.rs.getString("Nome"));
                igreja.setCnpj(con.rs.getString("Cnpj"));
                igreja.setEndereco(con.rs.getString("Endereco"));
                igreja.setBairro(con.rs.getString("Bairro"));
                igreja.setCidade(con.rs.getString("Cidade"));
                igreja.setEstado(con.rs.getString("Estado"));
                igreja.setContatos(con.rs.getString("Contatos"));
                igreja.setEmails(con.rs.getString("Emails"));
                igreja.setCep(con.rs.getString("Cep"));
                igreja.setPagina(con.rs.getString("Pagina"));
                igreja.setTexto(con.rs.getString("Texto"));
                igreja.setTipo(con.rs.getString("Tipo"));
                igreja.setFundacao(con.rs.getString("Fundacao"));
                igreja.setFoto(con.rs.getString("Foto"));
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return igreja;

    }

    public ArrayList<Igreja> Listar() {
        return Listar("SELECT * FROM Igrejas");
    }

    public ArrayList<Igreja> Listar(String sql) {

        ArrayList<Igreja> igrejas = new ArrayList<>();

        con.Conectar();

        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Igreja igreja = new Igreja();
                    igreja.setId(con.rs.getInt("Id"));
                    igreja.setNome(con.rs.getString("Nome"));
                    igreja.setCnpj(con.rs.getString("Cnpj"));
                    igreja.setEndereco(con.rs.getString("Endereco"));
                    igreja.setBairro(con.rs.getString("Bairro"));
                    igreja.setCidade(con.rs.getString("Cidade"));
                    igreja.setEstado(con.rs.getString("Estado"));
                    igreja.setContatos(con.rs.getString("Contatos"));
                    igreja.setEmails(con.rs.getString("Emails"));
                    igreja.setCep(con.rs.getString("Cep"));
                    igreja.setPagina(con.rs.getString("Pagina"));
                    igreja.setTexto(con.rs.getString("Texto"));
                    igreja.setTipo(con.rs.getString("Tipo"));
                    igreja.setFundacao(con.rs.getString("Fundacao"));
                    igreja.setFoto(con.rs.getString("Foto"));
                    igrejas.add(igreja);
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return igrejas;
    }

}
