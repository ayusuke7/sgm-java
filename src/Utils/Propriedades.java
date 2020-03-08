package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Alexandre
 */
public class Propriedades {

    private final String path = System.getProperty("user.dir");
    private final File arquivo;

    public Propriedades() {        
        this.arquivo = new File(path+"/settings.properties");                
    }

    public Properties loadProperties() {

        Properties props = new Properties();

        try (FileInputStream input = new FileInputStream(arquivo)) {

            props.load(input);

        } catch (FileNotFoundException ex) {
            LogsEventos.Gravar(ex.getMessage());
        } catch (IOException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        return props;

    }

    public boolean setProperties(Properties props) {

        try (FileOutputStream output = new FileOutputStream(arquivo)) {
            props.store(output, "FILE PROPERTIES:");
            return true;

        } catch (FileNotFoundException ex) {
            LogsEventos.Gravar(ex.getMessage());
        } catch (IOException ex) {
            LogsEventos.Gravar(ex.getMessage());
        }

        return false;

    }

}
