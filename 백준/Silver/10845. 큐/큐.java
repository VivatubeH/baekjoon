import java.io.*;
import java.util.*;

public class Main {
    public static Queue<Integer> queue = new ArrayDeque<>();
    public static StringBuilder answer = new StringBuilder();
    public static int backNumber = 0;

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
        if (instruction.startsWith("push")) {
            StringTokenizer st = new StringTokenizer(instruction);
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            backNumber = num;
            queue.offer(num);
        } else if (instruction.equals("pop")) {
            if (!queue.isEmpty()) {
                answer.append(queue.poll());
            } else {
                answer.append(-1);
            }
            answer.append("\n");
        } else if (instruction.equals("size")) {
            answer.append(queue.size()).append("\n");
        } else if (instruction.equals("empty")) {
            if (queue.isEmpty()) answer.append(1);
            else answer.append(0);
            answer.append("\n");
        } else if (instruction.equals("front")) {
            if (queue.isEmpty()) answer.append(-1);
            else answer.append(queue.peek());
            answer.append("\n");
        } else if (instruction.equals("back")) {
            if (queue.isEmpty()) answer.append(-1);
            else answer.append(backNumber);
            answer.append("\n");
        }
    }
}
