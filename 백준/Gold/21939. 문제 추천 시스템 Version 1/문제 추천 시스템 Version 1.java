import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static class Problem implements Comparable<Problem> {
        int number;
        int level;

        Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) {
                return Integer.compare(this.number, o.number);
            } else {
                return Integer.compare(this.level, o.level);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        TreeSet<Problem> problemSet = new TreeSet<>(); //문제를 관리
        Map<Integer, Integer> problemMap = new HashMap<>(); //문제 번호로 난이도 관리

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); //문제 번호
            int l = Integer.parseInt(st.nextToken()); //난이도

            problemSet.add(new Problem(p, l));
            problemMap.put(p, l);
        }

        int M = Integer.parseInt(br.readLine()); // 명령문 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                problemSet.add(new Problem(p, l));
                problemMap.put(p, l);

            } else if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(problemSet.last().number).append("\n"); //난이도 가장 높은 문제

                } else if (x == -1) {
                    sb.append(problemSet.first().number).append("\n"); //난이도 가장 낮은 문제
                }

            } else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());

                // 해당 문제 삭제
                int l = problemMap.get(p);

                problemSet.remove(new Problem(p, l));
                problemMap.remove(p);
            }
        }

        System.out.print(sb);
    }
}