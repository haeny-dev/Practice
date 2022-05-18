package net.acmicpc.step.set_and_map.problem1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> notHeardSeen = new TreeSet<>();
        Set<String> notHeard = new HashSet<>();

        while (N-- > 0) {
            notHeard.add(br.readLine());
        }

        while (M-- > 0) {
            String notSeen = br.readLine();
            if (notHeard.contains(notSeen)) {
                notHeardSeen.add(notSeen);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(notHeardSeen.size()).append("\n");
        notHeardSeen.forEach(x -> sb.append(x).append("\n"));

        System.out.println(sb);
    }
}
