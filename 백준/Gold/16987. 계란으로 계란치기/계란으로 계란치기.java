import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int[][] egg;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //계란
        egg = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken()); //내구도
            egg[i][1] = Integer.parseInt(st.nextToken()); //무게
        }

        if (N == 1) {
            result = 0;
        } else {
            dfs(0, 0);
        }
        System.out.println(result);
    }

    static void dfs(int idx, int cnt) {
        if (idx == N) {
            if (cnt > result) {
                result = cnt;
            }
            return;
        }

        if (egg[idx][0] <= 0 || cnt == N-1) {// 해당 계란 내구도 0일 때
            dfs(idx+1, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (idx == i || egg[i][0] <= 0) continue;

            egg[idx][0] -= egg[i][1];
            egg[i][0] -= egg[idx][1];

            if (egg[idx][0] <= 0) cnt++;
            if (egg[i][0] <= 0) cnt++;

            dfs(idx + 1, cnt);

            if (egg[idx][0] <= 0) cnt--;
            if (egg[i][0] <= 0) cnt--;

            egg[idx][0] += egg[i][1];
            egg[i][0] += egg[idx][1];
        }
    }
}
