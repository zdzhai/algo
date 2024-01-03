package com.yugutou.charpter13_math;

/**
 * @author dongdong
 * @Date 2023/12/29 10:50
 */
public class CanWinNim {
    public static void main(String[] args) {

    }

    /**
     * 如果是4的倍数，那自己一定输
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
