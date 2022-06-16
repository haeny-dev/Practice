package net.acmicpc.step.stack.problem9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.append(isVPS(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    private static String isVPS(String ps) {
        int flag = 0;

        for (int i = 0; i < ps.length(); i++) {
            char c = ps.charAt(i);
gi
            if (c == '(') {
                flag++;
            } else {
                flag--;
            }

            if (flag < 0) {
                return "NO";
            }
        }

        return flag == 0 ? "YES" : "NO";
    }
}
