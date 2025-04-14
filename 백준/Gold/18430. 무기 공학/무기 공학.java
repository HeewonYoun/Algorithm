import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] wood;
    static int result;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wood = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //길동이가 만들 수 있는 부메랑들의 강도의 최댓값
        visited = new boolean[N][M];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int index, int sum){
        if(index == N*M){
            result = Math.max(result, sum);
            return;
        }

        int x = index/M; //행
        int y = index%M; //열

        if(!visited[x][y]){
            visited[x][y] = true;

            //ㄱ
            if(x+1 < N && y-1 >= 0 && !visited[x+1][y] && !visited[x][y-1]){
                visited[x+1][y] = true;
                visited[x][y-1] = true;

                dfs(index + 1, sum + wood[x][y] * 2 + wood[x+1][y] + wood[x][y-1]);

                visited[x+1][y] = false;
                visited[x][y-1] = false;
            }

            //ㅢ
            if(x-1 >= 0 && y-1 >= 0 && !visited[x-1][y] && !visited[x][y-1]){
                visited[x-1][y] = true;
                visited[x][y-1] = true;

                dfs(index + 1, sum + wood[x][y] * 2 + wood[x-1][y] + wood[x][y-1]);

                visited[x-1][y] = false;
                visited[x][y-1] = false;
            }

            //ㄴ
            if(x-1 >= 0 && y+1 <M && !visited[x-1][y] && !visited[x][y+1]){
                visited[x-1][y] = true;
                visited[x][y+1] = true;

                dfs(index + 1, sum + wood[x][y] * 2 + wood[x-1][y] + wood[x][y+1]);

                visited[x-1][y] = false;
                visited[x][y+1] = false;
            }

            //ㅣㅡ
            if(x+1 < N && y+1 <M && !visited[x+1][y] && !visited[x][y+1]){
                visited[x+1][y] = true;
                visited[x][y+1] = true;

                dfs(index + 1, sum + wood[x][y] * 2 + wood[x+1][y] + wood[x][y+1]);

                visited[x+1][y] = false;
                visited[x][y+1] = false;
            }

            visited[x][y] = false;
        }
        dfs(index+1, sum); //부메랑 안만드는 경우
    }
}
