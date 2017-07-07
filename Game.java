import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by joao on 06-07-2017.
 */
public class Game {

    private Cell[][] board;
    private int length;
    private int width;

    public Game(int length, int width) {
        this.length = length;
        this.width = width;
        board = new Cell[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Cell(i,j);
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void addCell(int x, int y) {
        //TODO wont increase
        if (x > length-2 || y > width-2)
            increaseSize();
        board[y][x].state = true;
    }


    public void makeTurn() {
        ArrayList<Cell> toLive = new ArrayList<>();
        ArrayList<Cell> toDie = new ArrayList<>();
        boolean tooSmall = false;
        for (Cell[] line : board) {
            for (Cell cell : line) {
                int neigh = cell.nNeighbours();
                if (cell.state) {
                    if (cell.x == 1 || cell.x == length-2 || cell.y == 1 || cell.y == width-2)
                        tooSmall = true;
                    if (neigh < 2 || neigh > 3)
                        toDie.add(cell);
                } else {
                    if (neigh == 3)
                        toLive.add(cell);
                }
            }
        }

        for (Cell c : toDie)
            c.state = false;

        for (Cell c : toLive)
            c.state = true;

        if (tooSmall)
            increaseSize();
    }

    private void increaseSize() {
        Cell[][] newBoard = new Cell[length*2][width*2];
        for (int i = 0; i < length*2; i++) {
            for (int j = 0; j < width*2; j++) {
                newBoard[i][j] = new Cell(i,j);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].state)
                    newBoard[i][j].state = true;
            }
        }

        length = length*2;
        width = width*2;
        board = newBoard;
    }

    private class Cell {
        private int x;
        private int y;
        private boolean state;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            state = false;
        }

        private int nNeighbours() {
            int num = 0;
            if (!(x == 0 || x == length-1 || y == 0 || y == width-1)) {
                if (board[x+1][y+1].state)
                    num++;
                if (board[x+1][y].state)
                    num++;
                if (board[x+1][y-1].state)
                    num++;
                if (board[x][y + 1].state)
                    num++;
                if (board[x][y - 1].state)
                    num++;
                if (board[x - 1][y + 1].state)
                    num++;
                if (board[x - 1][y].state)
                    num++;
                if (board[x - 1][y - 1].state)
                    num++;
            }
            return num;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + state;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("");
        for (Cell[] line : board) {
            for (Cell cell : line) {
                if (cell.state)
                    sj.add("■");
                else
                    sj.add("•");
            }
            sj.add("\n");
        }
        return sj.toString();
    }
}
