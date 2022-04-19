package net.acmicpc.step.array.problem8958;

import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int point = 0;
            int score = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == 'O') {
                    score += ++point;
                } else {
                    point = 0;
                }
            }
            bw.write(score + "\n");
        }
        bw.flush();
    }
}
