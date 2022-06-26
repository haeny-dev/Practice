package net.acmicpc.step.queue.problem10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.StringTokenizer;

public class Main {

    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = -1;
            if (st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
            }

            execute(command, value).ifPresent(x -> sb.append(x).append("\n"));
        }

        System.out.println(sb);
    }

    private static Optional<Integer> execute(String command, int value) {
        if ("push_front".equals(command)) {
            deque.addFirst(value);
            return Optional.empty();
        } else if ("push_back".equals(command)) {
            deque.addLast(value);
            return Optional.empty();
        } else if ("pop_front".equals(command) && !deque.isEmpty()) {
            return Optional.of(deque.pollFirst());
        } else if ("pop_back".equals(command) && !deque.isEmpty()) {
            return Optional.of(deque.pollLast());
        } else if ("size".equals(command)) {
            return Optional.of(deque.size());
        } else if ("empty".equals(command)) {
            return Optional.of(deque.isEmpty() ? 1 : 0);
        } else if ("front".equals(command) && !deque.isEmpty()) {
            return Optional.of(deque.peekFirst());
        } else if ("back".equals(command) && !deque.isEmpty()) {
            return Optional.of(deque.peekLast());
        } else {
            return Optional.of(-1);
        }
    }
}
