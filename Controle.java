import java.util.Random;
import java.util.Scanner;

public class Controle {

    //PAREI NO controleTurnos e turno
    private Janela janela;
    public ListaDuplamenteEncadeada tabuleiro;
    public EstrPilha pilhaCartas;
    public Node posicaoJogador, posicaoMaquina, retornoNode, tempNode;
    //public String textoJogo = ""; substituido pelo string builder
    public StringBuilder stringBuilder;
    public boolean jogoAcabou = false, turnoJogador, parte1Turno = false, parte2Turno = false, rodando = true;
    public Carta cartaComprada;
    public int resultadoDadoJogador;

    public Controle(Janela entradaJanela){
        this.janela = entradaJanela;
        janela.setControle(this);
    }

    public void updateTextoJanela(){
        janela.atualizarTextoPrincipal(stringBuilder.toString());
    }
    
    public void Controlar(){
        tabuleiro = new ListaDuplamenteEncadeada(this);
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

        stringBuilder = new StringBuilder();

        /* --------------------------------------------------------------------- */
        //Scanner scan = new Scanner(System.in);
        posicaoJogador = tabuleiro.primeiro;
        posicaoMaquina = tabuleiro.primeiro;

        /*
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
        }*/

        primeiroTurno();
        while(rodando && (posicaoJogador.info != 15 || posicaoMaquina.info != 15)){
            controleTurnos();
        }
        
    }

    public void primeiroTurno(){
        stringBuilder.append("Decidindo turnos.\nDado da máquina: 4");
        int dadoJogador = lancarDado();
        stringBuilder.append("\nDado do jogador: " + dadoJogador);
        turnoJogador = dadoJogador > 4;
        parte1Turno = true;
        updateTextoJanela();
    }

    public void controleTurnos(){
            /* 
            switch(parteTurno){
            case 1:
                stringBuilder.append("\nTurno do jogador.");
                parte1TurnoJogador(tabuleiro, pilhaCartas, posicaoJogador);
                break;
            }*/

        if(turnoJogador){
            if(parte1Turno){
                stringBuilder.append("\nTurno do jogador.");
                parte1Turno = false;
                parte2Turno = true;
                parte1TurnoJogador(tabuleiro, pilhaCartas, posicaoJogador);
            }else if(parte2Turno){
                if (tempNode.info % 2 == 0) {
                    rodando = false;
                    return;
                }else{
                    posicaoJogador = tempNode;
                    updateTextoJanela();
                    rodando = true;
                }
                turnoJogador = false;
                if (posicaoJogador.info == 15) {
                    stringBuilder.append("\nJogador venceu.");
                } else if (posicaoMaquina.info == 15) {
                    stringBuilder.append("\nMáquina venceu.");
                }
                parte2Turno = false;
            }
        }else{
            stringBuilder.append("\nMáquina jogará.");
            posicaoMaquina = turnoMaquina(tabuleiro, pilhaCartas, posicaoMaquina);
            turnoJogador = true;
            parte1Turno = true;
            parte2Turno = false;
        }
        
        
        
        //while (posicaoJogador.info != 15 || posicaoMaquina.info != 15) {
        /*
        if (turnoJogador) {
            stringBuilder.append("\nTurno do jogador.");
            posicaoJogador = turno(tabuleiro, pilhaCartas, posicaoJogador);
            turnoJogador = false;
            if (posicaoJogador.info == 15) {
                stringBuilder.append("\nJogador venceu.");
                break;
            } else if (posicaoMaquina.info == 15) {
                stringBuilder.append("\nMáquina venceu.");
                break;
            }
        } else {
            stringBuilder.append("\nMáquina jogará.");
            posicaoMaquina = turnoMaquina(tabuleiro, pilhaCartas, posicaoMaquina);
            turnoJogador = true;
        }*/
        //}
    }

    /*
    private Node turno(/*Scanner scan*/ /*int parteTurnoInterior, String respostaJogador, ListaDuplamenteEncadeada tabuleiro, EstrPilha pilhaCartas, Node nodeAtual) {
        //int dado = lancarDado();
        //System.out.println("Dado do jogador: " + dado);
        /* 
        if ((nodeAtual.info + dado) > 15) {
            System.out.println("Moveu " + dado + " casa(s) para frente, parando na 15.");
            return tabuleiro.ultimo;
        }
        */
        //tabuleiro.avancar(nodeAtual.info, dado);
        //nodeAtual = tabuleiro.atual;
        /*
        if (nodeAtual.info % 2 == 0) {
            System.out.println("Jogador parou em uma casa par.");
            Carta carta = pilhaCartas.pop().getItem();
            System.out.println("Pergunta: " + carta.getPergunta());
            //String respostaJogador = scan.nextLine();
            if (respostaJogador.equalsIgnoreCase(carta.getResposta())) {
                System.out.println("Acertou a pergunta.");
                tabuleiro.avancar(nodeAtual.info, carta.getEfeito());
            } else {
                System.out.println("Errou a pergunta.");
                System.out.println("Resposta era " + carta.getResposta());
                tabuleiro.retroceder(nodeAtual.info, carta.getEfeito());
            }
        }*/
        //return nodeAtual;

