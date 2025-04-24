package EstruturasDeControle;

public class Tabuada {
    public static void main(String[] args) {
        int multiplicar = 1, numero = 5, valor;

        while(multiplicar < 11) {
            valor = numero * multiplicar;
            System.out.println("(" + numero + ") x (" + multiplicar + ") = (" + valor + ")");
            multiplicar++;
        }
    }
}
