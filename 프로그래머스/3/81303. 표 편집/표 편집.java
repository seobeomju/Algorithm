import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i=0; i<n+2;i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        k++; //앞에 공간을 확장했기 때문에 더하기
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(String c :cmd){
            if(c.startsWith("C")){
                stack.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n<down[k] ? up[k] : down[k]; 
                }
            else if(c.startsWith("Z")){
                int restore = stack.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            
            else{
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i =0; i<x;i++){
                    k=s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] result = new char[n];
        Arrays.fill(result,'O');
        
        for(int i : stack){
            result[i-1] = 'X';
        }
        
        answer = new String(result);
        
        return answer;
    }
}