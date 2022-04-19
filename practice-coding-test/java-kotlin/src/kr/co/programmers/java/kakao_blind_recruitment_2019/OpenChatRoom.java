package kr.co.programmers.java.kakao_blind_recruitment_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChatRoom {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new Solution().solution(record)));
    }

    static class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> codeMap = new HashMap<String, String>();
            codeMap.put("enter","들어왔습니다.");
            codeMap.put("leave","나갔습니다.");

            HashMap<String, String> uidMap = new HashMap<String, String>();
            List<String> list = new ArrayList<String>();
            for(String str:record){
                String[] split = str.split("\\s+");
                String code = split[0];
                String uid = split[1];
                if(split.length > 2) {
                    String name = split[2];
                    uidMap.put(uid, name);
                }
                if(!"Change".equalsIgnoreCase(code)){
                    list.add(code +" "+uid);
                }

            }
            String[] answer = new String[list.size()];
            for(int i=0;i<answer.length;i++){
                String[] split = list.get(i).split("\\s+");
                String name = uidMap.get(split[1]);
                answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
            }

            return answer;
        }
    }
}
