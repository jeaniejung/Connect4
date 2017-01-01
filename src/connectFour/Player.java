package connectFour;

import java.util.Scanner;

/**
 * Created by jjung on 11/22/16.
 */
class Player {
    private String color;
    private Board board;
    private Scanner in;

    Player(String color, Board board) {
        this.color = color;
        this.board = board;
        this.in = new Scanner(System.in);
    }

    String getColor() {
        return color;
    }

    public int[] makeMove() {
        int row;
        int[] move = new int[2];
        do {
            System.out.format("Player %s, enter your column number!", color);
            int col = in.nextInt();
            row = board.getRow(col);
            if (row >= 0) {
                board.place(row, col, this.color);
                move[0] = row;
                move[1] = col;
            } else {
                System.out.format("Column %d is full. Please enter a different column number", col);
            }
        } while (row < 0);
        return move;
    }

}
