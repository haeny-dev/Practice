package net.acmicpc.step.bruteforce.problem1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [][] board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (chars[j] == 'W') {
                    board[i][j] = true;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt = getConvertBoardCnt(board, i, j);
                if (cnt < min) {
                    min = cnt;
                }
            }
        }
        System.out.print(min);
    }

    private static int getConvertBoardCnt(boolean[][] board, int x, int y) {
        int cnt = 0;
        boolean isColorWhite = board[x][y];
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != isColorWhite) {
                    cnt++;
                }

                isColorWhite = !isColorWhite;
            }
            isColorWhite = !isColorWhite;
        }
        return Math.min(cnt, 64 - cnt);
    }
}
