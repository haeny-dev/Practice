package kr.co.programmers.java.practice;

public class Average {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new Solution().solution(arr));
    }

    static class Solution {
        public double solution(int[] arr) {
            double sum = 0;
            for(int n : arr){
                sum += n;
            }

            return sum / arr.length;
        }
    }
}
