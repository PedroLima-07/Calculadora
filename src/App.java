import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opt = 0;

        do{
            System.out.println("\n=====================");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Soma");
            System.out.println("2- Subtração");
            System.out.println("3- Multiplicação");
            System.out.println("4- Divisão");
            System.out.println("5- Sair");
            System.out.println("======================");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Digite o primeiro número:");
                    double num1 = sc.nextDouble();
                    System.out.println("Digite o segundo número:");
                    double num2 = sc.nextDouble();
                    calculadora calc = new calculadora(num1, num2);
                    System.out.println("Resultado da soma: " + calc.somar());
                    break;
                case 2:
                    System.out.println("Digite o primeiro número:");
                    num1 = sc.nextDouble();
                    System.out.println("Digite o segundo número:");
                    num2 = sc.nextDouble();
                    calc = new calculadora(num1, num2);
                    System.out.println("Resultado da subtração: " + calc.subtrair());
                    break;
                case 3:
                    System.out.println("Digite o primeiro número:");
                    num1 = sc.nextDouble();
                    System.out.println("Digite o segundo número:");
                    num2 = sc.nextDouble();
                    calc = new calculadora(num1, num2);
                    System.out.println("Resultado da multiplicação: " + calc.multiplicar());
                    break;
                case 4:
                    System.out.println("Digite o primeiro número:");
                    num1 = sc.nextDouble();
                    System.out.println("Digite o segundo número:");
                    num2 = sc.nextDouble();
                    calc = new calculadora(num1, num2);
                    try {
                        System.out.println("Resultado da divisão: " + calc.dividir());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opt != 5);
        sc.close();
    }
}
