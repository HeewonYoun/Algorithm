import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static String[] word;
    static boolean[] alpha;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //남극언어에 존재하는 단어 개수
        K = Integer.parseInt(st.nextToken()); //가르칠 글자 수

        //N개중에 읽을 수 있는 단어 개수 최댓값 출력
        //사이에 낀 단어 수 작은거부터 배우면?

        word = new String[N];
        for(int i = 0; i<N; i++){
            String tmp = br.readLine();
            tmp = tmp.replace("anta", "");
            tmp = tmp.replace("tica", "");
            word[i] = tmp;
        }

        if(K < 5){ //acnti도 모름
            System.out.println(0);
            return;
        } else if(K == 26){ //알파벳 다 아는 경우
            System.out.println(N);
            return;
        }

        // a, c, n, t, i
        alpha = new boolean[26];
        alpha['a'-'a'] = true;
        alpha['c'-'a'] = true;
        alpha['n'-'a'] = true;
        alpha['t'-'a'] = true;
        alpha['i'-'a'] = true;

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int idx, int len){
        if(len == K-5){
            int count = 0;

            for(int i = 0; i<N; i++){ //읽을 수 있는 단어 개수 세기
                boolean flag = true;

                for(int j = 0; j<word[i].length(); j++){
                    if(!alpha[word[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if(flag) count++;
            }

            result = Math.max(result, count);
            return;
        }


        for(int i = idx; i<26; i++){
            if(alpha[i]) continue;

            alpha[i] = true;
            dfs(i+1, len + 1);

            alpha[i] = false;

        }
    }
}