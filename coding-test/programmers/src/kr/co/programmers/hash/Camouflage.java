package kr.co.programmers.hash;

import java.util.HashMap;

public class Camouflage {

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
        };

        System.out.println(new Solution().solution(clothes));
    }

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            HashMap<String, Integer> map = new HashMap<>();
            for (String[] cloth : clothes) {
                map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
            }

            for (int value : map.values()) {
                answer *= (value + 1);
            }

            return answer - 1;
        }
    }
}
