package Game;

import java.util.Scanner;

public class Board {

    public static void printBoard(char[][] board) {

        int dim = board.length;
        System.out.print("\t");
        for (int i = 0; i < dim; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int row = 0; row < dim; row++) {
            System.out.print(row + "\t");
            for (int column = 0; column < dim; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean performMove(char[][] board, char activePlayer) throws Exception {
        System.out.println(activePlayer + ": Enter the row number ");
        int row = new Scanner(System.in).nextInt();

        while (row > board.length) {
            System.out.println("Wrong move");
            System.out.println(activePlayer + ": Enter the row number ");
            row = new Scanner(System.in).nextInt();
        }

        System.out.println(activePlayer + ": Enter the column number ");
        int column = new Scanner(System.in).nextInt();

        while (column > board.length) {
            System.out.println("Wrong move");
            System.out.println(activePlayer + ": Enter the row number ");
            column = new Scanner(System.in).nextInt();
        }

        if (board[row][column] == 0) {
            board[row][column] = activePlayer;
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkRow(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int row = 0; row < dim; row++) {
            boolean win = true;
            for (int column = 0; column < dim; column++) {
                if (board[row][column] != activePlayer) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumn(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int column = 0; column < dim; column++) {
            boolean win = true;
            for (int row = 0; row < dim; row++) {
                if (board[row][column] != activePlayer) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSlant1(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][i] != activePlayer) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSlant2(char[][] board, char activePlayer) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][dim - i - 1] != activePlayer) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkWinner(char[][] board, char activePlayer) {
        return checkRow(board, activePlayer) ||
                checkColumn(board, activePlayer) ||
                checkSlant1(board, activePlayer) ||
                checkSlant2(board, activePlayer);
    }
}

