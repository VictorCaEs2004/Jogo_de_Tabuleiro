import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        ListaDuplamenteEncadeada tabuleiro = new ListaDuplamenteEncadeada();
        for (int i = 1; i <= 10; i++) {
            tabuleiro.inserirUltimo(i);
        }

        int dado = lancarDado();
        tabuleiro.avancar(1, dado);
        tabuleiro.retroceder(tabuleiro.atual.info, dado);
    }

    static int lancarDado() {
        Random r = new Random();
        return 1 + r.nextInt(6);
    }
    
}