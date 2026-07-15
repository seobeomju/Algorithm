import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        //ArrayLsit가 아닌 Set을 사용하는 이유
        // ArrayList는 중복이 허용 되지만 Set은 중복이 허용되지 않음
        HashMap<String,Set<String>> idMap = new HashMap<>();
        HashMap<String,Integer> reportMap = new HashMap<>();
        for(String name : id_list){
            idMap.put(name,new HashSet<>());
            reportMap.put(name, 0);
        }
        for(int i=0; i <report.length; i++){
            String reported = report[i];
            StringTokenizer st = new StringTokenizer(reported);
            String reportName = st.nextToken();
            String reportedName = st.nextToken();
            
            idMap.get(reportName).add(reportedName);
        }
        for(String reporter : idMap.keySet()){
            Set<String> reportList = idMap.get(reporter);
            
            for(String reported : reportList){
                reportMap.put(reported,reportMap.get(reported)+1);
            }
        }
        
        
        for(String name : id_list){
            int count = 0;
            Set<String> reportList = idMap.get(name);
          
            
            for(String reported : reportList){
                if(reportMap.get(reported) >= k){
                    count++;
                }
            }
            answer.add(count);
            
        }
        
        
//         System.out.println(idMap);
        
//         System.out.println(reportMap);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}