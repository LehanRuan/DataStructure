package Hash;

import java.util.HashMap;



public class FourSumCount {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //用哈希表去存储对应的数字
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        int temp;
         //第一个两次for循环将nums1和nums2的元素和当成hashmap中的key，value值为和出现的次数
        for (int i : nums1) {
            for (int j : nums2) {
                 temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        //第二个两次for循环将0 - nums3与nums4中的元素和 判断hashmap中是否存在 如果存在结果加一
        for (int i : nums3) {
            for (int j : nums4) {
                 temp = i + j;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }

        return res;
    }

}
