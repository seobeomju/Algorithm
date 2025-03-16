import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성

        Scanner scanner = new Scanner(System.in);

        //필요한 정보 입력 받기
        int N = scanner.nextInt();
        int k= scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        
        //삽입정렬로 내림차순으로 정렬
        for (int i = 1; i < arr.length; i++) {
            int j = i -1 ;
            int target = arr[i];
            while (j >=0 &&arr[j] < target ) {
                arr[j+1] = arr[j];
                j = j -1; 
            }
            arr[j+1] = target;
        }
        System.out.println(arr[k-1]);

        scanner.close();
    }
}