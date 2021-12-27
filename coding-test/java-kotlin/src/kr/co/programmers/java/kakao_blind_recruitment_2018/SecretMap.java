package kr.co.programmers.java.kakao_blind_recruitment_2018;

import java.util.Arrays;

public class SecretMap {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(new Solution().solution(n, arr1, arr2)));
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for(int i = 0; i < n; i++){
                String row = "";
                int count = 0;
                int mok1 = arr1[i];
                int mok2 = arr2[i];

                while(count < n){
                    String temp = "#";
                    if(mok1%2 == 0 && mok2%2 == 0){
                        temp = " ";
                    }

                    row = temp + row;
                    mok1 = mok1/2;
                    mok2 = mok2/2;
                    count++;
                }
                answer[i] = row;
            }

            return answer;
        }
    }
}
