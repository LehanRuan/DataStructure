package Array_.SlidingWindow;


//leetcode 209:https://leetcode.cn/problems/minimum-size-subarray-sum/
public class MinSubArraylen {

    //暴力解法 (超时)
    public static int solution1 (int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sublength = 0;
        int sum = 0;
        //两个for循环枚举所有可能
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    sublength = j - i + 1;
                    result = result <= sublength ? result : sublength;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //滑动窗口法
    public static int solution2 (int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sublength = 0;
        int sum = 0;
        int i = 0;
        //j等于窗口的结尾
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            //当总数大于目标数字开始窗口的移动
            while (sum >= target) {
                //字符串长度
                sublength = j - i + 1;
                //谁小赋值给谁
                result = result < sublength ? result : sublength;
                //移动窗口
                sum -= nums[i++];
            }

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
