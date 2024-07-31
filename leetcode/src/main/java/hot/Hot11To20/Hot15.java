package hot.Hot11To20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * @author Moyon
 * @description 轮转数组
 * @date 2024/07/30
 */
public class Hot15 {

    public void rotate(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            deque.add(num);
        }
        for(int i=0;i<k;i++) {
            deque.addFirst(deque.pollLast());
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = deque.pollFirst();
        }
    }

    public void rotate2(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    // 翻转
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        Hot15 hot15 = new Hot15();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        hot15.rotate2(nums, 3);
    }
}
