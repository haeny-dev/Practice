package net.acmicpc.step.problem1001;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int a = System.in.read() - 48;
        System.in.read();
        System.out.print(a - (System.in.read() - 48));
    }
}
