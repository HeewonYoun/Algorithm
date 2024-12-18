import java.io.*;
import java.util.*;

public class Main {

    static int r, c, k;
    static int[][] map = new int[101][101];
    static int rowLen, colLen;

    public static class Node implements Comparable<Node>{
        int number;
        int count;

        Node(int number, int count){
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if(this.count == o.count){
                return this.number - o.number;
            } else {
                return this.count - o.count;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rowLen = 3;
        colLen = 3;
        int cnt = 0;
        int result = -1;

        while(cnt <= 100){
            if(map[r][c] == k){
                result = cnt;
                break;
            }

            if(rowLen >= colLen){
                r();
            } else {
                c();
            }
            cnt++;
        }

        System.out.println(result);
    }

    static void r(){
        int[][] map_copy = new int[101][101];
        int col = 0;

        for(int i = 1; i<=rowLen; i++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int j = 1; j<=colLen; j++){
                if(map[i][j] == 0) continue; //0인건 패스

                if(hashMap.containsKey(map[i][j])){ //해당 값이 있는 경우 +1
                    hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
                } else {
                    hashMap.put(map[i][j], 1);
                }
            }

            ArrayList<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
                list.add(new Node(entry.getKey(), entry.getValue()));
            }

            col = Math.max(col, list.size() * 2);
            Collections.sort(list);

            for(int k = 0; k<list.size(); k++){
                Node node = list.get(k);

                map_copy[i][2*k+1] = node.number;
                map_copy[i][2*k+2] = node.count;
            }
        }

        colLen = col;
        map = map_copy;
    }

    static void c(){
        int[][] map_copy = new int[101][101];
        int row = 0;

        for(int j = 1; j<=colLen; j++){
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int i = 1; i<= rowLen; i++){
                if(map[i][j] == 0) continue;

                if(hashMap.containsKey(map[i][j])){
                    hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
                } else {
                    hashMap.put(map[i][j], 1);
                }
            }

            ArrayList<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
                list.add(new Node(entry.getKey(), entry.getValue()));
            }

            row = Math.max(row, list.size() * 2);
            Collections.sort(list);

            for(int k = 0; k<list.size(); k++){
                Node node = list.get(k);

                map_copy[2*k+1][j] = node.number;
                map_copy[2*k+2][j] = node.count;
            }
        }

        rowLen = row;
        map = map_copy;
    }
}