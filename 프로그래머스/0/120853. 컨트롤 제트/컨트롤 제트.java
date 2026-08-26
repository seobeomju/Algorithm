import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int v = 0;
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals("Z")){
                answer -= v;
            }else{
                int value = Integer.parseInt(token);
                answer += value;
                v= value;
            }
        }
        return answer;
    }
}