package kr.co.programmers.java.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BiggestNumber {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String[] strings = new String[numbers.length];
            for(int i = 0; i < numbers.length; i++){
                strings[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
            return "0".equals(strings[0]) ? "0" : Arrays.stream(strings).collect(Collectors.joining());
        }
    }
}
