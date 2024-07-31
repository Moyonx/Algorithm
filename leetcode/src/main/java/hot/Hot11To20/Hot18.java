package hot.Hot11To20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Moyon
 * @description 矩阵置零
 * @date 2024/07/31
 */
public class Hot18 {

    public void setZeroes(int[][] matrix) {
        // 定义值
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row_flag = false;
        boolean col_flag = false;

        // 判断第一行是否有0
        for(int j = 0; j < col; j++) {
            if(matrix[0][j] == 0) {
                row_flag = true;
                break;
            }
        }

        // 判断第一列是否有0
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0) {
                col_flag = true;
                break;
            }
        }

        // 将第一行和第一列作为标志位
        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 置零
        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行和第一列
        if(row_flag) {
            for(int j=0;j<col;j++) {
                matrix[0][j] = 0;
            }
        }
        if(col_flag) {
            for(int i=0;i<row;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
