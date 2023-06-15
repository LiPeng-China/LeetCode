package com.taiyi.leetcode;

public class Solution_010 {
    public static boolean isMatch(String s, String p) {
        // 记录s的index
        int i = 0;
        for (int j = 0; i < s.length() && j < p.length(); j++) {
            if (p.charAt(j) == '.') {    // 匹配任意单个字符
                i++;
            } else if (p.charAt(j) == '*') {      // 匹配零个或多个前一个字符
                // 前一个字符
                char pre = p.charAt(i - 1);
                if (pre == '.') return true;
                while (i < s.length() && pre == s.charAt(i)) {
                    i++;
                }
            } else {
                if (p.charAt(j) != s.charAt(i)) return false;
                else i++;
            }
        }

        // 如果 p遍历完，而s没有遍历完,则匹配失败
        if (i < s.length()) return false;

        // 返回结果
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
