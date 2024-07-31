package hot.Hot11To20;

/**
 * @author Moyon
 * @description 除自身以外数组的乘积
 * @date 2024/07/31
 */
public class Hot16 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int aft = 1;
        int[] res = new int[n];

        for(int i=0;i<n;i++) {
            res[i] = pre;
            pre *= nums[i];
        }

        for(int j=n-1;j>=0;j--) {
            res[j] *= aft;
            aft *= nums[j];
        }
        return res;
    }

}
