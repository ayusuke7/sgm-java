/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class ImagePreview extends JComponent implements PropertyChangeListener {
    // Dimensions of image preview's preferred size.

    final static int WID = 200;
    final static int HEI = 250;
    private ImageIcon icon;

    // Create ImagePreview component to serve as a file chooser accessory.
    public ImagePreview(JFileChooser fc) {
        fc.addPropertyChangeListener(this);
        setPreferredSize(new Dimension(WID, HEI));
    }

    // Paint the ImagePreview component in response to a repaint() method call.
    @Override
    protected void paintComponent(Graphics g) {

        if (icon != null) {

            Graphics2D g2d = (Graphics2D) g;
            Rectangle bounds = new Rectangle(0, 0, icon.getIconWidth(), icon.getIconHeight());
            g.setColor(Color.white);
            g2d.fill(bounds);           
            
            icon.paintIcon(this, g, 0, 0);
        }
    }

    // Respond to property change events sent to this ImagePreview component by
    // the file chooser.
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        // Extract property name from event object.

        String propName = e.getPropertyName();

        // Erase any displayed image if user moves up the directory hierarchy.
        if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(propName)) {
            icon = null;
            repaint();
            return;
        }

        // Display selected file. If a directory is selected, erase any
        // displayed image.
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(propName)) {
            // Extract selected file's File object.

            File file = (File) e.getNewValue();

            if (file == null) {
                icon = null;
                repaint();
                return;
            }

            // Obtain the selected file's icon.
            icon = new ImageIcon(file.getPath());

            if (icon.getIconWidth() == -1) {
                icon.getImage().flush();
                icon = new ImageIcon(file.getPath());
            }

            // Scale icon to fit accessory area if icon too big.
            if (icon.getIconWidth() > WID) {
                icon = new ImageIcon(icon.getImage().getScaledInstance(WID, -1, Image.SCALE_DEFAULT));
            }

            // Display image.
            repaint();
        }
    }
}
