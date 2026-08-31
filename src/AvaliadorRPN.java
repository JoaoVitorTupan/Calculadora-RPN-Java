import java.util.List;

public class AvaliadorRPN {

    public static double avaliar(List<String> expressaoRPN) {

        Pilha pilha = new Pilha(expressaoRPN.size());

        for (String elemento : expressaoRPN) {

            if (ehNumero(elemento)) {

                double numero = Double.parseDouble(elemento);
                pilha.empilhar(numero);

            } else {

                double segundo = pilha.desempilhar();
                double primeiro = pilha.desempilhar();

                double resultado = calcular(
                        primeiro,
                        segundo,
                        elemento
                );

                pilha.empilhar(resultado);
            }
        }

        return pilha.desempilhar();
    }

    private static boolean ehNumero(String elemento) {

        try {
            Double.parseDouble(elemento);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double calcular(
            double primeiro,
            double segundo,
            String operador) {

        switch (operador) {

            case "+":
                return primeiro + segundo;

            case "-":
                return primeiro - segundo;

            case "*":
                return primeiro * segundo;

            case "/":
                if (segundo == 0) {
                    throw new ArithmeticException(
                            "Divisão por zero."
                    );
                }

                return primeiro / segundo;

            default:
                throw new IllegalArgumentException(
                        "Operador inválido: " + operador
                );
        }
    }
}