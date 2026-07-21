import java.util.*;

class Node{
    int amount;
    String enroll;
    Node referral;
    
    Node(String enroll){
        this.enroll = enroll;
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        //모든 사람 노드 만들기
        HashMap<String,Node> map = new HashMap<>();
        for(int i =0; i<enroll.length; i++){
            // 생성자가 enroll이므로 ""로 생성말고 enroll로 생성
            map.put(enroll[i],new Node(enroll[i]));
        }
        Node root = new Node("-");
        //부모 연결
        for(int i =0; i<referral.length;i++){
            if(referral[i].equals("-")){
                
                map.get(enroll[i]).referral = root;
            }else{
            //System.out.println(map.get(enroll[i]));
            map.get(enroll[i]).referral = map.get(referral[i]);
            }
        }
        
        //판매 발생
        for(int i =0; i<seller.length; i++){
            int money = amount[i] * 100;
           
            Node cur = map.get(seller[i]);
            //System.out.println(cur);
            //while(cur != root) 이것도 가능
            while(!cur.enroll.equals("-")){
                
                int referralMoney = money/10;
                
                //한 사람이 두번 판매할 경우 대비
                //map.get(seller[i]).amount = amount[i] * 100;
                cur.amount += money - referralMoney ;
                
                if(referralMoney == 0){
                    break;
                }
                
                money = referralMoney;
                cur = cur.referral;
            } 
        }
        
        for(int i=0; i<enroll.length;i++){
            answer[i] = map.get(enroll[i]).amount;
        }
        
        
        
        
        return answer;
    }
}