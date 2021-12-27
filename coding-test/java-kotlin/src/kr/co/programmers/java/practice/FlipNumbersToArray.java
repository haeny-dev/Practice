package kr.co.programmers.java.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlipNumbersToArray {

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(Arrays.toString(new Solution().solution(n)));
    }

    static class Solution {
        public int[] solution(long n) {
            List<String> sList = Arrays.asList(String.valueOf(n).split(""));
            Collections.reverse(sList);
            return sList.stream()
                    .mapToInt(x -> Integer.parseInt(x))
                    .toArray();
        }
    }
}
