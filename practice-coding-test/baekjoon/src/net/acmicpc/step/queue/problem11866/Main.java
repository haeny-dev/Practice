package net.acmicpc.step.queue.problem11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (idx % K == 0) {
                sb.append(n);

                if (queue.isEmpty()) {
                    sb.append(">");
                } else {
                    sb.append(", ");
                }

            } else {
                queue.add(n);
            }

            idx++;
        }

        System.out.println(sb);
    }
}
