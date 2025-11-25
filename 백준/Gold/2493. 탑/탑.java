import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Top> stack = new ArrayDeque<>();
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int index = 1; index <= N; index++) {
                int height = Integer.parseInt(st.nextToken());
                lazer(new Top(index, height));
            }
        }
    }

    public static void lazer(Top top) {
        if (stack.isEmpty()) {
            answer.append("0 ");
            stack.push(top);
            return;
        }
        while (!stack.isEmpty() && (stack.peek().height < top.height)) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            answer.append("0 ");
            stack.push(top);
            return;
        } else {
            answer.append(stack.peek().index).append(" ");
            stack.push(top);
        }
    }
}

class Top {
    int index;
    int height;

    Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}