import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        System.out.println(""
                + " /__   (_) ___  /__   \\__ _  ___  /__   \\___   ___ \n"
                + "   / /\\/ |/ __|   / /\\/ _` |/ __|   / /\\/ _ \\ / _ \\\n"
                + "  / /  | | (__   / / | (_| | (__   / / | (_) |  __/\n"
                + "  \\/   |_|\\___|  \\/   \\__,_|\\___|  \\/   \\___/ \\___|\n"
                + "                                                   \n"
        );
        char player = 'X';
        boolean GameOver = false;

        while (!GameOver) {
            printBoard(board);
            System.out.print("Player " + player + " enter: ");
            int row = in.nextInt();
            int col = in.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                GameOver = haveWon(board, player);
                if (GameOver) {
                    printBoard(board);
                    System.out.println("Congrats, " + player + " has won the game!");
                    GameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Position! Try again!");
            }
        }
        printBoard(board);
    }
    static void printBoard(char[][] board){
        for(int i = 0 ; i< board.length;i++){
            for(int j = 0 ; j<board[i].length; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
    static boolean haveWon(char[][] board, char player){
        for(int i = 0 ; i< board.length;i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player ){
                return true;
            }
        }
        for(int i = 0 ; i< board.length;i++){
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player ){
                return true;
            }
        }
        if(board[0][0]==player && board[1][1] == player && board[2][2]== player){
            return true;
        }
        if(board[0][2]==player && board[1][1] == player && board[2][0]== player){
            return true;
        }
        return false;
    }

}
