package Array_.GenerateMatrix;

import jdk.internal.dynalink.beans.StaticClass;

//leetcode 59:https://leetcode.cn/problems/spiral-matrix-ii/
public class generateMatrix {

    public static int[][] solution(int n) {
        int[][] result = new int[n][n];
        int loop = n / 2;
        int startx = 0;
        int starty = 0;
        int end = 1;
        int num = 0;

        while (loop-- > 0) {
            int i = startx;
            int j = starty;

            //从左到右
            for (; j < n - end; j++) {
                result[i][j] = ++num;
            }

            //从上到下
            for (; i < n - end; i++) {
                result[i][j] = ++num;
            }

            //从右到左
            for (; j > starty; j--) {
                result[i][j] = ++num;
            }

            //从下到上
            for (; i > startx; i--) {
                result[i][j] = ++num;
            }

            //新的一圈起始位置都要增加
            startx++;
            starty++;

            //结尾位置也要增加
            end++;
        }

        //如果n为奇数，中间位置需要单独赋值
        if (n % 2 == 1) {
            result[n / 2][n / 2] = ++num;
        }

        return result;
    }
}
