package kr.co.programmers.java.weekly_challenge;


import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("AAAAE"));
        System.out.println(new Solution().diffSolution("AAAAE"));
    }

    static class Solution {

        static List<String> list = new ArrayList<>();

        public int solution(String word) {
            dfs("", 0);
            return list.indexOf(word);
        }

        private void dfs(String str, int len) {
            if (len > 5) return;
            list.add(str);
            for (int i = 0; i < 5; i++) {
                dfs(str + "AEIOU".charAt(i), len + 1);
            }
        }

        public int diffSolution(String word) {
            int answer = 0;
            int per = 3905;
            for (String s : word.split("")) {
                answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
            }
            return answer;
        }
    }
}
