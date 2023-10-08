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

    SudokuGrid sudoku = new SudokuGrid(startGrid);

    /**
     * Recursively solves the Sudoku puzzle.
     */
    public void solve() {
        Point emptyCell = sudoku.findEmptyCell();
        
        if (emptyCell == null) {
            if (sudoku.verify()) {
                sudoku.print();
                System.exit(47);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!sudoku.givesConflict(emptyCell.x, emptyCell.y, i)) {
                sudoku.fillCell(emptyCell.x, emptyCell.y, i);
                solve();
                sudoku.clearCell(emptyCell.x, emptyCell.y);
            }
        }
        return;
    }

    /**
     * Main method to create a SudokuGrid and solve the puzzle or print message.
     */
    public static void main(String[] args) {
        
        SudokuSolver sudSolve = new SudokuSolver();
        sudSolve.solve();
        System.out.print("no solution was found");
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

{9, 2, 6, 5, 7, 1, 4, 8, 3},
{3, 5, 1, 4, 8, 6, 2, 7, 9},
{8, 7, 4, 9, 2, 3, 5, 1, 6},
{5, 8, 2, 3, 6, 7, 1, 9, 4},
{1, 4, 9, 2, 5, 8, 3, 6, 7},
{7, 6, 3, 1, 0, 0, 8, 2, 5},
{2, 3, 8, 7, 0, 0, 6, 5, 1},
{6, 1, 7, 8, 3, 5, 9, 4, 2},
{4, 9, 5, 6, 1, 2, 7, 3, 8},
*/


