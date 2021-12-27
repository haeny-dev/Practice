package kr.co.programmers.java.practice;

import java.util.Arrays;
import java.util.TreeSet;

public class DivisibleArrayOfNumbers {

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(Arrays.toString(new Solution().solution(arr, divisor)));
    }

    static class Solution {
        public int[] solution(int[] arr, int divisor) {
            TreeSet<Integer> integerSet = new TreeSet<>();

            for (int a : arr){
                if ( a % divisor == 0){
                    integerSet.add(a);
                }
            }

            if(integerSet.isEmpty()){
                integerSet.add(-1);
            }

            return integerSet.stream().mapToInt(x -> x).toArray();
        }
    }
}
