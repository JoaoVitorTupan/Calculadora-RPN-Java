public class Pilha {

    private double[] elementos;
    private int topo;

    public Pilha(int tamanho) {
        elementos = new double[tamanho];
        topo = -1;
    }

    public void empilhar(double valor) {
        if (topo == elementos.length - 1) {
            throw new RuntimeException("Pilha cheia.");
        }

        elementos[++topo] = valor;
    }

    public double desempilhar() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia.");
        }

        return elementos[topo--];
    }

    public double topo() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia.");
        }

        return elementos[topo];
    }

    public boolean estaVazia() {
        return topo == -1;
    }
}