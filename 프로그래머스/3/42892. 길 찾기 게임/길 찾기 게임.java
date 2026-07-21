import java.util.*;

class Node{
    int number;
    int x;
    int y;
    Node left;
    Node right;
    
    Node(int number){
        this.number = number;
    }
}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Node[] info = new Node[nodeinfo.length ];
        for(int i =0 ; i<nodeinfo.length; i++){
            info[i] = new Node(i+1);
            info[i].x = nodeinfo[i][0];
            info[i].y = nodeinfo[i][1];
        }
        
        Arrays.sort(info, (a,b) ->{
            if(a.y == b.y){
                return a.x - b.x; //y가 같으면 x오름차순 -> 작은게 앞으로
            }
            return b.y -a.y; //y내림차순 -> 큰게 앞으로
        });
        Node root = info[0];
        for(int i =1 ; i<info.length; i++){
            insertNode(root,info[i]);
        }
        idx = 0;
        preorder(root,answer[0]);

        idx =0;
        postorder(root,answer[1]);
        
        return answer;
    }
    
    public void insertNode(Node parent, Node child){
        // child의 x가 parent의 x보다 작은 경우 (왼쪽으로)
        if(child.x < parent.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insertNode(parent.left, child); //이미 있으면 다시 비교
            }
        }
        // child의 x가 parent의 x보다 큰경우(오른쪽)
        if(child.x > parent.x){
            if(parent.right == null){
                parent.right = child;
            }else{
                insertNode(parent.right,child);
            }
        }
        
    }
    
    int idx =0;
    //중->왼->오
    public void preorder(Node node, int[] answer){
        if(node == null){
            return ;
        }
        
        answer[idx++] = node.number;
        preorder(node.left,answer);
        preorder(node.right,answer);
    }
    
    //왼->오-> 중
    public void postorder(Node node, int[] answer){
        if(node == null){
            return ;
        }
        
        postorder(node.left,answer);
        postorder(node.right,answer);
        answer[idx++] = node.number;
    }
}