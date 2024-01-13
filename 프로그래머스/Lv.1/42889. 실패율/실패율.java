import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        //실패율: 스테이지도달O, 클리어X 플레이어 수 / 스테이지 도달O 플레이어 수
        //N: 전체 스테이지 개수 (1 <= N <= 500)
        //실패율 높은 스테이지부터 내림차순으로 스테이지 번호 담긴 배열 return
        
        //N+1은 마지막까지 클리어한 사용자
        //도전중인 스테이지 번호
        
        int[] dodal = new int[N+1]; //도달한 사용자
        dodal[0] = -1;
        int[] ing = new int[N+1];//도전중인 사용자
        ing[0] = -1;
        
        for(int i = 0; i<stages.length; i++){
            int stage = stages[i];
            if(stage == N+1){ //모든 스테이지 클리어
                for(int j = 1; j<=N; j++){
                    dodal[j] += 1;
                }
            } else {
                ing[stage] += 1;
                for(int j = 1; j<=stage; j++){
                    dodal[j] += 1;
                }
            }
        }
        
        // System.out.println(Arrays.toString(ing));
        // System.out.println(Arrays.toString(dodal));
        
        //실패율
        List<float[]> list = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            if(dodal[i] == 0){
                list.add(new float[]{i, 0}); //스테이지명, 실패율
            }else {
                float calc = (float)ing[i] / (float)dodal[i];
            // System.out.println(calc);
                list.add(new float[]{i, calc}); //스테이지명, 실패율
            }
        }
        
        Collections.sort(list, new Comparator<float[]>(){
            public int compare(float[] o1, float[] o2){
                if(o1[1] == o2[1]){
                    return Float.compare(o1[0], o2[0]);
                    // return (int)(o1[0] - o2[0]); //스테이지명 오름차순
                }
                return Float.compare(o2[1],o1[1]);
                // return (int)(o2[1] - o1[1]); //실패율 내림차순
            }
        });
        
        int[] answer = new int[N];
        for(int i = 0; i<N; i++){
            answer[i] = (int)list.get(i)[0];
        }
        return answer;
    }
}