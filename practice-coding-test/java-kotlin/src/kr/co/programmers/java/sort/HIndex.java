package kr.co.programmers.java.sort;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new Solution().solution(citations));
    }

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);

            for(int i = citations.length-1; i > -1; i--){
                if((citations.length - i) <= citations[i]){
                    answer = (citations.length - i);
                }
            }

            return answer;
        }
    }
}
