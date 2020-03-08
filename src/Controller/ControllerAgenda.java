/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.Conexao;
import Model.Evento;
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
public class ControllerAgenda {

    private final Conexao con;

    public ControllerAgenda() {
        this.con = new Conexao();
    }

    public boolean Cadastrar(Evento evento) {
        con.Conectar();
        try {
            String sql = "INSERT INTO Eventos (Nome, Data, Hora, Descricao) VALUES (?,?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getData());
            pst.setString(3, evento.getHora());
            pst.setString(4, evento.getDescricao());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(Evento evento) {
        con.Conectar();
        try {
            String sql = "UPDATE Eventos SET Nome=?, Data=?, Hora=?, Descricao=? WHERE Id=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getData());
            pst.setString(3, evento.getHora());
            pst.setString(4, evento.getDescricao());
            pst.setInt(5, evento.getId());
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
            PreparedStatement pst = con.con.prepareStatement("DELETE FROM Eventos WHERE Id=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return false;
    }

    public Evento Buscar(int id) {

        con.Conectar();
        Evento evento = new Evento();
        try {
            con.ExecutaSQL("SELECT * FROM Eventos WHERE Id=" + id);
            if (con.rs.first()) {
                evento.setId(con.rs.getInt("Id"));
                evento.setNome(con.rs.getString("Nome"));
                evento.setData(con.rs.getString("Data"));
                evento.setHora(con.rs.getString("Hora"));
                evento.setDescricao(con.rs.getString("Descricao"));
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return evento;

    }

    public ArrayList<Evento> Listar() {
        return Listar("SELECT * FROM Eventos");
    }

    public ArrayList<Evento> Listar(String sql) {

        ArrayList<Evento> patrimonios = new ArrayList<>();
        con.Conectar();
        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Evento evento = new Evento();
                    evento.setId(con.rs.getInt("Id"));
                    evento.setNome(con.rs.getString("Nome"));
                    evento.setData(con.rs.getString("Data"));
                    evento.setHora(con.rs.getString("Hora"));
                    evento.setDescricao(con.rs.getString("Descricao"));
                    patrimonios.add(evento);
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return patrimonios;
    }

}
