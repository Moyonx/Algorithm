package hot.Hot1To10;

import java.util.Arrays;

/**
 * @author Moyon
 * @description 移动零
 * @date 2024/07/05
 */
public class Hot4 {

    public void moveZeroes(int[] nums) {
        // get length of nums
        int n = nums.length;
        // set the position of non-zero element
        int k = 0;
        // loop through the array
        for(int i=0;i<n;i++) {
            if(nums[i]!=0) {
                // move it to its right position
                nums[k++] = nums[i];
            }
        }
        // fill the rest of the array with 0
        for(int i=k;i<n;i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if(nums==null) return;
        int i=0;
        for(int j=0;j<nums.length;j++) {
            if(nums[j]!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Hot4 hot4 = new Hot4();
        int[] nums = {0,1,0,3,12};
        hot4.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
