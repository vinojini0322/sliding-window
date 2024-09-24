package org.example;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int sum = maxSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 4);
        System.out.println(sum);
    }

    //    Find the maximum sum of a subarray of size K.
    //    Bruteforce approach
    private static int maxSubArray(int[] nums, int size) {
        int start = 0;
        int end = size - 1;
        int maxSum = 0;
        while (end < nums.length) {
            int sum = 0;
            for (int j = start; j <= end; j++) {
                sum += nums[j];
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
            start += 1;
            end += 1;
        }
        return maxSum;
    }
}