package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println("Print max sum of a sub array : " + maxSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 4));
        System.out.println("Print max sum of a sub array optimal : " + maxSubArrayOptimal(new int[]{1, 3, 3, 4, 3, 5, 1}, 4));
        System.out.println("Print start & end index of max sum of a sub array : " + Arrays.toString(indexOfMaxSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 4)));
        System.out.println("Longest sub array whose sum <= K : " + longestSubArray(new int[]{1, 3, 3, 4, 3, 5, 1}, 10));
        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        System.out.println("Maximum sum of cards : " + maximumPoints(nums, 3));
        String sequence = "abcabcbb";
        System.out.println("Longest substring without repeating the characters : " + longestUniqueSubString(sequence));
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

    //    Longest sub array with the sum <= k
    private static List<Integer> longestSubArray(int[] nums, int maxSum) {
        int sum = 0;
        List<Integer> currentArray = new ArrayList<>();
        List<Integer> longestArray = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            currentArray.add(num);
            while (sum > maxSum) {
                sum -= currentArray.get(0);
                currentArray.remove(0);
            }
            if (currentArray.size() > longestArray.size()) {
                longestArray = new ArrayList<>(currentArray);
            }
        }
        return longestArray;
    }

    //    Maximum Points You Can Obtain from Cards
    private static int maximumPoints(int[] nums, int size) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for (int i = 0; i < size; i++) {
            leftSum += nums[i];
        }
        maxSum = leftSum;

        for (int i = 0; i < size; i++) {
            leftSum -= nums[size - 1 - i];
            rightSum += nums[nums.length - 1 - i];
            if ((leftSum + rightSum) > maxSum) {
                maxSum = leftSum + rightSum;
            }
        }
        return maxSum;
    }

    //      Longest substring without repeating the characters
    private static int longestUniqueSubString(String sequence) {
        int a = 0;
        int b = 0;
        int max = 0;
        StringBuilder seq = new StringBuilder();
        while (b < sequence.length()) {
            if (seq.toString().contains(String.valueOf(sequence.charAt(b)))) {
                seq.deleteCharAt(0);
                a++;
            } else {
                seq.append(sequence.charAt(b));
                b++;
            }
            max = Math.max(max, seq.length());
        }
        return max;
    }
}