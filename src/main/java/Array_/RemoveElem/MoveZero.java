package Array_.RemoveElem;

public class MoveZero {
    /*
    leetcode 283 移动0:https://leetcode.cn/problems/move-zeroes/solution/283-yi-dong-ling-by-chen-wei-f-xzlk/
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2,3};
        moveZeros(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    public static void moveZeros(int[] nums) {
        int lowIndex = 0;
        int fastIndex = 0;
        for(fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            //想好需要删除（交换）的数字很关键。
            if (nums[fastIndex] != 0) {
                swap(nums, lowIndex++, fastIndex);
            }
        }
    }

    //交换数组内i与j位置的值
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
