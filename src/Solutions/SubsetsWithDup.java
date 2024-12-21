package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    // 带重复元素的幂集问题
    // 组合 + 去重
    public void dfs(int[] nums, int u, List<List<Integer>> ans, List<Integer> res) {
        // u为当前访问的element下标
        // 递归策略为：若不添加nums[u] 则直接搜索dfs(nums, u_of_next_element, ans, res)
        //  若添加 则每次向res中添加一个nums[u] 后搜索dfs(nums, u_of_next_element, ans, res)
        int n = nums.length;
        if(n==u) {
            ans.add(new ArrayList(res));
            return;
        }
        int cur = nums[u];
        int next_u = u; // 记录区间

        while(next_u<n && nums[next_u]==nums[u]) next_u++;

        // 不添加cur
        dfs(nums, next_u, ans, res);

        // 添加1 到 next_u次
        for(int i=u; i<next_u; i++) {
            res.add(cur);
            dfs(nums, next_u, ans, res);
        }

        // backTracking
        for(int i=u; i<next_u; i++) {
            res.remove(res.size()-1);
        }
        return ;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, ans, res);
        return new ArrayList(ans);
    }
}
