import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String instruction = br.readLine();
                execute(instruction);
            }
        }
    }

    public static void execute(String instruction) {
        StringTokenizer st = new StringTokenizer(instruction);
        String instruct = st.nextToken();

        int result = 0;

        if (instruct.equals("top")) {
            result = MyStack.top();
            answer.append(result).append("\n");
        } else if (instruct.equals("pop")) {
            result = MyStack.pop();
            answer.append(result).append("\n");
        } else if (instruct.equals("size")) {
            result = MyStack.size();
            answer.append(result).append("\n");
        } else if (instruct.equals("empty")) {
            result = MyStack.isEmpty();
            answer.append(result).append("\n");
        } else {
            int num = Integer.parseInt(st.nextToken());
            MyStack.push(num);
        }
    }
}

class MyStack {
    static int[] list = new int[10];
    static int capacity = 10;
    static int size = 0;

    public static void push(int x) {
        if (size == capacity) {
            int[] newList = new int[capacity * 2];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
            capacity = capacity * 2;
        }
        list[size++] = x;
    }

    public static int pop() {
        if (size == 0) return -1;
        int top = list[size - 1];
        size--;
        return top;
    }

    public static int size() {
        return size;
    }

    public static int isEmpty() {
        if (size == 0) return 1;
        return 0;
    }

    public static int top() {
        if (size == 0) return -1;
        return list[size - 1];
    }
}