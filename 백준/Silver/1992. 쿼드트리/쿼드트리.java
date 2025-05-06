import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static int white =0;
    public static int black =0;
    
    public static int[][] board;

    //public static ArrayList<String> result = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder(); //개선
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            //입력에 띄어쓰기가 없으므로 이렇게 해야 함
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                // *** 문자 (char)를 정수(int)로 변환
                board[i][j] = line.charAt(j) - '0';
            }
        }

        divide(0,0,N);

        // StringBuilder sb = new StringBuilder();
        // for (String s : result) {
        //     sb.append(s);
        // }
        // System.out.println(sb);
        System.out.println(sb.toString());
    }


    public static void divide(int row, int col, int size){
        if(colorCheck(row,col,size)){
            if(board[row][col] == 0){
                //result.add("0");
                sb.append("0");
            }
            else{
                //result.add("1");
                sb.append("1");
            }

            return;
        }

        //result.add("(");
        sb.append('(');

        int newSize = size/2;

        //1사분면
        divide(row,col,newSize);

        //2사분면
        divide(row, col + newSize, newSize);

        //3사분면
        divide(row + newSize, col, newSize);

        //4사분면
        divide(row + newSize, col + newSize , newSize);

        //result.add(")");
        sb.append(")");
    }

    public static boolean colorCheck(int row, int col, int size){
        
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(board[i][j] != board[row][col]) return false;
            }
        }

        //모두 같은색이면 true
        return true;
    }
}