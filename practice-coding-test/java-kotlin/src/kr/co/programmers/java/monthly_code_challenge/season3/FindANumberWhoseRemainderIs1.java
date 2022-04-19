package kr.co.programmers.java.monthly_code_challenge.season3;

public class FindANumberWhoseRemainderIs1 {

    public static void main(String[] args) {

    }

    static class Solution{

        public int solution(int n){
            int answer;

            for(answer = 1; answer < n - 1; answer++){
                if(n%answer == 1) return answer;
            }

            return answer;
        }
    }
}
