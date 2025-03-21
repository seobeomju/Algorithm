import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    //시간 초과 뜸
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] inputArr = new int[N];
        int[] countingArr = new int[10001];
        int[] sortArr = new int[N];
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }


        //arr의 값에 해당하는 counting_arr를 1증가
        for (int i = 0; i < inputArr.length; i++) {
            countingArr[inputArr[i]]++;
        }
        //countint_arr의 이전 값만큼 증가
        for (int i = 1; i < countingArr.length; i++) {
            countingArr[i] +=countingArr[i-1];
        }

        //안정성을 위해서 뒤에서 앞으로 1을 빼주며 sort배열에 정렬
        for(int i = inputArr.length-1; i>=0; i--){
            countingArr[inputArr[i]] --;
            sortArr[countingArr[inputArr[i]]] = inputArr[i];
        }

        for (int i = 0; i < sortArr.length; i++) {
            sb.append(sortArr[i]).append("\n");
        }
    System.out.println(sb);
        
    }
}