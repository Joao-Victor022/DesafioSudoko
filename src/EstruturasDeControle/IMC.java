package EstruturasDeControle;

public class IMC {
    public static void main(String[] args) {
        double peso = 80, altura = 1.90, imc;

        imc = peso / (altura * altura);

        if(imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if(imc > 18.6 && imc <= 24.9) {
            System.out.println("Peso ideal");
        } else if(imc > 25.0 && imc <= 29.9) {
            System.out.println("Acima do peso");
        } else if(imc > 30.0 && imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if(imc > 35.0 && imc <= 39.9) {
            System.out.println("Obesidade Grau II (Severo)");
        } else if(imc >= 40){
            System.out.println("Obesidade Grau III (Mórbida)");
        } else {
            System.out.println("Inválido!");
        }
    }
}
