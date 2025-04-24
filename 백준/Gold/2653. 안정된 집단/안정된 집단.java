import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] likes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //집단에 속한 사람 수
        likes = new boolean[n+1][n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                likes[i][j] = Integer.parseInt(st.nextToken()) != 1; //싫어하면 false, 좋아하면 true
            }
        }

        boolean[] visited = new boolean[n+1]; //소집단에 속했는지 여부
        int count = 0; //안정된 소집단 개수

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            List<Integer> list = new ArrayList<>();
            list.add(i);
            visited[i] = true;

            for (int j = 1; j <= n; j++) {
                if (i == j || !likes[i][j] || !likes[j][i]) continue;
                if (visited[j]) { //j가 이미 다른 집단에 속해 있는 경우
                    System.out.println(0);
                    return;
                }

                list.add(j); //같은 소집단에 포함
                visited[j] = true;
            }

            if (list.size() == 1) { //혼자만 있는 집단일 경우
                System.out.println(0);
                return;
            }

            count++;

            for (int cur : list) { //소집단 구성원 저장
                sb.append(cur).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(count);
        System.out.print(sb);
    }
}
