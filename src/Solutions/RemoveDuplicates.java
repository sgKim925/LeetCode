package Solutions;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int k=2; // 通解，允许重复k次
        int slow=k, fast=k; // 0    0～k-1一定是正确的
        while(fast < nums.length) {
            if(nums[fast] != nums[slow-k]) {
                // 此时需要插入
                // 此时nums[slow-k] == nums[slow-k+1] == ... == nums[slow]
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
