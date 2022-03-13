package kr.co.programmers.practice;

public class NextBigNumber {

    public static void main(String[] args) {
        int n = 78;
        System.out.println(new Solution().solution2(n));
    }

    static class Solution{

        // 시간 초과
        public int solution(int n){
            int count = getCountOneInBinaryString(n);
            while (count != getCountOneInBinaryString(++n)) {}
            return n;
        }

        private int getCountOneInBinaryString(int n) {
            return Integer.toBinaryString(n).replaceAll("0", "").length();
        }

        public int solution2(int n) {
            int count = getCountOneInBinaryString2(n);
            while(count != getCountOneInBinaryString2(++n)){}
            return n;
        }

        private int getCountOneInBinaryString2(int n) {
            int count = 0;
            String binaryString = Integer.toBinaryString(n);
            for (char c : binaryString.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            return count;
        }
    }
}
