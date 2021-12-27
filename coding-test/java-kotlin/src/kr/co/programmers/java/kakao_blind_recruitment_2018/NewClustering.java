package kr.co.programmers.java.kakao_blind_recruitment_2018;

import java.util.HashMap;
import java.util.Map;

public class NewClustering {

    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(new Solution().solution(str1, str2));
    }

    static class Solution {
        public int solution(String str1, String str2) {
            Map<String, int[]> map = new HashMap<>();

            for(int i = 0; i < str1.length() - 1; i++){
                String element = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i + 1));
                if(element.matches("^[a-zA-Z]*$")){
                    element = element.toUpperCase();
                    int[] cnts = map.getOrDefault(element, new int[2]);
                    cnts[0] = cnts[0] + 1;
                    map.put(element, cnts);
                }
            }

            for(int i = 0; i < str2.length() - 1; i++){
                String element = String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i + 1));
                if(element.matches("^[a-zA-Z]*$")){
                    element = element.toUpperCase();
                    int[] cnts = map.getOrDefault(element, new int[2]);
                    cnts[1] = cnts[1] + 1;
                    map.put(element, cnts);
                }
            }

            if(map.size() == 0){
                return 65536;
            }

            int in = 0;
            int union = 0;
            for (int[] value : map.values()) {
                if(value[0] > value[1]){
                    in += value[1];
                    union += value[0];
                    continue;
                }

                in += value[0];
                union += value[1];
            }

            return (int) ((double)in/(double) union * 65536);
        }
    }
}
