import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner scanner  = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][2];
        
        
    for (int i = 0; i < N; i++) {
        for (int j = 1; j >= 0; j--) {
            arr[i][j] = scanner.nextInt();
        }
    }

    //람다식을 활용하여 Arrary.sort를 사용하여 풀이
    Arrays.sort(arr,(e1,e2)->{
        if (e1[0] == e2[0]) {
            return e1[1] - e2[1];
        }else {
            return  e1[0] - e2[0];
        }
    });
    
    for (int i = 0; i < N; i++) {
        System.out.println(arr[i][1]+" "+arr[i][0]);
    }

        scanner.close();
    }
}