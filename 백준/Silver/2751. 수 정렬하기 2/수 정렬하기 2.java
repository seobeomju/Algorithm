import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

//오류 뜸 => 해결
//새로운 오류 메모리초과
class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N]; 
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            queue.add(scanner.nextInt());
            
        } //end for
        for (int i = 0; i<N; i++){
            sb.append(queue.poll()).append("\n");
        }
        System.out.println(sb);
        scanner.close();
    }
    //heap정렬
    //QuickSort pivot을 기준으로 호출
    // public static void QuickSort(int[] arr, int start, int end) {
    //     if(start < end){
    //         int pivot = partition(arr,start,end);

    //         //재귀호출 왼쪽, 오른쪽
    //         QuickSort(arr, start, pivot -1);
    //         QuickSort(arr, pivot+1, end);
    //     }
    // }

    // //pivot을 기준으로 퀵정렬 후 새로운 pivot반환
    // public static int partition(int[] arr, int start, int end){
    //     int pivot = start + (end-start)/2;
    //     int pivotValue = arr[pivot];
    //     int left = start;
    //     int right =end;
    //     //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
    //     //while문에 left <= right추가해야함
    //     while (left <= right) {
    //         while (left<= right &&arr[left]<=pivotValue){
    //             left++;
    //         }
    //         while (left <= right && arr[right]>=pivotValue){
    //             right--;
    //         }
    //         //더이상 이동하지 못하면 스왑을 진행
    //         if(left<=right){
    //             int temp = arr[left];
    //             arr[left]=arr[right];
    //             arr[right]=temp;
    //             left ++;
    //             right --;
    //         }
    //     }//end while
    
    //     //새로운 피벗 위치 반환
    //     return left;
    // }
}