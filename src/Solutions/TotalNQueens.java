package Solutions;

public class TotalNQueens {
    private static int ans;
    private boolean[] rows;
    private boolean[] cols;
    private boolean[] trace;
    private boolean[] reTrace;

    private  boolean isValid(int row, int col, int n) {
        if(
            rows[row] || cols[col] ||
            trace[n-row+col-1] || reTrace[row+col]
        ) return false;
        return true;
    }

    private void backTracking(int row, int n) {
        if(row==n) {
            ans+=1;
            return ;
        }

        for(int col=0; col<n; col++) {
            if(isValid(row, col, n)) {
                // add (row col)
                rows[row] = true; cols[col] = true; 
                trace[n-row+col-1] = true; reTrace[row+col]=true;
                backTracking(row+1, n);
                rows[row] = false; cols[col] = false; 
                trace[n-row+col-1] = false; reTrace[row+col]=false;
            }
        }
    }

    public int totalNQueens(int n) {
        ans = 0;
        rows = new boolean[n];
        cols = new boolean[n];
        trace = new boolean[2*n-1];
        reTrace = new boolean[2*n-1];
        backTracking(0, n);
        return ans;
    }
}
