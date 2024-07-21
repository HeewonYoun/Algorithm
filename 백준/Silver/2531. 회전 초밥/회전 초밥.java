import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        int[] sushi = new int[N];
        for(int i = 0; i<N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] get = new int[d+1];
        int count = 0;
        for(int i = 0; i<k; i++){ //사이즈 k
            if(get[sushi[i]] == 0){
                count++;
            }
            get[sushi[i]]++;
        }

        int max = count;
        for(int i = 0; i<N; i++){
            if(max <= count){ 
                if(get[c] == 0){//쿠폰초밥 안먹은 경우
                    max = count + 1;
                } else {
                    max = count;
                }
            }

            int end = (i + k) % N;
            if(get[sushi[end]] == 0) {
                count++;
            }
            get[sushi[end]]++;

            get[sushi[i]]--;
            if(get[sushi[i]] == 0){
                count--;
            }

        }
        System.out.println(max);
    }
}