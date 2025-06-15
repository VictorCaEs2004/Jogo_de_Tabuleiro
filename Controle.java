import java.util.Random;
import java.util.Scanner;

public class Controle {

    private Janela janela;

    public Controle(Janela entradaJanela){
        this.janela = entradaJanela;
        janela.setControle(this);
    }
    

    static Node turno(Scanner scan, ListaDuplamenteEncadeada tabuleiro, EstrPilha pilhaCartas, Node nodeAtual) {
        int dado = lancarDado();
        System.out.println("Dado do jogador: " + dado);
        if ((nodeAtual.info + dado) > 15) {
            System.out.println("Moveu " + dado + " casa(s) para frente, parando na 15.");
            return tabuleiro.ultimo;
        }
        tabuleiro.avancar(nodeAtual.info, dado);
        nodeAtual = tabuleiro.atual;
        if (nodeAtual.info % 2 == 0) {
            System.out.println("Jogador parou em uma casa par.");
            Carta carta = pilhaCartas.pop().getItem();
            System.out.println("Pergunta: " + carta.getPergunta());
            String respostaJogador = scan.nextLine();
            if (respostaJogador.equalsIgnoreCase(carta.getResposta())) {
                System.out.println("Acertou a pergunta.");
                tabuleiro.avancar(nodeAtual.info, carta.getEfeito());
            } else {
                System.out.println("Errou a pergunta.");
                System.out.println("Resposta era " + carta.getResposta());
                tabuleiro.retroceder(nodeAtual.info, carta.getEfeito());
            }
        }
        return nodeAtual;
    }

    static Node turnoMaquina(ListaDuplamenteEncadeada tabuleiro, EstrPilha pilhaCartas, Node nodeAtual) {
        int dado = lancarDado();
        System.out.println("Dado da máquina: " + dado);
        if ((nodeAtual.info + dado) > 15) {
            System.out.println("Máquina moveu " + dado + " casa(s) para frente, parando na 15.");
            return tabuleiro.ultimo;
        }
        tabuleiro.avancar(nodeAtual.info, dado);
        nodeAtual = tabuleiro.atual;
        if (nodeAtual.info % 2 == 0) {
            System.out.println("Máquina parou em uma casa par.");
            Carta carta = pilhaCartas.pop().getItem();
            System.out.println("Pergunta: " + carta.getPergunta());
            System.out.println("Máquina respondeu " + carta.getResposta());
            System.out.println("Acertou a pergunta.");
            tabuleiro.avancar(nodeAtual.info, carta.getEfeito());
        }
        return nodeAtual;
    }

    static int lancarDado() {
        Random r = new Random();
        return 1 + r.nextInt(6);
    }
}
