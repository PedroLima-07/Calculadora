package calculadora;

/**
 * Calculadora com as quatro operações matemáticas básicas.
 *
 * <p>Esta classe é o módulo de cálculos do FinançApp e pode ser reutilizada
 * em funcionalidades como orçamento mensal, divisão de despesas e projeção
 * de economia. Os operandos são inteiros e o resultado é sempre um
 * {@code double}, para que a divisão não perca a parte decimal
 * (por exemplo, {@code 7 / 2 = 3.5}).</p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * Calculadora calculadora = new Calculadora();
 * double resultado = calculadora.calc(10, 5, "+"); // 15.0
 * }</pre>
 *
 * @author Pedro Cardoso Lima
 * @version 2.0
 */
public class Calculadora {

    /** Operador da soma: {@value}. */
    public static final String SOMA = "+";

    /** Operador da subtração: {@value}. */
    public static final String SUBTRACAO = "-";

    /** Operador da multiplicação: {@value}. */
    public static final String MULTIPLICACAO = "*";

    /** Operador da divisão: {@value}. */
    public static final String DIVISAO = "/";

    /** Mensagem exibida quando há tentativa de divisão por zero. */
    private static final String MENSAGEM_DIVISAO_POR_ZERO = "Erro: não é possível dividir por zero.";

    /**
     * Cria uma nova calculadora. A classe não guarda estado, então a mesma
     * instância pode ser usada para vários cálculos.
     */
    public Calculadora() {
    }

    /**
     * Realiza a operação matemática indicada entre dois números inteiros.
     *
     * @param primeiroNumero primeiro operando (na divisão, é o dividendo)
     * @param segundoNumero  segundo operando (na divisão, é o divisor)
     * @param operador       operação desejada: {@code "+"}, {@code "-"},
     *                       {@code "*"} ou {@code "/"}
     * @return o resultado da operação
     * @throws ArithmeticException      se o operador for {@code "/"} e o
     *                                  segundo número for zero
     * @throws IllegalArgumentException se o operador for nulo ou não for
     *                                  uma das operações suportadas
     */
    public double calc(int primeiroNumero, int segundoNumero, String operador) {
        // O switch não aceita null, por isso a validação é feita antes
        if (operador == null) {
            throw new IllegalArgumentException("Erro: operação inválida (nula). Use +, -, * ou /.");
        }

        // Cada operador é delegado para um método específico
        return switch (operador) {
            case SOMA -> somar(primeiroNumero, segundoNumero);
            case SUBTRACAO -> subtrair(primeiroNumero, segundoNumero);
            case MULTIPLICACAO -> multiplicar(primeiroNumero, segundoNumero);
            case DIVISAO -> dividir(primeiroNumero, segundoNumero);
            default -> throw new IllegalArgumentException(
                    "Erro: operação inválida \"" + operador + "\". Use +, -, * ou /.");
        };
    }

    /**
     * Soma dois números.
     *
     * @param primeiroNumero primeira parcela
     * @param segundoNumero  segunda parcela
     * @return a soma dos dois números
     */
    private double somar(int primeiroNumero, int segundoNumero) {
        // A conversão para double evita estouro do limite de int
        return (double) primeiroNumero + segundoNumero;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param primeiroNumero minuendo
     * @param segundoNumero  subtraendo
     * @return a diferença entre os dois números
     */
    private double subtrair(int primeiroNumero, int segundoNumero) {
        return (double) primeiroNumero - segundoNumero;
    }

    /**
     * Multiplica dois números.
     *
     * @param primeiroNumero primeiro fator
     * @param segundoNumero  segundo fator
     * @return o produto dos dois números
     */
    private double multiplicar(int primeiroNumero, int segundoNumero) {
        return (double) primeiroNumero * segundoNumero;
    }

    /**
     * Divide o dividendo pelo divisor, mantendo a parte decimal.
     *
     * @param dividendo número a ser dividido
     * @param divisor   número pelo qual se divide; não pode ser zero
     * @return o quociente da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    private double dividir(int dividendo, int divisor) {
        validarDivisor(divisor);
        // A conversão para double evita a divisão inteira (7 / 2 = 3)
        return (double) dividendo / divisor;
    }

    /**
     * Garante que o divisor seja diferente de zero.
     *
     * @param divisor valor a ser validado
     * @throws ArithmeticException se o divisor for zero
     */
    private void validarDivisor(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException(MENSAGEM_DIVISAO_POR_ZERO);
        }
    }
}
