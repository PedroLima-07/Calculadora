package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TesteCalculadora {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    private void exibir(String teste, String entrada, Object esperado, Object obtido) {
        System.out.println("[" + teste + "]");
        System.out.println("  Entrada:  " + entrada);
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtido:   " + obtido);
    }

    @Test
    @DisplayName("Soma: 10 + 5 = 15")
    void testeSoma() {
        double esperado = 15.0;
        double obtido = calculadora.calc(10, 5, "+");
        exibir("Soma", "a=10, b=5, op=\"+\"", esperado, obtido);
        assertEquals(esperado, obtido);
    }

    @Test
    @DisplayName("Subtração: 10 - 5 = 5")
    void testeSubtracao() {
        double esperado = 5.0;
        double obtido = calculadora.calc(10, 5, "-");
        exibir("Subtração", "a=10, b=5, op=\"-\"", esperado, obtido);
        assertEquals(esperado, obtido);
    }

    @Test
    @DisplayName("Multiplicação: 10 * 5 = 50")
    void testeMultiplicacao() {
        double esperado = 50.0;
        double obtido = calculadora.calc(10, 5, "*");
        exibir("Multiplicação", "a=10, b=5, op=\"*\"", esperado, obtido);
        assertEquals(esperado, obtido);
    }

    @Test
    @DisplayName("Divisão: 7 / 2 = 3.5")
    void testeDivisao() {
        double esperado = 3.5;
        double obtido = calculadora.calc(7, 2, "/");
        exibir("Divisão", "a=7, b=2, op=\"/\"", esperado, obtido);
        assertEquals(esperado, obtido);
    }

    @Test
    @DisplayName("Divisão por zero: 10 / 0 lança ArithmeticException")
    void testeDivisaoPorZero() {
        ArithmeticException erro = assertThrows(ArithmeticException.class,
                () -> calculadora.calc(10, 0, "/"));
        exibir("Divisão por zero", "a=10, b=0, op=\"/\"",
                "ArithmeticException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
        assertEquals("Erro: não é possível dividir por zero.", erro.getMessage());
    }

    @Test
    @DisplayName("Operação inválida: \"%\" lança IllegalArgumentException")
    void testeOperacaoInvalida() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, "%"));
        exibir("Operação inválida", "a=10, b=5, op=\"%\"",
                "IllegalArgumentException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
        assertEquals("Erro: operação inválida \"%\". Use +, -, * ou /.", erro.getMessage());
    }

    @Test
    @DisplayName("Operação nula lança IllegalArgumentException")
    void testeOperacaoNula() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, null));
        exibir("Operação nula", "a=10, b=5, op=null",
                "IllegalArgumentException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
    }
}
