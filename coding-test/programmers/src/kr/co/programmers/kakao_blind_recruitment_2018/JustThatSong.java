package kr.co.programmers.kakao_blind_recruitment_2018;

import java.util.Arrays;

public class JustThatSong {

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(new Solution().solution(m, musicinfos));
    }

    static class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";

            m = m.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");

            int theTime = 0;
            for (int i = 0; i < musicinfos.length; i++) {
                String[] infos = musicinfos[i].split(",");

                int[] sDate = Arrays.stream(infos[0].split(":")).mapToInt(x -> Integer.valueOf(x)).toArray();
                int[] eDate = Arrays.stream(infos[1].split(":")).mapToInt(x -> Integer.valueOf(x)).toArray();
                String title = infos[2];
                String sheet = infos[3].replace("C#", "c")
                        .replace("D#", "d")
                        .replace("F#", "f")
                        .replace("G#", "g")
                        .replace("A#", "a");

                int time = (eDate[0] - sDate[0]) * 60 + eDate[1] - sDate[1];
                while (time > sheet.length()) {
                    sheet += sheet;
                }

                sheet = sheet.substring(0, time);
                if (sheet.contains(m) && time > theTime) {
                    answer = title;
                    theTime = time;
                }
            }

            return answer;
        }
    }
}
