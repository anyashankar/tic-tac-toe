//Anya Shankar
//Period 2

import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] n = new char[3][3];
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                n[i - 1][j - 1] = '-';
            }
        }
        Scanner pen = new Scanner(System.in);
        System.out.println("Player 1 is X and Player 2 is O");

        boolean p1 = true;
        boolean e = false;
        int row, col;
        while (!e) {
            Board(n);
            if (p1) {
                System.out.println("Player 1: ");
            }
            else {
                System.out.println("Player 2: ");
            }
            char c = '-';
            if (p1) {
                c = 'X';
            }
            else {
                c = 'O';
            }
            row = 0;
            col = 0;

            while (true) {
                System.out.print("Enter a row number (first row is 0): ");
                row = pen.nextInt();
                System.out.print("Enter a column number (first column is 0): ");
                col = pen.nextInt();
                if (n[row][col] != '-') {
                    System.out.println("Try again.");
                }
                else {
                    break;
                }
            }
            n[row][col] = c;
            if (winner(n) == 'X') {
                System.out.println("Player 1 wins!");
                e = true;
            }
            else if (winner(n) == 'O') {
                System.out.println(" Player 2 wins!");
                e = true;
            }
            else {
                if (tie(n)) {
                    System.out.println("A tie!");
                    e = true;
                }
                else {
                    p1 = !p1;
                }
            }
        }
        Board(n);
        pen.close();
    }

    public static void Board(char[][] board) {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(board[i - 1][j - 1]);
            }
            System.out.println();
        }
    }

    public static char winner(char[][] board) {
        for (int i = 1; i < 4; i++) {
            if ((board[i -1][0] == board[i - 1][1]) &&
                    (board[i - 1][1] == board[i -1][2]) &&
                    (board[i -1][0] != '-')) {
                return board[i - 1][0];
            }
        }

        for (int j = 1; j < 4; j++) {
            if (board[0][j - 1] == board[1][j - 1] &&
                    board[1][j - 1] == board[2][j - 1] &&
                    board[0][j - 1] != '-') {
                return board[0][j - 1];
            }
        }

        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2] &&
                board[0][0] != '-') {
            return board[0][0];
        }

        if (board[2][0] == board[1][1] &&
                board[1][1] == board[0][2] &&
                board[2][0] != '-') {
            return board[2][0];
        }

        return ' ';

    }

    //tie method
    public static boolean tie(char[][] board) {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (board[i - 1][j - 1] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

