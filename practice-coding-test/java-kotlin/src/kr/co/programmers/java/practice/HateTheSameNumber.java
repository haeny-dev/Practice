package kr.co.programmers.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HateTheSameNumber {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(new Solution().solution(arr)));
    }

    static class Solution {

        public int[] solution(int[] arr) {
            int[] answer = {};

            int count = 0;

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                if(i==0) {
                    count++;
                    list.add(arr[i]);
                    continue;
                }

                if(arr[i-1] != arr[i]){
                    list.add(arr[i]);
                    count++;
                }
            }
            answer = new int[count];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i).intValue();
            }

            return answer;
        }
    }
}
