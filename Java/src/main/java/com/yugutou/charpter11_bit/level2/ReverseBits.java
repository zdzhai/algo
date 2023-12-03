package com.yugutou.charpter11_bit.level2;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits2(43261596));
    }

    /**
     * 通过移位实现反转
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                reverse += 1 << (32 - i - 1);
            }
        }
        return reverse;
    }

    /**
     * 通过分块实现反转
     *
     * @param n
     * @return
     */
    public static int reverseBits2(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
