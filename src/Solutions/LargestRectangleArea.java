package Solutions;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        // 单调栈: 栈内元素单调递增
        // 对每个元素分别找左右小于本身的最近index
        // area = heights[cur] * (r-l)
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        int max_area = 0;
        // int i=0;
        for(int i=0; i<heights.length; i++) {
            int top_index = stack.peek();
            if(top_index==-1 || heights[i]>=heights[top_index]) {
                stack.addFirst(i);
            } else {
                // 退栈 保证单调栈性质
                // !!! 不要忘记当前i入栈 ！！！
                while(top_index!=-1 && heights[top_index]>heights[i]) {
                    int cur = stack.poll(); top_index = stack.peek();
                    int span = i - top_index - 1;
                    int area = heights[cur] * span;
                    if(area > max_area) {
                        max_area = area;
                    }
                }
                stack.addFirst(i);
            }
        }
        // System.out.println(max_area);
        if(stack.size() > 1) {
            int top_index = stack.peek();
            while(top_index!=-1) {
                int cur = stack.poll(); top_index = stack.peek();
                int span = heights.length - top_index - 1;
                int area = span * heights[cur];
                if(area > max_area) {
                    max_area = area;
                }
            }
        }
        return max_area;
    }
}
