package C02nio.t6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpCustomClient {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String url = "http://127.0.0.1:8801";
        Request request = new Request.Builder().url(url).get().build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
