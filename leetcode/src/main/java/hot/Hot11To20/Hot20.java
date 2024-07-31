package hot.Hot11To20;

/**
 * @author Moyon
 * @description 旋转图像
 * 思路：先按对角线翻转一下，再逐行逆转
 * @date 2024/07/31
 */
public class Hot20 {

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 按对角线翻转，即将下半三角形的元素与对应的上半三角形的元素进行交换
        for(int i=1;i<m;i++) {
            for(int j=0;j<i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 逐行逆转
        for(int i=0;i<m;i++) {
            for(int j=0;j<n/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
