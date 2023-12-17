class Solution {
    public long solution(int n) {
        
        long[] d = new long[2005];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        d[4] = 5;
        
        for(int i = 3; i<= n; i++ ){
            d[i] = (d[i-1] + d[i-2]) % 1234567;
        }
        
        long answer = d[n];
        return answer;
    }
}