package kr.co.programmers.java.kakao_blind_recruitment_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MenuRenewal {

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(new Solution().solution(orders, course)));
    }

    static class Solution {
        public String[] solution(String[] orders, int[] course) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < course.length; i++){
                Map<String, Integer> map = new HashMap<>();
                for(int j = 0; j < orders.length; j++){
                    char[] orderChars = orders[j].toCharArray();
                    Arrays.sort(orderChars);
                    recursiveAddMenu(map, orderChars, "", course[i]);
                }

                int max = 2;
                String temp = "";
                for(Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        temp = " " + entry.getKey();
                        max = entry.getValue();
                    } else if(entry.getValue() == max){
                        temp += " " + entry.getKey();
                    }
                }

                result.append(temp);
            }

            String[] answer = result.toString().trim().split(" ");
            Arrays.sort(answer);
            return answer;
        }

        private void recursiveAddMenu(Map<String, Integer> map, char[] preOrderChars, String preMenu, int preCourse){
            if(preOrderChars.length < preCourse){
                return;
            }

            for(int i = 0; i < preOrderChars.length; i++){
                String menu = preMenu + preOrderChars[i];
                if(preCourse == 1){
                    map.put(menu, map.getOrDefault(menu, 0) + 1);
                    continue;
                }

                char[] orderChars = Arrays.copyOfRange(preOrderChars, i + 1, preOrderChars.length);
                int course = preCourse - 1;
                recursiveAddMenu(map, orderChars, menu, course);
            }
        }
    }
}
