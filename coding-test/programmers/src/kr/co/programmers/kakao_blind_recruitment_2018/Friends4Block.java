package kr.co.programmers.kakao_blind_recruitment_2018;

public class Friends4Block {

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(new Solution().solution(m, n, board));
    }

    static class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            String[][] blocks = new String[m][n];
            boolean[][] deleted = new boolean[m][n];
            for(int i = 0; i < m; i++){
                blocks[i] = board[i].split("");
            }

            while(check(blocks, deleted)){
                remove(blocks, deleted);
                fill(blocks, deleted);
            }

            answer = count(blocks);
            return answer;
        }

        private boolean check(String[][] blocks, boolean[][] deleted){
            boolean changed = false;
            for(int i = 0; i < blocks.length - 1; i++){
                for(int j = 0; j < blocks[0].length - 1; j++){
                    if(!"".equals(blocks[i][j])
                            && blocks[i][j].equals(blocks[i][j + 1])
                            && blocks[i][j].equals(blocks[i + 1][j])
                            && blocks[i][j].equals(blocks[i + 1][j + 1])){
                        deleted[i][j] = deleted[i][j + 1] = deleted[i + 1][j] = deleted[i + 1][j + 1] = changed = true;
                    }
                }
            }

            return changed;
        }

        private void remove(String[][] blocks, boolean[][] deleted){
            for(int i = 0; i < blocks.length; i++){
                for(int j = 0; j < blocks[0].length; j++){
                    if(deleted[i][j]){
                        blocks[i][j] = "";
                    }
                }
            }
        }

        private void fill(String[][] blocks, boolean[][] deleted){
            for(int i = blocks.length - 1; i > 0; i--){
                for(int j = 0; j < blocks[0].length; j++){
                    if("".equals(blocks[i][j])){
                        for(int k = i - 1; k >= 0; k--){
                            if(!"".equals(blocks[k][j])){
                                blocks[i][j] = blocks[k][j];
                                blocks[k][j] = "";
                                deleted[i][j] = false;
                                deleted[k][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        private int count(String[][] blocks){
            int count = 0;
            for(int i = 0; i < blocks.length; i++){
                for(int j = 0; j < blocks[0].length; j++){
                    if(blocks[i][j].isEmpty()){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
