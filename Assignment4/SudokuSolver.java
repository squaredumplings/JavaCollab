import java.awt.Point;

/**
 * [BLANK].
 */

public class SudokuSolver {

    /**
     * [BLANK].
     */
    public void solve(SudokuGrid sudoku) {
        // Use a recursive strategy to solve the Sudoku puzzle
     
        Point emptyCell = sudoku.findEmptyCell();
        
        if (emptyCell == null) {
            sudoku.print();
            System.exit(4732);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!sudoku.givesConflict(emptyCell.x, emptyCell.y, i)) {
                sudoku.fillCell(emptyCell.x, emptyCell.y, i);
                solve(sudoku);
                sudoku.clearCell(emptyCell.x, emptyCell.y);
            }
        }
    }

    /**
     * [BLANK].
     */
    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver
        // Call solve() to solve the puzzle and print the solution 
        // or a message if no solution is found
        int[][] startGrid = {
            {0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 0, 0, 0, 0, 3},
            {0, 7, 4, 0, 8, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 2},
            {0, 8, 0, 0, 4, 0, 0, 1, 0},
            {6, 0, 0, 5, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 7, 8, 0},
            {5, 0, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 4, 0},
        };

        SudokuGrid sudGrid = new SudokuGrid(startGrid, -1, -1);
        SudokuSolver sudSolve = new SudokuSolver();
        sudSolve.solve(sudGrid);
        
        //sudGrid.reformatInput();
    }
}

/*

{1, 2, 3, 4, 5, 6, 7, 8, 9},   
{4, 5, 6, 7, 8, 9, 1, 2, 3},   
{7, 8, 9, 1, 2, 3, 4, 5, 6},   
{0, 0, 0, 0, 0, 0, 0, 0, 0},   
{0, 0, 0, 0, 0, 0, 0, 0, 0},   
{0, 0, 0, 0, 0, 0, 0, 0, 0},   
{0, 0, 0, 0, 0, 0, 0, 0, 0},   
{0, 0, 0, 0, 0, 0, 0, 0, 0},   
{9, 0, 0, 0, 0, 0, 0, 0, 8}, 

{0, 2, 0, 0, 0, 0, 0, 0, 0},
{0, 0, 0, 6, 0, 0, 0, 0, 3},
{0, 7, 4, 0, 8, 0, 0, 0, 0},
{0, 0, 0, 0, 0, 3, 0, 0, 2},
{0, 8, 0, 0, 4, 0, 0, 1, 0},
{6, 0, 0, 5, 0, 0, 0, 0, 0},
{0, 0, 0, 0, 1, 0, 7, 8, 0},
{5, 0, 0, 0, 0, 9, 0, 0, 0},
{0, 0, 0, 0, 0, 0, 0, 4, 0},
*/


