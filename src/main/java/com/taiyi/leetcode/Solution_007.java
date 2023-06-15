package com.taiyi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_007 {
    public static int reverse(int x) {

        long res = 0;

        while (x != 0) {
            // 取 x 末尾数字判断是否溢出
            int pop = x % 10;
            if (res * 10 + pop > Integer.MAX_VALUE || res * 10 + pop < Integer.MIN_VALUE) {
                return 0;
            }
            // 没有溢出，拼接
            res = res * 10 + pop;

            x /= 10;
        }

        return (int)res;
    }

    public static void main(String[] args) {

        System.out.println(reverse(1534236469));
        //System.out.println(1<<31);
    }
}
