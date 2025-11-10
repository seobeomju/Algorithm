import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        LinkedList<String> keyLog = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        ListIterator<String> cursor = keyLog.listIterator(0);
        for (int i = 0; i < N; i++) {
            String inputString = br.readLine();
            for(String s : inputString.split("")){
                switch (s) {
                    case "<":
                        if(cursor.hasPrevious()) cursor.previous();
                        break;
                    case ">":
                        if(cursor.hasNext()) cursor.next();
                        break;
                    case "-":
                        if(cursor.hasPrevious()){
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                    cursor.add(s);
                        break;
                }
            }

            for(String data : keyLog){
            sb.append(data);
        }
        System.out.println(sb.toString());
        sb.setLength(0);
        keyLog.clear();
        cursor = keyLog.listIterator(0);
        }
    }
}