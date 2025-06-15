import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Janela extends JFrame{

    private Controle controle;

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public JPanel painelPrincipal, painelDeBaixo;
    public JLabel labelDoPainelPrincipal;
    public JButton botaoIniciarJogo, botaoRespostaA, botaoRespostaB, botaoRespostaC, botaoRespostaD, botaoRespostaE, botaoRespostaF, botaoRespostaG;
    //public String textoPrincipal;
    public String textoInstrucoes = "Os jogadores percorrem um tabuleiro de 15 casas. O movimento e turno"
                                    + "\ndos jogadores é decidido por dado. Ao parar em uma casa par, devem"
                                    + "\ncomprar uma carta e respondê-la (a resposta é a pergunta). Dependendo da resposta, sofrerão uma"
                                    + "\nrecompensa ou penalidade. Vence quem chegar na última casa primeiro.";

    public Janela(){
        this.setSize(1600,900); //define o tamanho da janela
        this.setTitle("A3 Pseudo-Tabuleiro"); //define o título da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //faz com que o programa pare quando a janela é fechada (EXIT termina todas as janelas, DISPOSE termina só a que foi fechada)
        this.setResizable(false); //proíbe o usuário de redimensionar a janela
        this.getContentPane().setBackground(Color.lightGray);
        this.setLayout(null);

        //this.textoPrincipal = stringToHtml(textoInstrucoes);

        preparaPainelPrincipal();
        configurarBotoes();


        this.setVisible(true);
    }

    public void preparaPainelPrincipal(){
        //JPanel: componente que funciona como container, possuindo outros componentes
        painelPrincipal = new JPanel();
        painelPrincipal.setBounds(0, 0, 1600, 400);
        painelPrincipal.setOpaque(false);

        labelDoPainelPrincipal = new JLabel();
        atualizarTextoPrincipal(textoInstrucoes);
        labelDoPainelPrincipal.setForeground(Color.BLACK);

        painelPrincipal.add(labelDoPainelPrincipal);
        add(painelPrincipal);
    }

    public void configurarBotoes(){
        painelDeBaixo = new JPanel();
        painelDeBaixo.setBounds(0, 433, 1600, 468);
        painelDeBaixo.setOpaque(false);

        botaoIniciarJogo = new JButton();
        botaoIniciarJogo.setText("Iniciar partida");
        botaoIniciarJogo.setFocusable(false);
        botaoIniciarJogo.addActionListener(e -> {
            botaoIniciarJogo.setVisible(false);
            controle.Controlar();
        });

        botaoRespostaA = new JButton();
        botaoRespostaA.setText("A");
        botaoRespostaA.setFocusable(false);
        botaoRespostaA.addActionListener(e -> {
            responderPergunta("A");
        });
        botaoRespostaA.setVisible(false);

        botaoRespostaB = new JButton();
        botaoRespostaB.setText("B");
        botaoRespostaB.setFocusable(false);
        botaoRespostaB.addActionListener(e -> {
            responderPergunta("B");
        });
        botaoRespostaB.setVisible(false);

        botaoRespostaC = new JButton();
        botaoRespostaC.setText("C");
        botaoRespostaC.setFocusable(false);
        botaoRespostaC.addActionListener(e -> {
            responderPergunta("C");
        });
        botaoRespostaC.setVisible(false);

        botaoRespostaD = new JButton();
        botaoRespostaD.setText("D");
        botaoRespostaD.setFocusable(false);
        botaoRespostaD.addActionListener(e -> {
            responderPergunta("D");
        });
        botaoRespostaD.setVisible(false);

        botaoRespostaE = new JButton();
        botaoRespostaE.setText("E");
        botaoRespostaE.setFocusable(false);
        botaoRespostaE.addActionListener(e -> {
            responderPergunta("E");
        });
        botaoRespostaE.setVisible(false);

        botaoRespostaF = new JButton();
        botaoRespostaF.setText("F");
        botaoRespostaF.setFocusable(false);
        botaoRespostaF.addActionListener(e -> {
            responderPergunta("F");
        });
        botaoRespostaF.setVisible(false);

        botaoRespostaG = new JButton();
        botaoRespostaG.setText("G");
        botaoRespostaG.setFocusable(false);
        botaoRespostaG.addActionListener(e -> {
            responderPergunta("G");
        });
        botaoRespostaG.setVisible(false);

        painelDeBaixo.add(botaoIniciarJogo);
        painelDeBaixo.add(botaoRespostaA);
        painelDeBaixo.add(botaoRespostaB);
        painelDeBaixo.add(botaoRespostaC);
        painelDeBaixo.add(botaoRespostaD);
        painelDeBaixo.add(botaoRespostaE);
        painelDeBaixo.add(botaoRespostaE);
        painelDeBaixo.add(botaoRespostaF);
        add(painelDeBaixo);
    }

    public void responderPergunta(String resposta){
        controle.posicaoJogador = controle.parte2TurnoJogador(resposta);
        desligarBotoesResposta();
    }

    public void ligarBotoesResposta(){
        botaoRespostaA.setVisible(true);
        botaoRespostaB.setVisible(true);
        botaoRespostaC.setVisible(true);
        botaoRespostaD.setVisible(true);
        botaoRespostaE.setVisible(true);
        botaoRespostaF.setVisible(true);
        botaoRespostaG.setVisible(true);
    }
    public void desligarBotoesResposta(){
        botaoRespostaA.setVisible(false);
        botaoRespostaB.setVisible(false);
        botaoRespostaC.setVisible(false);
        botaoRespostaD.setVisible(false);
        botaoRespostaE.setVisible(false);
        botaoRespostaF.setVisible(false);
        botaoRespostaG.setVisible(false);
    }

    public void atualizarTextoPrincipal(String novoTexto){
        labelDoPainelPrincipal.setText(stringToHtml(novoTexto));
    }

    public String stringToHtml(String stringASerConvertida){
        String nHtml = "<html>" + stringASerConvertida.replaceAll("<","&lt;").replaceAll(">", "&gt;")
                                                        .replaceAll("\n", "<br>") + "</html>";
        return nHtml;
    }
}