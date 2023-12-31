import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int[] arr = new int[(queue1.length+queue2.length)];
        long sum1 = 0;
        long sum2 = 0;
        long total = 0;
        
        for(int i = 0; i<queue1.length; i++){
            arr[i] = queue1[i];
            sum1 += queue1[i];
        }
        for(int i = 0; i<queue2.length; i++){
            arr[i + queue1.length] = queue2[i];
            sum2 += queue2[i];
        }

        int start = 0;
        int end = queue1.length;
        
        if((sum1+sum2)%2!=0){
            return -1;
        }
        
        total = (sum1 + sum2)/2;
        // long sum = sum1; //시작 합은 queue1의 모든 원소 합
        int cnt = 0; // 포인터 이동 횟수 - 정답
        
        while(cnt <= 4*queue1.length){
            if(sum1 == sum2){
                return cnt;
            } else if(sum1 > sum2){
                sum1 -= arr[start];
                sum2 += arr[start];
                
                start = (start + 1) % arr.length;
            } else {
                sum1 += arr[end];
                sum2 -= arr[end];
                
                end = (end + 1) % arr.length;
            }
            cnt++;
        }
        return -1;

//         while(start <= end && end < arr.length-1){
//             if(sum < total){
//                 sum += arr[++end];
//                 cnt++;
//             } else if(sum == total){
//                 break;
//             } else if(sum > total){
//                 sum -= arr[start++];
//                 cnt++;
//             }
//         }
        
//         if(start > end) cnt = -1;
//         if(cnt > arr.length-1) cnt = -1;
//         System.out.println(cnt);
       
//         int answer = cnt; 
//         return answer;
    }
}