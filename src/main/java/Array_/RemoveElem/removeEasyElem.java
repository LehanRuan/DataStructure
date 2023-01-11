package Array_.RemoveElem;

public class removeEasyElem {
}
class SolutionEasyElem {
    public int removeElement(int[] nums, int val) {
        int lowIndex = 0;
        int fasetIndex = 0;
        int size = nums.length;
        for(fasetIndex = 0; fasetIndex < nums.length; fasetIndex ++ ) {
            //快指针往后移动， 快指针遇到val时向后移动
            //慢指针在快指针遇到val时不动，没遇到val时赋值
            if(nums[fasetIndex] != val) {
                nums[lowIndex++] = nums[fasetIndex];
            }
        }
        return lowIndex;
    }
}
