package Controller;

import Conexao.Conexao;
import Model.Patrimonio;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AYU7-WN
 */
public class ControllerPatrimonios {

    private final Conexao con;

    public ControllerPatrimonios() {
        this.con = new Conexao();
    }

    public boolean Cadastrar(Patrimonio patrimonio) {
        con.Conectar();
        try {
            String sql = "INSERT INTO Patrimonios (Nome, Data, Tipo, Quantidade, "
                    + "UnMedida, Valor, Descricao, IdIgreja) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, patrimonio.getNome());
            pst.setString(2, patrimonio.getData());
            pst.setString(3, patrimonio.getTipo());
            pst.setInt(4, patrimonio.getQuantidade());
            pst.setString(5, patrimonio.getUnMedida());
            pst.setString(6, patrimonio.getValor());
            pst.setString(7, patrimonio.getDescricao());
            pst.setInt(8, patrimonio.getIdIgreja());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(Patrimonio patrimonio) {

        con.Conectar();
        try {
            PreparedStatement pst = con.con.prepareStatement("UPDATE Patrimonios SET "
                    + "Nome=?, Data=?, Tipo=?, Quantidade=?, UnMedida=?, Valor=?, "
                    + "Descricao=?, IdIgreja=? WHERE Id=?");
            pst.setString(1, patrimonio.getNome());
            pst.setString(2, patrimonio.getData());
            pst.setString(3, patrimonio.getTipo());
            pst.setInt(4, patrimonio.getQuantidade());
            pst.setString(5, patrimonio.getUnMedida());
            pst.setString(6, patrimonio.getValor());
            pst.setString(7, patrimonio.getDescricao());
            pst.setInt(8, patrimonio.getIdIgreja());
            pst.setInt(9, patrimonio.getId());
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
            PreparedStatement pst = con.con.prepareStatement("DELETE FROM Patrimonios WHERE Id=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerIgrejas.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.Desconectar();
        return false;
    }

    public Patrimonio Buscar(int id) {

        con.Conectar();
        Patrimonio patrimonio = new Patrimonio();

        try {
            con.ExecutaSQL("SELECT * FROM Patrimonios WHERE Id=" + id);
            if (con.rs.first()) {
                patrimonio.setId(con.rs.getInt("Id"));
                patrimonio.setNome(con.rs.getString("Nome"));
                patrimonio.setData(con.rs.getString("Data"));
                patrimonio.setTipo(con.rs.getString("Tipo"));
                patrimonio.setQuantidade(con.rs.getInt("Quantidade"));
                patrimonio.setUnMedida(con.rs.getString("UnMedida"));
                patrimonio.setValor(con.rs.getString("Valor"));
                patrimonio.setDescricao(con.rs.getString("Descricao"));
                patrimonio.setIdIgreja(con.rs.getInt("IdIgreja"));
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return patrimonio;

    }

    public ArrayList<Patrimonio> Listar() {
        return Listar("SELECT * FROM Patrimonios");
    }

    public ArrayList<Patrimonio> Listar(String sql) {

        ArrayList<Patrimonio> patrimonios = new ArrayList<>();
        con.Conectar();
        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Patrimonio patrimonio = new Patrimonio();
                    patrimonio.setId(con.rs.getInt("Id"));
                    patrimonio.setNome(con.rs.getString("Nome"));
                    patrimonio.setData(con.rs.getString("Data"));
                    patrimonio.setTipo(con.rs.getString("Tipo"));
                    patrimonio.setQuantidade(con.rs.getInt("Quantidade"));
                    patrimonio.setUnMedida(con.rs.getString("UnMedida"));
                    patrimonio.setValor(con.rs.getString("Valor"));
                    patrimonio.setDescricao(con.rs.getString("Descricao"));
                    patrimonio.setIdIgreja(con.rs.getInt("IdIgreja"));
                    patrimonios.add(patrimonio);
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return patrimonios;
    }

}
