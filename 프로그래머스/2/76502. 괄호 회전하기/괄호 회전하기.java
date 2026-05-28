import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '('); //키로 닫는 괄호, 값으로 여는 괄호
        map.put('}', '{');
        map.put(']', '[');
        
        int answer = 0;
        int n = s.length();
        s += s; //문자열 뒤에 문자열 하나 더 붙임
        
        A: for(int i=0; i<n;i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            for(int j =i ; j<i+n; j++){
                char c = s.charAt(j);
                if(!map.containsKey(c)){
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))){
                        continue A;
                        }
                    }    
                }
            
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}