package Controller;

import Conexao.Conexao;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AYU7-WN
 */
public class ControllerGenerico {

    private final Conexao con;

    public ControllerGenerico() {
        con = new Conexao();
    }

    public boolean Excluir(int id, String primareKey, String tabela) {
        con.Conectar();
        try {
            String sql = "DELETE FROM " + tabela + " WHERE "+primareKey+"=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
           LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;
    }

    public ArrayList<String> Buscar(int id, String primareKey, String tabela) {
        con.Conectar();
        ArrayList<String> dados = new ArrayList();
        try {
            con.ExecutaSQL("SELECT * FROM " + tabela + " WHERE "+primareKey+"=" + id);
            if (con.rs.first()) {

                ResultSetMetaData meta = con.rs.getMetaData();
                int tam = meta.getColumnCount();

                for (int i = 0; i < tam; i++) {
                    dados.add(String.valueOf(con.rs.getObject(meta.getColumnName(i + 1))));
                }

            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return dados;

    }

    public ArrayList<String[]> Listar(String sql) {

        ArrayList dados = new ArrayList<>();
        con.Conectar();

        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                ResultSetMetaData meta = con.rs.getMetaData();
                int tam = meta.getColumnCount();
                do {
                    String[] tmp = new String[tam];
                    for (int i = 0; i < tam; i++) {
                        tmp[i] = "" + con.rs.getObject(meta.getColumnName(i + 1));
                    }
                    dados.add(tmp);

                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return dados;
    }

    public int UltimoRegistro(String primareKey, String tabela) {

        int saida = -1;

        con.Conectar();
        con.ExecutaSQL("SELECT " + primareKey + " FROM " + tabela);
        try {
            if (con.rs.last()) {
                saida = con.rs.getInt(primareKey);
            }
        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }
        con.Desconectar();
        return saida;

    }
    
}
