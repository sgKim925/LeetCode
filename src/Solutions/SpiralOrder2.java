package Solutions;

public class SpiralOrder2 {
    
    public int[][] generateMatrix(int n) {
        int target = n*n;
        int rowLength = n;
        int colLength = n-1;
        int row=0; int col=0;
        int num=1;
        int[][] ans = new int[n][n];

        while(num<=target) {
            // -> 
            for(int i=0; i<rowLength; i++) {
                ans[row][col] = num++;
                col++;
            }
            col--; rowLength--; row++;
            if(rowLength == 0) return ans;
            // down
            for(int i=0; i<colLength; i++) {
                ans[row][col] = num++;
                row++;
            }
            row--; colLength--; col--;
            // <-
            for(int i=0; i<rowLength; i++) {
                ans[row][col] = num++;
                col--;
            }
            col++; rowLength--; row--;
            if(rowLength == 0) return ans;
            // up
            for(int i=0; i<colLength; i++) {
                ans[row][col] = num++;
                row--;
            }
            row++; colLength--; col++;
        }
        return ans;
    }
}
