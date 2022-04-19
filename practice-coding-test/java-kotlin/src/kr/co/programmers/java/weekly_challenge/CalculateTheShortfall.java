package kr.co.programmers.java.weekly_challenge;

public class CalculateTheShortfall {

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(new Solution().solution(price, money, count));
    }

    static class Solution {
        public long solution(int price, int money, int count) {
            long answer = money;

            for(int i = 0; i < count; i++){
                answer -= price * (i+1);
            }

            return answer < 0 ? Math.abs(answer) : 0;
        }
    }
}
