public class Carta {
    private String pergunta, resposta;
    private int efeito;

    public Carta(String pergunta, String resposta, int efeito) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.efeito = efeito;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public int getEfeito() {
        return efeito;
    }
}
