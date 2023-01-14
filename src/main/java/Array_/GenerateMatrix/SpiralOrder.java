package Array_.GenerateMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        ArrayList<Integer> result = spiralOrder2(new int[][]{new int[]{1, 2, 3},
                new int[]{5, 6, 7}, new int[]{8,9,10}});
//        , new int[]{13, 14, 15, 16}
        System.out.println(result);
    }

    //版本1
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int ylen = matrix.length;
        int xlen = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int loop = 0;
        int startx = 0;
        int starty = 0;
        int end = 0;
        while (loop < (Math.min(ylen, xlen) + 1) / 2) {
            int i = startx;
            int j = starty;

            //从左到右
            for (; i < xlen - end; i++) {
                result.add(matrix[j][i]);
            }
            i--;
            //从上到下
            for (j = j + 1; j < ylen - end; j++) {
                result.add(matrix[j][i]);
            }

            j--;
            //从右到左
            for (i = i  - 1; i >= startx && ylen - loop - startx != 1; i--) {
                result.add(matrix[j][i]);
            }

            i++;
            //从下到上
            for (j = j  - 1; j > starty && xlen - loop - startx != 1; j--) {
                result.add(matrix[j][i]);
            }

            //新的一圈起始位置都要增加
            startx++;
            starty++;
            //结尾位置也要增加
            end++;
            loop++;
        }
        return result;
    }


    /*
    优化版本:
            使用了i替换了loop，end，startx，starty
            因为这三者都对等可以转换，
            其实再添加一个变量会更好理解
     */
    public static ArrayList<Integer> spiralOrder2(int[][] matrix) {
        int ylen = matrix.length;
        int xlen = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < (Math.min(ylen, xlen) + 1) / 2) {
            //从左到右
            for (j = i; j < xlen - i ; j++) {
                result.add(matrix[i][j]);
            }

            //从上到下
            for (j = i + 1; j < ylen - i; j++) {
                result.add(matrix[j][xlen - 1 - i]);
            }

            //从右到左
            //起始位置从xlen - 1长度本身就要 - 1，从上到下占了一个位置再减1，还要减去层数
            //终止位置与层数一致
            for (j = xlen - 1 - i - 1; j >= i && ylen - 1 - i != i; j--) {
                result.add(matrix[ylen - 1 - i][j]);
            }

            //从下到上
            //起始位置从xlen - 1长度本身就要 - 1，从右到左占了一个位置再减1，还要减去层数
            //终止位置开始给从左到右占了一个位置所以取不到终止位置i
            for (j =  ylen - 1 - i - 1; j > i && xlen - 1 - i != i; j--) {
                result.add(matrix[j][i]);
            }

            i++;
        }
        return result;
    }
}
