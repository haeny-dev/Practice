package kr.co.programmers.practice;

public class HashadNumber {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(new Solution().solution(x));
    }

    static class Solution {
        public boolean solution(int x) {
            int sum = 0;
            int mok = x;
            while(mok != 0) {
                sum += mok % 10;
                mok = mok / 10;
            }
            return x % sum == 0;
        }
    }
}
