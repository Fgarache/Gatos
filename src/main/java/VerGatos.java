import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class VerGatos {
    public VerGatos () throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
        Response respuesta = client.newCall(request).execute();

        String elJson = respuesta.body().string();



        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);
        Image imagen = null;
        URL url = new URL(gatos.getUrl());
        imagen = ImageIO.read(url);
        //icon para jOp
        ImageIcon fotogato = new ImageIcon(imagen);


        String[] menuvergatos = {"Ver otro \uD83D\uDE3B", " Favorito ♡♥\uD83D\uDC95\uD83D\uDE18", "Volver\uD83D\uDD19 "};

        int vergatos = (int) JOptionPane.showOptionDialog(null, "Gatos", "Gatos", 0,
                JOptionPane.OK_CANCEL_OPTION, fotogato, menuvergatos, menuvergatos);







    }

}
