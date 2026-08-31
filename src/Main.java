import java.util.List;

public class Main {

    public static void main(String[] args) {

        testar("10 / 2");
        testar("10 / 3");
        testar("10 / 0");
        testar("(10 + 5");
        testar("10 + 5)");
    }

    private static void testar(String expressao) {

        try {

            List<String> rpn = ConversorRPN.converter(expressao);

            double resultado = AvaliadorRPN.avaliar(rpn);

            System.out.println("Expressão: " + expressao);
            System.out.println("RPN: " + String.join(" ", rpn));
            System.out.println("Resultado: " + resultado);

        } catch (Exception e) {

            System.out.println("Expressão: " + expressao);
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
    }
}