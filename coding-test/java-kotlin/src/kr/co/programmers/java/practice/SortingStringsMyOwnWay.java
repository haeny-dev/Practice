package kr.co.programmers.java.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingStringsMyOwnWay {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(new Solution().solution(strings, n));
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};
            Arrays.sort(strings);
            return Arrays.stream(strings)
                    .sorted(Comparator.comparingInt(x -> x.charAt(n)))
                    .collect(Collectors.toList())
                    .toArray(answer);
        }
    }
}
