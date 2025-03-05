import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); //경사로 길이

        map = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //지나갈 수 있는 길의 개수
        for(int i = 0; i<N; i++){
            if(check(i,0,0)) result++; //0 열방향
            if(check(0,i,1)) result++; //1 행방향
        }

        System.out.println(result);
    }

    static boolean check(int x, int y, int d){
        int[] height = new int[N];
        boolean[] visited = new boolean[N]; //경사로가 설치된 위치 저장

        for(int i = 0; i<N; i++){
            if(d == 0) height[i] = map[i][x];
            else height[i] = map[y][i];
        }

        for(int i = 0; i<N-1; i++){
            if(height[i] == height[i+1]) continue; //높이같은경우

            if(Math.abs(height[i] - height[i+1]) != 1) return false; //경사로 높이는 1

            if(height[i] > height[i+1]){ //내려가는 경사로
                for(int j = i+1; j<=i+L; j++){
                    if(j > N - 1) return false; //경사로가 범위 벗어나는 경우
                    if(visited[j]) return false; //이미 설치된 곳
                    if(height[j] != height[i+1]) return false; //높이가 다르면
                    visited[j] = true;
                }
            } else if(height[i] < height[i+1]){ //올라가는 경사로
                for(int j = i; j>i-L; j--){
                    if(j<0) return false;
                    if(visited[j]) return false;
                    if(height[i] != height[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
