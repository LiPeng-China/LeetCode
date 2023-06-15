package com.taiyi.leetcode;

public class Solution_009 {
    public static boolean isPalindrome(int x) {
        // 1、负数不是回文
        if (x < 0){
            return false;
        }
        if (x >= 0 && x <= 9) {
            return true;
        }
        // 2、判断十进制的位数
        int len = 0;
        int x1 = x;
        while(x1 != 0){
            len++;
            x1 /= 10;
        }
        // 3、遍历位数，取首尾组成前半段和后半段
        // 前半段
        int div = 1;
        for (int i = 0; i<(len/2); i++){
            div *= 10;
        }
        if (len%2 != 0) div *= 10;

        int left = x / div;
        // 后半段
        int right = 0;
        for (int i = 0; i < (len/2); i++){
            int tail = x%10;
            right = right*10 + tail;
            x /= 10;
        }

        // 4、判断返回
        if (right == left){
            return true;
        }
        return false;
    }

    /**
     * 左闭右开
     * @param x
     * @param start
     * @param end
     * @return
     */
    public static boolean isPalindrome(char[] x, int start, int end){

        if (x[start] == x[end-1]){  // 如果收尾字符相等，判断掐头去尾后的char数组是否是回文
            start++;
            end--;
            if (start >= end) return true;
            return isPalindrome(x, start, end);
        }else{  // 如果收尾字符不相等，不是回文，返回 false
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        //System.out.println(10/Math.pow(10, 2));
        //System.out.println(5/2);
    }

}
