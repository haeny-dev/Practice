package net.acmicpc.step.stack.problem4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = br.readLine();

            if (".".equals(readLine)) {
                System.out.println(sb);
                break;
            }

            sb.append(check(readLine)).append("\n");
        }
    }

    private static String check(String readLine) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < readLine.length(); i++) {
            char c = readLine.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {

                if (stack.isEmpty()) {
                    return "no";
                }

                char top = stack.pop();

                if (top != '(') {
                    return "no";
                }
            } else if (c == ']') {

                if (stack.isEmpty()) {
                    return "no";
                }

                char top = stack.pop();

                if (top != '[') {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
}
