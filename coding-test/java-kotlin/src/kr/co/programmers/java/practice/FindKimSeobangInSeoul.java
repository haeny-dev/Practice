package kr.co.programmers.java.practice;

import java.util.Arrays;

public class FindKimSeobangInSeoul {

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        System.out.println(new Solution().solution(seoul));
    }

    static class Solution {
        public String solution(String[] seoul) {
            //x에 김서방의 위치를 저장하세요.
            int x = Arrays.asList(seoul).indexOf("Kim");

            return "김서방은 "+ x + "에 있다";
        }
    }
}
