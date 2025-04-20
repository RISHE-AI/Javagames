import java.util.Scanner;

public class TicTacToe {

    private static char[] board = new char[9];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        boolean gameOver = false;

        System.out.println("Welcome to Tic-Tac-Toe Game!");
        printBoard();

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Player " + currentPlayer + ", Enter your move (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                board[move - 1] = currentPlayer; // Update the board
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch players
                }
            } else {
                System.out.println("Invalid move! Give another number.");
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
    }

    private static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i] + " | " + board[i + 1] + " | " + board[i + 2]);
        }
    }

    private static boolean isValidMove(int move) {
        return move >= 1 && move <= 9 && board[move - 1] == '-';
    }

    private static boolean checkWin() {
        switch (currentPlayer) {
            case 'X':
            case 'O':
                // Rows
                if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer)
                    return true;
                if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer)
                    return true;
                if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer)
                    return true;
                // Columns
                if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer)
                    return true;
                if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer)
                    return true;
                if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer)
                    return true;
                // Diagonals
                if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer)
                    return true;
                if (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer)
                    return true;
                break;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == '-') {
                return false;
            }
        }
        return true;
    }
}
