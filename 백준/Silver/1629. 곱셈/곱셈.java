import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
    
        System.out.println(pow(A,B,C));
    }

  // 분할 정복을 이용한 모듈러 거듭제곱
  public static long pow(long A, long B, long C){
    if (B == 0) return 1; // A^0 = 1

    long half = pow(A, B / 2, C);  // A^(B/2) % C 를 재귀 호출로 구함
    long result = (half * half) % C; // 결과 제곱 후 % C

    // B가 홀수면 A 한 번 더 곱하기
    if (B % 2 == 1) {
        result = (result * A) % C;
    }

    return result;
}





    //처음 생각한 아이디어
    // public static long pow(long A, long B, long C){
    //     if(checkPow(A,B,C)){
    //         B = B/2;

    //         pow(A, B, C);
    //     }

    //     return (long) (Math.pow(A, B)%C);
    // }

    // public static boolean checkPow(long A, long B, long C){
    //     if( Math.pow(A,B) < C ) return false;

    //     return true;
    // }
}