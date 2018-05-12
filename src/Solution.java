/**
 * Created by jizhengyong on 2018/2/25.
 */


public class Solution {


    public String removeDuplicate(String str) {

        char[] cs = str.toCharArray();


        int k = 0;
        int i = 0;
        int length = cs.length;
        for (; i < length - 1; i++) {
            if (cs[i] == cs[i + 1]) {
                k++;
            } else {
                cs[i - k] = cs[i];
            }
            System.out.println(String.valueOf(cs));
        }
        cs[length - 1 - k] = cs[length - 1];
        System.out.println(String.valueOf(cs));
        System.out.println(String.valueOf(cs).substring(0, length - k));
        return str;

    }


    /**
     * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Example:
     * <p>
     * Given nums = [1,1,2],
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     * It doesn't matter what you leave beyond the new length.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        //维护两个指针，一个保留当前有效元素的长度，一个从前往后扫，然后跳过那些重复的元素。因为数组是有序的，所以重复元素一定相邻，不需要额外记录。
        if (nums.length == 0) return 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1])
                nums[index++] = nums[i];
        }
        return index;
    }


    public static void main(String... args) {

        new Solution().removeDuplicate("aabbbcc");
    }

    public boolean containsDuplicate() {
        int[] nums = new int[50000];

        for (int j = 0; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[j] == nums[k])
                    return true;
            }
        }
        return false;
    }

}
