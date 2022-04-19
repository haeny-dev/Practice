package net.acmicpc.step.ioandarithmetic.problem1008;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double a = System.in.read() - 48;
        System.in.read();
        System.out.print(a / (double) (System.in.read() - 48));
    }
}
