package net.acmicpc.step.recursive.problem10870;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        System.out.print(fibo(N));
    }

    private static int fibo(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return fibo(N - 1) + fibo(N - 2);
    }
}
