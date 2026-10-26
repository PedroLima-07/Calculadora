package calculadora;

public class Calculadora {

    public static final String SOMA = "+";
    public static final String SUBTRACAO = "-";
    public static final String MULTIPLICACAO = "*";
    public static final String DIVISAO = "/";

    private static final String MENSAGEM_DIVISAO_POR_ZERO = "Erro: não é possível dividir por zero.";

    public double calc(int primeiroNumero, int segundoNumero, String operador) {
        if (operador == null) {
            throw new IllegalArgumentException("Erro: operação inválida (nula). Use +, -, * ou /.");
        }

        return switch (operador) {
            case SOMA -> somar(primeiroNumero, segundoNumero);
            case SUBTRACAO -> subtrair(primeiroNumero, segundoNumero);
            case MULTIPLICACAO -> multiplicar(primeiroNumero, segundoNumero);
            case DIVISAO -> dividir(primeiroNumero, segundoNumero);
            default -> throw new IllegalArgumentException(
                    "Erro: operação inválida \"" + operador + "\". Use +, -, * ou /.");
        };
    }

    private double somar(int primeiroNumero, int segundoNumero) {
        return (double) primeiroNumero + segundoNumero;
    }

    private double subtrair(int primeiroNumero, int segundoNumero) {
        return (double) primeiroNumero - segundoNumero;
    }

    private double multiplicar(int primeiroNumero, int segundoNumero) {
        return (double) primeiroNumero * segundoNumero;
    }

    private double dividir(int dividendo, int divisor) {
        validarDivisor(divisor);
        return (double) dividendo / divisor;
    }

    private void validarDivisor(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException(MENSAGEM_DIVISAO_POR_ZERO);
        }
    }
}
