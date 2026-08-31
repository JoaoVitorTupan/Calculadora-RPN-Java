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

        boolean esperaOperando = true;

        while (i < expressao.length()) {

            char caractere = expressao.charAt(i);

            if (Character.isWhitespace(caractere)) {
                i++;
                continue;
            }

            if (Character.isDigit(caractere) || caractere == '.') {

                if (!esperaOperando) {
                    throw new IllegalArgumentException(
                            "Operadores ausentes entre os valores."
                    );
                }

                StringBuilder numero = new StringBuilder();
                boolean possuiPontoDecimal = false;

                while (i < expressao.length()) {

                    char atual = expressao.charAt(i);

                    if (Character.isDigit(atual)) {

                        numero.append(atual);
                        i++;

                    } else if (atual == '.') {

                        if (possuiPontoDecimal) {
                            throw new IllegalArgumentException(
                                    "Número decimal inválido."
                            );
                        }

                        possuiPontoDecimal = true;
                        numero.append(atual);
                        i++;

                    } else {
                        break;
                    }
                }

                if (numero.toString().equals(".")) {
                    throw new IllegalArgumentException(
                            "Número decimal inválido."
                    );
                }

                saida.add(numero.toString());
                esperaOperando = false;
                continue;
            }

            if (caractere == '(') {

                if (!esperaOperando) {
                    throw new IllegalArgumentException(
                            "Operador ausente antes do parêntese."
                    );
                }

                operadores.empilhar("(");
                i++;
                esperaOperando = true;
                continue;
            }

            if (caractere == ')') {

                if (esperaOperando) {
                    throw new IllegalArgumentException(
                            "Parêntese fechado em posição inválida."
                    );
                }

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
                esperaOperando = false;
                continue;
            }

            if (caractere == '+' || caractere == '-'
                    || caractere == '*' || caractere == '/') {

                if (esperaOperando) {
                    throw new IllegalArgumentException(
                            "Operador em posição inválida."
                    );
                }

                String operadorAtual = String.valueOf(caractere);

                while (!operadores.estaVazia()
                        && !operadores.topo().equals("(")
                        && precedencia(operadores.topo())
                        >= precedencia(operadorAtual)) {

                    saida.add(operadores.desempilhar());
                }

                operadores.empilhar(operadorAtual);

                i++;
                esperaOperando = true;
                continue;
            }

            throw new IllegalArgumentException(
                    "Caractere inválido: " + caractere
            );
        }

        if (esperaOperando) {
            throw new IllegalArgumentException(
                    "Expressão incompleta."
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