/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Renderer;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author AYU7-WN
 */
public class CustomListCheckBox extends JCheckBox implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, 
            Object value, int index, boolean isSelected, boolean cellHasFocus) {        
        
        return this;
    }


}
