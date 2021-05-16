package kr.co.programmers.monthly_code_challenge.season2;

public class NumberAndAdditionOfFactors {

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(new Solution().solution(left, right));
    }

    static class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for(int num = left; num <= right; num++){
                int count = 0;

                for(int d = 1, mok = num; d <= mok; d++){
                    if(num % d == 0){
                        mok = num/d;

                        if(d != mok){
                            count++;
                        }

                        count++;
                    }
                }

                if(count%2 == 0){
                    answer += num;
                } else {
                    answer -= num;
                }
            }
            return answer;
        }
    }
}
