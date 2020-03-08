package Controller;

import Conexao.Conexao;
import Model.Livro;
import Utils.LogsEventos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author YU7
 */
public class ControllerLivros {

    private final Conexao con;

    public ControllerLivros() {
        this.con = new Conexao();
    }

    public Livro Buscar(int codigo) {

        Livro livro = new Livro();
        try {
            con.Conectar();
            con.ExecutaSQL("SELECT * FROM LIVROS WHERE Livro=" + codigo);

            if (con.rs.first()) {
                livro.setId(con.rs.getInt("Livro"));
                livro.setTestamento(con.rs.getString("Testamento"));
                livro.setAbreviacao(con.rs.getString("Abreviacao"));
                livro.setNomeLivro(con.rs.getString("Nome"));
            }

        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return livro;
    }

    public ArrayList<Livro> Listar(){
        return Listar("SELECT * FROM Livros");
    }
    
    public ArrayList<Livro> Listar(String sql) {

        ArrayList<Livro> livros = new ArrayList<>();

        con.Conectar();
        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Livro livro = new Livro();
                    livro.setId(con.rs.getInt("Livro"));
                    livro.setTestamento(con.rs.getString("Testamento"));
                    livro.setAbreviacao(con.rs.getString("Abreviacao"));
                    livro.setNomeLivro(con.rs.getString("Nome"));
                    livros.add(livro);
                } while (con.rs.next());
            }

        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return livros;
    }

}
