import java.util.*;
class Solution {
    //터트려져 사라진 인형의 갯수를 찾는 문제
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = moves.length;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        A: for(int i = 0; i <n; i++){
            int j = moves[i]-1;
            for(int k =0; k<board.length; k++){
                if(board[k][j] != 0){
                    int target = board[k][j];
                    board[k][j] = 0;
                    if(!stack.isEmpty() && stack.peek() == target){
                        stack.pop();
                        answer+=2;
                    }else{
                        stack.push(target);
                    }
                    continue A;
                }
            } 
        }
        return answer;
    }
}