import java.util.*;
class Node{
    int info;
    List<Node> children= new ArrayList<>();
    
    Node(int info){
        this.info = info;
    }
}

class State{
    int sheep;
    int wolf;
    List<Node> next = new ArrayList<>();

}
class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        //양과 늑대의 배열을 생성
        Node[] nodes = new Node[info.length];
        for(int i =0 ;i<info.length; i++){
            nodes[i] = new Node(info[i]);
        }
        
        //트리 생성
        for(int i =0 ;i<edges.length;i++){
            nodes[edges[i][0]].children.add(nodes[edges[i][1]]);
        }
        
        //넓이 우선 탐색 사용(BFS)
        //초기 상태 초기화
        State start = new State();
        start.sheep = 1;
        start.wolf = 0;
        // nodes[0].childern의 모든 내용을 넣기 위해 addAll
        start.next.addAll(nodes[0].children);
        
        Queue<State> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            State current = q.poll();
            //늑대가 양보다 많으면 이 상태는 버림
            if(current.wolf >= current.sheep){
                 continue;
             }
            //현재 상태에서 최대 양 갱신
            answer = Math.max(answer, current.sheep);
            
           
            //현재 갈 수 있는 후보 노드들을 하나씩 선택
            for(Node child : current.next){
                //새로운 상태 생성
                State nextState = new State();
                    
                //현재 상태 복사
                nextState.sheep = current.sheep;
                nextState.wolf = current.wolf;
                    
                //선택한 노드 방문
                if(child.info == 0){
                    nextState.sheep++;
                }else{
                    nextState.wolf++;
                }
                
                if(nextState.wolf >= nextState.sheep){
                    continue;
                }
                
                
                //다음 후보 리스트 복사  
                nextState.next = new ArrayList<>(current.next);
            
                //선택한 노드 제거
                nextState.next.remove(child);
                    
                    
                // 선택한 노드의 자식 추가                
                nextState.next.addAll(child.children);
                
                q.offer(nextState);
            }    
        }
        
        return answer;
    }
}