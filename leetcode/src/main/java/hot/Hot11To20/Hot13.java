package hot.Hot11To20;

/**
 * @author Moyon
 * @description 最大子数组和
 * @date 2024/07/30
 */
public class Hot13 {

    public int maxSubArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        int preSum = 0;
        for(int num : nums) {
            min = Math.min(min, preSum);
            preSum += num;
            ans = Math.max(ans, preSum - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        Hot13 hot13 = new Hot13();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(hot13.maxSubArray(nums));
    }
}
