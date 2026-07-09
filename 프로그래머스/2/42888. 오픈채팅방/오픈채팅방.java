import java.util.*;

// 모든 유저는 유저 아이디로
// Enter - 유저가 들어옴
// Leave - 유저가 퇴장
// Change - 유저 아이디 사용자가 닉네임을 변경
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {}; 
        HashMap<String,String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i< record.length; i++ ){
            String word = record[i];
            StringTokenizer st = new StringTokenizer(word);
            
            String cmd = st.nextToken();
            String uid = st.nextToken();
            if(cmd.equals("Enter") || cmd.equals("Change")){
                String nickname = st.nextToken();
                map.put(uid,nickname);
            }
            
        }
        
        for(int i = 0; i< record.length; i++ ){
            String word = record[i];
            StringTokenizer st = new StringTokenizer(word);
            String cmd = st.nextToken();
            String uid = st.nextToken();
           if(cmd.equals("Enter")){
                list.add(map.get(uid) + "님이 들어왔습니다.");
            }else if(cmd.equals("Leave")){
                list.add(map.get(uid) + "님이 나갔습니다.");  
            }           
        }
        answer = list.toArray(new String[0]);
        return answer;
    }
}