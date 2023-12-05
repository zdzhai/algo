package com.yugutou.charpter12_string.level3;

public class Compress {
    public static void main(String[] args) {
        //char[] chars = {'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'};
        char[] chars = {'a', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        //char[] chars = {'a'};
        System.out.println(compress(chars));
    }

    /**
     * left定位字符，right定位个数
     * 还需要一个标记写入位置的指针
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int n = chars.length;
        if (n == 0) {
            return 0;
        }
        int write = 0, left = 0;
        int right = 1;
        while (right <= n) {
            if (right < n && chars[right] == chars[right - 1]) {
                right++;
            } else {
                chars[write++] = chars[right - 1];
                int num = right - left;
                if (num == 1) {
                    left = right++;
                    continue;
                }
                if (num >= 10) {
                    int start = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num = num / 10;
                    }
                    reverse(chars, start, write - 1);
                } else {
                    chars[write++] = (char) (num + '0');
                }
                left = right++;
            }
        }
        return write;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

