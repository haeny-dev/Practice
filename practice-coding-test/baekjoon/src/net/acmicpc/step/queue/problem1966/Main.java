package net.acmicpc.step.queue.problem1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();

            int highestPriority = 1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());

                queue.add(new int[]{i, priority});

                if (priority > highestPriority) {
                    highestPriority = priority;
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] d = queue.poll();

                if (highestPriority == d[1]) {
                    count++;

                    if (d[0] == M) {
                        sb.append(count).append("\n");
                        break;
                    }

                    highestPriority = 1;
                    for (int[] doc : queue) {
                        if (doc[1] > highestPriority) {
                            highestPriority = doc[1];
                        }
                    }

                } else {
                    queue.add(d);
                }
            }
        }

        System.out.println(sb);
    }
}
