package hot.Hot11To20;

import java.util.Arrays;

/**
 * @author Moyon
 * @description 缺失的第一个正数
 * @date 2024/07/31
 */
public class Hot17 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 把所有非正数标记为n+1
        for(int i=0;i<n;i++) {
            if(nums[i] <= 0) {
                nums[i] = n+1;
            }
        }
        // 对于每个正数x，如果x在[1,n]范围内，就把nums[x-1]标记为负数
        for(int i=0;i<n;i++) {
            int num = Math.abs(nums[i]);
            if(num <= n) {
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        // 返回第一个正数的下标+1
        for(int i=0;i<n;i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return n+1;
    }
}
