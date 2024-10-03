import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //색종이 수
        int[][] bg = new int[101][101];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //3,7 ~ 13,17
            for(int j = 1; j<11; j++){
                for(int k = 1; k<11; k++){
                    if(bg[x+j][y+k]==0) bg[x+j][y+k]= 1;
                }
            }

        }

        //검은 영역 넓이
        int result = 0;
        for(int i = 1; i<101; i++){
            for(int j = 1; j<101; j++){
                if(bg[i][j] == 1) result++;
            }
        }

        System.out.println(result);
    }
}