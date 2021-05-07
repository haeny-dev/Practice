package kr.co.programmers.greedy;

public class GymSuit {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(new Solution().solution(n, lost, reserve));
    }

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            int answer = 0;
            int[] students = new int[n];

            for(int l : lost) students[l-1]--;

            for(int r : reserve) students[r-1]++;

            for(int i = 0; i < students.length; i++){
                if(students[i] == -1){
                    if(i > 0 && students[i-1] > 1){
                        students[i-1]--;
                        students[i]++;
                        answer++;
                        continue;
                    }

                    if(i < students.length - 1 && students[i+1] > 1){
                        students[i+1]--;
                        students[i]++;
                        answer++;
                        continue;
                    }
                }
                answer++;
            }

            return answer;
        }
    }
}
