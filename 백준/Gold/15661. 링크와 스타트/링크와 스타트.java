import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] point;
    static int min = Integer.MAX_VALUE;
    static boolean[] isTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isTeam = new boolean[N+1];

        point = new int[N+1][N+1];
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<N+1; j++){
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //모든 경우의 수
        for(int i = 1; i <= N/2; i++){
            isTeam = new boolean[N+1];

            makeTeam(1,0,i);

            if(min == 0){
                System.out.println(min);
                return;
            }
        }

        System.out.println(min);
    }

    static void makeTeam(int cur, int cnt, int total){
        if(cnt == total){
            calcDiff();
            return;
        }

        for(int i = cur; i<=N; i++){
            isTeam[i] = true;
            makeTeam(i + 1, cnt +1, total); //조심..

            isTeam[i] = false;
        }
    }

    static void calcDiff(){
        List<Integer> teamS = new ArrayList<>(); //true 인 멤버
        List<Integer> teamL = new ArrayList<>(); //false인 멤버

        int totalS = 0;
        int totalL = 0;

        for(int i = 1; i<isTeam.length; i++){
            if(isTeam[i]) teamS.add(i);
            else teamL.add(i);
        }

        //능력치 계산
        for(int i = 0; i<teamS.size(); i++){
            for(int j = 0; j<teamS.size(); j++){
                if(i == j) continue;

                totalS += point[teamS.get(i)][teamS.get(j)];
            }
        }

        for(int i = 0; i<teamL.size(); i++){
            for(int j = 0; j<teamL.size(); j++){
                if(i == j) continue;

                totalL += point[teamL.get(i)][teamL.get(j)];
            }
        }

        int diff = Math.abs(totalS-totalL);
        if(diff < min) min = diff;
    }
}