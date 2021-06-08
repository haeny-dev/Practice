package kr.co.programmers.full_search;

import java.util.HashSet;

public class FindPrimeNumber {

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        private HashSet<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;

            String[] numArr = numbers.split("");
            boolean[] isVisited = new boolean[numArr.length];
            dfs(numArr, isVisited, "");

            for(int number : set){
                if(number == 0) continue;
                if(number == 1) continue;
                if(number != 2 && number % 2 == 0) continue;

                answer++;
                for(int i = 3; i < number/2; i += 2){
                    if(number % i == 0){
                        answer--;
                        break;
                    }
                }
            }

            return answer;
        }

        private void dfs(String[] numArr, boolean[] isVisited, String targetNum) {
            if(!"".equals(targetNum)){
                set.add(Integer.parseInt(targetNum));
            }

            for(int i = 0; i < numArr.length; i++){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    String nextTargetNum = targetNum + numArr[i];
                    dfs(numArr, isVisited, nextTargetNum);
                    isVisited[i] = false;
                }
            }
        }
    }
}
