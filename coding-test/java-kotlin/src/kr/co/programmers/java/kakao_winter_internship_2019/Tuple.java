package kr.co.programmers.java.kakao_winter_internship_2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tuple {

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(new Solution().solution(s)));
    }

    static class Solution {
        public int[] solution(String s) {
            Map<String, Integer> map = new HashMap<>();
            String[] aArr = s.replace("}", "")
                    .replace("{", "")
                    .split(",");

            for(String key : aArr){
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            return map.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .map(Map.Entry::getKey)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
