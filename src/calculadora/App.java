package calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        int opt = 0;

        do {
            System.out.println("\n=====================");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Soma");
            System.out.println("2- Subtração");
            System.out.println("3- Multiplicação");
            System.out.println("4- Divisão");
            System.out.println("5- Sair");
            System.out.println("======================");

            try {
                opt = sc.nextInt();
                if (opt == 1) {
                    System.out.println("Digite o primeiro número:");
                    int n1 = sc.nextInt();
                    System.out.println("Digite o segundo número:");
                    int n2 = sc.nextInt();
                    System.out.println("Resultado da soma: " + calc.calc(n1, n2, "+"));
                } else if (opt == 2) {
                    System.out.println("Digite o primeiro número:");
                    int n1 = sc.nextInt();
                    System.out.println("Digite o segundo número:");
                    int n2 = sc.nextInt();
                    System.out.println("Resultado da subtração: " + calc.calc(n1, n2, "-"));
                } else if (opt == 3) {
                    System.out.println("Digite o primeiro número:");
                    int n1 = sc.nextInt();
                    System.out.println("Digite o segundo número:");
                    int n2 = sc.nextInt();
                    System.out.println("Resultado da multiplicação: " + calc.calc(n1, n2, "*"));
                } else if (opt == 4) {
                    System.out.println("Digite o primeiro número:");
                    int n1 = sc.nextInt();
                    System.out.println("Digite o segundo número:");
                    int n2 = sc.nextInt();
                    System.out.println("Resultado da divisão: " + calc.calc(n1, n2, "/"));
                } else if (opt == 5) {
                    System.out.println("Saindo...");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
                sc.nextLine();
            }
        } while (opt != 5);
        sc.close();
    }
}
