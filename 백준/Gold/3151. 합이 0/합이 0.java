import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //학생 수
        int[] skills = new int[N]; //코딩 실력

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            skills[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skills); //오름차순 정렬
        long result = 0;

        for (int i = 0; i <N ; i++) { //첫번째 학생
            if(skills[i] > 0) break; //0보다 크면 코딩 실력 합이 0이 될 수 없음

            int left = i + 1; //두번째 학생
            int right = N - 1; //세번째 학생

            while (left < right) {
                int sum = skills[i] + skills[left] + skills[right]; //세명의 코딩 실력 합

                if (sum == 0) {
                    int leftCount = 1;
                    int rightCount = 1;

                    if(skills[left] == skills[right]){ //중복 처리
                        result += (long)(right - left + 1) * (right - left) / 2;
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

                    result += (long) leftCount * rightCount;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(result);

    }
}