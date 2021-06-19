package kr.co.programmers.kakao_blind_recruitment_2018;

import java.util.ArrayList;

public class Cache {

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(new Solution().solution(cacheSize, cities));
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            ArrayList<String> cache = new ArrayList<>();
            for(int i = 0; i < cities.length; i++){
                String element = cities[i].toLowerCase();
                if(cache.contains(element)){
                    answer += 1;
                    cache.remove(element);
                    cache.add(element);
                    continue;
                }

                answer += 5;
                cache.add(element);
                if(cache.size() > cacheSize){
                    cache.remove(0);
                }
            }

            return answer;
        }
    }
}
