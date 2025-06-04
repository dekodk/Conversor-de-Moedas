import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Consulta {

    public static void converter(String de, String para) {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/97a2aaee7fb3106f01c8f58c/latest/" + de;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser parser = new JsonParser();
            JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            if (jsonobj.get("result").getAsString().equals("success")) {
                JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
                float taxa = rates.get(para).getAsFloat();

                System.out.println("Taxa de câmbio de " + de + " para " + para + ": " + taxa);
                System.out.println("Digite o valor que deseja converter:");

                float valor = new java.util.Scanner(System.in).nextFloat();
                float convertido = valor * taxa;

                System.out.printf("Resultado: %.2f %s = %.2f %s\n", valor, de, convertido, para);
            } else {
                System.out.println("Erro ao consultar a taxa de câmbio.");
            }
        } catch (Exception e) {
            System.out.println("Erro na conversão: " + e.getMessage());
        }
    }

}