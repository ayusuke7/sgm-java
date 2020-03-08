/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class LogsEventos {

    public static void Gravar(String ref) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String format = sdf.format(new Date());
        
        String data = format.substring(0, 10);
        String hora = format.substring(10);
        
        String source = System.getProperty("user.dir");
        File file = new File(source+"/Logs/"+data+".txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(hora+" - "+ref);
            bw.newLine();
            bw.flush();

            int op = JOptionPane.showConfirmDialog(null, "OCORREU UM PROBLEMA\nABRIR ARQUIVO DE LOG?", 
                    "PROBLEMA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(op == JOptionPane.YES_OPTION){
                Desktop.getDesktop().open(file);
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "ERRO EM SALVAR LOG\n"+ex.getMessage(), 
                    "PROBLEMAS", JOptionPane.WARNING_MESSAGE);
        }

    }
}
