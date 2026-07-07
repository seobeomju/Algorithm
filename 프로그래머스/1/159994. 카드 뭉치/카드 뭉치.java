import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> ArrayCards1 = new ArrayDeque<>();
        ArrayDeque<String> ArrayCards2 = new ArrayDeque<>();
        ArrayDeque<String> target = new ArrayDeque<>();
        
        for(int i =0; i <cards1.length;i++){
            String card1 = cards1[i];
            ArrayCards1.add(card1);
        }
        for(int i =0; i <cards2.length;i++){
            String card2 = cards2[i];
            ArrayCards2.add(card2);
        }
        for(int i =0; i <goal.length;i++){
            String card3 = goal[i];
            target.add(card3);
        }
        
        for(int i =0 ; i< goal.length; i++){
            String targetCard = target.poll();
            System.out.println(targetCard);
            
            if(targetCard.equals(ArrayCards1.peek())){
                ArrayCards1.poll();

            }else if(targetCard.equals(ArrayCards2.peek())){
                ArrayCards2.poll();

            }else{
                return "No";
            }
        }   
        
        return "Yes";
    }
}