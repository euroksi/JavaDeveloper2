import java.util.Scanner;

public class TicTacGame {

    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final String CREATOR_MESSAGE = "\nCreated by Shreyas Saha. Thanks for playing!";

    private char[] board;
    private Scanner scanner;

    public TicTacGame() {
        board = initializeBoard();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean gameActive = true;

        while (gameActive) {
            displayBoard();
            playerMove();
            if (checkWin(PLAYER_X)) {
                System.out.println("You won the game!" + CREATOR_MESSAGE);
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!" + CREATOR_MESSAGE);
                break;
            }
            computerMove();
            if (checkWin(PLAYER_O)) {
                System.out.println("You lost the game!" + CREATOR_MESSAGE);
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!" + CREATOR_MESSAGE);
                break;
            }
        }
        scanner.close();
    }

    private char[] initializeBoard() {
        return new char[] { EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY };
    }

    private void displayBoard() {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private void playerMove() {
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

    private void computerMove() {
        while (true) {
            int rand = (int) (Math.random() * 9);
            if (board[rand] == EMPTY) {
                board[rand] = PLAYER_O;
                break;
            }
        }
    }

    private boolean checkWin(char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||
                (board[0] == player && board[3] == player && board[6] == player) ||
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||
                (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player);
    }

    private boolean isBoardFull() {
        for (char c : board) {
            if (c == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacGame game = new TicTacGame();
        game.startGame();
    }
}
