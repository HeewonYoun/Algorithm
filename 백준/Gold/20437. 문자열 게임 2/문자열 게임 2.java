import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K==1){ //K가 1이면 무조건 1
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26]; //알파벳 별 개수 저장
            for(int i = 0; i<W.length(); i++){
                alpha[W.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            //3. 어떤 문자를 정확히 K개 포함하는 가장 짧은 연속 문자열
            //4. 어떤 문자를 정확히 K개 포함하고, 첫번째 = 마지막, 가장 긴 연속문자열
            
            for(int i = 0; i<W.length(); i++){
                if(alpha[W.charAt(i)-'a'] < K) continue; //개수가 K 보다 이미 적으면 continue
                char check = W.charAt(i); 
                
                int count = 1;
                for(int j = i+1; j<W.length(); j++){
                    if(W.charAt(j) == check) count++;
                    
                    if(count == K){
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            
            if(min == Integer.MAX_VALUE || max == -1) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}