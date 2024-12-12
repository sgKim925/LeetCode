package Solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralOrder { 
    List<Integer> ans;
    Map<Integer, int[]> map;

    public void backTracking(int[][] matrix, boolean[][] flag, int m, int n, int i, int j, int direction) {
        // direction: '0r' '1d' '2l' '3u'四个方向
        // 1. output
        // make sure current i, j is valid
        ans.add(matrix[i][j]);
        flag[i][j] = true;
        int[] shift = map.get(direction);

        // 2. next round
        //  invalid: update i,j,direction
        //  valid: update i,j
        //  finish: return

        // invalid situation: reach bound || next m[i][j] is true
        if(
            direction==0 && j==n-1 ||
            direction==1 && i==m-1 ||
            direction==2 && j==0 ||
            direction==3 && i==0 ||
            flag[i+shift[0]][j+shift[1]] // next traversed
        ) {
            // change direction
            direction = (direction+1) % 4;
            shift = map.get(direction);
            if(
                direction==0 && j==n-1 ||
                direction==1 && i==m-1 ||
                direction==2 && j==0 ||
                direction==3 && i==0 ||
                flag[i+shift[0]][j+shift[1]]
            ) return; // no unit left
            backTracking(matrix, flag, m, n, i+shift[0], j+shift[1], direction);
        } else {
            // valid
            backTracking(matrix, flag, m, n, i+shift[0], j+shift[1], direction);
        }
        
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        for(boolean[] x: flag) { // flag=true 意味着 遍历过
            Arrays.fill(x, false);
        }
        map = new HashMap<>();
        map.put(0, new int[]{0, 1});
        map.put(1, new int[]{1, 0});
        map.put(2, new int[]{0, -1});
        map.put(3, new int[]{-1, 0});

        backTracking(matrix, flag, m, n, 0, 0, 0);

        StringBuilder builder = new StringBuilder();
        for(int x: ans) {
            builder.append(x);
        }
        System.out.println(builder.toString());
        return ans;
    }
}