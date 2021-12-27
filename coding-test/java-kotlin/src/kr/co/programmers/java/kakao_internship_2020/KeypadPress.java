package kr.co.programmers.java.kakao_internship_2020;

public class KeypadPress {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(new Solution().solution(numbers, hand));
    }

    static class Solution {
        public String solution(int[] numbers, String hand) {

            StringBuilder answer = new StringBuilder();

            String leftLineNumbers = "147";
            String rightLineNumbers = "369";
            String middleLineNumbers = "2580";

            int[] leftHand = {0, 3};
            int[] rightHand = {2, 3};

            for(int i = 0; i < numbers.length; i++){

                String num = String.valueOf(numbers[i]);

                if(leftLineNumbers.contains(num)){
                    leftHand[0] = 0;
                    leftHand[1] = leftLineNumbers.indexOf(num);
                    answer.append("L");
                    continue;
                }

                if(rightLineNumbers.contains(num)){
                    rightHand[0] = 2;
                    rightHand[1] = rightLineNumbers.indexOf(num);
                    answer.append("R");
                    continue;
                }

                int leftHandDistance = Math.abs(leftHand[0] - 1) + Math.abs(leftHand[1] - middleLineNumbers.indexOf(num));
                int rightHandDistance = Math.abs(rightHand[0] - 1) + Math.abs(rightHand[1] - middleLineNumbers.indexOf(num));

                int difference = leftHandDistance - rightHandDistance;

                if(difference > 0 || (difference == 0 && "right".equals(hand))){
                    rightHand[0] = 1;
                    rightHand[1] = middleLineNumbers.indexOf(num);
                    answer.append("R");
                } else if(leftHandDistance - rightHandDistance < 0 || (difference == 0 && "left".equals(hand))){
                    leftHand[0] = 1;
                    leftHand[1] = middleLineNumbers.indexOf(num);
                    answer.append("L");
                }

            }

            return answer.toString();
        }

    }
}
