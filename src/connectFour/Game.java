package connectFour;

/**
 * Created by jjung on 12/26/16.
 */
public class Game {
    private Board board;
    private Player rPlayer;
    private Player yPlayer;
    private Player currPlayer;
    private int movesCount;

    public Game() {
        this.board = new Board();
        this.rPlayer = new Player("RED", this.board);
        this.yPlayer = new Player("YELLOW", this.board);
        this.currPlayer = rPlayer;
        this.movesCount = 0;
        System.out.println("Player RED begin");
    }

    public void play() {
        while (true) {
            int[] move = currPlayer.makeMove();
            int x = move[0];
            int y = move[1];
            movesCount++;

            if (isTie()) {
                System.out.println("It's a tie!");
                return;
            }
            if (hasWon(x, y)) {
                System.out.format("Player %s has won!", currPlayer.getColor());
                return;
            }
            togglePlayer();
        }
    }

    public void togglePlayer() {
        this.currPlayer = currPlayer == rPlayer ? yPlayer : rPlayer;
    }

    boolean isTie() {
        return movesCount == (board.WIDTH * board.HEIGHT);
    }

    boolean hasWon(int x, int y) {
        return checkRow(x, y) || checkColumn(x, y) || checkLeftDiag(x, y) || checkRightDiag(x, y);
    }

    private boolean checkRow(int x, int y) {
        boolean rowFound = false;
        int seenCount = 0;
        for (int i = Math.max(x - 3, 0); i <= Math.min(x + 3, 6); i++) {
           if (board.getColor(i, y) == currPlayer.getColor()){
               seenCount++;
               if (seenCount == 4) {
                   return true;
               }
            } else {
               seenCount = 0;
           }

        }
        return true;
    }
    private boolean checkColumn(int x, int y) {
        if (y < 3) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (board.getColor(x, y - i) != currPlayer.getColor()){
                return false;
            }
        }
        return true;
    }
    private boolean checkLeftDiag(int x, int y) {
        if (x < 3 || y < 3) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (board.getColor(x - i, y - i) != currPlayer.getColor()) {
                return false;
            }
        }
        return true;
    }
    private boolean checkRightDiag(int x, int y) {
        if (x > 3 || y < 3) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
           if (board.getColor(x + i, y - i) != currPlayer.getColor()) {
                return false;
            }
        }
        return true;
    }
}
