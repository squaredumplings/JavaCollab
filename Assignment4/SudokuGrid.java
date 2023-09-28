import java.awt.Point;

public class SudokuGrid {
    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;

    private int[][] defaultGrid = new int[][] {
        {0, 9, 0, 7, 3, 0, 4, 0, 0},   
        {0, 0, 0, 0, 1, 0, 5, 0, 0},   
        {3, 0, 4, 0, 0, 6, 9, 0, 0},   
        {0, 0, 0, 0, 0, 2, 6, 4, 0},   
        {0, 3, 0, 6, 5, 1, 0, 8, 0},   
        {0, 0, 6, 9, 0, 7, 0, 0, 0},   
        {5, 8, 2, 0, 0, 0, 0, 0, 0},   
        {9, 0, 0, 0, 0, 3, 0, 2, 5},   
        {6, 0, 3, 0, 7, 0, 8, 0, 0}, 
    };

    private int[][] grid;
    private int rEmpty;
    private int cEmpty;

    /**
     * Initializes the grid and sets rEmpty and cEmpty to -1.
     */
    public SudokuGrid() {
        grid = defaultGrid;

        rEmpty = -1;
        cEmpty = -1;
    }

    /**
     * Creates a copy of the SudokuGrid.
     * @return SudokuGrid copy
     */
    public SudokuGrid copy() {
        return null;
    }

    /**
     * Searches for the next empty cell in reading order.
     * @return coordinates as a Point
     */
    public Point findEmptyCell() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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
     * Prints the Sudoku grid.
     */
    public void print() {
        for (int i = 0; i < 9; i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.println("+-----------------+");
            }
            for (int j = 0; j < 9; j++){
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

    public void fillCell(int r, int c) {
        // Fill the cell at row r and column c
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
        for (int i = 0; i < 9; i++) {
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
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a conflict in the 3x3 box containing the cell at row r and column c when filling the number d.
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
}