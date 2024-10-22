import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(); //원본 문자열
        String P = br.readLine();

        //copy(s,p) -> S의 s번 문자부터 p개의 문자를 P에 복사해서 붙인다
        //copy 함수의 최소 사용횟수
        int idx = 0;
        int result = 0;
        for(int i = 0; i<P.length(); i++){
            String check = P.substring(idx, i+1);

            if(S.indexOf(check) == -1){ //특정 문자열(check)의 인덱스가 있는지
                result++;
                idx = i;
            }
        }
        System.out.println(result + 1);
    }
}