package Controller;

import Conexao.Conexao;
import Model.Lancamento;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author AYU7-WN
 */
public class ControllerDizimos {

    private final Conexao con;

    public ControllerDizimos() {
        this.con = new Conexao();
    }

    public boolean Cadastrar(Lancamento lanc) {
        con.Conectar();
        try {
            String sql = "INSERT INTO Dizimos (IdMembro, MesRef, Dizimo, Oferta, IdIgreja) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setInt(1, lanc.getIdMembro());
            pst.setString(2, lanc.getMesRef());
            pst.setString(3, lanc.getDizimo());
            pst.setString(4, lanc.getOferta());
            pst.setInt(5, lanc.getIdIgreja());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(Lancamento lanc) {
        con.Conectar();
        try {
            String sql = "UPDATE Dizimos SET MesRef=?, Dizimo=?, Oferta=?, IdIgreja=?, IdMembro=? WHERE Id=?";
            PreparedStatement pst = con.con.prepareStatement(sql);            
            pst.setString(1, lanc.getMesRef());
            pst.setString(2, lanc.getDizimo());
            pst.setString(3, lanc.getOferta());
            pst.setInt(4, lanc.getIdIgreja());
            pst.setInt(5, lanc.getIdMembro());
            pst.setInt(6, lanc.getId());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return false;
    }

}
