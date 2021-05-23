package kr.co.programmers.kakao_blind_recruitment_2018;

public class DartsGame {

    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        System.out.println(new Solution().solution(dartResult));
    }

    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int[] points = new int[3];

            String[] strPoints = dartResult.replaceAll("[^0-9]", " ").replace("  ", " ").split(" ");
            String[] temp = dartResult.replaceAll("[0-9]", " ").trim().replace("  ", " ").split(" ");

            for(int i = 0; i < 3; i++){
                int bonus = 0;
                String option = "";

                points[i] = Integer.parseInt(strPoints[i]);

                if(temp[i].length() > 1){
                    option = temp[i].substring(1);
                    temp[i] = temp[i].substring(0, 1);
                }

                if("S".equals(temp[i])){
                    bonus = 1;
                } else if("D".equals(temp[i])){
                    bonus = 2;
                } else {
                    bonus = 3;
                }

                points[i] = (int) Math.pow(points[i], bonus);

                if("*".equals(option)){
                    if(i > 0){
                        points[i-1] = points[i-1] * 2;
                    }

                    points[i] = points[i] * 2;
                } else if("#".equals(option)){
                    points[i] = points[i] * -1;
                }
            }

            for(int point : points){
                answer += point;
            }

            return answer;
        }
    }
}