        //--------------------------------------------------------------------------------------
        /*
        switch(parteTurnoInterior){
            case 1:
                int dado = lancarDado();
                stringBuilder.append("\nDado do jogador: " + dado);
                if ((nodeAtual.info + dado) > 15) {
                    stringBuilder.append("\nMoveu " + dado + " casa(s) para frente, parando na 15.");
                    return tabuleiro.ultimo;
                }
                tabuleiro.avancar(nodeAtual.info, dado);
                nodeAtual = tabuleiro.atual;
                if (nodeAtual.info % 2 == 0) {
                    stringBuilder.append("\nJogador parou em uma casa par.");
                    cartaComprada = pilhaCartas.pop().getItem();
                    stringBuilder.append("\nPergunta: " + cartaComprada.getPergunta());
                }
                return nodeAtual;
            case 2:
                if (respostaJogador.equalsIgnoreCase(cartaComprada.getResposta())) {
                    System.out.println("Acertou a pergunta.");
                    tabuleiro.avancar(nodeAtual.info, cartaComprada.getEfeito());
                } else {
                    System.out.println("Errou a pergunta.");
                    System.out.println("Resposta era " + cartaComprada.getResposta());
                    tabuleiro.retroceder(nodeAtual.info, cartaComprada.getEfeito());
                }
                return nodeAtual;
        }
        
    }*/

    public void parte1TurnoJogador(ListaDuplamenteEncadeada tabuleiro, EstrPilha pilhaCartas, Node nodeAtual){
        resultadoDadoJogador = lancarDado();
        stringBuilder.append("\nDado do jogador: " + resultadoDadoJogador);
        if ((nodeAtual.info + resultadoDadoJogador) > 15) {
            stringBuilder.append("\nMoveu " + resultadoDadoJogador + " casa(s) para frente, parando na 15.");
            retornoNode = tabuleiro.ultimo;
            updateTextoJanela();
            //parar jogo
            return;
        }
        tabuleiro.avancar(nodeAtual.info, resultadoDadoJogador);
        nodeAtual = tabuleiro.atual;
        tempNode = nodeAtual;
        if (nodeAtual.info % 2 == 0) {
            stringBuilder.append("\nJogador parou em uma casa par.");
            cartaComprada = pilhaCartas.pop().getItem();
            stringBuilder.append("\nPergunta: " + cartaComprada.getPergunta());
            updateTextoJanela();
            janela.ligarBotoesResposta();
        }
    }

    public Node parte2TurnoJogador(String respostaJogador){
        retornoNode = tempNode;
        if(tempNode.info % 2 == 0){
            if (respostaJogador.equalsIgnoreCase(cartaComprada.getResposta())) {
                stringBuilder.append("\nAcertou a pergunta.");
                tabuleiro.avancar(tempNode.info, cartaComprada.getEfeito());
                retornoNode = tempNode;
            } else {
                stringBuilder.append("\nErrou a pergunta.");
                stringBuilder.append("\nResposta era " + cartaComprada.getResposta());
                tabuleiro.retroceder(tempNode.info, cartaComprada.getEfeito());
                retornoNode = tempNode;
                updateTextoJanela();
            }
            
            parte2Turno = false;
            turnoJogador = false;
        }
        
        rodando = true;
        return retornoNode;
    }

    public Node turnoMaquina(ListaDuplamenteEncadeada tabuleiro, EstrPilha pilhaCartas, Node nodeAtual) {
        int dado = lancarDado();
        stringBuilder.append("\nDado da máquina: " + dado);
        if ((nodeAtual.info + dado) > 15) {
            stringBuilder.append("\nMáquina moveu " + dado + " casa(s) para frente, parando na 15.");
            updateTextoJanela();
            return tabuleiro.ultimo;
        }
        tabuleiro.avancar(nodeAtual.info, dado);
        nodeAtual = tabuleiro.atual;
        if (nodeAtual.info % 2 == 0) {
            stringBuilder.append("\nMáquina parou em uma casa par.");
            Carta carta = pilhaCartas.pop().getItem();
            stringBuilder.append("\nPergunta: " + carta.getPergunta());
            stringBuilder.append("\nMáquina respondeu " + carta.getResposta());
            stringBuilder.append("\nAcertou a pergunta.");
            tabuleiro.avancar(nodeAtual.info, carta.getEfeito());
            updateTextoJanela();
        }
        updateTextoJanela();
        return nodeAtual;
    }

    static int lancarDado() {
        Random r = new Random();
        return 1 + r.nextInt(6);
    }
}
