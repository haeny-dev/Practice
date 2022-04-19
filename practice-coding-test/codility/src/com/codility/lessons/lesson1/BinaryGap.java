package com.codility.lessons.lesson1;

public class BinaryGap {

    public static void main(String[] args) {
        int N = 1041;
        System.out.println(new Solution().solution(N));
    }

    static class Solution {
        public int solution(int N) {
            int answer = 0;
            String binaryString = Integer.toBinaryString(N);
            String[] arr = binaryString
                    .substring(binaryString.indexOf("1"), binaryString.lastIndexOf("1") + 1)
                    .split("1");

            for (int i = 1; i < arr.length; i++) {
                if (arr[i].length() > answer) {
                    answer = arr[i].length();
                }
            }
            return answer;
        }
    }
}
