package Solutions;

public class SetZeros {
    
    public void setZeroes(int[][] matrix) {
        // 用位图 
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[7];
        int[] cols = new int[7];
        for(int i=0;i<m;i++) {
            for(int j=0; j<n; j++) {
                // i = i/32 0～31， 。。。
                if(matrix[i][j]==0) {
                    // System.out.println(matrix[i][j]);
                    rows[i/32] |= (1<<(i%32));
                    cols[j/32] |= (1<<(j%32));
                }
            }
        }
        // 注意在赋值时，要遍历矩阵而非遍历位图
        // 前者为O(m * n)
        // 后者为O(m*m*n*n)
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(
                    ((rows[i/32]>>i%32) & 1 )== 1 ||
                    ((cols[j/32]>>j%32) & 1) == 1
                ) matrix[i][j] = 0;
            }
        }

    }
}
