package com.yugutou.charpter9_bitree_bisearch.level1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int result = -1;
        int testMethod = 1;
        switch (testMethod) {
            case 1:
                result = binarySearch1(array, 0, 8, 3);
                break;
            case 2:
                result = binarySearch2(array, 0, 8, 3);
                break;

        }
        System.out.println(result);


    }

    /**
     * 循环实现二分查找
     *
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch1(int[] array, int low, int high, int target) {

       while (low <= high) {
           int mid = low + ((high - low) >> 1);
           if (array[mid] > target) {
               high = mid - 1;
           } else if (array[mid] < target) {
               low = mid + 1;
           } else {
               return mid;
           }
       }
       return -1;
    }

    /**
     * 方法二：递归方式实现
     *
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch2(int[] array, int low, int high, int target) {
        //递归终止条件
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                return binarySearch2(array, low, mid - 1, target);
            } else {
                return binarySearch2(array, mid + 1, high, target);
            }
        }
        return -1;
    }
}
