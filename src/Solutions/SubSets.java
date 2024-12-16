package Solutions;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    // 位图解幂集问题
    // 0000 表示什么都不放，0001表示放第一个。。。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<(1<<nums.length); i++) {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<nums.length; j++) {
                if(((i>>j)&1)==1) res.add(nums[j]);
            }
            ans.add(res);
        }

        return ans;
    }
}
