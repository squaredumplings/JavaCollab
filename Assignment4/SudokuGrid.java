import java.awt.Point;
import java.util.Scanner;

/**
* SudokuGrid
* This class represents a Sudoku grid and provides the method to solve it.
*
* @author Mihnea Buzoiu
* @id 1923552
* @author Nicholas Gurgu
* @id 1952234
*/

public class SudokuGrid {
    private static final int SIZE = 9;

    private int[][] grid;
    private int rEmpty;
    private int cEmpty;

    Scanner scan = new Scanner(System.in);

    /**
     * Constructs a SudokuGrid object with the given initial grid.
     *
     * @param newGrid    The initial Sudoku grid.
     */
    public SudokuGrid(int[][] newGrid) {
        this.grid = newGrid;

        this.rEmpty = -1;
        this.cEmpty = -1;
    }

    /**
     * Reads and reformats the input Sudoku grid. Used for testing.
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
     * Checks if the final sudoku is correct using a temporary holder variable.
     */
    public boolean verify() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int holder = grid[i][j];
                clearCell(i, j);
                if (givesConflict(i, j, holder)) {
                    return false;
                }
                fillCell(i, j, holder);
            }
        }
        return true;
    }

    /**
     * Returns a copy of the grid and the coordinates of the next empty cell.
     */
    public SudokuGrid copy() {
        return new SudokuGrid(grid);
    }

    /**
     * Searches for the next empty cell in reading order.
     *
     * @return Coordinates as a Point.
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
     * Sets the targeted cell to the number d.
     *
     * @param r The row of the cell.
     * @param c The column of the cell.
     * @param d The number to fill in.
     */
    public void fillCell(int r, int c, int d) {
        grid[r][c] = d;
    }

    /**
     * Sets the targeted cell to 0.
     *
     * @param r The row of the cell.
     * @param c The column of the cell.
     */
    public void clearCell(int r, int c) {
        grid[r][c] = 0;
    }

    /**
     * Checks if filling the number d in the cell at row r and column c causes a conflict.
     *
     * @param r The row of the cell.
     * @param c The column of the cell.
     * @param d The filled-in number.
     * @return true if a conflict is found, false if no conflicts are encountered.
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
     *
     * @param r The row to check.
     * @param d The filled-in number.
     * @return true if a conflict is found, false if the row is conflict-free.
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
     *
     * @param c The column to check.
     * @param d The filled-in number.
     * @return true if a conflict is found, false if the column is conflict-free.
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
     *
     * @param r The row of the cell.
     * @param c The column of the cell.
     * @param d The filled-in number.
     * @return true if a conflict is found, false if the box is conflict-free.
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
        System.out.println("+-----------------+");
    }
}