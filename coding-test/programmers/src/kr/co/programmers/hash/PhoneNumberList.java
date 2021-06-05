package kr.co.programmers.hash;

import java.util.Arrays;

public class PhoneNumberList {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(new Solution().solution(phone_book));
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            String text = String.format(" %s", String.join(" ", phone_book));
            return !Arrays.stream(phone_book)
                    .anyMatch(s -> text.split(String.format(" %s", s)).length > 2);
        }
    }
}
