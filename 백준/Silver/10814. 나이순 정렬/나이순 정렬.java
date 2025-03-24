import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Main {
    //객체생성
    public static class Person{
        int age;
        String name;
        public Person(int age, String name) {
             this.age = age;
             this.name = name;
        }
    
    }
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> member = new ArrayList<>();

        //이렇게 입력받으려면 줄바꿈이 되야함
        // for (int i = 0; i < N; i++) {
        //     member.add(new Person(
        //         Integer.parseInt(br.readLine()),  
        //         br.readLine()                         
        //     ));
        //  } //end for

        // 한줄에 입력 받아서(readLine 한번만사용) 나눠서 저장 후 배열에 채우기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            member.add(new Person(
                Integer.parseInt(input[0]),
                input[1]
            ));
        }
        Collections.sort(member, (a,b)->{
            
                return a.age-b.age;
                //아 문제 잘못 읽어서 나이가 같으면 사전순 정렬도 해버림
            // }else{
            //     return a.name.compareTo(b.name);
            // }
            
        });

        for (Person person : member){
            System.out.println(person.age + " " +person.name);
        }

    }
}