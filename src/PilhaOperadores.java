public class PilhaOperadores {

    private String[] elementos;
    private int topo;

    public PilhaOperadores(int tamanho) {
        elementos = new String[tamanho];
        topo = -1;
    }

    public void empilhar(String valor) {
        if (topo == elementos.length - 1) {
            throw new RuntimeException("Pilha de operadores cheia.");
        }

        elementos[++topo] = valor;
    }

    public String desempilhar() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha de operadores vazia.");
        }

        return elementos[topo--];
    }

    public String topo() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha de operadores vazia.");
        }

        return elementos[topo];
    }

    public boolean estaVazia() {
        return topo == -1;
    }
}