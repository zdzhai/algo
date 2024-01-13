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
     * 模板1 更新右边界，判断范围为[left, mid - 1]和[mid, right]
     * 需要注意计算mid要多加1
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch3(int[] array, int target) {
        int size = array.length;
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return array[left] == target ? left : -1;
    }

    /**
     * 模板2 更新左边界，判断范围为[mid + 1, right]和[left, mid]
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch4(int[] array, int target) {
        int size = array.length;
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] == target ? left : -1;
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
