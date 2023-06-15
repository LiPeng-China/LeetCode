package com.taiyi.offer;

import java.util.HashSet;
import java.util.Set;

public class Solution_03 {
    public static int findRepeatNumber(int[] nums) {
        // 原地交换

        int i = 0;
        while (i < nums.length){
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[i] == nums[nums[i]]) return nums[i];

            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(a));
//        Set<Integer> dic = new HashSet<>();
//        System.out.println(dic);
    }
}
