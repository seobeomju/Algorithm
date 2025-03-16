import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
       //배열의 크기 입력 받기
        int N = Integer.parseInt(scanner.nextLine());

        //입력 받은 크기 만큼 배열 생성
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
       
        //선택정렬로 풀이
        for (int i = 0; i < N-1; i++) {
            int min = i;
            for (int j = i+1; j < N ; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
                
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}