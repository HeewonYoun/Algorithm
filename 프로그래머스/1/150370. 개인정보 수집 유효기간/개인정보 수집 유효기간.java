import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        StringTokenizer st = new StringTokenizer(today,".");
        int[] today_date = new int[3]; // 오늘 년, 월, 일
        for(int i = 0; i<3; i++){
            today_date[i] = Integer.parseInt(st.nextToken());       
        }
        //System.out.println(Arrays.toString(today_date));
        
        //약관 나누기, Hashmap에 저장
        HashMap<String, Integer> termMap = new HashMap<>();
        String tmp = "";
        int tmp2;
        
        for(int i = 0; i<terms.length; i++){
            st = new StringTokenizer(terms[i]);
            tmp = st.nextToken(); //약관명
            tmp2 = Integer.parseInt(st.nextToken()); //약관기간
            
            termMap.put(tmp, tmp2);
        }
        // System.out.println(termMap);
        
        int cnt = 0; //파기해야 할 개인정보 개수
        List<Integer> list = new ArrayList<>(); //파기해야 하는거 번호
        
        //유효기간 확인
        for(int i = 0; i<privacies.length; i++){
            //날짜, 약관종류 변수에 저장
            int year = 0, month = 0, day = 0;
            st = new StringTokenizer(privacies[i]); //날짜, 약관 종류 나누기
            //날짜 년월일 나누기
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),".");
            year = Integer.parseInt(st2.nextToken());
            month = Integer.parseInt(st2.nextToken());
            day = Integer.parseInt(st2.nextToken());

            String term = st.nextToken(); //약관
    
            // System.out.println(year+" "+month+" "+day+" "+term);
            
            //약관종류에 따른 유효기간 체크
            int tmonth = termMap.get(term); //유효기간
            
            int exyear = year;
            int exmonth = month + tmonth;
            int exday = day - 1;
            
            //exday가 0 일 때
            if(exday == 0){
                exday = 28 + exday;
                exmonth = exmonth-1;
            }
            //exmonth가 13 이상일 때
            if(exmonth > 12){
                exyear += (exmonth/12);
                exmonth = exmonth - 12*(exmonth/12);
            }
            if(exmonth == 0){
                exmonth = 12;
                exyear -= 1;
            }
            
            // System.out.println(exyear + " " + exmonth + " " + exday);
            //오늘 날짜와 비교
            if(today_date[0] < exyear){ //기한 남은 경우
                continue;
            } else if(today_date[0] == exyear){ //년도가 같은 경우
                if(today_date[1] < exmonth){
                    continue;
                } else if(today_date[1] == exmonth){ //월 같은 경우
                    if(today_date[2] < exday){
                        continue;
                    } else if(today_date[2] == exday){
                        continue;
                    }
                    else {
                        cnt++;
                        list.add(i+1);
                    }
                    
                } else {
                    cnt++;
                    list.add(i+1);
                }
                
            } else { // 기간 지난 경우
                cnt++;
                list.add(i+1);
            }
        }
        
        
        int[] answer = new int[cnt];
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}