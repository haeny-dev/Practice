package net.acmicpc.step.recursive.problem2447;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        char[][] starRectangle = new char[N][N];
        recursiveStarRec(0, 0, N, false, starRectangle);

        StringBuilder sb = new StringBuilder();
        for (char[] chars : starRectangle) {
            sb.append(chars).append("\n");
        }
        System.out.print(sb);
    }

    private static void recursiveStarRec(int startX, int startY, int recSize, boolean isBlank, char[][] starRectangle) {

        if (isBlank) {
            for (int i = startX; i < startX + recSize; i++) {
                for (int j = startY; j < startY + recSize; j++) {
                    starRectangle[i][j] = ' ';
                }
            }
            return;
        }

        if (recSize == 1) {
            starRectangle[startX][startY] = '*';
            return;
        }

        int unitRecSize = recSize / 3;
        int index = 0;
        for (int i = startX; i < startX + recSize; i += unitRecSize) {
            for (int j = startY; j < startY + recSize; j += unitRecSize) {
                index++;
                recursiveStarRec(i, j, unitRecSize, index == 5, starRectangle);
            }
        }
    }
}
