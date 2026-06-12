import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Importações da biblioteca Minimal-JSON
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class Conselho {
    private int id_registro;
    String con;

    public Conselho(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_registro() {return id_registro; }
    public void setId_registro(int id_registro) { this.id_registro = id_registro; }

    //public static void main(String[] args) {
    public void consultar(String idEscolha) {
        String url = "https://api.adviceslip.com/advice/"+idEscolha+"";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            System.out.println("Conectando à API...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonBody = response.body();

                System.out.println("Json: "+jsonBody);

                // 1. Transforma o texto bruto recebido da API em um Objeto JSON
                JsonObject objetoPrincipal = Json.parse(jsonBody).asObject();
                
                // 2. Entra no nó/objeto "slip"
                JsonObject slip = objetoPrincipal.get("slip").asObject();
                
                // 3. Extrai o ID como um número inteiro (int) do Java
                int id = slip.get("id").asInt();
                
                // 4. Extrai o conselho como uma String do Java
                String conselho = slip.get("advice").asString();

                // 5. Mostra os resultados separados
                System.out.println("\n--- CONSELHO ENCONTRADO ---");
                System.out.println("ID do Conselho: " + id);
                System.out.println("Conselho: \"" + conselho + "\"");
                System.out.println("---------------------------\n");
                con = conselho;
            } else {
                System.out.println("Erro na requisição. Código: " + response.statusCode());
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void consultarA(String idEscolha) {
        String url = "https://api.adviceslip.com/advice";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            System.out.println("Conectando à API...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonBody = response.body();

                System.out.println("Json: "+jsonBody);

                // 1. Transforma o texto bruto recebido da API em um Objeto JSON
                JsonObject objetoPrincipal = Json.parse(jsonBody).asObject();
                
                // 2. Entra no nó/objeto "slip"
                JsonObject slip = objetoPrincipal.get("slip").asObject();
                
                // 3. Extrai o ID como um número inteiro (int) do Java
                int id = slip.get("id").asInt();
                
                // 4. Extrai o conselho como uma String do Java
                String conselho = slip.get("advice").asString();

                // 5. Mostra os resultados separados
                System.out.println("\n--- CONSELHO ENCONTRADO ---");
                System.out.println("ID do Conselho: " + id);
                System.out.println("Conselho: \"" + conselho + "\"");
                System.out.println("---------------------------\n");
                con = conselho;
            } else {
                System.out.println("Erro na requisição. Código: " + response.statusCode());
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

}
