package regra;

import java.util.Scanner;

public class JogoDaVelha {
    private static char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static int vitoriasJogador1 = 0;
    private static int vitoriasJogador2 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            jogarJogoDaVelha(scanner);
            exibirTabuleiro();

            System.out.println("Deseja jogar novamente? (S/N)");
        } while (scanner.next().equalsIgnoreCase("S"));

        System.out.println("Total de vitórias do Jogador 1: " + vitoriasJogador1);
        System.out.println("Total de vitórias do Jogador 2: " + vitoriasJogador2);

        scanner.close();
    }

    private static void jogarJogoDaVelha(Scanner scanner) {
        char jogadorAtual = 'X';

        do {
            exibirTabuleiro();
            realizarJogada(jogadorAtual, scanner);

            if (verificarVitoria(jogadorAtual)) {
                exibirTabuleiro();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                atualizarContagemVitorias(jogadorAtual);
                return;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        } while (verificarEspacosDisponiveis());

        exibirTabuleiro();
        System.out.println("O jogo empatou!");
    }

    private static void exibirTabuleiro() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void realizarJogada(char jogador, Scanner scanner) {
        int linha, coluna;

        do {
            System.out.println("Jogador " + jogador + ", informe a posição (1-9): ");
            int posicao = scanner.nextInt();

            linha = (posicao - 1) / 3;
            coluna = (posicao - 1) % 3;

        } while (!verificarPosicaoValida(linha, coluna));

        tabuleiro[linha][coluna] = jogador;
    }

    private static boolean verificarPosicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ';
    }

    private static boolean verificarEspacosDisponiveis() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean verificarVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }

        return (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
               (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador);
    }

    private static void atualizarContagemVitorias(char jogador) {
        if (jogador == 'X') {
            vitoriasJogador1++;
        } else {
            vitoriasJogador2++;
        }
    }
}
