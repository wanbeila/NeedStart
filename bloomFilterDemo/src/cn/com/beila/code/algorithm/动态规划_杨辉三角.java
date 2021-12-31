package cn.com.beila.code.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanbeila
 * @date 2021-09-02-13:45
 * @desc
 */
public class 动态规划_杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        // 第1行数据 1
        // 第2行数据 1 1
        // ...
        // 第k行数据 [k, 0] = [k-1, 0] [k, 1] = [k-1, 0] + [k-1, 1] ... [k, i] = 求和 [k-1, i-1] + [k-1, i]
        // ...
        int[][] nums = new int[numRows][];
        for (int i = 0;i < numRows;i ++) {
            nums[i] = new int[i + 1];
            int j = 0;
            for (;j < i;j ++) {
                if (j == 0) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
            }
            nums[i][j] = 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] ins : nums) {
            List<Integer> innerList = new ArrayList<>();
            for (int i : ins) {
                innerList.add(i);
            }
            result.add(innerList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new 动态规划_杨辉三角().generate(5);
        for (List<Integer> integers : generate) {
            for (Integer i : integers) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
