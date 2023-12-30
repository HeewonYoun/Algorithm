import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //R라이언T튜브, C콘F프로도, J제이지M무지, A어피치N네오 - 먼저 나오는게 비동의
        //매우-3, 그냥-2 약간-1, 모르겠음0
        //매우비동의 1 ~ 매우동의 7
        
        //점수 담을 변수
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        
        map.put("C", 0);
        map.put("F", 0);
        
        map.put("J", 0);
        map.put("M", 0);
        
        map.put("A", 0);
        map.put("N", 0);
        
        for(int i = 0; i<survey.length; i++){
            //지표
            String check = survey[i];
            String first = check.substring(0,1);
            String second = check.substring(1,2);
            // System.out.println(first + " " + second);
            
            //점수
            int choice = choices[i];
            
            if(choice < 4){
                //앞 알파벳에 4-choice%4 한 점수 입력
                map.replace(first, map.get(first)+(4-choice%4));
        
                // System.out.println(first + " " + map.get(first));
            } else if(choice > 4){
                map.replace(second, map.get(second)+choice%4);
                
                // System.out.println(second + " " + map.get(second));
            }
        }
        
        //점수 다 비교해서 
        StringBuffer sb = new StringBuffer();
        if(map.get("R") > map.get("T")){
            sb.append("R");
        }else if(map.get("R") == map.get("T")){ //같으면 사전순으로 빠른거
            sb.append("R");
        } else {
            sb.append("T");
        }
        
        if(map.get("C") > map.get("F")){
            sb.append("C");
        }else if(map.get("C") == map.get("F")){ //같으면 사전순으로 빠른거
            sb.append("C");
        }else{
            sb.append("F");
        }
        
        if(map.get("J") > map.get("M")){
            sb.append("J");
        }else if(map.get("J") == map.get("M")){ //같으면 사전순으로 빠른거
            sb.append("J");
        }else{
            sb.append("M");
        }
        
        if(map.get("A") > map.get("N")){
            sb.append("A");
        }else if(map.get("A") == map.get("N")){ //같으면 사전순으로 빠른거
            sb.append("A");
        }else{
            sb.append("N");
        }
        
        String answer = sb.toString();
        return answer;
    }
}