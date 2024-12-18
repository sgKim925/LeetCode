package Solutions;

public class SearchRotate2 {
    // 搜索带重复值的旋转数组
    // 先首尾去重
    // 二分法用开区间 浅显易懂
    public boolean binarySearch(int[] nums, int target, int l, int r) {
        if(nums[l]==target || nums[r]==target) return true;
        while(l+1 != r) {
            int mid = (l+r) / 2;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return nums[r]==target;
    }

    public boolean search(int[] nums, int target) {
        if(nums.length==1) return nums[0] == target;

        int l=0, r=nums.length-1;
        if(nums[l]==target || nums[r]==target) return true; // 变成开区间   
        while(l<nums.length-1 && nums[l+1]==nums[l]) l++;
        while(r>0 && nums[r-1]==nums[r]) r--;

        while(l+1 < r) {
            int mid = (l+r) / 2;
            if(nums[mid] >= nums[l]) {  // left
                if(target<= nums[mid] && target>=nums[l]) {
                    return binarySearch(nums, target, l, mid);
                }else {
                    l=mid;
                }

            } else {
                if(nums[mid] <= target && target<=nums[r]) {
                    return binarySearch(nums, target, mid, r);
                } else {
                    r=mid;
                }
            }
        }
        return false;
    }
}
