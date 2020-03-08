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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AYU7-WN
 */
public class ControllerCargos {

    private final Conexao con;

    public ControllerCargos() {
        this.con = new Conexao();
    }

    public boolean Cadastrar(String nome, String tabela) {
        con.Conectar();
        try {
            String sql = "INSERT INTO "+tabela+" (Nome) VALUES (?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public boolean Editar(int id, String nome, String tabela) {
        con.Conectar();
        try {
            String sql = "UPDATE "+tabela+" SET Nome=? WHERE Id=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
           LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

}
