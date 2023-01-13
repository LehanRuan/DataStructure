package Array_.SlidingWindow;

// leetcode 904:https://leetcode.cn/problems/fruit-into-baskets/
public class TotalFruit {
    public static int totalFruit(int[] fruits) {
        int result = Integer.MIN_VALUE;
        //使用数组去存储，下标代表种类，下标对应的值是种类的个数
        int[] cnt = new int[fruits.length +  1];
        for(int j = 0, i = 0, tol = 0; j < fruits.length; j++) {
            //等于1代表种类新增一种
            if (++cnt[fruits[j]] == 1) tol++;
            //种类为三种时开始重置
            while (tol > 2) {
                if (--cnt[fruits[i++]] == 0) tol--;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }


}
