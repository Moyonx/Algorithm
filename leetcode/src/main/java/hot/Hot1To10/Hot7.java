package hot.Hot1To10;

import java.util.Stack;

/**
 * @author Moyon
 * @description 接雨水
 * @date 2024/07/17
 */
public class Hot7 {

    public int trap(int[] height) {

        int length = height.length;
        if(length == 0) {
            return 0;
        }

        // 下标i及其左边元素的最大值
        int[] left = new int[length];
        left[0] = height[0];
        for(int i=1;i<length;i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        // 下表i及其右边元素的最大值
        int[] right = new int[length];
        right[length-1] = height[length-1];
        for(int i=length-2;i>=0;i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        // 遍历每个元素，计算其能容纳的雨水量
        int sum = 0;
        for(int i=0;i<length;i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }

        return sum;
    }

    public int trap2(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int width = i - left - 1;
                int high = Math.min(height[left], height[i]) - height[top];
                res += width * high;
            }
            stack.push(i);
        }
        return res;
    }
}
