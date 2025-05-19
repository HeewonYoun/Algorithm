import java.io.*;

public class Main {

    static int[][][] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        dp = new int[a.length()+1][b.length()+1][c.length()+1];

        for(int i = 1; i<=a.length(); i++){
            for(int j = 1; j <=b.length(); j++){
                for(int k = 1; k<=c.length(); k++){
                    if(a.charAt(i-1) == b.charAt(j-1) && b.charAt(j-1) == c.charAt(k-1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }

                }
            }
        }

        System.out.println(dp[a.length()][b.length()][c.length()]);
    }
}
