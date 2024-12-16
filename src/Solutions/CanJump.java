package Solutions;

public class CanJump {
    public boolean canJump(int... nums) {
        int l=0, r=0; // l记录起始点，r记录最右距离
        int n = nums.length;
        while(l<n && l<=r) {
            r = Math.max(l+nums[l], r);
            l++;
        }
        return r>=n-1; 
    }
}
