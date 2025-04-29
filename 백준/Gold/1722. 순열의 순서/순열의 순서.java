import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long k;
    static int[] num = new int[21]; //순열 저장

    static long[] factorial = new long[21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        factorial[0] = 1;
        for(int i = 1; i<=N; i++){ //팩토리얼 계산
            factorial[i] = factorial[i-1] * i;
        }

        st = new StringTokenizer(br.readLine());
        if(st.nextToken().equals("1")){
            k = Long.parseLong(st.nextToken()); //k번째 순열

            for(int i = 0; i<N; i++){ //자리수
                for(int j = 1; j<=N; j++){ //자리수에 들어갈 수 있는 숫자
                    if(visited[j]) continue;

                    if(factorial[N-i-1] < k){ // 현재 자리의 남은 경우의 수가 k보다 작으면, k에서 빼주고 다음 숫자 확인
                        k -= factorial[N-i-1];
                    } else { // factorial[N - i - 1] >= k이면 현재 숫자가 k번째 순열에 포함될 숫자
                        num[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }

            for(int i = 0; i<N; i++){
                sb.append(num[i]).append(" ");
            }
        }
        else { //현재 순열이 몇번째인지
            for(int i = 0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken()); //순열 배열 저장
            }

            long result = 1;

            for(int i = 0; i<N; i++){ // 자리수별로 가능한 숫자들 중 현재 숫자보다 작은 수의 개수만큼 순서 더함
                for(int j = 1; j<num[i]; j++){
                    if(visited[j]) continue;
                    result += factorial[N-i-1];
                }
                visited[num[i]] = true;
            }
            sb.append(result);
        }

        System.out.println(sb);
    }
}