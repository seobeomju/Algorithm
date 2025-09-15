import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static long[] table;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        table = new long[N+1];

        long topDownResult = topDown(N);
        //int bottomUpResult = bottomUp(N);

        System.out.println(topDownResult);
        //System.out.println(bottomUpResult);
    }

    //topDown 방식
    public static long topDown(int n){
        if( n < 2) return table[n] = n;

        if(table[n] >0) return table[n];

        table[n] = topDown(n-1) + topDown(n-2);

        return table[n];
    }

    //Bottom-up
//     public static long bottomUp (int n){
//         table[0] = 0;
//         table[1] = 1;

//         for(int i =2 ; i<=n; i++){
//             table[i] = table[i-1] + table[i-2];
//         }

//         return table[n];
//     }
}