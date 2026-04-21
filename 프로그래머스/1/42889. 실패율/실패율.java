import java.util.*;
class Solution {
    // 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
    // 전체 스테이지의 개수 1<N<500, N +1 스테이지 클리어
    // 사용자가 멈춰있는 스테이지의 번호가 담긴 배열 stages가 주어짐
    // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 함
    public int[] solution(int N, int[] stages) {
    
        //스테이지의 도전자 수를 구함
        int[] answer = new int[N+2];
        for(int i =0; i<stages.length;i++){
            answer[stages[i]]++;
        }
        
        //스테이지별 실패한 사용자 수를 구함
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        //각 스테이지를 순회하면 실패율 계산
        for(int i =1; i<=N; i++){
            if(answer[i]==0){
                fails.put(i,0.); // Double값이므로 0.으로 안 할시 에러발생
            }else{
                fails.put(i,answer[i]/total);
                total -= answer[i];
            }
        }
               
        //실패율이 높은 스테이지부터 내림차순으로 정렬
        return fails.entrySet()
                    .stream()
                    .sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue()))
                    .mapToInt(HashMap.Entry::getKey)
                    .toArray();
    }
}