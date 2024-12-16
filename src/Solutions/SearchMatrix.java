package Solutions;

public class SearchMatrix {
    // 二分查找的最终形式
    // l=-1, r=N
    // while(l+1!=r) {...}
    public int search(int[][] matrix, int target) {
        // 找第一个小于等于tar的值
        int l=-1; int r=matrix.length;
        while(l+1 != r) {
            int mid = (l+r) / 2;
            if(matrix[mid][0]>target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = search(matrix, target);
        if(rowIndex==-1) return false;

        int l = -1; int r = matrix[rowIndex].length;
        while(l+1 != r) {
            int mid = (l+r) / 2;
            if(matrix[rowIndex][mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if(r==matrix[rowIndex].length) return false;
        return matrix[rowIndex][r] == target;
    }
}
