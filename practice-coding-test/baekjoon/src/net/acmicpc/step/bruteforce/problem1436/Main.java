package net.acmicpc.step.bruteforce.problem1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        int num = 666;
        int count = 1;
        while (count != N) {
            num++;
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.print(num);
    }
}
