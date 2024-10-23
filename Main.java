import java.util.Scanner;

public class Main {

    /**
     * 
     * [ 0, 1, 2]
     * [ 3, 4, 5]
     * [ 6, 7, 8]
     */

    static char[][] tabuleiro = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    static boolean jogoContinua = true;
    static int linha, coluna;
    static char x_or_ball = 'X';
    static int numeroJogadas = 0;

    public static void main(String[] args) {
        while (jogoContinua) {
            exibeTabuleiro();
            leiaCoordenadas();

            // Enquanto jogado não digitar uma coordeanada valida, pede pra ele digitar
            // novamente.
            while (!verificaSeCoordenadasValida(linha, coluna)) {
                System.out.println("Coordenadas inválidas.");
                leiaCoordenadas();
            }

            // atualiza tabuleiro
            tabuleiro[linha][coluna] = x_or_ball;

            //incrementa o número de jogadas
            numeroJogadas++;

            // Guarda a jogada
            char jogadaAnterior = x_or_ball;

            // atualiza de quem é a vez de jogar
            x_or_ball = x_or_ball == 'X' ? 'O' : 'X';

            boolean houveVencedor = verificaSeHouveVencedor(jogadaAnterior);
           
            if(houveVencedor){
                System.out.println("Parabéns " + jogadaAnterior + " ganhou!!!");
                jogoContinua = false;
                exibeTabuleiro();
            }else{
              if(numeroJogadas == 9 ){
                System.out.println("Jogo empatou!!!");
                jogoContinua = false;
                exibeTabuleiro();
              }

            }

        }

    }

    static boolean verificaSeHouveVencedor(char jogada) {
        // verifica horizontal
        if (tabuleiro[0][0] == jogada && tabuleiro[0][1] == jogada && tabuleiro[0][2] == jogada) {
            return true;
        }
        if (tabuleiro[1][0] == jogada && tabuleiro[1][1] == jogada && tabuleiro[1][2] == jogada) {
            return true;
        }
        if (tabuleiro[2][0] == jogada && tabuleiro[2][1] == jogada && tabuleiro[2][2] == jogada) {
            return true;
        }

        // verifica vertical
        if (tabuleiro[0][0] == jogada && tabuleiro[1][0] == jogada && tabuleiro[2][0] == jogada) {
            return true;
        }
        if (tabuleiro[0][1] == jogada && tabuleiro[1][1] == jogada && tabuleiro[2][1] == jogada) {
            return true;
        }
        if (tabuleiro[0][2] == jogada && tabuleiro[1][2] == jogada && tabuleiro[2][2] == jogada) {
            return true;
        }


        //verifica diagonal
        if (tabuleiro[0][0] == jogada && tabuleiro[1][1] == jogada && tabuleiro[2][2] == jogada) {
            return true;
        }
        if (tabuleiro[0][2] == jogada && tabuleiro[1][1] == jogada && tabuleiro[2][0] == jogada) {
            return true;
        }


        return false;
    }

    static boolean verificaSeCoordenadasValida(int linha, int coluna) {
        if ((linha >= 0 && linha <= 2) && (coluna >= 0 && coluna <= 2)) {
            if (tabuleiro[linha][coluna] == ' ') {
                return true;
            }
        }

        return false;
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

    static void leiaCoordenadas() {
        System.out.println("\nDigite a linha e coluna.");
        Scanner scanner = new Scanner(System.in);
        linha = scanner.nextInt();
        coluna = scanner.nextInt();
    }

}