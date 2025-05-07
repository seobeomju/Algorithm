import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int plus =0;
    public static int minus = 0;
    public static int zero =0;

    public static int[][] board ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

       
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
              board[i][j] = Integer.parseInt(st.nextToken());  
            }
        }

        divide(0,0,N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void divide(int row, int col, int size){
        if(numCheck(row, col, size)){
            if(board[row][col] == 0){
                zero ++;
            }else if(board[row][col] == 1){
                plus ++;
            }else if(board[row][col] == -1){
                minus ++;
            }
            return;
        }


        int newSize = size/3;

        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row,col+(newSize*2),newSize);
        divide(row+newSize,col+(newSize*2),newSize);
        divide(row+newSize,col, newSize);
        divide(row+(newSize*2) ,col, newSize);
        divide(row+(newSize*2),col+newSize,newSize);
        divide(row+newSize, col+newSize, newSize);
        divide(row+(newSize*2), col+(newSize*2), newSize);

    }

    public static boolean numCheck(int row, int col, int size){
        int  num = board[row][col];
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(board[i][j] != num)
                return false;
            }
        }

        return true;
    }
}