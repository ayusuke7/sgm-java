/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.Conexao;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author AYU7-WN
 */
public class ControllerUsuarios {

    private final Conexao con;

    public ControllerUsuarios() {
        this.con = new Conexao();
    }

    public boolean Cadastrar(String nome, String senha, String dica) {
        con.Conectar();
        try {
            String sql = "INSERT INTO Usuarios (Nome, Senha, Dica) VALUES (?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.setString(3, dica);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(int id, String nome, String senha, String dica) {
        con.Conectar();
        try {
            String sql = "UPDATE Usuarios SET Nome=?, Senha=?, Dica=? WHERE Id=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.setString(3, dica);
            pst.setInt(4, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

}
