import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Integer> inputStack = new ArrayDeque<>();
    public static Deque<Integer> afterStack = new ArrayDeque<>();
    public static Deque<Integer> answerStack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        algorithm();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer numberToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inputStack.push(Integer.parseInt(numberToken.nextToken()));
            }
        }
    }

    public static void algorithm() {
        while (!inputStack.isEmpty()) {
            int number = inputStack.pop();

            if (afterStack.isEmpty()) {
                answerStack.push(-1);
            } else {
                while (!afterStack.isEmpty() && afterStack.peek() <= number) {
                    afterStack.pop();
                }
                if (afterStack.isEmpty()) {
                    answerStack.push(-1);
                } else if (afterStack.peek() > number) {
                    answerStack.push(afterStack.peek());
                }
            }

            afterStack.push(number);
        }
    }

    public static void output() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Integer integer : answerStack) {
                bw.write(integer + " ");
            }
            bw.flush();
        }
    }
}
