import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //creat borad size 3x3
        char[][] board3o3 = creatBoard();
        Scanner userInput = new Scanner(System.in);
        int turns = 0;

        //System.out.println("welcome to a tictactoe game");
        //System.out.println("player 1 is X go first");


        //take each turn
        while (turns < 9){

        }
    }
    public static char[][] creatBoard()
    {//creat borad size 3x3
        char[][] board3o3 = new char[3][3];
        Scanner userInput = new Scanner(System.in);

        //System.out.println("welcome to a tictactoe game");
        //System.out.println("player 1 is X go first");

        //show the board
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board3o3[i][j] = '_';
                System.out.print(board3o3[i][j] + " ");
            }
            System.out.println("  ");
        }
      return board3o3;
    }
}
