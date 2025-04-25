import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Stack.runByInstruction(br.readLine());
        }
        Stack.print();
    }
}

class Stack {
    private static int[] stackArray =  new int[10001];
    // 이렇게 만들어도 굳이 배열의 크기를 모두 다 활용할 이유는 없음.
    // topIndex까지만 활용한다는 느낌으로 가면 됨.

    private static int topIndex = 0; // 스택의 top 인덱스는 얼마든지 바뀔 수 있다.

    private static StringBuilder sb = new StringBuilder();

    public static void runByInstruction(String instruction) {
        if (instruction.contains("push")) { // push 명령어에 한해서만 매개변수로 쪼개야함.
            String[] pushToken = instruction.split(" ");
            int args = Integer.parseInt(pushToken[1]); // 숫자를 매개변수화 합니다.
            push(args);
        } else if (instruction.contains("pop")) {
            pop();
        } else if (instruction.contains("size")) {
            size();
        } else if (instruction.contains("empty")) {
            empty();
        } else if (instruction.contains("top")) {
            top();
        }
    }

    public static void push(int number) {
        topIndex++; // 최상단의 인덱스를 늘립니다.
        stackArray[topIndex] = number; // 최상단에 값을 저장합니다.
    }

    public static void pop() {
        if (topIndex == 0) { // 만약 스택에 들어있는 정수가 없는 경우라면
            sb.append(-1).append("\n");
        } else { // 스택에 값이 들어있는 경우에만
            sb.append(stackArray[topIndex]).append("\n");
            topIndex--; // 최상단 정수를 출력합니다.
        }
    }

    public static void size() {
        sb.append(topIndex).append("\n"); // topIndex만큼이 스택에 들어있는 정수의 개수입니다.
    }

    public static void empty() {
        if (topIndex == 0) { // topIndex가 0이면 스택이 비어있는 것이므로
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void top() {
        if (topIndex != 0) { // 스택에 정수가 들어있는 경우에만
            sb.append(stackArray[topIndex]).append("\n"); // 최상단 정수를 출력하고
        } else {
            sb.append(-1).append("\n"); // 아닌 경우에는 -1을 출력합니다.
        }
    }

    public static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}