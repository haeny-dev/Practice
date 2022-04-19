package net.acmicpc.step.recursive.problem10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.print(factorial(N));
    }

    private static int factorial(int N) {
        if(N == 0) return 1;
        return N * factorial(--N);
    }
}
