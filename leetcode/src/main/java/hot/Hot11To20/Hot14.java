package hot.Hot11To20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Moyon
 * @description 合并区间
 * @date 2024/07/30
 */
public class Hot14 {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            // 如果list为空或list最后一个区间的右边界小于当前区间的左边界，则添加当前区间
            if(list.size() ==  0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left,right});
            }else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Hot14 hot14 = new Hot14();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = hot14.merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
}
