package hot.Hot1To10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moyon
 * @description 和为k的子数组
 * @date 2024/07/19
 */
public class Hot10 {

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            for(int j=i;j>=0;j--) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0;
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
