import java.util.HashMap;
import java.util.Map;

public class MapaExemplo {
    public static void main(String[] args) {
        Map<String, Integer> idades = new HashMap<>();

        idades.put("João", 23);
        idades.put("Maria", 34);
        idades.put("Wiliam", 44);

        // Atualizar a idade da Maria
        idades.put("Maria", 35);

        for(String nome : idades.keySet()) {
            System.out.println(nome + " tem " + idades.get(nome) + " anos.");
        }
    }
}
