import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Student> list = new ArrayList<>();
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 도현이네 반의 학생 수 N ( 1 <= N <= 100,000 )이 주어집니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N개의 줄에 걸쳐서 한 줄에 하나씩 학생 이름, 국어, 영어, 수학 점수가 공백으로 구분되어서 주어집니다.
        // 점수는 1과 100 사이의 자연수이며 이름은 알파벳 대소문자로 이루어진 문자열이며 길이는 10자리를 넘지 않습니다.
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name, korean, english, math);
            list.add(student);
        }

        // 입력이 끝났으면 정렬합니다.
        Collections.sort(list, (s1, s2) -> {
            if (s2.korean == s1.korean && s2.english == s1.english && s2.math == s1.math) {
                return s1.name.compareTo(s2.name); // 사전 순으로 증가하는 순서로
            }
            if (s2.korean == s1.korean && s2.english == s1.english) {
                return s2.math - s1.math; // 국어 영어 점수가 같으면 수학 점수가 감소하는 순서로
            }
            if (s2.korean == s1.korean) {
                return s1.english - s2.english; // 국어 점수가 같으면 영어 점수는 증가하는 순서로
            }
            return s2.korean - s1.korean; // 기본적으로는 국어 점수가 감소하는 순서로
        });

        // 이름을 정답에 붙여서 한 번에 출력하겠습니다.
        for (Student student : list) {
            answer.append(student.name + "\n");
        }
        System.out.print(answer);
    }
}

class Student {
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}
