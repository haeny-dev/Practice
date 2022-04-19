package net.acmicpc.step.forstatement.problem10871;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int x = Integer.parseInt(st.nextToken());
        bw.write(Arrays.stream(br.readLine().split(" "))
                .filter(n -> Integer.parseInt(n) < x)
                .collect(Collectors.joining(" ")));
        bw.flush();
        br.close();
        bw.close();
    }
}
