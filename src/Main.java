import java.util.Scanner;

/*
TicTacToe like explained in x.txt (Insert right file name there) ,  X starts first by giving row index, and Column index, that are not cccupied , and turn change
*/
//board is the defined as array first index is rows second index is column "array[rows][columns]"
public class Main {
    public static void main(String[] args) {

        while(true)
        {
            System.out.println("Start a new game? yes or no");
            Scanner s = new Scanner(System.in);
            String sa=s.nextLine();
            if(sa.equals("yes"))
                playGame();
            else if(sa.equals("no"))
            {
                break;
            }
            else{
                System.out.println("Invalid output");
            }
        }

    }
    private static void playGame()
    {
        //creat borad size 3x3

        char[][] board3o3 = creatBoard();

        int turns = 0; // even turn is X , odd turn is O
        // What heappends each turn
        while (turns < 9) {

            int row_index = -1;
            int column_index = -1;
            // Get a valid user input
            while (true) {
                System.out.println("Please enter row index from 0 to " + (board3o3.length - 1) + ", on an empty space only");

                row_index = getvalue();

                System.out.println("Please enter column index from 0 to " + (board3o3.length - 1) + ", on an empty space only");
                column_index = getvalue();
                if (row_index <= 2 && row_index >= 0 && column_index <= 2 && column_index >= 0 && board3o3[row_index][column_index] == '_') {
                    break;
                } else {
                    System.out.println("your move is not valid please try again");
                    printBoardState(board3o3);
                }

            }
            board3o3 = addMoveToBoard(board3o3, row_index, column_index, turns);
            if (checkIfWinner(board3o3,turns)) {
                //declare winner x or o and ask if user want to start a new game
                printGameResult(turns,true);
                return;
            }


            // Print Board State
            printBoardState(board3o3);
            turns++;

        }
        // After all turn have ended
        printGameResult(turns,false);
    }
    private static char[][] addMoveToBoard(char[][] board, int row_index, int column_index, int turns) {
        if (turns % 2 == 0) {
            board[row_index][column_index] = 'X';
        } else {
            board[row_index][column_index] = 'O';
        }
        return board;
    }

    private static int getvalue() {
        Scanner userinput = new Scanner(System.in);
        String input;
        while (true) {
            input = userinput.nextLine();
            if (input.equals("0") || input.equals("1") || input.equals("2")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("invalid input, pls try again");
            }
        }
    }
    static void printGameResult(int turn, boolean isWinner) {
        if (isWinner) {
            if (turn % 2 == 0) {
                System.out.println("Player X is the WINNER!!!");
            } else {
                System.out.println("Player O is the WINNER!!!");
            }
        }
        else {
            System.out.println("The game is ended in a Tie");
        }

    }

    static void printBoardState(char[][] board) {
        int boardSize = 3;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("  ");
        }
    }

    static boolean isNotLegalIndex() {
        return true;
    }

    static boolean isGameNotEnded() {
        return true;
    }

    public static char[][] creatBoard() {//creat borad size 3x3
        final int boardSize = 3;
        char[][] board3o3 = new char[boardSize][boardSize];


        //show the board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board3o3[i][j] = '_';
                System.out.print(board3o3[i][j] + " ");
            }
            System.out.println("  ");
        }
        return board3o3;
    }

    private static boolean checkIfWinner(char[][] board,int turn) {
        /*check if symbol is the same in this cases:
        rows: (0,0)(0,1)(0,2) , (1,0)(1,1)(1,2) , (2,0)(2,1)(2,2);
        columns: (0,0)(1,0)(2,0) , (0,1)(1,1)(2,1) , (0,2)(1,2)(2,2);
        diagonals:(0,0)(1,1)(2,2) , (0,2)(1,1)(2,0);
         */
        char checkletter;
        if (turn % 2 == 0) {
            checkletter = 'X';
        } else {
            checkletter = 'O';
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == checkletter) {
                System.out.println("winner found");
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]&&board[0][i]==checkletter) {
                System.out.println("winner found");
                return true;

            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]&& board[1][1] ==checkletter) {
            System.out.println("winner found");
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]&& board[1][1] ==checkletter) {
            System.out.println("winner found");
            return true;
        }
        return false;


    }

}

