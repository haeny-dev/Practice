package net.acmicpc.step.geometry.problem3053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double R = in.nextDouble();
        in.close();

        System.out.println(Math.PI * R * R);
        System.out.println(2 * R * R);
    }
}
