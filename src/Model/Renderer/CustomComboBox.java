/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author AYU7-WN
 */
public class CustomComboBox extends JLabel implements ListCellRenderer<Object> {

    Font font = new Font("Century Gothic", Font.PLAIN, 12);
    
    private Color corFundo = Color.BLUE;
    private Color corFonte = Color.WHITE;
    private Color corSelecionado = new Color(34, 47, 62);
    
    public CustomComboBox() {
        setOpaque(true);
    }    
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {

        setText((String) value);
        setFont(font);
        
        if (isSelected) {
            setBackground(getCorFundo());
            setForeground(getCorFonte());
        } else {
            setBackground(getCorSelecionado());
            setForeground(getCorFonte());
        }

        return this;

    }

    /**
     * @return the corFundo
     */
    public Color getCorFundo() {
        return corFundo;
    }

    /**
     * @param corFundo the corFundo to set
     */
    public void setCorFundo(Color corFundo) {
        this.corFundo = corFundo;
    }

    /**
     * @return the corFonte
     */
    public Color getCorFonte() {
        return corFonte;
    }

    /**
     * @param corFonte the corFonte to set
     */
    public void setCorFonte(Color corFonte) {
        this.corFonte = corFonte;
    }

    /**
     * @return the corSelecionado
     */
    public Color getCorSelecionado() {
        return corSelecionado;
    }

    /**
     * @param corSelecionado the corSelecionado to set
     */
    public void setCorSelecionado(Color corSelecionado) {
        this.corSelecionado = corSelecionado;
    }

}
