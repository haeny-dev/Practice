package net.acmicpc.step.ioandarithmetic.problem10171;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            bw.write("\\    /\\\n");
            bw.write(" )  ( ')\n");
            bw.write("(  /  )\n");
            bw.write(" \\(__)|\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
