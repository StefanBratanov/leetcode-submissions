package org.stefataa.leetcodesubmissions.medium;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater subject = new ContainerWithMostWater();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(subject.maxArea(height));
        System.out.println(subject.maxArea(new int[]{1, 2}));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int pointerAtStart = 0;
        int pointerAtEnd = height.length - 1;

        for (int i = 0; i < height.length; i++) {
            int y1 = height[pointerAtStart];
            int y2 = height[pointerAtEnd];

            maxArea = Math.max(maxArea, calculateArea(pointerAtStart + 1, y1,
                    pointerAtEnd + 1, y2));

            if (Math.abs(pointerAtStart - pointerAtEnd) <= 1) {
                break;
            }

            if (y1 > y2) {
                pointerAtEnd--;
            } else if (y2 > y1) {
                pointerAtStart++;
            } else {
                pointerAtEnd--;
                pointerAtStart++;
            }
        }

        return maxArea;
    }

    public int calculateArea(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) * Math.min(y1, y2);
    }

}
