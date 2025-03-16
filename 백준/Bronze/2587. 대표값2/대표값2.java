import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner scanner = new Scanner(System.in);

        // 배열 입력받기
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        //평균
        int avg =0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        avg = avg/5;

        //중앙값 버블정렬 사용
        for ( int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i -1 ; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(avg);
        System.out.println(arr[arr.length/2]);

    }
}