package kr.co.programmers.monthly_code_challenge.season3;

public class AddMissingNumbers {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;

            for(int i = 0; i < 10; i++){
                answer += i;
            }

            for(int number : numbers){
                answer -= number;
            }

            return answer;
        }
    }
}
