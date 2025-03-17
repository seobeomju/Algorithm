import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] arr = new int[10];
        int count =0;
        int result =0;
        //countSort 처럼 새로운 배열 생성
        while (N != 0) {
            arr[N%10]++;
            N /= 10;
            count++;
        }
        //배열 생성 확인
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }

        //i값이 있을경우 0이 될때까지 반복
        for (int i = arr.length-1; i >=0 ; i--) {
                while(arr[i]--> 0){
                    result = result + (int)(i * Math.pow(10,count-1));
                    count -- ; 
            }
         }
        System.out.println(result);
        

        scanner.close();
    }
}