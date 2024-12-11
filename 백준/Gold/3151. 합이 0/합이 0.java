import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 학생 수
        int[] skills = new int[N]; //코딩 실력

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            skills[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skills);
        long count = 0;

        for (int i = 0; i <N ; i++) {
            if(skills[i] > 0) break;
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = skills[i] + skills[left] + skills[right]; //세명의 코딩 실력 합

                if (sum == 0) {
                    int leftCount = 1;
                    int rightCount = 1;

                    if(skills[left] == skills[right]){
                        count += (long)(right - left + 1) * (right - left) / 2;
                        break;
                    }

                    while (skills[left] == skills[left+1]) {
                        leftCount++;
                        left++;
                    }

                    while (skills[right] == skills[right-1]) {
                        rightCount++;
                        right--;
                    }

                    count += (long) leftCount * rightCount;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}