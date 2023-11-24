package com.yugutou.charpter3_array;

/**
 * @author dongdong
 * @Date 2023/11/24 9:11
 */
public class Test3 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,4,5};
        int index = deleteDuplicate(nums);
        for (int i = 0; i < index; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 使用快慢指针，慢指针定位下一个有用的元素的位置
     * 快指针去寻找下一个有用的元素。
     * 快指针通过判断i+1 和 i是否相同来确定有用的元素。
     * @param nums
     */
    public static int deleteDuplicate(int[] nums) {
        int size = nums.length;
        int slow = 0, fast = 0;
        int temp = 0;
        while (fast < size - 1) {
            if ( nums[fast] == nums[fast + 1] || nums[fast] == temp) {
                if (nums[fast] == temp) {
                    fast++;
                } else {
                    temp = nums[fast];
                    fast += 2;
                }
            } else {
                nums[slow++] = nums[fast++];
            }
        }

        if (nums[size - 1] != nums[size - 2]) {
            nums[slow++] = nums[size - 1];
        }
        return slow;
    }
}
