import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


//처음 시간 초과 뜸
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<String> editor = new LinkedList<>();
        String  input  = br.readLine();
        for( String s : input.split("")){
            editor.add(s);
        }

        //기존 cursor 시간 초과가 뜸 -> index기반 조작은 시간 복잡도 때문에 안됨
        //int cursor = editor.size();
        ListIterator<String> cursor = editor.listIterator(editor.size());
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if(cursor.hasPrevious()) cursor.previous();
                    break;
                case "D":
                    if(cursor.hasNext()) cursor.next();
                    break;
                case "B":
                    if(cursor.hasPrevious()){
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case "P":
                    String inputValue = st.nextToken();
                    cursor.add(inputValue);
                    break;
            }
        }

       for(String data : editor){
        sb.append(data);
       }
       System.out.println(sb.toString());
    }
}