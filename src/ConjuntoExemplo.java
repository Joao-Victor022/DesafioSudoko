import java.util.HashSet;
import java.util.Set;

public class ConjuntoExemplo {
    public static void main(String[] args) {
        Set<String> frutas = new HashSet<>();

        frutas.add("Maça");
        frutas.add("Banana");
        frutas.add("Uva");
        frutas.add("Maça");

        for(String fruta : frutas) {
            System.out.println(fruta);
        }
    }
}
