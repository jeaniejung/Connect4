package connectFour;

/**
 * Created by jjung on 11/22/16.
 */
class Board {
    public static final int WIDTH = 7;
    public static final int HEIGHT = 6;
    private Character[][] board = new Character[HEIGHT][WIDTH];
    //put returns the row of the col
    int getRow(int col) {
        int height = 5;
        if (board[height][col] != null) {
            return -1;
        }
        while (height >=0 && board[height][col] == null) {
            height--;
        }
        return height+1;
    }

    String getColor(int x, int y) {
        Character c = board[y][x];
        if (c == 'R') {
            return "RED";
        } else {
            return "YELLOW";
        }
    }

    boolean place(int x, int y, String s) {
        Character c;
        if (s.equals("RED")) {
            c = 'R';
        } else {
            c = 'Y';
        }
        if (board[y][x] == null) {
            board[y][x] = c;
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Character c = board[i][j];
                if (c != null) {
                    System.out.print(" (" + board[i][j] + ") ");
                } else {
                    System.out.print(" ( ) ");
                }
            }
            System.out.println();
        }
    }


}
