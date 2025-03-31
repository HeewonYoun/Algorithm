import java.io.*;

public class Main{

    static String S, T;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        System.out.println(solution(T));
    }

    //마지막 글자 A라면 -> A 제거
    //첫 글자가 B라면 ->  B 제거하고 문자열 뒤집기
    static int solution(String t){
        if(S.length() == t.length()){ //길이 같을 때 같으면
            if(S.equals(t)) return 1;
            return 0;
        }

        int result = 0;

        if(t.charAt(t.length() - 1) == 'A') { //마지막 글자가 A인 경우
            result += solution(t.substring(0, t.length()-1)); //A 제거
        }

        if(t.charAt(0) == 'B'){ //맨 앞 글자가 B인 경우
            StringBuilder sb = new StringBuilder(t.substring(1)); //첫 글자 제거
            String tmp = sb.reverse().toString(); //뒤집기
            result += solution(tmp);
        }

        return result > 0 ? 1 : 0;
    }
}
