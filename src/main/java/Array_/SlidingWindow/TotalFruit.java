package Array_.SlidingWindow;

// leetcode 904:https://leetcode.cn/problems/fruit-into-baskets/
public class TotalFruit {

    public static void main(String[] args) {
        System.out.println(totalFruit1(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    //滑动窗口版本
    public static int totalFruit(int[] fruits) {
        int result = Integer.MIN_VALUE;
        //使用数组去存储，下标代表种类，下标对应的值是种类的个数
        int[] cnt = new int[fruits.length +  1];
        for(int j = 0, i = 0, tol = 0; j < fruits.length; j++) {
            //等于1代表种类新增一种
            if (++cnt[fruits[j]] == 1) tol++;
            //种类为三种时开始滑动
            while (tol > 2) {
                if (--cnt[fruits[i++]] == 0) tol--;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    //暴力版本
    public static int totalFruit1(int[] fruits) {
        int result = Integer.MIN_VALUE;
        //使用数组去存储，下标代表种类，下标对应的值是种类的个数
        int total = 0;
        for(int i = 0; i < fruits.length; i++) {
            int[] cnt = new int[fruits.length +  1];
            for (int j = i; j < fruits.length; j++) {
                if (++cnt[fruits[j]] == 1) {
                    total++;
                }
                if (total > 2) {
                    result = result > j - i  ? result : j - i  ;
                    total = 0;
                    break;
                }
            }
        }
        return result;
    }
}
