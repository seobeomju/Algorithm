import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        // R(뒤집기): 배열에 있는 수의 순서를 뒤집음
        // D(버리기): 첫 번째 수를 버리는 함수 -> 비어있을 때 사용하면 에러 발생
        // 함수는 조합해서 한 번에 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스의 개수 T
        int T = Integer.parseInt(br.readLine());

        // T갯수만큼 반복
        for (int i = 0; i < T; i++) {
            Deque<String> deque = new ArrayDeque<>();
            // 수행할 함수 p가 주어짐
            // StringTokenizer st = new StringTokenizer(br.readLine());
            String func = br.readLine();
            char[] funcArray = func.toCharArray();
            String result = null;

            // 배열에 들어있는 수의 갯수
            int n = Integer.parseInt(br.readLine());

            // 문자열의 입력받고 양쪽 괄호 제거
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);

            // ,를 기준으로 나눠서 덱에 입력
            if (!input.isEmpty()) {
                for (String s : input.split(",")) {
                    deque.add(s);
                }
            }

            // 직접 뒤집으면 시간 초과가 남
            // for (int j = 0; j < funcArray.length; j++) {
            // if(funcArray[j]=='R'){
            // for (int k = 0; k < deque.size(); k++) {
            // String temp = deque.peek();
            // deque.addLast(temp);
            // }
            // }else{
            // try {
            // deque.remove();
            // } catch (Exception e) {
            // System.out.println("error");
            // break;
            // }

            // }
            // }

            // 뒤집혓는지 안 뒤집혔는지 판단하는 용
            boolean isfront = true;
            for (int j = 0; j < funcArray.length; j++) {
                if (funcArray[j] == 'R') {
                    isfront = (isfront) ? false : true;
                } else {
                    if (deque.isEmpty()) {
                        result = "error";
                        break;
                    }

                    if (isfront) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (result=="error") {
                sb.append(result).append("\n");
                
            } else {
                sb.append("[");
                if (isfront) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);

    }
}