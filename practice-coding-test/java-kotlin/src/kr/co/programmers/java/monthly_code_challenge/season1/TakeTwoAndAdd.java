package kr.co.programmers.java.monthly_code_challenge.season1;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class TakeTwoAndAdd {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            TreeSet<Integer> treeSet = new TreeSet<>();

            for(int i = 0; i < numbers.length; i++){
                for(int j = i+1; j < numbers.length; j++){
                    treeSet.add(numbers[i] + numbers[j]);
                }
            }

            return treeSet.stream().flatMapToInt(x -> IntStream.of(x.intValue())).toArray();
        }
    }
}
