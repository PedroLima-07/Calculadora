package calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final int OPCAO_SOMA = 1;
    private static final int OPCAO_SUBTRACAO = 2;
    private static final int OPCAO_MULTIPLICACAO = 3;
    private static final int OPCAO_DIVISAO = 4;
    private static final int OPCAO_SAIR = 5;

    private final Scanner entrada;
    private final Calculadora calculadora;

    public App(Scanner entrada, Calculadora calculadora) {
        this.entrada = entrada;
        this.calculadora = calculadora;
    }

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            new App(entrada, new Calculadora()).executar();
        }
    }

    public void executar() {
        int opcaoEscolhida = 0;

        do {
            exibirMenu();
            try {
                opcaoEscolhida = entrada.nextInt();
                processarOpcao(opcaoEscolhida);
            } catch (ArithmeticException | IllegalArgumentException erro) {
                System.out.println(erro.getMessage());
            } catch (InputMismatchException erro) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
                entrada.nextLine();
            }
        } while (opcaoEscolhida != OPCAO_SAIR);
    }

    private void exibirMenu() {
        System.out.println("\n=====================");
        System.out.println("Escolha uma opção:");
        System.out.println(OPCAO_SOMA + "- Soma");
        System.out.println(OPCAO_SUBTRACAO + "- Subtração");
        System.out.println(OPCAO_MULTIPLICACAO + "- Multiplicação");
        System.out.println(OPCAO_DIVISAO + "- Divisão");
        System.out.println(OPCAO_SAIR + "- Sair");
        System.out.println("======================");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case OPCAO_SOMA -> executarOperacao(Calculadora.SOMA, "soma");
            case OPCAO_SUBTRACAO -> executarOperacao(Calculadora.SUBTRACAO, "subtração");
            case OPCAO_MULTIPLICACAO -> executarOperacao(Calculadora.MULTIPLICACAO, "multiplicação");
            case OPCAO_DIVISAO -> executarOperacao(Calculadora.DIVISAO, "divisão");
            case OPCAO_SAIR -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void executarOperacao(String operador, String nomeOperacao) {
        int primeiroNumero = lerInteiro("Digite o primeiro número:");
        int segundoNumero = lerInteiro("Digite o segundo número:");
        double resultado = calculadora.calc(primeiroNumero, segundoNumero, operador);
        System.out.println("Resultado da " + nomeOperacao + ": " + resultado);
    }

    private int lerInteiro(String mensagem) {
        System.out.println(mensagem);
        return entrada.nextInt();
    }
}
