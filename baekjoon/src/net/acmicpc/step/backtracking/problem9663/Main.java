package net.acmicpc.step.backtracking.problem9663;

import java.util.Scanner;

public class Main {

    private static int[] arr;
    private static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr = new int[N];

        nQueen(N, 0);
        System.out.print(count);
    }

    private static void nQueen(int N, int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (ableToPutQueen(depth)) {
                nQueen(N, depth + 1);
            }
        }
    }

    private static boolean ableToPutQueen(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
