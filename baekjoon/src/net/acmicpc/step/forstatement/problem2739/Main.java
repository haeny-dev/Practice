package net.acmicpc.step.forstatement.problem2739;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = System.in.read() - 48;
        for (int i = 1; i <= 9; i++) {
            bw.write(N + " * " + i + " = " + (N * i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
