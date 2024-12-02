// Time Complexity : O(4 ^n)  worst case we might explore all the paths in the grid . 4 recursive cells at each path
// Space Complexity  : O(k) where k is length of the word. So recursion depth is propotional to length of word
public class WordSearch {
    public boolean wordExist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // iterate through rows and columns to find the first character of word
        for( int i =0; i< rows; i++){
            for (int j =0; j < cols; j++){
                if (board[i][j] == word.charAt(0)){
                   if( backtrack(board, word, i, j, 0)){
                       return true;
                   }
                }
            }
        }
        return false;

    }

    public boolean backtrack(char[][] board, String word, int rows, int cols, int index) {
        // base case : if all characters are matched
        if (index == word.length()) {
            return true;
        }

        //check boundaries
        if (rows < 0 || cols < 0 || rows >= board.length || cols >= board[0].length || board[rows][cols] != word.charAt(index)) {
            return false;

        }

        // mark current character as visited
        char temp = board[rows][cols];
        board[rows][cols] = '#';

        // recurse in al directions

        boolean found = backtrack(board, word, rows + 1, cols, index + 1) || //down
                backtrack(board, word, rows - 1, cols, index + 1) || // up
                backtrack(board, word, rows, cols - 1, index + 1) || // left
                backtrack(board, word, rows, cols + 1, index + 1); // right
        // backtrack
        board[rows][cols] = temp;


        return found;
    }

    public static void main (String [] args){
        WordSearch wordSearch = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(wordSearch.wordExist(board, word1)); // Output: true
        System.out.println(wordSearch.wordExist(board, word2)); // Output: true
        System.out.println(wordSearch.wordExist(board, word3)); // Output: false
    }
}
