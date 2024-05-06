package com.yugutou.charpter3_array;

/**
 * @author dongdong
 * @Date 2024/5/6 15:39
 * leetcode 80.删除有序数组中的重复项川
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 使用双指针 slow记录需要替换的位置，fast一直往后遍历
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size <= 2) return size;
        int slow = 1, fast = 2;
        while (fast < size) {
            if (nums[slow] == nums[slow - 1] && nums[fast] == nums[slow]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow + 1;
    }
}
