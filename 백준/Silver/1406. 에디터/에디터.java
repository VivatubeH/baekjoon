import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 커서 기준 왼쪽을 저장할 연결리스트, 오른쪽을 저장할 연결리스트 생성
        LinkedList<Character> leftLinkedList = new LinkedList<>();
        LinkedList<Character> rightLinkedList = new LinkedList<>();
        // 사용자로부터 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 최초에는 전부 다 커서 앞이니 leftLinkedList에 다 담는다.
        for (int i = 0; i < input.length(); i++) {
            leftLinkedList.add(input.charAt(i));
        }
        // 이후 M을 입력받고, M개의 명령을 매 줄마다 입력받는다.
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            // 명령어를 입력받는다.
            String instruction = br.readLine();
            // 메서드를 통해 하나씩 명령어를 실행한다.
            cursorEditor(instruction, leftLinkedList, rightLinkedList);
        }
        // 모든 명령이 수행되고 나면 커서 기준 왼쪽, 오른쪽을 붙여서 출력한다.
        StringBuilder answer = new StringBuilder();
        for (Character ch : leftLinkedList) {
            answer.append(ch);
        }
        for (Character ch : rightLinkedList) {
            answer.append(ch);
        }
        System.out.print(answer);
    }

    // 커서기준 왼쪽 연결 리스트, 오른쪽 연결리스트, 명령어를 기반으로 연산을 수행한다.
    public static void cursorEditor(String instruction, LinkedList<Character> left, LinkedList<Character> right) {
        // L이 입력되면 커서를 왼쪽으로 한 칸 옮긴다.
        if (instruction.equals("L")) {
            if (!left.isEmpty()) { // 커서가 문장의 맨 앞이면 무시
                char ch = left.pollLast(); // 제일 뒷 문자를
                right.offerFirst(ch); // 커서 뒤의 가장 앞에 옮긴다.
            }
        }
        // D가 입력되면 커서를 오른쪽으로 한 칸 옮긴다.
        else if (instruction.equals("D")) {
            if (!right.isEmpty()) { // 커서가 문장의 맨 뒤이면 무시
                char ch= right.pollFirst(); // 커서 뒤 제일 앞 문자를
                left.offerLast(ch); // 커서 앞의 제일 앞에 옮긴다.
            }
        }
        // B가 입력되면 커서 왼쪽에 있는 문자를 삭제한다.
        else if (instruction.equals("B")) {
            if (!left.isEmpty()) { // 커서가 문장의 맨 앞이면 무시
                left.pollLast(); // 커서 왼쪽에 있는 문자만 삭제한다.
            }
        }
        // P $(소문자) 가 입력되면 문자를 커서 왼쪽에 추가한다.
        else if (instruction.contains("P")) {
            // 2번째 인덱스에 위치한 소문자를 String 기준
            char ch = instruction.charAt(2);
            // 소문자를 커서 왼쪽에 입력한다.
            left.offerLast(ch);
        }
    }
}
/*
    leftLinkedList = a -> b
    rightLinkedList = c -> d

    leftLinkedList = a -> b -> c
    rightLinkedList = d
 */