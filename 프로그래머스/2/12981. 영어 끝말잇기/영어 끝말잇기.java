import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        HashSet<String> set = new HashSet<>();
        
        set.add(words[0]);
        for(int i =1; i<words.length ; i++){
            String currentWord = words[i];
            String beforWord = words[i-1];
            if(!set.add(currentWord) || beforWord.charAt(beforWord.length()-1) != currentWord.charAt(0)){
                answer = new int[]{(i%n)+1, (i/n) + 1};
                break;
            }

        }
    
        return answer;
    }
}