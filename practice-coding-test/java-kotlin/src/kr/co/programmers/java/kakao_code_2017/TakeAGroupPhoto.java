package kr.co.programmers.java.kakao_code_2017;

public class TakeAGroupPhoto {

    public static void main(String[] args) {
        int n = 2;
        String[] datas = {"N~F=0", "R~T>2"};
        System.out.println(new Solution().solution(n, datas));
    }

    static class Solution {

        private int answer = 0;
        private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

        public int solution(int n, String[] datas) {
            boolean[] isVisited = new boolean[8];
            String sortedFriends = "";
            dfs(isVisited, sortedFriends, datas);
            return answer;
        }

        private void dfs(boolean[] isVisited, String sortedFriends, String[] datas){

            if(sortedFriends.length() > 7){
                if(check(sortedFriends, datas)){
                    answer++;
                }
            }

            for(int i = 0; i < 8; i++){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    String nextSortedFriends = sortedFriends + friends[i];
                    dfs(isVisited, nextSortedFriends, datas);
                    isVisited[i] = false;
                }
            }
        }

        private boolean check(String sortedFriends, String[] datas){
            for(String data : datas){
                int friendsPosition1 = sortedFriends.indexOf(data.charAt(0));
                int friendsPosition2 = sortedFriends.indexOf(data.charAt(2));

                int distance = Math.abs(friendsPosition1 - friendsPosition2) - 1;

                String conditionKey = String.valueOf(data.charAt(3));
                int conditionValue = Integer.parseInt(String.valueOf(data.charAt(4)));

                if("=".equals(conditionKey) && distance == conditionValue){
                } else if ("<".equals(conditionKey) && distance < conditionValue){
                } else if (">".equals(conditionKey) && distance > conditionValue){
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
