
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class Menu {

    public Menu() throws IOException {
        String[] botones = {"1. VER GATOS \uD83D\uDE3B", "2. FAVORITOS ♡♥\uD83D\uDC95\uD83D\uDE18", "3. Ver Perros", "4. SALIR"};
        Icon logo;
        logo = new ImageIcon(new URL("https://cdn2.thecatapi.com/images/dgh.jpg"));


        int menu = (int) JOptionPane.showOptionDialog(null, "                                 " +
                        "Selecciona una opcion", "Ver imagenes de Gatos ", 0,
                JOptionPane.QUESTION_MESSAGE, logo, botones, botones);

        switch (menu) {
            case 0:
                VerGatos ver = new VerGatos();
                break;
            case 1:
                break;
            case 2: VerPerros verperros = new VerPerros();

                break;
            case 3:  Salir salir = new Salir();
                break;

        }
    }
}
