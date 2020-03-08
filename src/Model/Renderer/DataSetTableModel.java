package Model.Renderer;

import Conexao.Conexao;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class DataSetTableModel {


    public static DefaultTableModel Tabela(String sql) {

        Conexao con = new Conexao();
        
        //Desativando o edição da celulas da jTable
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        try {
            con.Conectar();
            con.ExecutaSQL(sql);
            ResultSetMetaData rsMeta = con.rs.getMetaData();
            int tam = rsMeta.getColumnCount();
            String[] colunas = new String[tam]; //vetor do tamanho da quantidade de colunas no ResultSet

            for (int i = 0; i < tam; i++) {
                colunas[i] = rsMeta.getColumnName(i + 1).toUpperCase(); //Preenchendo o vetor de String com os nomes das Colunas
            }

            //Preechendo as colunas do DefaultTableModel com os nomes das colunas no salvos no vetor
            for (int i = 0; i < tam; i++) {
                modelo.addColumn(colunas[i]);
            }
            
            if (con.rs.first()) {
                //Enquanto tiver dados no ResultSet, adiciona as linhas no DefaultTableModel           
                do {
                    String[] reg = new String[tam];
                    for (int i = 0; i < tam; i++) {
                        reg[i] = con.rs.getString(colunas[i]);
                    }
                    Object[] registros = reg;
                    modelo.addRow(registros);
                } while (con.rs.next());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
        }
        con.Desconectar();
        return modelo;

    }

}
