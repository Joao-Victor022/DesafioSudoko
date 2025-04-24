import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Paulo");
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("João");

        for(String nome : nomes) {
            System.out.println(nome);
        }
    }
}
