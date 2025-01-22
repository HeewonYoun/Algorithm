import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] card;
    static int[] result;
    static int[] selected;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); //플레이어 수

        card = new int[N+1]; //각 플레이어의 카드 값
        selected = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            card[i] = Integer.parseInt(st.nextToken());
            selected[card[i]] = i;
        }

        result = new int[N+1]; //점수 저장 배열

        for(int i = 1; i<=N; i++){
            for(int j = card[i] * 2; j<= 1000000; j+=card[i]){ //카드의 배수 탐색
                if(selected[j] > 0){ //다른 플레이어 카드값이면
                    result[selected[j]]-= 1;
                    result[i]+= 1;
                }
            }
        }

        for(int i = 1; i<=N; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}