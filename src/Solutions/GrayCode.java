package Solutions;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    // 格雷码公式：第i位的格雷码为 i/2 ^ i
    //
    // 令解： n位格雷码等于n-1位格雷码正序 + n-1位格雷码填一的倒序
    List<Integer> ans;
    boolean[] shown;

    public List<Integer> getNext(int n, int k) {
        // 共n位
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<n; i++) {
            // 第i位取反
            res.add(
                k ^ (1<<i)
            );
        }
        return res;
    }

    public boolean backTracking(int n, int k) {
        int length = (int)Math.pow(2, n);
        if(ans.size()==length) {
            for(int x: getNext(n, 0)) {
                if(x==k) return true;
            }
            return false;
        }
        
        for(int x: getNext(n, k)) {
            if(!shown[x]) {
                ans.add(x); shown[x]=true;
                if(backTracking(n, x)) return true;
                shown[x]=false; ans.remove(ans.size()-1);
            }
        }
        return false;
    }
 
    public List<Integer> grayCode(int n) {
        int length = (int)Math.pow(2, n);
        ans = new LinkedList<>();
        shown = new boolean[length];
        shown[0] = true;
        ans.add(0);

        backTracking(n, 0);
        return ans;
    }
    
}
