import java.awt.Point;

/**
* SudokuSolver
* This class is responsible for solving Sudoku puzzles using a recursive strategy.
*
* @author Mihnea Buzoiu
* @id 1923552
* @author Nicholas Gurgu
* @id 1952234
*/

public class SudokuSolver {

    /**
     * Recursively solves the Sudoku puzzle.
     *
     * @param sudoku The SudokuGrid representing the puzzle to solve.
     */
    public void solve(SudokuGrid sudoku) {
     
        Point emptyCell = sudoku.findEmptyCell();
        
        if (emptyCell == null) {
            sudoku.print();
            //System.exit(4732);
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
     * Main method to create a SudokuGrid and solve the puzzle.
     */
    public static void main(String[] args) {
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

        SudokuGrid sudGrid = new SudokuGrid(startGrid);
        SudokuSolver sudSolve = new SudokuSolver();
        sudSolve.solve(sudGrid);
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


