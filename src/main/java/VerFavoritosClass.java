import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class VerFavoritosClass {

   public  VerFavoritosClass () throws IOException {
       OkHttpClient client = new OkHttpClient().newBuilder()
               .build();
       Request request = new Request.Builder()
               .url("https://api.thecatapi.com/v1/favourites")
               .method("GET", null)
               .addHeader("x-api-key", "f6edf5a6-cded-47a5-a8d1-1decc883d18f")
               .build();
       Response response = client.newCall(request).execute();



   }
}
