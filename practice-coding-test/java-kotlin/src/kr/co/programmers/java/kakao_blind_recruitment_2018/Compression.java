package kr.co.programmers.java.kakao_blind_recruitment_2018;

import java.util.*;

public class Compression {

    public static void main(String[] args) {
        String msg = "KAKAO";
        System.out.println(Arrays.toString(new Solution().solution(msg)));
    }

    static class Solution {
        public int[] solution(String msg) {
            Map<String, Integer> dictionary = initialize();
            List<Integer> output = new ArrayList<>();
            compression(msg, dictionary, 27,  output);
            return output.stream().mapToInt(x -> x).toArray();
        }

        private void compression(String msg, Map<String, Integer> dictionary, int index, List<Integer> output){
            if(msg.isEmpty()){
                return;
            }

            String current = msg.substring(0, 1);
            int outputIdx = dictionary.get(current);

            while(!msg.isEmpty() && dictionary.containsKey(current)){
                outputIdx = dictionary.get(current);
                msg = msg.substring(1);

                if(!msg.isEmpty()){
                    current += msg.substring(0, 1);
                }
            }

            output.add(outputIdx);
            if(!msg.isEmpty()){
                dictionary.put(current, index);
                compression(msg, dictionary, ++index, output);
            }
        }

        private Map<String, Integer> initialize(){
            Map<String, Integer> map = new HashMap<>();
            int index = 0;
            for(int i = 65; i <= 90; i++){
                map.put(String.valueOf((char)i), ++index);
            }
            return map;
        }
    }
}
