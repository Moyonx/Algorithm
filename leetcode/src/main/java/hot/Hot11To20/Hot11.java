package hot.Hot11To20;

import java.util.*;

/**
 * @author Moyon
 * @description 滑动窗口最大值
 * @date 2024/07/28
 */
public class Hot11 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 定义优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        // 初始化优先队列，放k个进去
        for(int i=0;i<k;i++) {
            pq.offer(new int[]{nums[i], i});
        }
        // 初始化结果数组
        int[] res = new int[n - k + 1];
        res[0] = pq.peek()[0];
        for(int i = k;i<n;i++) {
            pq.offer(new int[]{nums[i], i});
            // 如果队列头部的元素不在窗口内，则弹出
            while(pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 获得当前队列的队头元素，即最大值
            res[i - k + 1] = pq.peek()[0];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // 初始化单调队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++) {
            // 如果队列不为空且新元素比队尾元素大，则弹出队尾元素
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 将新元素加入队尾
            deque.offerLast(i);
        }

        // 初始化结果数组
        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for(int i=k;i<n;i++) {
            // 如果队列不为空且新元素比队尾元素大，则弹出队尾元素
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Hot11 hot11 = new Hot11();
        hot11.maxSlidingWindow(nums, k);
    }
}
