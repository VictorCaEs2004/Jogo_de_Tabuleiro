import java.util.Random;
import java.util.Scanner;

public class Controle {

    //PAREI NO controleTurnos e turno
    private Janela janela;
    public ListaDuplamenteEncadeada tabuleiro;
    public EstrPilha pilhaCartas;
    public Node posicaoJogador, posicaoMaquina;
    public String textoJogo = "";

    public Controle(Janela entradaJanela){
        this.janela = entradaJanela;
        janela.setControle(this);
    }
    
    public void Controlar(){
        tabuleiro = new ListaDuplamenteEncadeada();
        for (int i = 1; i <= 15; i++) {
            tabuleiro.inserirUltimo(i);
        }

        pilhaCartas = new EstrPilha();
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

        /* --------------------------------------------------------------------- */
        Scanner scan = new Scanner(System.in);
        posicaoJogador = tabuleiro.primeiro;
        posicaoMaquina = tabuleiro.primeiro;

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
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
        
    }

    public void controleTurnos(){
        textoJogo = "";
        textoJogo = textoJogo + "Decidindo turnos.\nDado da máquina: 4";
        int dadoJogador = lancarDado();
        textoJogo = textoJogo + "\nDado do jogador: " + dadoJogador;
        boolean turnoJogador = dadoJogador > 4;
        while (posicaoJogador.info != 15 || posicaoMaquina.info != 15) {
            if (turnoJogador) {
                textoJogo = textoJogo + "\nTurno do jogador.";
                //PAREI AQUI
                posicaoJogador = turno(tabuleiro, pilhaCartas, posicaoJogador);
                turnoJogador = false;
                if (posicaoJogador.info == 15) {
                    textoJogo = textoJogo + "\nJogador venceu.";
                    break;
                } else if (posicaoMaquina.info == 15) {
                    textoJogo = textoJogo + "\nMáquina venceu.";
                    break;
                }
            } else {
                textoJogo = textoJogo + "\nMáquina jogará.";
                posicaoMaquina = turnoMaquina(tabuleiro, pilhaCartas, posicaoMaquina);
                turnoJogador = true;
            }
        }
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
