package calculadora;

public class Calculadora {

    public double calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Erro: operação inválida (nula). Use +, -, * ou /.");
        }
        if (op.equals("+")) {
            return (double) a + b;
        } else if (op.equals("-")) {
            return (double) a - b;
        } else if (op.equals("*")) {
            return (double) a * b;
        } else if (op.equals("/")) {
            if (b == 0) {
                throw new ArithmeticException("Erro: não é possível dividir por zero.");
            } else {
                return (double) a / b;
            }
        } else {
            throw new IllegalArgumentException("Erro: operação inválida \"" + op + "\". Use +, -, * ou /.");
        }
    }
}
