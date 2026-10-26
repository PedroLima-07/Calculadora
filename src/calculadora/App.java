package calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Aplicação de console que permite usar a {@link Calculadora} por meio de um menu.
 *
 * <p>O menu é exibido repetidamente até o usuário escolher a opção de sair.
 * Erros de cálculo (divisão por zero, operação inválida) e entradas que não
 * são números inteiros são tratados e exibidos como mensagem, sem
 * interromper a execução do programa.</p>
 *
 * @author Pedro Cardoso Lima
 * @version 2.0
 */
public class App {

    /** Opção do menu para soma. */
    private static final int OPCAO_SOMA = 1;

    /** Opção do menu para subtração. */
    private static final int OPCAO_SUBTRACAO = 2;

    /** Opção do menu para multiplicação. */
    private static final int OPCAO_MULTIPLICACAO = 3;

    /** Opção do menu para divisão. */
    private static final int OPCAO_DIVISAO = 4;

    /** Opção do menu para encerrar o programa. */
    private static final int OPCAO_SAIR = 5;

    /** Leitor das entradas digitadas pelo usuário. */
    private final Scanner entrada;

    /** Calculadora usada para realizar as operações. */
    private final Calculadora calculadora;

    /**
     * Cria a aplicação com o leitor de entrada e a calculadora informados.
     *
     * @param entrada     leitor de onde as opções e os números serão lidos
     * @param calculadora calculadora que realizará as operações
     */
    public App(Scanner entrada, Calculadora calculadora) {
        this.entrada = entrada;
        this.calculadora = calculadora;
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // try-with-resources fecha o Scanner automaticamente ao sair
        try (Scanner entrada = new Scanner(System.in)) {
            new App(entrada, new Calculadora()).executar();
        }
    }

    /**
     * Exibe o menu e processa as opções até o usuário escolher sair.
     */
    public void executar() {
        int opcaoEscolhida = 0;

        do {
            exibirMenu();
            try {
                opcaoEscolhida = entrada.nextInt();
                processarOpcao(opcaoEscolhida);
            } catch (ArithmeticException | IllegalArgumentException erro) {
                // Erros da calculadora: mostra a mensagem e volta ao menu
                System.out.println(erro.getMessage());
            } catch (InputMismatchException erro) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
                // Descarta a entrada inválida para não entrar em loop infinito
                entrada.nextLine();
            }
        } while (opcaoEscolhida != OPCAO_SAIR);
    }

    /**
     * Exibe as opções disponíveis no menu.
     */
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

    /**
     * Executa a ação correspondente à opção escolhida no menu.
     *
     * @param opcao número da opção digitada pelo usuário
     */
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

    /**
     * Lê dois números, realiza a operação e exibe o resultado.
     *
     * @param operador     operador enviado para {@link Calculadora#calc(int, int, String)}
     * @param nomeOperacao nome da operação usado na mensagem de resultado
     * @throws ArithmeticException      se houver divisão por zero
     * @throws InputMismatchException   se o usuário não digitar um número inteiro
     */
    private void executarOperacao(String operador, String nomeOperacao) {
        int primeiroNumero = lerInteiro("Digite o primeiro número:");
        int segundoNumero = lerInteiro("Digite o segundo número:");
        double resultado = calculadora.calc(primeiroNumero, segundoNumero, operador);
        System.out.println("Resultado da " + nomeOperacao + ": " + resultado);
    }

    /**
     * Exibe uma mensagem e lê um número inteiro digitado pelo usuário.
     *
     * @param mensagem texto exibido antes da leitura
     * @return o número inteiro digitado
     * @throws InputMismatchException se o valor digitado não for um número inteiro
     */
    private int lerInteiro(String mensagem) {
        System.out.println(mensagem);
        return entrada.nextInt();
    }
}
