import java.util.Scanner;

public class TicTacGame {

    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final String CREATOR_MESSAGE = "\nCreated by Shreyas Saha. Thanks for playing!";

    public void startGame() {
        char[] board = initializeBoard();
        Scanner scanner = new Scanner(System.in);
        boolean gameActive = true;

        while (gameActive) {
            displayBoard(board);
            playerMove(scanner, board);
            if (checkWin(board, PLAYER_X)) {
                System.out.println("You won the game!" + CREATOR_MESSAGE);
                break;
            }
            if (isBoardFull(board)) {
                System.out.println("It's a draw!" + CREATOR_MESSAGE);
                break;
            }
            computerMove(board);
            if (checkWin(board, PLAYER_O)) {
                System.out.println("You lost the game!" + CREATOR_MESSAGE);
                break;
            }
            if (isBoardFull(board)) {
                System.out.println("It's a draw!" + CREATOR_MESSAGE);
                break;
            }
        }
        scanner.close();
    }

    private static char[] initializeBoard() {
        return new char[] { EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY };
    }

    private static void displayBoard(char[] board) {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private static void playerMove(Scanner scanner, char[] board) {
        while (true) {
            System.out.print("Enter box number (1-9): ");
            byte input = scanner.nextByte();
            if (input >= 1 && input <= 9 && board[input - 1] == EMPTY) {
                board[input - 1] = PLAYER_X;
                break;
            }
            System.out.println("Invalid input or box already in use. Please try again.");
        }
    }

    private static void computerMove(char[] board) {
        while (true) {
            int rand = (int) (Math.random() * 9);
            if (board[rand] == EMPTY) {
                board[rand] = PLAYER_O;
                break;
            }
        }
    }

    private static boolean checkWin(char[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||
                (board[0] == player && board[3] == player && board[6] == player) ||
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||
                (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player);
    }

    private static boolean isBoardFull(char[] board) {
        for (char c : board) {
            if (c == EMPTY) {
                return false;
            }
        }
        return true;
    }
}