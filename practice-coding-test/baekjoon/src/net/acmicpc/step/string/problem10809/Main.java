package net.acmicpc.step.string.problem10809;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        for (int i = 97; i < 123; i++) {
            bw.write(s.indexOf((char) i) + " ");
        }

        bw.flush();
    }
}
