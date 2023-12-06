package com.yugutou.charpter13_math.level1;

public class ArraySign {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                prod = -prod;
            } else if (nums[i] == 0 ) {
                prod = 0;
                break;
            }
        }
        return prod;
    }
}
