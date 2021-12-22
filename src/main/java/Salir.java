import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Salir {

    public Salir () throws IOException {
        String[] botones = {"SI", "Volver"};
        int menusalir = (int) JOptionPane.showOptionDialog(null, "seguro deseas salir", "salir", 0,
                JOptionPane.OK_CANCEL_OPTION, null, botones, botones);

        switch (menusalir){
            case 0:
                break;
            case 1: Menu menu = new Menu();
                break;
        }
    }
}
