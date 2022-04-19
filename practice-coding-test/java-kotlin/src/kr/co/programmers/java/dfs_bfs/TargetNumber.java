package kr.co.programmers.java.dfs_bfs;

public class TargetNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new Solution().solution(numbers, target));
    }

    static class Solution {

        private int answer = 0;

        public int solution(int[] numbers, int target) {
            int[] visitCodes = new int[numbers.length];
            dfs(numbers, visitCodes, 0, 0, target);
            return answer;
        }

        private void dfs(int[] numbers, int[] visitCodes, int i, int sum, int target) {
            if(i == numbers.length){
                if(sum == target){
                    answer++;
                }
                return;
            }

            while(visitCodes[i] < 2){
                if(visitCodes[i] == 0){
                    visitCodes[i]++;
                    int nextSum = sum + numbers[i];
                    dfs(numbers, visitCodes, i + 1, nextSum, target);
                } else if (visitCodes[i] == 1){
                    visitCodes[i]++;
                    int nextSum = sum - numbers[i];
                    dfs(numbers, visitCodes, i + 1, nextSum, target);
                }
            }
            visitCodes[i] = 0;
        }
    }
}
