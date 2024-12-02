// Time Complexity = O(n!) because n ! possible arrangements to explore
// Space complexity O(n) recursive stack space
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialise the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(0, board, n);
        return result;


    }

    private void solve(int row, char[][] board, int n) {
        // base case : If all Queens are placed

        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        // logic - place the Queen row wise
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q'; // place Q if it is safe position
                solve(row + 1, board, n); //recurse and move to the next row
                board[row][col] = '.'; // you also need to backtrack because in case of recursion if we place at the wrong position then remove the queen from previous step

            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        //
        for (int i = 0; i < row; i++) { // check the current coloum for all the rows above the current row
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check upper left diagnol
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // check upper right diagnol
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    private List<String> constructBoard(char [][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));

        }
        return result;
    }
       public static void main( String [] args){

           NQueens NQueensobj = new NQueens();
           int n = 4;
           List<List<String>> solutions = NQueensobj.solveNQueens(n);

           System.out.println("Number of solutions: " + solutions.size());
           for (List<String> solution : solutions) {
               for (String row : solution) {
                   System.out.println(row);
               }
               System.out.println();
           }
       }


    }

