package kr.co.programmers.java.practice;

import java.util.Arrays;

public class NSpaceByX {

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(new Solution().solution(x, n)));
    }

    static class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            long num = x;
            for(int i = 0; i < n; i++){
                answer[i] = num;
                num += x;
            }

            return answer;
        }
    }
}
