package Controller;

import Conexao.Conexao;
import Model.Ata;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AYU7-WN
 */
public class ControllerAtas {

    private final Conexao con;

    public ControllerAtas() {
        this.con = new Conexao();
    }

    public boolean Cadastrar(Ata ata) {
        con.Conectar();
        try {
            String sql = "INSERT INTO Atas (Data, Titulo, Secretario, "
                    + "Pastor, Votos, Descricao, IdIgreja) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, ata.getData());
            pst.setString(2, ata.getTitulo());
            pst.setString(3, ata.getSecretario());
            pst.setString(4, ata.getPastor());
            pst.setString(5, ata.getVotos());
            pst.setString(6, ata.getDescricao());
            pst.setInt(7, ata.getIdIgreja());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(Ata ata) {

        con.Conectar();
        try {
            PreparedStatement pst = con.con.prepareStatement("UPDATE Atas SET "
                    + "Data=?, Titulo=?, Secretario=?, Pastor=?, Votos=?, "
                    + "Descricao=?, IdIgreja=? WHERE Id=?");
            pst.setString(1, ata.getData());
            pst.setString(2, ata.getTitulo());
            pst.setString(3, ata.getSecretario());
            pst.setString(4, ata.getPastor());
            pst.setString(5, ata.getVotos());
            pst.setString(6, ata.getDescricao());
            pst.setInt(7, ata.getIdIgreja());
            pst.setInt(8, ata.getId());
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
            PreparedStatement pst = con.con.prepareStatement("DELETE FROM Atas WHERE Id=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return false;
    }

    public Ata Buscar(int id) {

        con.Conectar();
        Ata ata = new Ata();

        try {
            con.ExecutaSQL("SELECT * FROM Atas WHERE Id=" + id);
            if (con.rs.first()) {
                ata.setId(con.rs.getInt("Id"));
                ata.setData(con.rs.getString("Data"));
                ata.setTitulo(con.rs.getString("Titulo"));
                ata.setSecretario(con.rs.getString("Secretario"));
                ata.setPastor(con.rs.getString("Pastor"));
                ata.setDescricao(con.rs.getString("Descricao"));
                ata.setIdIgreja(con.rs.getInt("IdIgreja"));
                ata.setVotos(con.rs.getString("Votos"));
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return ata;

    }

    public ArrayList<Ata> Listar() {
        return Listar("SELECT * FROM Atas");
    }

    public ArrayList<Ata> Listar(String sql) {

        ArrayList<Ata> atas = new ArrayList<>();
        con.Conectar();
        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Ata ata = new Ata();
                    ata.setId(con.rs.getInt("Id"));
                    ata.setData(con.rs.getString("Data"));
                    ata.setTitulo(con.rs.getString("Titulo"));
                    ata.setSecretario(con.rs.getString("Secretario"));
                    ata.setPastor(con.rs.getString("Pastor"));
                    ata.setDescricao(con.rs.getString("Descricao"));
                    ata.setVotos(con.rs.getString("Votos"));
                    ata.setIdIgreja(con.rs.getInt("IdIgreja"));
                    atas.add(ata);
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return atas;
    }

    public int UltimoRegistro() {
        con.Conectar();
        int registro = 0;
        try {
            con.ExecutaSQL("SELECT MAX(Id) AS Registro FROM Atas;");
            con.rs.first();
            registro = con.rs.getInt("Registro");
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return registro;
    }

}
