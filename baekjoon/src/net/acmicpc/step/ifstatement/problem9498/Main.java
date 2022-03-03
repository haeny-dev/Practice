package net.acmicpc.step.ifstatement.problem9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if (a >= 90) {
            System.out.print("A");
        } else if (a >= 80) {
            System.out.print("B");
        } else if (a >= 70) {
            System.out.print("C");
        } else if (a >= 60) {
            System.out.print("D");
        } else {
            System.out.print("F");
        }
    }
}
