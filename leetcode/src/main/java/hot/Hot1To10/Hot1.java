package hot.Hot1To10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moyon
 * @description 两数之和
 * @date 2024/07/03
 */
public class Hot1 {

    public int[] twoSum(int [] nums, int target) {
        int [] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] + nums[j] ==target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int [] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Hot1 hot1 = new Hot1();
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] result = hot1.twoSum2(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
