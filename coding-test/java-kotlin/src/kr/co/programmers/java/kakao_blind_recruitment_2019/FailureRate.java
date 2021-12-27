package kr.co.programmers.java.kakao_blind_recruitment_2019;

import java.util.*;

public class FailureRate {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(new Solution().solution(N, stages)));
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] total = new int[N+1];
            int[] notClear = new int[N+1];
            TreeMap<Double, List<Integer>> failRateMap =
                    new TreeMap<>(Collections.reverseOrder());

            for(int user : stages){
                for(int i = 0; i < user; i++){
                    total[i]++;
                }

                notClear[user-1]++;
            }

            for(int i = 0; i < N; i++){
                List<Integer> tempList;

                if(total[i] == 0){
                    tempList = failRateMap.getOrDefault(0.0, new ArrayList<>());
                    tempList.add(i+1);
                    failRateMap.put(0.0, tempList);
                    continue;
                }

                double failRate = (double)notClear[i] / (double)total[i];
                tempList = failRateMap.getOrDefault(failRate, new ArrayList<>());
                tempList.add(i+1);
                failRateMap.put(failRate, tempList);
            }

            return failRateMap.entrySet().stream()
                    .flatMap(x -> x.getValue().stream())
                    .mapToInt(i -> i)
                    .toArray();
        }
    }
}
