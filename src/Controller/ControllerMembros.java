package Controller;

import Conexao.Conexao;
import Model.Membro;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AYU7-WN
 */
public class ControllerMembros {

    private final Conexao con;

    public ControllerMembros() {
        con = new Conexao();
    }

    public boolean Cadastrar(Membro membro) {

        con.Conectar();
        try {
            PreparedStatement pst = con.con.prepareStatement("INSERT INTO Membros "
                    + "(Nome, Genero, DtNascimento, EstadoCivil, Contatos, "
                    + "Cpf, Email, NomePai, NomeMae, Endereco, Bairro, Cidade, Estado, Cep, "
                    + "Complemento, IdIgreja, Cargo, Situacao, Ministerio, Foto) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, membro.getNome());
            pst.setString(2, membro.getGenero());
            pst.setString(3, membro.getDtNascimento());
            pst.setString(4, membro.getEstadoCivil());
            pst.setString(5, membro.getContatos());
            pst.setString(6, membro.getCpf());
            pst.setString(7, membro.getEmail());
            pst.setString(8, membro.getNomePai());
            pst.setString(9, membro.getNomeMae());
            pst.setString(10, membro.getEndereco());
            pst.setString(11, membro.getBairro());
            pst.setString(12, membro.getCidade());
            pst.setString(13, membro.getEstado());
            pst.setString(14, membro.getCep());
            pst.setString(15, membro.getComplemento());
            pst.setInt(16, membro.getIdIgreja());
            pst.setString(17, membro.getCargo());
            pst.setString(18, membro.getSituacao());
            pst.setString(19, membro.getMinisterio());
            pst.setString(20, membro.getFoto());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(Membro membro) {

        con.Conectar();
        try {
            PreparedStatement pst = con.con.prepareStatement("UPDATE Membros SET "
                    + "Nome=?, Genero=?, DtNascimento=?, EstadoCivil=?, Contatos=?, "
                    + "Cpf=?, Email=?, NomePai=?, NomeMae=?, Endereco=?, "
                    + "Bairro=?, Cidade=?, Estado=?, Cep=?, Complemento=?, "
                    + "Cargo=?, Situacao=?, Ministerio=?, Foto=?, IdIgreja=? WHERE Id=?");
            pst.setString(1, membro.getNome());
            pst.setString(2, membro.getGenero());
            pst.setString(3, membro.getDtNascimento());
            pst.setString(4, membro.getEstadoCivil());
            pst.setString(5, membro.getContatos());
            pst.setString(6, membro.getCpf());
            pst.setString(7, membro.getEmail());
            pst.setString(8, membro.getNomePai());
            pst.setString(9, membro.getNomeMae());
            pst.setString(10, membro.getEndereco());
            pst.setString(11, membro.getBairro());
            pst.setString(12, membro.getCidade());
            pst.setString(13, membro.getEstado());
            pst.setString(14, membro.getCep());
            pst.setString(15, membro.getComplemento());
            pst.setString(16, membro.getCargo());
            pst.setString(17, membro.getSituacao());
            pst.setString(18, membro.getMinisterio());
            pst.setString(19, membro.getFoto());
            pst.setInt(20, membro.getIdIgreja());
            pst.setInt(21, membro.getId());
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
            PreparedStatement pst = con.con.prepareStatement("DELETE FROM Membros WHERE Id=?");
            pst.setInt(1, id);
            pst.execute();

            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public Membro Buscar(int id) {

        con.Conectar();
        Membro membro = new Membro();

        try {
            con.ExecutaSQL("SELECT * FROM Membros WHERE Id=" + id);
            if (con.rs.first()) {

                membro.setId(con.rs.getInt("Id"));
                membro.setNome(con.rs.getString("Nome"));
                membro.setGenero(con.rs.getString("Genero"));
                membro.setEstadoCivil(con.rs.getString("EstadoCivil"));
                membro.setContatos(con.rs.getString("Contatos"));
                membro.setCpf(con.rs.getString("Cpf"));
                membro.setEmail(con.rs.getString("Email"));
                membro.setNomePai(con.rs.getString("NomePai"));
                membro.setNomeMae(con.rs.getString("NomeMae"));
                membro.setEndereco(con.rs.getString("Endereco"));
                membro.setBairro(con.rs.getString("Bairro"));
                membro.setCidade(con.rs.getString("Cidade"));
                membro.setEstado(con.rs.getString("Estado"));
                membro.setCep(con.rs.getString("Cep"));
                membro.setComplemento(con.rs.getString("Complemento"));
                membro.setCargo(con.rs.getString("Cargo"));
                membro.setSituacao(con.rs.getString("Situacao"));
                membro.setMinisterio(con.rs.getString("Ministerio"));
                membro.setFoto(con.rs.getString("Foto"));
                membro.setIdIgreja(con.rs.getInt("IdIgreja"));
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return membro;

    }

    public ArrayList<Membro> Listar(String sql) {

        ArrayList<Membro> membros = new ArrayList<>();
        con.Conectar();
        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Membro membro = new Membro();
                    membro.setId(con.rs.getInt("Id"));
                    membro.setNome(con.rs.getString("Nome"));
                    membro.setDtNascimento(con.rs.getString("DtNascimento"));
                    membro.setGenero(con.rs.getString("Genero"));
                    membro.setEstadoCivil(con.rs.getString("EstadoCivil"));
                    membro.setContatos(con.rs.getString("Contatos"));
                    membro.setCpf(con.rs.getString("Cpf"));
                    membro.setEmail(con.rs.getString("Email"));
                    membro.setNomePai(con.rs.getString("NomePai"));
                    membro.setNomeMae(con.rs.getString("NomeMae"));
                    membro.setEndereco(con.rs.getString("Endereco"));
                    membro.setBairro(con.rs.getString("Bairro"));
                    membro.setCidade(con.rs.getString("Cidade"));
                    membro.setEstado(con.rs.getString("Estado"));
                    membro.setCep(con.rs.getString("Cep"));
                    membro.setComplemento(con.rs.getString("Complemento"));
                    membro.setCargo(con.rs.getString("Cargo"));
                    membro.setSituacao(con.rs.getString("Situacao"));
                    membro.setMinisterio(con.rs.getString("Ministerio"));
                    membro.setFoto(con.rs.getString("Foto"));
                    membro.setIdIgreja(con.rs.getInt("IdIgreja"));
                    membros.add(membro);
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return membros;
    }

    public ArrayList<Membro> Listar() {
        return Listar("SELECT * FROM Membros");
    }

}
