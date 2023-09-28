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
     * [BLANK].
     */
    public SudokuGrid() {
        // Initialize the grid and set rEmpty and cEmpty to -1
        grid = defaultGrid;

        rEmpty = -1;
        cEmpty = -1;
    }

    /**
     * [BLANK].
     * @return [BLANK]
     */
    public SudokuGrid copy() {
        // Create a copy of the SudokuGrid and return it
        return null;
    }

    /**
     * [BLANK].
     * @return [BLANK]
     */
    public Point findEmptyCell() {
        // Find the next empty cell in reading order and return its coordinates as a Point
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
     * [BLANK].
     */
    public void print() {
        // Print the Sudoku grid
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
     * [BLANK].
     * @param r row
     * @param c column
     * @param d [BLANK]
     * @return [BLANK]
     */
    public boolean givesConflict(int r, int c, int d) {
        // Check if filling the number d in the cell at row r and column c causes a conflict
        if (rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d)) {
            return true;
        }
        return false;
    }

    /**
     * [BLANK].
     * @param r row
     * @param d [BLANK]
     * @return [BLANK]
     */
    private boolean rowConflict(int r, int d) {
        // Check if there is a conflict in the row r when filling the number d
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * [BLANK].
     * @param r row
     * @param d [BLANK]
     * @return [BLANK]
     */
    private boolean colConflict(int c, int d) {
        // Check if there is a conflict in the column c when filling the number d
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * [BLANK].
     * @param r row
     * @param d [BLANK]
     * @return [BLANK]
     */
    private boolean boxConflict(int r, int c, int d) {
        // Check if there is a conflict in the 3x3 box containing the cell at row r and column c
        // when filling the number d

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