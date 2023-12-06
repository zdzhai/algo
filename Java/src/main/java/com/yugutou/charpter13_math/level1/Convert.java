package com.yugutou.charpter13_math.level1;

public class Convert {

    public static final String[] F = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {
        System.out.println(convert(100, 8));

    }

    /**
     * 将十进制数M转化为N进制数
     *
     * @param M
     * @param N
     * @return
     */
    public static String convert(int M, int N) {
        boolean flag = false;
        if (M < 0) {
            flag = true;
            M = -M;
        }
        //对7求余数
        StringBuilder sb = new StringBuilder();
        while (M > 0) {
            sb.append(M % N);
            M  /= N;
        }
        return flag ? sb.append("-").reverse().toString() : sb.reverse().toString();
    }
}
