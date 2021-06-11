package kr.co.programmers.kakao_blind_recruitment_2019;

import java.util.ArrayList;
import java.util.HashSet;

public class CandidateKey {

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(new Solution().solution(relation));
    }

    static class Solution {
        public int solution(String[][] relation) {
            ArrayList<Integer> candidateKey = new ArrayList<>();

            for (int comb = 1; comb < (1 << relation[0].length); comb++) {
                if (!isMinimal(comb, candidateKey)) {
                    continue;
                }

                if (isUnique(comb, relation)) {
                    candidateKey.add(comb);
                }
            }

            return candidateKey.size();
        }

        private boolean isUnique(int comb, String[][] relation) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder value = new StringBuilder();
                for (int j = 0; j < relation[0].length; j++) {
                    if ((comb & (1 << j)) > 0) {
                        value.append(relation[i][j]);
                    }
                }

                if (set.contains(value.toString())) {
                    return false;
                } else {
                    set.add(value.toString());
                }
            }

            return true;
        }

        private boolean isMinimal(int comb, ArrayList<Integer> candidateKey) {
            for (int key : candidateKey) {
                if ((key & comb) == key) return false;
            }

            return true;
        }
    }
}
