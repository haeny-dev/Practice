package kr.co.programmers.summer_winter_coding_2018;

public class SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new Solution().solution(skill, skill_trees));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            String regex = "[^" + skill + "]";
            for(String skill_tree : skill_trees){
                skill_tree = skill_tree.replaceAll(regex, "");
                if(skill.startsWith(skill_tree)){
                    answer++;
                }
            }
            return answer;
        }
    }
}
