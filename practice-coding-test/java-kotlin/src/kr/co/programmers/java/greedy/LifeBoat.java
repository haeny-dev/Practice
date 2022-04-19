package kr.co.programmers.java.greedy;

import java.util.Arrays;

public class LifeBoat {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(new Solution().solution(people, limit));
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int i = 0, j = people.length - 1;
            for (; i < j; --j) {
                if (people[i] + people[j] <= limit)
                    ++i;
            }
            return people.length - i;
        }
    }
}
