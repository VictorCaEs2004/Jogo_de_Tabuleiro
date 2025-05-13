import java.security.SecureRandom;
public class Tabuleiro {

// cria um gerador seguro de números aleatórios para uso no método lancarDado
    private static final SecureRandom randomNumbers = new SecureRandom();

    // joga uma partida de dados
    public static void main(String[] args) {
        
        int dado1 = lancarDado(); 
        int numero6 = 6;
        
        String resultado;
        Integer.valueOf(resultado = dado1 == numero6 ? "Ganhou. Ande "+ (dado1) + " passos.": "Perdeu");
        System.out.printf("Resultado(%d): %s", dado1, resultado);
    }

    // lança os dados, calcula 
    public static int lancarDado() {
        return 1 + randomNumbers.nextInt(6);

}
}