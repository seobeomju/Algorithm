import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        //차번호 + 들어온 시간 records에 IN일때 넣기
        HashMap<String,String> recordMap = new HashMap<>();
        HashMap<String,Integer> minMap = new HashMap<>();
        HashSet<String> carName = new HashSet<>(); 
        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String car = st.nextToken();
            String info = st.nextToken();
            carName.add(car);
            // System.out.println(time);
            // System.out.println(car);
            // System.out.println(info);
            
            if(info.equals("IN")){
                recordMap.put(car,time);
            }else if(info.equals("OUT")){
                String inTime = recordMap.get(car);
                //시간 차이 계산 못하겠음
                String[] start = inTime.split(":");
                String[] end = time.split(":");
                
                int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
                int endMin = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

                int mindiff = endMin - startMin;
                
                minMap.put(car,minMap.getOrDefault(car, 0) + mindiff);
                
                recordMap.remove(car);
            }
        }
        
 
        //OUT하지 않은 차 관리
        if(!recordMap.isEmpty()){
            for(String car : carName){
                String startTime = recordMap.get(car);
                if(startTime != null){
                    String[] start =startTime.split(":"); 
                    int startMin = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
                    int endMin = 23* 60 + 59;
                    int diff = endMin - startMin;
                    minMap.put(car, minMap.getOrDefault(car, 0) + diff);
                }
            }
        }
        
        ArrayList<String> list = new ArrayList<>(carName);
        System.out.println(list);
        
        Collections.sort(list);
        System.out.println(list);
        int[] answer = new int[list.size()];
        
        //cost관리
        for(int i=0; i<list.size();i++){
            int totalMins = minMap.get(list.get(i));
            System.out.println(totalMins);
            if(totalMins <= fees[0]){
                answer[i] = fees[1];
            }else{
                answer[i] = fees[1] + ( (totalMins - fees[0] + fees[2] -1) / fees[2] ) * fees[3];
            }
        
        }
        
        return answer;
    }
}