package Hash;

import sun.awt.windows.WPrinterJob;

//leetcode 202:https://leetcode.cn/problems/happy-number/submissions/

import java.util.HashSet;

public class IsHappy {

    public static void main(String[] args) {
        boolean  flag = isHappy(2);
        System.out.println(flag);
    }

    public static boolean isHappy(int n) {
        int temp = 0;
        //用hashSet记录重复出现的数如果重复出现则退出循环return false
        HashSet<Integer> containers = new HashSet<Integer>();
        while(n != 1 && !containers.contains(n)) {
            containers.add(n);
            int flag = 0;
            int num = n;

            //取位数有多少个
            while(num != 0) {
                num = num / 10;
                flag++;
            }
            num = n;

            //算出新数的值
            while(flag != 0) {
                int t = num % 10;
                num = num / 10;
                temp += t * t;
                flag--;
            }
            //重置
            n = temp;
            temp = 0;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}
