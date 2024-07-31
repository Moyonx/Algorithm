package hot.Hot21To30;

/**
 * @author Moyon
 * @description 搜索二维矩阵II
 * @date 2024/07/31
 */
public class Hot21 {

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums : matrix) {
            if(search(nums, target)>=0) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i<m && j>=0) {
            if(matrix[i][j] == target) {
                return true;
            }else if(matrix[i][j] <target) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l<=r) {
            int mid = l + (r - l) / 2;
            if(nums[mid]==target) {
                return mid;
            }else if(nums[mid]<target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
