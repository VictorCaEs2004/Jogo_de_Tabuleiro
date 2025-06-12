public class Jogador {
    public String nome;
    public String numeroJogadores;
    public boolean prioridade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroJogadores() {
        return numeroJogadores;
    }

    public void setNumeroJogadores(String numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }
}