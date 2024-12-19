package Solutions;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // 将问题变为 以每行为基底， 求柱状图中的最大矩形
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        int ans=0;
        for(int i=0; i<m; i++) {
            // initiate heights[i]
            for(int j=0; j<n; j++) {
                if(matrix[i][j]=='0') {
                    heights[i][j] = 0;
                } else {
                    if(i==0) {
                        heights[i][j] = 1;
                    } else {
                        heights[i][j] = heights[i-1][j] + 1;
                    }
                }
            }

            // 对每一行 求柱状图中的最大矩形   
            Deque<Integer> stack = new LinkedList<>(); // 单调栈
            int max_area = 0;

            stack.addFirst(-1); 
            for(int j=0; j<n; j++){
                int top_index = stack.peek();
                if(top_index==-1 || heights[i][j]>=heights[i][top_index]) {
                    stack.addFirst(j);
                } else {
                    // 弹栈以维护单调性
                    while(top_index!=-1 && heights[i][j]<heights[i][top_index]) {
                        int cur = stack.poll(); top_index = stack.peek();
                        int width = j - top_index -1;
                        if(width*heights[i][cur] > max_area) {
                            max_area = width*heights[i][cur];
                        }
                    }
                    stack.addFirst(j);
                }
            }

            if(stack.size()>1) {
                int top_index = stack.peek();
                while(top_index != -1) {
                    int cur = stack.poll(); top_index = stack.peek();
                    int width = n - top_index -1;
                    if(width*heights[i][cur] > max_area) {
                        max_area = width*heights[i][cur];
                    }
                }
            }

            if(max_area > ans) ans = max_area;
        }

        return ans;
    }
    
}
