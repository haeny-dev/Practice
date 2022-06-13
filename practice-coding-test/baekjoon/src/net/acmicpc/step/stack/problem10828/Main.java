package net.acmicpc.step.stack.problem10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if ("push".equals(command)) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(command)) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } else if ("size".equals(command)) {
                sb.append(stack.size()).append("\n");
            } else if ("empty".equals(command)) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if ("top".equals(command)) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
