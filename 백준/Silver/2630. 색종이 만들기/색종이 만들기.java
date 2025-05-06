import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            //한 행을 입력받아 공백을 기주능로 분리하기 위해 사용
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                //하나씩 채움
                board[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N);

        System.out.println(white);
        System.out.println(blue);

    }




    public static void divide(int row, int col, int size){
        if(colorCheck(row, col, size)){
            if(board[row][col]==0){
                white ++;
            }
            else{
                blue ++;
            }
            return;
        }
        
        int newSize = size/2;

        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize,col+newSize,newSize);

     
    }

    public static boolean colorCheck(int row, int col, int size){
        for(int i =row; i<row+size;i++){
            for (int j = col; j < col+size; j++) {
                if(board[i][j] != board[row][col]) return false;
            }
        }

        return true;
    }
    
}