package Solutions;

public class Merge88 {
    // 原地插入排序: 从尾部插入
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 用一位insert位指向要插入位置，初始为m+n，这样只需赋值而不用移动
        // 同时先插入最大的
        int insert = m+n-1;
        int p1 = m-1, p2 = n-1;
        while(p1>=0 && p2>=0 && insert>=0) {
            if(nums1[p1]>=nums2[p2]) {
                nums1[insert--] = nums1[p1--];
            } else {
                nums1[insert--] = nums2[p2--];
            }
        }
        while(p1>=0 && insert>=0) nums1[insert--] = nums1[p1--];
        while(p2>=0 && insert>=0) nums1[insert--] = nums2[p2--];

        return ;
    }
}
