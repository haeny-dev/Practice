package kr.co.programmers.java.summer_winter_coding_2018;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EndToEndEnglish {

    public static void main(String[] args) {
//        int n = 5;
//        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n = 2;
        String[] words = {"eqwe", "qwe", "eqwe"};
        System.out.println(Arrays.toString(new Solution().solution(n, words)));
    }

    static class Solution{

        public int[] solution(int n, String[] words){
            int[] answer = {0, 0};

            String prefix = String.valueOf(words[0].charAt(0));
            Set<String> preWords = new HashSet<>();

            for(int i = 1; i <= words.length; i++){
                if(!words[i - 1].startsWith(prefix) || preWords.contains(words[i - 1])){
                    int number = i%n == 0 ? n :i%n;
                    int round = i%n == 0 ? i/n : i/n + 1;

                    answer[0] = number;
                    answer[1] = round;
                    return answer;
                }
                preWords.add(words[i - 1]);
                prefix = String.valueOf(words[i - 1].charAt(words[i - 1].length() - 1));
            }

            return answer;
        }
    }
}
