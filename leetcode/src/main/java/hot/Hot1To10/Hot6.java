package hot.Hot1To10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Moyon
 * @description 三数之和
 * @date 2024/07/13
 */
public class Hot6 {

    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> val = new ArrayList<>();
        for(int i=0;i<length;i++) {
            if(i>0&& nums[i] == nums[i-1]) {
                continue;
            }
            int k = length - 1;
            int target = -nums[i];
            // view j
            for(int j=i+1;j<length;j++) {
                if(j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                while(j<k && nums[j] + nums[k] > target) {
                    k--;
                }
                if(j == k) {
                    break;
                }
                if(nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    val.add(list);
                }
            }
        }
        return val;
    }
}
