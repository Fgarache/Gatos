import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class VerPerros {
    public VerPerros() throws IOException {
        //postman
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("https://api.thedogapi.com/v1/images/search")
                .method("GET", null).build();
        Response respuesta = client.newCall(request).execute();

        String elJson = respuesta.body().string();

        //cortar los corchetes
        //elJson = elJson.substring(1, elJson.length());
        //elJson = elJson.substring(0, elJson.length() - 1);

        Gson gson = new Gson();
        Type listOfMyClassObject = new TypeToken<ArrayList<Gatos>>() {}.getType();

        ArrayList<Gatos> gatos = gson.fromJson(elJson, listOfMyClassObject);
        Optional<Gatos> gato = gatos.stream().findFirst();
        Gatos gatoVar = null;
        if (gato.isPresent()){
            gatoVar = gato.get();
        }


        Image imagen;
        URL url = new URL(String.format("%s?x-api-key=%s", gatoVar.getUrl(), gatoVar.getApikey()));
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) " +
                        "AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

        imagen = ImageIO.read(connection.getInputStream());

        //convertir a icon para jop
        ImageIcon imageIcon = new ImageIcon(imagen);

        //redimencionar imagen
        if (imageIcon.getIconWidth() > 800) {

            Image fondo = imageIcon.getImage();
            Image modificada = ((java.awt.Image) fondo).getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(modificada);
        }


        //menu ver gatos
        String[] menuvergatos = {"Siguiente \uD83D\uDE3B", " Favorito ♡♥\uD83D\uDC95\uD83D\uDE18", "Volver\uD83D\uDD19 "};

        int menuver = (int) JOptionPane.showOptionDialog(null, " ",
                "Ver imagenes de Gatos ", 0,
                JOptionPane.QUESTION_MESSAGE, imageIcon, menuvergatos, menuvergatos);


        //obciones menu ver
        switch (menuver) {
            case 0:
                VerPerros ver = new VerPerros();
                break;
            case 1:
                MarcarFav fav = new MarcarFav(gatoVar);
                System.out.println("marcar favoritos");
                break;
            case 2:
                Menu menu = new Menu();
                break;
        }


    }

}
