package kr.co.programmers.java.kakao_winter_internship_2019;

import java.util.Stack;

public class CranePuppetGame {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(new Solution().solution(board, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            Stack<Integer> stack = new Stack<>();
            for(int pickNum : moves){

                int puppet = 0;

                for(int line = 0; line < board.length; line++){
                    if(board[line][pickNum - 1] != 0){
                        puppet = board[line][pickNum - 1];
                        board[line][pickNum - 1] = 0;
                        break;
                    }
                }

                if(puppet == 0) continue;

                if(stack.empty()){
                    stack.push(puppet);
                    continue;
                }

                if(stack.peek() == puppet){
                    stack.pop();
                    answer+= 2;
                } else {
                    stack.push(puppet);
                }
            }

            return answer;
        }
    }
}
