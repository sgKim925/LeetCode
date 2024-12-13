package Solutions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {
    /*
     * 注意：用四个数组来统计并判断每个位置合法与否
     * 注意对角线与反对角线方向的角标计算
     */
    private static List<List<String>> ans;
    private Deque<String> res;
    private static boolean[] rows;
    private static boolean[] cols;
    // trace代表对角线方向，traceId = n-rowId + colId -1 // length = 2n-1
    private static boolean[] trace;  
    // reTrace代表反对角线方向，reTraceId = rowId+colId;
    private static boolean[] reTrace; 

    private boolean isValid(int row, int col, int n) {
        if(
            rows[row] || 
            cols[col] || 
            trace[n-row+col-1] || 
            reTrace[row+col]
        ) return false;
        return true;
    }

    private void backTracking(char[][] board, int row) {
        if(row == board.length) {
            // res -> ans
            ans.add(new LinkedList<>(res));
            return;
        }

        int n = board.length;
        for(int col=0; col<n; col++) {
            if(isValid(row, col, n)) {
                rows[row] = true; cols[col] = true; 
                trace[n-row+col-1] = true; reTrace[row+col] = true;
                board[row][col] = 'Q';
                StringBuilder builder = new StringBuilder();
                for(char c: board[row]) {
                    builder.append(c);
                }
                res.add(builder.toString());
                backTracking(board, row+1);

                res.removeLast();
                board[row][col] = '.';
                rows[row] = false; cols[col] =false; 
                trace[n-row+col-1] = false; reTrace[row+col] = false;
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        ans = new LinkedList<>();
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for(char[] b: board) {
            Arrays.fill(b, '.');
        }
        rows = new boolean[n];
        cols = new boolean[n];
        trace = new boolean[2*n-1];
        reTrace = new boolean[2*n-1];
        backTracking(board, 0);
        return ans;
    }
}
