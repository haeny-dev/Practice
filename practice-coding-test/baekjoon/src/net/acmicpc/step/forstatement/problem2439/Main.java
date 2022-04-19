package net.acmicpc.step.forstatement.problem2439;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        for (int i = n - 1; i >= 0; i--) {
            sb.replace(i, i + 1, "*");
            bw.write(sb + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
