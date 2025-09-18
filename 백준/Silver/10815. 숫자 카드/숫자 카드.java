import java.io.*;
import java.util.*;

public class Main {
    public static Set<Integer> set = new HashSet<>();
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int current = Integer.parseInt(st.nextToken());
                if (set.contains(current)) {
                    answer.append("1 ");
                } else {
                    answer.append("0 ");
                }
            }
        }
    }

    public static void output() throws IOException {
        System.out.print(answer);
    }
}
