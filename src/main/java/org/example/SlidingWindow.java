package org.example;

import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Print max sum of a sub array : " + maxSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 4));
        System.out.println("Print max sum of a sub array optimal : " + maxSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 4));
        System.out.println("Print start & end index of max sum of a sub array : " + Arrays.toString(indexOfMaxSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 4)));
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

    //    Find the maximum sum of a subarray of size K.
    //    Optimal approach
    private static int maxSubArrayOptimal(int[] nums, int size) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = size; i < nums.length; i++) {
            sum += nums[i] - nums[i - size];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    //    Return index of start and end of the maximum sum of a subarray of size K.
    //    Optimal approach


    private static int[] indexOfMaxSubArray(int[] nums, int size) {
        int sum = 0;
        int maxSum = 0;
        int start = 0;
        int end = size - 1;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = size; i < nums.length; i++) {
            sum += nums[i] - nums[i - size];
            if (sum > maxSum) {
                maxSum = sum;
                start += 1;
                end = i;
            }
        }
        return new int[]{start, end};
    }

}