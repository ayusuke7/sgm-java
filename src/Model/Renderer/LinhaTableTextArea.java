package Model.Renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class LinhaTableTextArea extends JTextArea implements TableCellRenderer {

    private ArrayList<Integer> rows;

    public LinhaTableTextArea() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    public void SetFonte(Font font) {
        setFont(font);
    }

    public void SetCoresLinhas(ArrayList<Integer> linhas) {
        this.rows = linhas;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable,
            Object obj, boolean isSelected, boolean hasFocus, int row,
            int column) {

        setText((String) obj);

        if (isSelected) {
            setForeground(jTable.getSelectionForeground());
            setBackground(jTable.getSelectionBackground());
        } else {
            setForeground(jTable.getForeground());
            if (rows != null && rows.contains(row)) {
                setBackground(new Color(255, 255, 153));
            } else {
                setBackground(jTable.getBackground());
            }
            
        }

        int larg = jTable.getColumnModel().getColumn(column).getWidth();
        int altu = getPreferredSize().height;

        setSize(larg, altu);

        if (jTable.getRowHeight(row) != getPreferredSize().height) {
            jTable.setRowHeight(row, getPreferredSize().height);
        }

        return this;

    }

}
