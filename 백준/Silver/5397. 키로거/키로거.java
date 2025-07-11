import java.io.*;
import java.util.*;

public class Main {
    // 커서 앞을 담당할 연결리스트
    public static Deque<Character> beforeCursor = new LinkedList<>();
    // 커서 뒤를 담당할 연결리스트
    public static Deque<Character> afterCursor = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 수 N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) { // 테스트 케이스의 수만큼
            // 각각의 테스트 케이스를 입력받는다.
            String testCase = br.readLine();
            // 테스트 케이스에 대해 비밀번호를 알아내고 출력한다.
            printPassword(testCase);
        }
    }

    // 입력칸을 토대로 비밀번호를 알아내서 출력한다.
    public static void printPassword(String input) {
        // 각 글자에 대해 판단해서 연산을 수행해야 한다.
        for (int i = 0; i < input.length(); i++) {
            // 해당 글자를 얻어온다.
            char ch = input.charAt(i);
            // 해당 글자에 대한 연산을 수행한다.
            executeByChar(ch);
        }
        // 알아낸 비밀번호를 출력한다.
        StringBuilder answer = new StringBuilder();
        // 커서 기준 앞뒤를 붙이면 알아낸 비밀번호가 나온다
        for (char before : beforeCursor) {
            answer.append(before);
        }
        for (char after : afterCursor) {
            answer.append(after);
        }
        // 비밀번호를 출력한다.
        System.out.println(answer);
        // 이후 다음번 메서드 실행을 위해 커서 앞뒤를 초기화한다.
        beforeCursor.clear();
        afterCursor.clear();
    }

    // 각 칸의 글자에 대해 연산을 수행한다.
    public static void executeByChar(char ch) {
        if (ch == '<') { // 커서 좌측 이동
            // 커서 좌측이 하나라도 있어야 커서 좌측 이동 가능.
            if (!beforeCursor.isEmpty()) {
                // 커서 앞의 맨뒤를 커서 뒤의 맨앞에 붙인다.
                char target = beforeCursor.pollLast();
                afterCursor.offerFirst(target);
            }
        }
        else if (ch == '>') { // 커서 우측 이동
            // 커서 우측이 하나라도 있어야 커서 우측 이동 가능.
            if (!afterCursor.isEmpty()) {
                // 커서 뒤의 맨앞을 커서 앞의 맨뒤에 붙인다.
                char target = afterCursor.pollFirst();
                beforeCursor.offerLast(target);
            }
        }
        else if (ch == '-') { // 백스페이스
            // 커서 바로 앞 글자가 존재하면 그 글자를 지운다.
            if (!beforeCursor.isEmpty()) {
                beforeCursor.pollLast();
            }
        } else { // 다 아니면 커서의 좌측 끝에 문자를 추가한다.
            // 커서가 줄의 마지막이 아니라면
            // ab|cd -> e추가 -> abe|cd
                beforeCursor.offerLast(ch);
            }
        }
}

