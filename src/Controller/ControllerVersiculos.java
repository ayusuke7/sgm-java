package Controller;

import Conexao.Conexao;
import Model.Versiculo;
import Utils.LogsEventos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author YU7
 */
public class ControllerVersiculos {

    private final Conexao con;

    public ControllerVersiculos() {
        this.con = new Conexao();
    }

    public Versiculo Buscar(int id) {

        Versiculo vers = new Versiculo();
        con.Conectar();

        try {
            con.ExecutaSQL("SELECT * FROM Versiculos WHERE Id=?");
            if (con.rs.first()) {
                vers.setId(con.rs.getInt("Id"));
                vers.setLivro(con.rs.getInt("Livro"));
                vers.setCapitulo(con.rs.getInt("Capitulo"));
                vers.setVersiculo(con.rs.getInt("Versiculo"));
                vers.setTexto(con.rs.getString("Descricao"));
                vers.setFavorito(con.rs.getBoolean("Favorito"));
            }

        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return vers;
    }

    public ArrayList<Versiculo> Listar(int Livro, int Capitulo) {
        String sql = "SELECT * FROM Versiculos WHERE "
                + "Livro = " + Livro + " AND Capitulo = " + Capitulo;
        return Listar(sql);
    }

    public ArrayList<Versiculo> Listar(String sql) {

        ArrayList<Versiculo> versiculos = new ArrayList<>();

        con.Conectar();
        try {
            con.ExecutaSQL(sql);
            if (con.rs.first()) {
                do {
                    Versiculo vers = new Versiculo();
                    vers.setId(con.rs.getInt("Id"));
                    vers.setLivro(con.rs.getInt("Livro"));
                    vers.setCapitulo(con.rs.getInt("Capitulo"));
                    vers.setVersiculo(con.rs.getInt("Versiculo"));
                    vers.setTexto(con.rs.getString("Descricao"));
                    vers.setFavorito(con.rs.getBoolean("Favorito"));
                    versiculos.add(vers);
                } while (con.rs.next());
            }

        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return versiculos;

    }

    public boolean Favoritar(int IdVerso, boolean favorito) {

        con.Conectar();

        try {

            String sql = "UPDATE Versiculos SET Favorito=? WHERE Id=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setBoolean(1, favorito);
            pst.setInt(2, IdVerso);
            pst.execute();
            return true;

        } catch (SQLException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        con.Desconectar();
        return false;

    }

    public ArrayList<String[]> Referencias() {

        String sql = "SELECT Livros.Nome, Referencias.Capitulo, Referencias.Versiculo, Descricao\n"
                + "FROM (Referencias INNER JOIN Livros ON Referencias.Livro = Livros.Livro) \n"
                + "INNER JOIN Versiculos ON Referencias.Livro = Versiculos.Livro\n"
                + "WHERE  Referencias.Capitulo = Versiculos.Capitulo\n"
                + "AND Referencias.Versiculo = Versiculos.Versiculo";

        return new ControllerGenerico().Listar(sql);
                
        
    }

}
