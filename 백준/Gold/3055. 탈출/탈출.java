import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 비어 있는 곳 . 
//물이 차있는 지역 *
//돌 x
//비버의 굴 D
//고슴도치 위치 S
//다음에 물이 찰 예정인 곳은 못감
class Main {
    static class Node {
        int x;
        int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
        public static int R,C ;
        public static char[][] map;
        public static int[][] check;
        public static ArrayDeque<Node> waterq =  new ArrayDeque<>(); //물 위치
        public static ArrayDeque<Node> hogq = new ArrayDeque<>(); //고슴도치 위치


        public static int[] dx = { -1,1,0,0};
        public static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    

        map = new char[R][C];
        check = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                check[i][j] = -1;
            }
        }
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                map[i][j] = ch;
                if(ch == 'S'){
                    hogq.offer(new Node(i, j));
                    check[i][j] =0;
                }else if (ch == '*'){
                    waterq.offer(new Node(i, j));
                }
            }
        }

        int ans = bfs();
        System.out.println(ans == -1 ? "KAKTUS":ans);
    }

    static int bfs(){

        while(!hogq.isEmpty()){

            // 물확산: 현재 큐 크기만큼 퍼짐
            int ws = waterq.size();
            for (int i = 0; i < ws; i++) {
                Node w = waterq.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = w.x + dx[d];
                    int ny = w.y + dy[d];

                    //범위 밖 or 돌/굴이면 안 퍼짐
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C){
                        continue;
                    }

                    if( map[nx][ny] != '.'){
                        continue;
                    }

                    map[nx][ny] = '*';
                    waterq.offer(new Node(nx, ny));
                }
            }

            //고슴도치 이동
            int hs = hogq.size();
            for (int i = 0; i < hs; i++) {
                Node cur = hogq.poll();

                for(int d =0; d<4;d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                    if(map[nx][ny]== 'D'){
                        return  check[cur.x][cur.y]+1; //다음에 굴에 들어가니깐 +1
                    }

                    if(map[nx][ny] == '.' && check[nx][ny] == -1){
                        check[nx][ny] = check[cur.x][cur.y]+1;
                        hogq.offer(new Node(nx, ny));
                    }
                }
            }
        }
        //더 이상 이동 불가 
        return -1;
    }
}