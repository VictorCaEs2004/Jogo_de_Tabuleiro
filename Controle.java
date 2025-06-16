import java.util.Random;

public class Controle {

    private Janela janela;
    public ListaDuplamenteEncadeada tabuleiro;
    public EstrPilha pilhaCartas;
    public Node posicaoJogador, posicaoMaquina, retornoNode, tempNode;
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
                new Carta("\n2¹⁰ + 818?", "1842", 1),
                new Carta("\nQual o ano da primeira comunicação por cabos de telégrafo transatlânticos bem-sucedida?", "1858", 1),
                new Carta("\nQual o número atômico do Livermório?", "116", 1),
                new Carta("\nContando de Help! (1965) a Let It Be (1970), quantos álbums a banda The Beatles lançou no Reino Unido?", "8", 1),
                new Carta("\nQual a capital da Noruega?", "Oslo", 1),
                new Carta("\nPara qual instituição de ensino este trabalho foi (discutivelmente) feito?", "UniSul", 1),
                new Carta("\nTodos são __________.", "bem-vindos", 1),
        };

        for (Carta carta : cartas) {
            pilhaCartas.push(new ElementoPilha(carta));
        }

        stringBuilder = new StringBuilder();

        posicaoJogador = tabuleiro.primeiro;
        posicaoMaquina = tabuleiro.primeiro;

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

    public void continuaAposJogador(){
        while(rodando && (posicaoJogador.info != 15 || posicaoMaquina.info != 15)){
            controleTurnos();
        }
    }

    public void controleTurnos(){
        if (posicaoJogador.info == 15) {
            stringBuilder.append("\nJogador venceu.");
            updateTextoJanela();
            rodando = false;
            return;
        } else if (posicaoMaquina.info == 15) {
            stringBuilder.append("\nMáquina venceu.");
            updateTextoJanela();
            rodando = false;
            return;
        }

        if(turnoJogador){
            if(parte1Turno){
                stringBuilder.append("\nTurno do jogador.");
                parte1Turno = false;
                parte2Turno = true;
                parte1TurnoJogador(tabuleiro, pilhaCartas, posicaoJogador);
            }else if(parte2Turno){
                if (tempNode.info % 2 == 0) {
                    rodando = false;
                }else{
                    posicaoJogador = tempNode;
                    updateTextoJanela();
                }
                turnoJogador = false;
                parte2Turno = false;
            }
        }else{
            stringBuilder.append("\nMáquina jogará.");
            posicaoMaquina = turnoMaquina(tabuleiro, pilhaCartas, posicaoMaquina);
            turnoJogador = true;
            parte1Turno = true;
            parte2Turno = false;
        }
    }


    public void parte1TurnoJogador(ListaDuplamenteEncadeada tabuleiro, EstrPilha pilhaCartas, Node nodeAtual){
        resultadoDadoJogador = lancarDado();
        stringBuilder.append("\nDado do jogador: " + resultadoDadoJogador);
        if ((nodeAtual.info + resultadoDadoJogador) > 15) {
            stringBuilder.append("\nMoveu " + resultadoDadoJogador + " casa(s) para frente, parando na 15.");
            retornoNode = tabuleiro.ultimo;
            updateTextoJanela();
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
                updateTextoJanela();
            } else {
                stringBuilder.append("\nErrou a pergunta.");
                stringBuilder.append("\nResposta era " + cartaComprada.getResposta());
                tabuleiro.retroceder(tempNode.info, cartaComprada.getEfeito());
                retornoNode = tempNode;
                updateTextoJanela();
            }
        }
        parte2Turno = false;
        turnoJogador = false;
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
