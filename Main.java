import java.util.Random;

public class Main {

    /**
     * 
     * [ 0, 1, 2]
     * [ 3, 4, 5]
     * [ 6, 7, 8]
     * 
     * 
     */

    // Exibir o tabuleiro - OK
    // Ler jogada do usuario
    // validar jogada do usuario(verificar coordenadas e verificar se a casa não
    // está preenchida)
    // atualizar o tabuleiro
    // verificar se houve vencedor ou se houve empate

    static char[][] tabuleiro = {
            { '1', '2', '3' },
            { '4', '5', '6' },
            { '7', '8', '9' }
    };

    public static void main(String[] args) {
    
    }

    static void exibeTabuleiro() {
        for (int i = 0; i < 3; i++) {
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
            }
            System.out.println("]");
        }
    }

}