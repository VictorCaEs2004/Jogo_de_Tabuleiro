import javax.swing.JOptionPane;
public class Historico{
    public Object[] fila, nome, numeroJogada, prioridade;

    public void verHistorico() {
        int indice = 0;
        String historico = "";
        if (indice == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma jogada realizada");
        } else {
            for (int i = 0; i < indice; i++) {
                historico += "Jogador: " + fila[i].nome
                        + "\nNúmero de Jogadas: " + fila[i].numeroJogada
                        + "\nPrioridade: " + fila[i].prioridade + "\nAtendido: " + (i < cont ? "Sim." : "Não.");
                JOptionPane.showMessageDialog(null, historico);
                
            }
        }
    }
}