import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        
        //record 문자열 변경 기록
        //최종적으로 방을 개설한 사람이 보게되는 메시지 배열형태로 return
        Map<String, String> map = new HashMap<>();
        List<String[]> history = new ArrayList<>();
        int cnt = 0; //change count
        
        for(int i = 0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String check = st.nextToken();
            
            if(check.equals("Enter")){
                String uid = st.nextToken();
                String nickname = st.nextToken();
                
                if(map.containsKey(uid)){
                    map.replace(uid, nickname);
                } else {
                    map.put(uid, nickname);
                }
                // System.out.println(uid+" "+nickname+"들어옴");
                history.add(new String[]{uid, "님이 들어왔습니다."});
                
            } else if(check.equals("Leave")){
                String uid = st.nextToken();
                // System.out.println(uid+"나감");
                history.add(new String[]{uid, "님이 나갔습니다."});
                
            } else if(check.equals("Change")){
                cnt++;
                String uid = st.nextToken();
                String nickname = st.nextToken();
                
                map.replace(uid, nickname);
            }
        }
        
        String[] answer = new String[history.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = map.get(history.get(i)[0]) + history.get(i)[1];
            // System.out.println(answer[i]);
            
        }
        
        return answer;
    }
}