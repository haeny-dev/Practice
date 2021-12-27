package kr.co.programmers.java.full_search;

import java.util.Arrays;

public class MockExam {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Solution().solution(answers)));
    }

    static class Solution {

        public int[] solution(int[] answers) {

            int[] answer = {0, 0, 0};

            int[] student1 = {1, 2, 3, 4, 5};
            int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] scores = {0, 0, 0};

            for(int i = 0; i < answers.length; i++){
                if(answers[i] == student1[i % student1.length]){
                    scores[0]++;
                }

                if(answers[i] == student2[i % student2.length]){
                    scores[1]++;
                }

                if(answers[i] == student3[i % student3.length]){
                    scores[2]++;
                }
            }

            int topScore = Arrays.stream(scores).max().getAsInt();

            int topScoreCnt = 0;

            for(int i = 0; i < scores.length; i++){
                System.out.println("student" + (i + 1) + " : " + scores[i]);
                if(scores[i] == topScore){
                    answer[i] = i + 1;
                    topScoreCnt++;
                }
            }

            answer = Arrays.stream(answer).sorted().filter(x -> x != 0).toArray();
            answer = Arrays.copyOf(answer, topScoreCnt);
            return answer;
        }

    }
}
