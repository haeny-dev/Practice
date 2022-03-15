package net.acmicpc.step.recursive.problem11729;

import java.util.Scanner;

public class Main {

    private static int count = 0;

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        StringBuilder sb = new StringBuilder();
        tower(N, 1, 3, 2, sb);

        System.out.println(count);
        System.out.print(sb);
    }

    private static void tower(int N, int start, int end, int empty, StringBuilder sb) {

        if (N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            count++;
            return;
        }

        tower(N - 1, start, empty, end, sb);
        tower(1, start, end, empty, sb);
        tower(N - 1, empty, end, start, sb);


        /* layer4 1 -> 3 옮기기 */
        // layer 3개 1 -> 2 옮기기
            // layer2개 1 -> 3 옮기기
                // layer 1개 1 -> 2 옮기기
                // layer 1개 1 -> 3 옮기기
                // layer 1개 2 -> 3 옮기기
            // layer1개 1 -> 2 옮기기
            // layer2개 3 -> 2 옮기기
                // layer 1개 3 -> 1 옮기기
                // layer 1개 3 -> 2 옮기기
                // layer 1개 1 -> 2 옮기기

        // layer 1개 1 -> 3 옮기기

        // layer 3개 2 -> 3 옮기기
            // layer2개 2 -> 1 옮기기
            // layer1개 2 -> 3 옮기기
            // layer2개 2 -> 3 옮기기
    }
}
