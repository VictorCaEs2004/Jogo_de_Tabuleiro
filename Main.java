import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Janela janela = new Janela();

        Controle controle = new Controle(janela);

        //aqui: criar Controle

        /*
        ListaDuplamenteEncadeada tabuleiro = new ListaDuplamenteEncadeada();
        for (int i = 1; i <= 15; i++) {
            tabuleiro.inserirUltimo(i);
        }

        EstrPilha pilhaCartas = new EstrPilha();
        Carta[] cartas = {
                new Carta("A", "A", 1),
                new Carta("B", "B", 1),
                new Carta("C", "C", 1),
                new Carta("D", "D", 1),
                new Carta("E", "E", 1),
                new Carta("F", "F", 1),
                new Carta("G", "G", 1),
        };

        for (Carta carta : cartas) {
            pilhaCartas.push(new ElementoPilha(carta));
        }

        Scanner scan = new Scanner(System.in);
        Node posicaoJogador = tabuleiro.primeiro;
        Node posicaoMaquina = tabuleiro.primeiro;

        while (true) {
            System.out.println("1. Jogar partida \n2. Explicar regras \n3. Sair");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1:
                    System.out.println("Decidindo turnos.");
                    System.out.println("Dado da máquina: 4");
                    int dadoJogador = lancarDado();
                    System.out.println("Dado do jogador: " + dadoJogador);
                    boolean turnoJogador = dadoJogador > 4;
                        while (posicaoJogador.info != 15 || posicaoMaquina.info != 15) {
                            if (turnoJogador) {
                                System.out.println("Turno do jogador.");
                                posicaoJogador = turno(scan, tabuleiro, pilhaCartas, posicaoJogador);
                                turnoJogador = false;
                                if (posicaoJogador.info == 15) {
                                    System.out.println("Jogador venceu.");
                                    break;
                                } else if (posicaoMaquina.info == 15) {
                                    System.out.println("Máquina venceu.");
                                    break;
                                }
                            } else {
                                System.out.println("Máquina jogará.");
                                posicaoMaquina = turnoMaquina(tabuleiro, pilhaCartas, posicaoMaquina);
                                turnoJogador = true;
                            }
                        }
                    break;
                case 2:
                    System.out.println("Os jogadores percorrem um tabuleiro de 15 casas. O movimento e turno"
                            + "\ndos jogadores é decidido por dado. Ao parar em uma casa par, devem"
                            + "\ncomprar uma carta e respondê-la. Dependendo da resposta, sofrerão uma"
                            + "\nrecompensa ou penalidade. Vence quem chegar na última casa primeiro.");
                    break;
                case 3:
                    System.out.println("Fechando jogo.");
                    scan.close();
                    return;
                default:
                    System.out.println("Digite um número de 1-3.");
                    break;
            }
        }
        */
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