package kr.co.programmers.practice;

import java.util.Arrays;

public class GcfAndLcm {

    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        System.out.println(Arrays.toString(new Solution().solution(n, m)));
    }

    static class Solution {
        public int[] solution(int n, int m) {
            int temp = n * m;
            int nmg = n % m;

            while(nmg != 0){
                n = m;
                m = nmg;
                nmg = n % m;
            }

            return new int[]{m, temp/m};
        }
    }
}
