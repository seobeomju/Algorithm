import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String,String> person = new HashMap<>();
        HashMap<String,Integer> moneyMap = new HashMap<>();
        
        //판매자와 소개한 사람 map 생성
        for(int i=0; i<enroll.length; i++){
            person.put(enroll[i], referral[i]);
            // moneyMap.put(enroll[i],0);
            //System.out.println(person);
        }
        
        //판매 발생
        for(int i =0; i<seller.length; i++){
            int money = amount[i]*100;
            String sellerName = seller[i];
            
            while(!sellerName.equals("-")){
                int referralMoney = money/10;
                moneyMap.put(sellerName, moneyMap.getOrDefault(sellerName,0) + money-referralMoney);
                
                if(referralMoney == 0){
                    break;
                }
                
                money = referralMoney;
                sellerName = person.get(sellerName);
            }
            
        }
        
        for(int i=0; i<enroll.length; i++){
            answer[i] = moneyMap.getOrDefault(enroll[i],0);
        }
        
        
        
        return answer;
    }
}