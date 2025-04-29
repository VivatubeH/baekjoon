import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) { // N개의 명령어를 실행합니다.
            CustomDeck.execute(br.readLine());
        }
        // 출력은 한 번에 StringBuilder를 통해 처리하겠습니다.
        System.out.print(CustomDeck.getStringBuilder());
    }
}

class CustomDeck {
    // 명령어를 기반으로 일치하는 메서드를 매핑해서 실행해주는 메서드입니다.
    // switch ~ case로 문자열을 비교하되, 어차피 break 없이 메서드 실행후에는 return으로 종료합니다.
    private static ArrayList<Integer> numbers = new ArrayList<>(); // 크기 지정 없고, 뒤로 자유롭게 밀기 위해서 ArrayList를 사용합니다.
    private static StringBuilder sb = new StringBuilder();

    // StringBuilder를 제공받습니다.
    public static StringBuilder getStringBuilder() {
        return sb;
    }

    public static void execute(String instruction) {
        // 만약 공백을 포함하고 있다면 push_front, push_back 메서드니 정수를 매개변수화 해야 합니다.
        if (instruction.contains(" ")) { // 공백을 포함하고 있으면
            String[] token = instruction.split(" "); // 공백을 기준으로 토큰화합니다.
            switch(token[0]) {
                case "push_front":
                    pushFront(Integer.parseInt(token[1])); // 정수를 매개변수로 넘겨서 메서드를 실행합니다.
                    return;
                case "push_back":
                    pushBack(Integer.parseInt(token[1])); // 마찬가지로 정수를 매개변수로 넘겨서 메서드를 실행합니다.
                    return;
            }
        } else {
            switch(instruction) {
                case "pop_front":
                    popFront();
                    return;
                case "pop_back":
                    popBack();
                    return;
                case "size":
                    size();
                    return;
                case "empty":
                    empty();
                    return;
                case "front":
                    front();
                    return;
                case "back":
                    back();
                    return;
            }
        }
    }

    // 앞에 정수를 넣는 메서드
    public static void pushFront(int x) {
        numbers.add(0, x); // ArrayList의 0번 인덱스에 정수를 넣으면 어차피 기존 정수들은 뒤로 밀립니다.
    }

    // 뒤에 정수를 넣는 메서드
    public static void pushBack(int x) {
        numbers.add(x); // 별도 인덱스 지정 없이 값을 넣으면 뒤에 들어가게 됩니다.
    }

    // 가장 앞의 정수를 빼고 출력하는 메서드 ( 덱에 정수가 없을 때 -1 출력 )
    public static void popFront() {
        if (numbers.isEmpty()){ // 덱에 정수가 없으면
            sb.append(-1).append("\n"); // -1을 이어붙이고 줄바꿈.
            return;
        }
        Integer num = numbers.remove(0); // 가장 앞에 있는 수를 빼고
        sb.append(num).append("\n"); // 그 수를 이어붙이고 줄바꿈.
    }

    public static void popBack() {
        if (numbers.isEmpty()) {
            sb.append(-1).append("\n");
            return;
        }
        Integer num = numbers.remove(numbers.size() - 1); // 크기-1인 가장 마지막 인덱스의 원소를 제거합니다.
        sb.append(num).append("\n"); // 그 수를 이어붙이고 줄바꿈을 합니다.
    }

    public static void size() {
        sb.append(numbers.size()).append("\n"); // size() 메서드를 활용합니다.
    }

    public static void empty() {
        if (numbers.isEmpty()) { // 비어 있으면
            sb.append("1").append("\n"); // 비어 있으면 1을 붙입니다.
        } else {
            sb.append("0").append("\n"); // 아니면 0을 붙입니다.
        }
    }

    public static void front() {
        if (numbers.isEmpty()) {
            sb.append("-1").append("\n"); // 비어 있으면 -1을 출력합니다.
        } else {
            sb.append(numbers.get(0)).append("\n"); // 값이 있으면 가장 앞에 있는 정수를 출력합니다.
        }
    }

    public static void back() {
        if (numbers.isEmpty()) {
            sb.append("-1").append("\n"); // 비어 있으면 -1을 출력합니다.
        } else {
            sb.append(numbers.get(numbers.size() - 1)).append("\n"); // 가장 마지막 원소를 이어붙입니다.
        }
    }

}
