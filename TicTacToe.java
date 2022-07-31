import java.util.Scanner;
/*
TicTacToe like explained in x.txt (Insert right file name there) ,  X starts first by giving row index, and Column index, that are not cccupied , and turn change
* */
public class x_solution {
    public static void main(String[] args) {
        //creat borad size 3x3
        char[][] board3o3 = creatBoard();
        Scanner userInput = new Scanner(System.in);
        int turns = 0; // even turn is X , odd turn is O
        // What heappends each turn
        while(isGameNotEnded()) {
            int row_index = -1;
            int column_index = -1;
            // Get a valid user input
            while(isNotLegalIndex()) {
                System.out.println("Please enter row index from 0 to " + (board3o3.length - 1) + ", on an empty space only");
                row_index = userInput.nextInt();
                System.out.println("Please enter row index from 0 to " + (board3o3.length - 1) + ", on an empty space only");
                column_index = userInput.nextInt();
            }
            // Print Board State
            printBoardState();
            turns++;
            
        }
        // After all turn have ended
        printGameResult();
    }

    static void printGameResult() {

    }
    static void printBoardState() {
        System.out.println("Tiger diuck");
    }

    static boolean isNotLegalIndex() {
        return true;
    }
    static boolean isGameNotEnded() {
        return true;
    }

    public static char[][] creatBoard()
    {//creat borad size 3x3
        final int boardSize = 3;
        char[][] board3o3 = new char[boardSize][boardSize];
        Scanner userInput = new Scanner(System.in);


        //show the board
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board3o3[i][j] = '_';
                System.out.print(board3o3[i][j] + " ");
            }
            System.out.println("  ");
        }
        return board3o3;
    }
}