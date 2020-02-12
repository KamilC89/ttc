package Game;

import static Game.Board.*;

public class Game {

    public static void game() {
        try {
            System.out.println("Welcome in the game: Tic Tac Toe ");

            int dim = 3;
            char[][] board = new char[dim][dim];

            char activePlayer = 'X';
            int counter = 0;


            boolean win = false;
            while (counter < dim * dim && !win) {
                printBoard(board);
                boolean correctMove = performMove(board, activePlayer);
                if (correctMove) {
                    counter++;
                    if (win = checkWinner(board, activePlayer)) {
                        break;
                    }

                    if (activePlayer == 'X') {
                        activePlayer = 'O';
                    } else {
                        activePlayer = 'X';
                    }
                } else {
                    System.out.println("Wrong move, try again");
                }
            }
            printBoard(board);
            System.out.println("End of the game, the winner is : " + activePlayer);


        } catch (Exception e) {
            System.out.println("Wrong move");
        }
    }
}