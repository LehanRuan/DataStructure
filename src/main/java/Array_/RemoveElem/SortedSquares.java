package Array_.RemoveElem;

/*
leetcode 977:有序数组的平方 https://leetcode.cn/problems/squares-of-a-sorted-array/comments/
 */

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];
        int k = nums.length - 1;
        //双指针的位置很重要，不能太死板根据题目要求设置额外的空间
        //从头尾分别设置指针谁大，谁放入新数组的最后一个位置开始往前
        for (int i = 0, j = nums.length - 1; i <= j ; ) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                 newNums[k--] = nums[j] * nums[j];
                 j--;
            } else {
                newNums[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return newNums;
    }
}
