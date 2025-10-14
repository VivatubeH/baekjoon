import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int K;
    public static StringBuilder answer = new StringBuilder("<");
    public static Deque<Integer> list = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        service();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        }
    }

    public static void service() {
        initialize();
        makePermutation();
        output();
    }

    public static void initialize() {
        for (int i = 1; i <= N; i++) {
            list.addLast(i);
        }
    }

    public static void makePermutation() {
        while (!list.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                Integer integer = list.removeFirst();
                list.addLast(integer);
            }
            answer.append(list.removeFirst());
            if (!list.isEmpty()) {
                answer.append(", ");
            }
        }
        answer.append(">");
    }

    public static void output() {
        System.out.print(answer);
    }
}
