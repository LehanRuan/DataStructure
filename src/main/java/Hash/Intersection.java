package Hash;

import java.util.HashSet;
import java.util.Set;

//leetcode 349:https://leetcode.cn/problems/intersection-of-two-arrays/

public class Intersection {

    public int[] intersection (int[] nums1, int[] nums2) {
        int[] ans = new int[1005];
        Set<Integer> containers = new HashSet<Integer>();

        //将nums1的数存在ans中
        for (int i = 0; i < nums1.length; i++) {
            ans[nums1[i]] = 1;
        }

        //将重复的数字存放在hashset中
        for (int i = 0; i < nums2.length; i++) {
            if (ans[nums2[i]] == 1) {
                containers.add(nums2[i]);
            }
        }


        int[] result = new int[containers.size()];
        int t = 0;
        for (Integer in : containers) {
            result[t++] = in;
        }

        return result;
    }
}
