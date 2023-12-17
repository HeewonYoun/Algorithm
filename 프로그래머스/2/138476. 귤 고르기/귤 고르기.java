import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> tang = new HashMap<>();
        
        for(int i = 0; i<tangerine.length; i++){
            if(tang.containsKey(tangerine[i])){
                tang.put(tangerine[i], tang.get(tangerine[i])+1);
            } else {
                tang.put(tangerine[i], 1);
            }
        }
        
        List<Integer> tangCnt = new ArrayList<>(tang.values());
        Collections.sort(tangCnt, Collections.reverseOrder()); //귤 개수 정렬
        
        int answer = 1; //종류 수
        int cnt = tangCnt.get(0); //귤 갯수
        for(int i = 1; i<k; i++){
            if(cnt < k){
                cnt += tangCnt.get(i);
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}