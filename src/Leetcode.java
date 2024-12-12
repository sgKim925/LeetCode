import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        /*
        初始化状态矩阵f
        f[i][j][cur] 表示 位于(i, j)时，剩余cur时有多少种走法

         */
        int[][][] f = new int[m][n][maxMove+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0) {
                    f[i][j][1] +=1;
                }
                if(j==0) {
                    f[i][j][1] +=1;
                }
                if(i==m-1) {
                    f[i][j][1] +=1;
                }
                if(j==n-1) {
                    f[i][j][1] +=1;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1,0}, {0,1}, {0,-1}};

        // 因为步数需递增，所以步数做外层循环
        for(int cur=2; cur<=maxMove; cur++) {
            for(int fromX=0; fromX<m; fromX++) {
                // int minXMove = (fromX>m/2) ? m-fromX :fromX;
                for(int fromY=0; fromY<n; fromY++) {
                    f[fromX][fromY][cur] += f[fromX][fromY][1];
                    // int minYMove = (fromY>n/2) ? n-fromY:fromY;
                    // int minMove = Math.min(minXMove, minYMove); 
                    // 剩余步数>=至少需要的步数
                    // if(cur >= minMove) {
                    for(int[] d: dirs) {
                        int toX = fromX+d[0];
                        int toY = fromY+d[1];
                        if(toX>=0 && toX<m && toY>=0 && toY<n) {
                            f[fromX][fromY][cur] += f[toX][toY][cur-1];
                            f[fromX][fromY][cur] %= 1000000007;
                        }
                    }
                // }
                }
            }
        }

        return f[startRow][startColumn][maxMove];
    }
}
