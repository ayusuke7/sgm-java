package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;

/**
 *
 * @author AYU7-WN
 */
public class ManipularArquivos {

    private final String _CODIFE = "ISO-8859-1";//UTF-8

    public boolean copiaArquivos(File origem, File destino) {

        if (destino.exists()) {
            destino.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {

            sourceChannel = new FileInputStream(origem).getChannel();
            destinationChannel = new FileOutputStream(destino).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
            return true;

        } catch (FileNotFoundException ex) {
            LogsEventos.Gravar(ex.getMessage());
        } catch (IOException ex) {
            LogsEventos.Gravar(ex.getMessage());
        } finally {

            if (sourceChannel != null && sourceChannel.isOpen()) {
                try {
                    sourceChannel.close();
                } catch (IOException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                try {
                    destinationChannel.close();
                } catch (IOException ex) {
                    LogsEventos.Gravar(ex.getMessage());
                }
            }
        }

        return false;

    }

    public boolean GravarArquivo(File arquivo, String texto, boolean apend) {

        try {
            FileOutputStream output = new FileOutputStream(arquivo, apend);
            //Salva como ANSI windows-1252
            try (OutputStreamWriter print = new OutputStreamWriter(output, _CODIFE)) {
                print.append(texto);
                print.flush();
            }
            return true;
        } catch (IOException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        return false;
    }

    public String LerArquivo(File arquivo) {

        String saida = "";

        try {
            FileInputStream file = new FileInputStream(arquivo);
            BufferedReader in = new BufferedReader(new InputStreamReader(file, "UTF-8"));
            while (in.ready()) {
                saida += in.readLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            saida = "ERRO FileNotFoundException: " + ex;
            LogsEventos.Gravar(ex.getMessage());
        } catch (IOException ex) {
            saida = "ERRO IOException: " + ex;
            LogsEventos.Gravar(ex.getMessage());
        }

        return saida;
    }

}
