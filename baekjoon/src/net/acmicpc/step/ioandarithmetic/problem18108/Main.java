package net.acmicpc.step.ioandarithmetic.problem18108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final int difference = 2541 - 1998;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(br.readLine()) - difference);
    }
}
