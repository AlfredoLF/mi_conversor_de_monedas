import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.Gson;

public class Busqueda {
    double conversion;

    public Conversiones consultarConversion(String base_code, String target_code, double monto) {
        URI direccionWeb = URI.create("https://v6.exchangerate-api.com/v6/0f4154e6fe7d5978073d4b12/pair/" + base_code + "/" + target_code + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionWeb)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversiones.class);
        } catch (IOException | InterruptedException I) {
            throw new RuntimeException(I);
        }
    }

    public void mostrarResultado(String base_code, String target_code, double monto) {
        Busqueda deseoBuscar = new Busqueda();
        conversion = deseoBuscar.consultarConversion(base_code, target_code, monto).conversion_result();
        System.out.println("\nEl valor de " + monto + " [" + base_code + "] " + "equivale a un valor de: " + conversion + " [" + target_code + "]\n");
    }
}
