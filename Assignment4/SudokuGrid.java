import java.awt.Point;
import java.util.Scanner;

/**
 * [BLANK].
 */

public class SudokuGrid {
    private static final int SIZE = 9;
    //private static final int DIGIT_RANGE = 9;

    private int[][] grid;
    private int rEmpty;
    private int cEmpty;

    Scanner scan = new Scanner(System.in);

    /**
     * Initializes the grid and sets rEmpty and cEmpty to -1.
     */
    public SudokuGrid(int[][] newGrid, int emptyRow, int emptyColumn) {
        this.grid = newGrid;

        this.rEmpty = -1;
        this.cEmpty = -1;
    }

    /**
     * Initializes the grid and sets rEmpty and cEmpty to -1.
     */
    public void reformatInput() {
        int[][] tempGrid = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tempGrid[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.print("{");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tempGrid[i][j]);
                if (j == SIZE - 1) {
                    System.out.print("},");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * [BLANK].
     */
    public SudokuGrid copy() {
        return new SudokuGrid(grid, rEmpty, cEmpty);
    }

    /**
     * Searches for the next empty cell in reading order.
     * @return coordinates as a Point
     */
    public Point findEmptyCell() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 0) {
                    rEmpty = i;
                    cEmpty = j;
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    /**
     * [BLANK].
     */
    public void fillCell(int r, int c, int d) {
        grid[r][c] = d;
    }

    /**
     * [BLANK].
     */
    public void clearCell(int r, int c) {
        grid[r][c] = 0;
    }

    /**
     * Checks if filling the number d in the cell at row r and column c causes a conflict.
     * @param r row
     * @param c column
     * @param d the to be filled number
     * @return true if a conflict is found, false if no conflicts are encountered
     */
    public boolean givesConflict(int r, int c, int d) {
        // 
        if (rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if there is a conflict in the row r when filling the number d.
     * @param r row
     * @param d the to be filled number
     * @return true if a conflict is found, false if the row is conflict free
     */
    private boolean rowConflict(int r, int d) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a conflict in the column c when filling the number d.
     * @param c column
     * @param d the to be filled number
     * @return true if a conflict is found, false if the column is conflict free
     */
    private boolean colConflict(int c, int d) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a conflict in the box containing the cell when filling the number.
     * @param r row
     * @param c column
     * @param d the to be filled number
     * @return true if a conflict is found, false if the box is conflict free
     */
    private boolean boxConflict(int r, int c, int d) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[r / 3 * 3 + i][c / 3 * 3 + j] == d) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints the Sudoku grid.
     */
    public void print() {
        for (int i = 0; i < SIZE; i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.println("+-----------------+");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j == 0 || j == 3 || j == 6) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
                System.out.print(grid[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("+-----------------+ \n\n");
    }
}