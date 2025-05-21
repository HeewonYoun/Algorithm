import java.io.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cut(N, getOdd(N));
        System.out.println(min + " " + max);

    }

    static void cut(int n, int total){
        if(n < 10) { //한 자리
            min = Math.min(min, total);
            max = Math.max(max, total);
        }

        else if(n < 100) { //두 자리: 2개로 나눠서 합 구해서 새로운 수로 생각
            int sum = (n / 10) + (n % 10);
            cut(sum, total + getOdd(sum));
        }

        else { //세 자리 이상
            String str = Integer.toString(n);
            int len = str.length();

            for(int i = 0; i <= len-3; ++i) {
                for(int j = i+1; j <= len-2; ++j) {
                    String s1 = str.substring(0, i+1);
                    String s2 = str.substring(i+1, j+1);
                    String s3 = str.substring(j+1, len);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    cut(sum, total + getOdd(sum));
                }
            }
        }
    }

    static int getOdd(int n){
        int count = 0;

        while(n > 0){
            int cur = n%10;
            if((cur%2) == 1) count++;
            n /= 10;
        }

        return count;
    }

}