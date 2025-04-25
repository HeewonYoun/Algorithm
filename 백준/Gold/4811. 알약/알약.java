import java.io.*;

public class Main {

    // dp[i][j] : 아직 쪼개지 않은 알약이 i개, 절반 조각(H)이 j개 남아있을 때 가능한 방법의 수
    static long[][] dp = new long[31][31];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        
        dp[1][0] = 1; // 초기 상태: 알약 1개(W)만 있을 때 시작 가능한 경우의 수

        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                // 아직 쪼개지 않은 알약(W)을 쪼갤 수 있으면: W -> W-1, H+1
                if (i < 30) {
                    dp[i + 1][j] += dp[i][j];
                }
                // 절반 알약(H)을 먹을 수 있으면: H -> H-1
                // 쪼개진 알약(H)은 쪼개지지 않은 알약(W)보다 많을 수 없음
                if (j < i) {
                    dp[i][j + 1] += dp[i][j];
                }
            }
        }

        while (true) {
            N = Integer.parseInt(br.readLine()); 
            if (N == 0) break; 

            sb.append(dp[N][N] + "\n");
        }

        System.out.println(sb);
    }
}
