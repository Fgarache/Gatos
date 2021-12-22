import lombok.Data;

@Data
public class Gatos {

    String id;
    String url;
    String apikey = "f6edf5a6-cded-47a5-a8d1-1decc883d18f";
    String image;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
