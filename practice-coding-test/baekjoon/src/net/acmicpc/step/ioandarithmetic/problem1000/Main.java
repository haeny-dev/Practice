package net.acmicpc.step.ioandarithmetic.problem1000;


import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum()));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        try {
            int a = System.in.read() - 48;
            System.in.read();
            System.out.print(a + System.in.read() - 48);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
