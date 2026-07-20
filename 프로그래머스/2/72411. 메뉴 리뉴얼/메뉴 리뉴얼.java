import java.util.*;
class Solution {
    // 만들 수 있는 메뉴 구성과 주문 수를 저장

    private static HashMap<Integer, HashMap<String,Integer>> courseMap;
    
    
    public String[] solution(String[] orders, int[] course) {
        
        courseMap = new HashMap<>();
        //해쉬맵 초기화
        for(int i : course){
            courseMap.put(i,new HashMap<>());
        }
        
        
        //코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for(String order : orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0,orderArray, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        //모든 코스의 후보에 대해서
        for(HashMap<String,Integer> count : courseMap.values()){
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o)) //가장 빈도수가 높은 코스를 찾음
                .ifPresent(cnt -> count.entrySet() //코스에 대한 메뉴 수가 가능할 때만
                          .stream()
                           //최소 2명 이상의 손님으로부터 주문된 단품 메뉴 주문에 대해서만
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt >1)
                           //코스 메뉴만 answer 리스트에 추가
                          .forEach(entry -> answer.add(entry.getKey())));
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    
    
    }
    
    
    //조합 매서드 (재귀)
    // 손님이 주문했던 메뉴에서 n가지를 뽑아 메뉴 좋바을 구성하는 매서드
    public static void combinations(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())){
            HashMap<String,Integer> map =courseMap.get(result.length());
            // 해당 코스의 수 1 증가
            map.put(result, map.getOrDefault(result,0)+1);
        }
        
        for(int i= idx; i<order.length; i++){
            combinations(i+1,order,result+order[i]);
        }
    }
}