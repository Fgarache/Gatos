import okhttp3.*;

import java.io.IOException;

public class MarcarFav {
    public MarcarFav() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\"image_id\":\"MjAzODE2Nw\"\n}");
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/favourites")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "f6edf5a6-cded-47a5-a8d1-1decc883d18f")
                .build();
        Response response = client.newCall(request).execute();


        VerGatos ver = new VerGatos();


    }


}
