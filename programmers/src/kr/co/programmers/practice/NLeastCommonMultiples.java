package kr.co.programmers.practice;

import java.util.Arrays;

public class NLeastCommonMultiples {

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
//        System.out.println(new Solution().solution(arr));
        System.out.println(new Solution().solution(arr));
    }


    static class Solution {
        public int diffSolution(int[] arr) {
            int answer = arr[0];
            for (int i = 1, g; i < arr.length; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
            return answer;
        }

        public int gcd(int a, int b) {
            if (a > b)
                return (a % b == 0) ? b : gcd(b, a % b);
            else
                return (b % a == 0) ? a : gcd(a, b % a);
        }

        public int solution(int[] arr) {
            int answer = 0;

            Arrays.sort(arr);
            int max = arr[arr.length - 1];
            int multiple = 1;

            while (answer == 0) {
                int temp = max * multiple;

                for (int i = 0; i < arr.length; i++) {
                    if (temp % arr[i] != 0) {
                        temp = 0;
                        break;
                    }
                }

                if (temp == 0) {
                    multiple++;
                    continue;
                }

                answer = temp;
            }

            return answer;
        }
    }
}
