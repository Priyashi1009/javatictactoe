import java.util.Scanner;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer;

    
    public TicTacToe() {
        currentPlayer = 'X'; // Player X starts the game
        initializeBoard();
    }

    // Method to initialize the game board with empty cells
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Method to display the current state of the game board
    public void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    
    public boolean makeMove(int row, int col) {
        // Check if the selected cell is empty
        if (board[row][col] == '-') {
            board[row][col] = currentPlayer; 
            return true;
        } else {
            System.out.println("Cell already occupied. Try again.");
            return false;
        }
    }

    
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }


    public boolean checkWinner() {
        // Check rows, columns, and diagonals for winning combinations
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            game.displayBoard();
            System.out.println("Player " + game.currentPlayer + "'s turn.");
            System.out.print("Enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (game.makeMove(row, col)) {
                    if (game.checkWinner()) {
                        game.displayBoard();
                        System.out.println("Player " + game.currentPlayer + " wins!");
                        gameOver = true;
                    } else {
                        game.switchPlayer();
                    }
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
}
