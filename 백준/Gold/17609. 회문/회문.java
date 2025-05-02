import java.io.*;

public class Main {

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();

            int result = checkPalindrome(str);
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }

    // 주어진 문자열이 회문/유사회문/일반문자열인지 판단
    static int checkPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) { //문자 같으면 계속 진행
                start++;
                end--;

            } else { // 문자가 다르면 두 가지 경우 중 하나라도 회문이면 유사회문
                if (isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1)) { //오른쪽 문자 삭제경우, 왼쪽 문자 삭제경우
                    return 1;  // 유사회문
                } else {
                    return 2;  // 일반 문자열
                }
            }
        }
        return 0;  // 회문
    }

    // 주어진 구간이 회문인지 판단
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;

            start++;
            end--;
        }

        return true;
    }
}
