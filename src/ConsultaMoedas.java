import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoedas {

    private static final String API_KEY = "e0cd4c5b945a80dd9b4b6fb3";  // Sua chave de API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Moedas buscaMoedas(String moeda) {
        URI endereco = URI.create(BASE_URL + API_KEY + "/latest/USD");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
                double taxa = rates.get(moeda).getAsDouble();
                Moedas moedas = new Moedas();
                moedas.setTaxa(taxa);
                return moedas;
            } else {
                throw new RuntimeException("Erro ao acessar a API, status code: " + response.statusCode());
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter dados da API: " + e.getMessage());
        }
    }
}
