package Array_.RemoveElem;

/*
leetcode 26:https://leetcode.cn/problems/remove-duplicates-from-sorted-array/submissions/
按顺序去重，且返回长度

思路：
    快慢指针
 */
public class RemoveRepeat {

    public static void main(String[] args) {
        int k = SolutionReR.removeDuplicates(new int[] {1,1,2});
        System.out.println(k);
    }
}
class SolutionReR {
    public static int removeDuplicates(int[] nums) {
        int lowIndex = 0;
        int fastIndex = 0;
        int k = nums.length;

        for (fastIndex = 0; fastIndex < k; fastIndex++) {
            //当快指针遇到数字重复之后的第一个数字时，让lowIndex + 1位置与之覆盖即可。
            if (nums[lowIndex] != nums[fastIndex]) {
                nums[++lowIndex] = nums[fastIndex];
            }
        }
        return  lowIndex + 1;
    }
}
