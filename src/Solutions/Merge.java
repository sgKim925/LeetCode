package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        /*
         * 在Arrays.sort中重写匿名内部类的compare方法实现自定义排序
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> ans = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] <= r) {
                if(intervals[i][1] > r) {
                    r = intervals[i][1];
                }
            } else {
                ans.add(new int[]{l ,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        ans.add(new int[]{l ,r});
        for(int[] x: ans) {
            System.out.println(Arrays.toString(x));
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
