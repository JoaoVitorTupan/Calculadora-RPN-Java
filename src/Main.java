import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] expressoes = {
                "3 + 5 * 2",
                "(10 + 5) * 2",
                "10.5 + 2.5",
                "(5.5 + 2.5) * 3",
                "10 + (5 * 2.5) - 4"
        };

        for (String expressao : expressoes) {

            List<String> rpn = ConversorRPN.converter(expressao);

            System.out.println("Expressão: " + expressao);
            System.out.println("RPN: " + String.join(" ", rpn));
            System.out.println();
        }
    }
}