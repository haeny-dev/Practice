package net.acmicpc.step.set_and_map.problem1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (nA-- > 0) {
            set.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (nB-- > 0) {
            String token = st.nextToken();
            if (set.contains(token)) {
                set.remove(token);
            } else {
                set.add(token);
            }
        }

        System.out.println(set.size());
    }
}
