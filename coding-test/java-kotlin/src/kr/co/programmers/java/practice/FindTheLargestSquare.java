package kr.co.programmers.java.practice;

public class FindTheLargestSquare {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(new Solution().solution(board));
    }

    static class Solution{
        public int solution(int [][]board){
            int answer = 0;

            if(board.length == 1 || board[0].length == 1){
                for(int i = 0; i < board.length; i++){
                    for(int j = 0; i < board[0].length; j++){
                        if(board[i][j] == 1){
                            return 1;
                        }
                    }
                }
            }

            for(int i = 1; i < board.length; i++){
                for(int j = 1; j < board[0].length; j++){
                    if(board[i][j] == 0) continue;

                    board[i][j] = board[i][j] + Math.min(board[i-1][j] ,Math.min(board[i-1][j-1], board[i][j-1]));
                    answer = answer > board[i][j] ? answer : board[i][j];
                }
            }

            return answer * answer;
        }
    }
}
