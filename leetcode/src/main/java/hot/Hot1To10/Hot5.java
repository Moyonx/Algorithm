package hot.Hot1To10;

/**
 * @author Moyon
 * @description 盛最多水的容器
 * @date 2024/07/13
 */
public class Hot5 {

    public int maxArea(int[] height) {
         int i = 0, j = height.length - 1;
         int val = 0;
         while(i<j) {
             int h = Math.min(height[i], height[j]);
             int w = j - i;
             val = Math.max(val, h*w);
             if(height[i]<height[j]) {
                 i++;
             }else {
                 j--;
             }
         }
         return val;
    }
}
