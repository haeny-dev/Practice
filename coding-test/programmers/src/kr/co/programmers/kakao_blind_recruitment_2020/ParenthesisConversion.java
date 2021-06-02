package kr.co.programmers.kakao_blind_recruitment_2020;

public class ParenthesisConversion {

    public static void main(String[] args) {
        String p = "(()())()";
        System.out.println(new Solution().solution(p));
    }

    static class Solution {
        public String solution(String p) {
            if(isProperBracket(p)){
                return p;
            }

            return recursiveConvert(p);
        }

        private String recursiveConvert(String w) {
            if (w.isEmpty()) return w;

            String u = "";
            String v = "";
            int flag = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) == '(') {
                    flag++;
                } else if (w.charAt(i) == ')') {
                    flag--;
                }

                if (flag == 0) {
                    u = w.substring(0, i + 1);
                    v = w.substring(i + 1);
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isProperBracket(u)) {
                result.append(u).append(recursiveConvert(v));
            } else {
                result.append("(")
                        .append(recursiveConvert(v))
                        .append(")");

                u = u.substring(1, u.length()-1)
                        .replace("(", "[")
                        .replace(")", "(")
                        .replace("[", ")");

                result.append(u);
            }

            return result.toString();
        }


        private boolean isProperBracket(String s) {
            int flag = 0;
            for (char bracket : s.toCharArray()) {
                if (bracket == '(') {
                    flag++;
                } else {
                    flag--;
                }

                if (flag < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
