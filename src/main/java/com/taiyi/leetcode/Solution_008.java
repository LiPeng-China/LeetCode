package com.taiyi.leetcode;

public class Solution_008 {
    public static int myAtoi(String s) {
        // 1、将字符串转换成char数组方便遍历
        char[] chars = s.toCharArray();
        int len = chars.length;


        // 2、去除前导空格
        int idx = 0;
        for (char c : chars) {
            if (c == ' '){
                idx++;
            }else{
                break;
            }
        }

        if (idx == len){
            return 0;
        }

        // 3、记录符号
        int sign = 1;
        if (chars[idx] == '-'){
            sign = -1;
            idx++;
        }else if (chars[idx] == '+'){
            idx++;
        }

        // 4、开始遍历
        int res = 0;
        while (idx < len){
            // 判断不合法，直接退出
            if (chars[idx] < '0' || chars[idx] > '9'){
                break;
            }
            // 判断是否越界，越界就返回边界值
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && (chars[idx]-'0') > Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && (chars[idx] - '0') > -(Integer.MIN_VALUE%10))){
                return Integer.MIN_VALUE;
            }
            // 转换
            res = res*10 + sign * (chars[idx] - '0');
            idx++;
        }
        // 5、返回int数字（带上符号）
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
        //System.out.println(Integer.MAX_VALUE);
    }
}
