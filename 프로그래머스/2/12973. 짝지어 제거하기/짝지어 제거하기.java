import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i <n; i++){
            char c = s.charAt(i);
            if(stack.isEmpty()|| !stack.peek().equals(c)){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }
        return answer;
    }
}