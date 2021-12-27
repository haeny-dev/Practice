package kr.co.programmers.java.hash;

import java.util.Arrays;

public class PlayersWhoDidNotComplete {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(new Solution().solution(participant, completion));
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Arrays.sort(participant);
            Arrays.sort(completion);

            for(int i = 0; i < completion.length; i++){
                if(!participant[i].equals(completion[i])){
                    answer = participant[i];
                    break;
                }
            }

            if(answer.isEmpty()) {
                answer = participant[participant.length - 1];
            }

            return answer;
        }
    }
}
