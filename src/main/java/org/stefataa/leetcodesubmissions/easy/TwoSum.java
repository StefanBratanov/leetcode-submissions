package org.stefataa.leetcodesubmissions.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        TwoSum subject = new TwoSum();
        System.out.println(Arrays.toString(subject.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(subject.twoSum(new int[]{-1, -2, -3, -4, -5, -8}, -8)));
        System.out.println(Arrays.toString(subject.twoSum(new int[]{3,2,4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numByIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numByIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int complement = target - nums[i];
            if (numByIndex.containsKey(complement) && numByIndex.get(complement) != i) {
                return new int[]{i, numByIndex.get(complement)};
            }
        }

        throw new IllegalStateException("Should not come here");
    }
}
