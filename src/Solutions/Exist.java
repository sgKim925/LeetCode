package Solutions;

public class Exist {
    public boolean backTracking(
        char[][] board, boolean[][] visited, 
        char[] arr, int pointer,
        int row, int col
    ) {
        if(pointer == arr.length) return true;
        if(row<0 || row>=board.length) return false;
        if(col<0 || col>=board[0].length) return false;
        if(visited[row][col]) return false;

        if(!visited[row][col] && board[row][col]==arr[pointer]) {
            visited[row][col] = true;
            if(
                backTracking(board, visited, arr, pointer+1, row-1, col) ||
                backTracking(board, visited, arr, pointer+1, row+1, col) ||
                backTracking(board, visited, arr, pointer+1, row, col-1) ||
                backTracking(board, visited, arr, pointer+1, row, col+1) 
            )  {return true;}
            visited[row][col] = false;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] arr = word.toCharArray();
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                if(backTracking(board, visited, arr, 0, i, j)) return true;
        return false;
    }
}
