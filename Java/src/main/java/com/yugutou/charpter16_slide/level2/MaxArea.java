package com.yugutou.charpter16_slide.level2;

public class MaxArea {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    /**
     * 使用滑动窗口
     * 向内移动长板，（j - i变小）（nums[j]-nums[i]不变，短板决定的）面积必减小
     * 向内移动短板（j - i变小）（nums[j]-nums[i]可能增大，面积可能更大
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0, n = height.length, right = n - 1;
        int area = 0;
        int x = 0, y = 0;
        while (left < right) {
            x = right - left;
            y = Math.min(height[right], height[left]);
            area = Math.max(area, x * y);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
