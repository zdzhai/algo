package com.yugutou.charpter13_math.level3;

public class IsPrime {
    public static void main(String[] args) {

        System.out.println(isPrime(11));
    }

   public static boolean isPrime(int num) {
        int m = (int) Math.sqrt(num);
       for (int i = 2; i <= m; i++) {
           if (num % i == 0) {
               return false;
           }
       }
       return true;
    }
}
