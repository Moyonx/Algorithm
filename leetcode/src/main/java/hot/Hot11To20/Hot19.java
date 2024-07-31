package hot.Hot11To20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moyon
 * @description 螺旋矩阵
 * @date 2024/07/31
 */
public class Hot19 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        // 定义上下左右四个边界
        int u = 0, d = m - 1, l = 0, r = n - 1;

        // 循环遍历
        while(true) {
            // 从左到右
            for(int i=l;i<=r;i++) {
                res.add(matrix[u][i]);
            }
            // 如果超出边界，则退出循环
            if(++u > d) {
                break;
            }
            // 从上到下
            for(int i=u;i<=d;i++) {
                res.add(matrix[i][r]);
            }
            // 如果超出边界，则退出循环
            if(--r < l) {
                break;
            }
            // 从右到左
            for(int i=r;i>=l;i--) {
                res.add(matrix[d][i]);
            }
            // 如果超出边界，则退出循环
            if(--d < u) {
                break;
            }
            // 从下到上
            for(int i=d;i>=u;i--) {
                res.add(matrix[i][l]);
            }
            // 如果超出边界，则退出循环
            if(++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Hot19 hot19 = new Hot19();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = hot19.spiralOrder(matrix);
        System.out.println(res);
    }
}
