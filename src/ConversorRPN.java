import java.util.ArrayList;
import java.util.List;

public class ConversorRPN {

    private static int precedencia(String operador) {

        if (operador.equals("+") || operador.equals("-")) {
            return 1;
        }

        if (operador.equals("*") || operador.equals("/")) {
            return 2;
        }

        return 0;
    }

    public static List<String> converter(String expressao) {

        List<String> saida = new ArrayList<>();
        PilhaOperadores operadores = new PilhaOperadores(expressao.length());

        int i = 0;

        while (i < expressao.length()) {

            char caractere = expressao.charAt(i);

            if (Character.isWhitespace(caractere)) {
                i++;
                continue;
            }

            if (Character.isDigit(caractere) || caractere == '.') {

                StringBuilder numero = new StringBuilder();

                while (i < expressao.length()) {

                    char atual = expressao.charAt(i);

                    if (Character.isDigit(atual) || atual == '.') {
                        numero.append(atual);
                        i++;
                    } else {
                        break;
                    }
                }

                saida.add(numero.toString());
                continue;
            }

            if (caractere == '(') {

                operadores.empilhar("(");
                i++;
                continue;
            }

            if (caractere == ')') {

                while (!operadores.estaVazia()
                        && !operadores.topo().equals("(")) {

                    saida.add(operadores.desempilhar());
                }

                if (operadores.estaVazia()) {
                    throw new IllegalArgumentException(
                            "Parênteses desbalanceados."
                    );
                }

                operadores.desempilhar();

                i++;
                continue;
            }

            if (caractere == '+' || caractere == '-'
                    || caractere == '*' || caractere == '/') {

                String operadorAtual = String.valueOf(caractere);

                while (!operadores.estaVazia()
                        && !operadores.topo().equals("(")
                        && precedencia(operadores.topo())
                        >= precedencia(operadorAtual)) {

                    saida.add(operadores.desempilhar());
                }

                operadores.empilhar(operadorAtual);

                i++;
                continue;
            }

            throw new IllegalArgumentException(
                    "Caractere inválido: " + caractere
            );
        }

        while (!operadores.estaVazia()) {

            if (operadores.topo().equals("(")) {
                throw new IllegalArgumentException(
                        "Parênteses desbalanceados."
                );
            }

            saida.add(operadores.desempilhar());
        }

        return saida;
    }
}