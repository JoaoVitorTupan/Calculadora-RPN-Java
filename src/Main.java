import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       CALCULADORA INFIXA PARA RPN");
        System.out.println("========================================");
        System.out.println("Digite uma expressão matemática.");
        System.out.println("Digite 'sair' para encerrar.");
        System.out.println();

        while (true) {

            System.out.print("Digite uma expressão: ");
            String expressao = scanner.nextLine();

            if (expressao.equalsIgnoreCase("sair")) {
                break;
            }

            if (expressao.trim().isEmpty()) {
                System.out.println("Erro: a expressão não pode estar vazia.");
                System.out.println();
                continue;
            }

            try {

                List<String> rpn = ConversorRPN.converter(expressao);

                double resultado = AvaliadorRPN.avaliar(rpn);

                System.out.println();
                System.out.println("Expressão original: " + expressao);
                System.out.println(
                        "Expressão RPN:      " + String.join(" ", rpn)
                );
                System.out.println("Resultado:          " + resultado);
                System.out.println();

            } catch (Exception e) {

                System.out.println();
                System.out.println("Erro: " + e.getMessage());
                System.out.println();
            }
        }

        scanner.close();

        System.out.println();
        System.out.println("Programa encerrado.");
    }
}