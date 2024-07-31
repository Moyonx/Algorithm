package hot.Hot1To10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Moyon
 * @description 最长连续序列
 * @date 2024/07/05
*/public class Hot3 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums);
        int max = 0;
        int val = 1;
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==pre+1){
                pre = nums[i];
                val++;
            }else if(nums[i]==pre){
                continue;
            }
            else{
                if(val>max){
                    max = val;
                }
                val = 1;
                pre = nums[i];
            }
        }
        if(val>max){
            max = val;
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num:nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for(int num:num_set) {
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(num_set.contains(currentNum+1)){
                    currentNum += 1;
                    currentStreak +=1;
                }

                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Hot3 hot3 = new Hot3();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(hot3.longestConsecutive(nums));
    }
}
