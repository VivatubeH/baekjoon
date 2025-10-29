import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] candidate;
    public static int[] selected;
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        combination(0, 0);
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            candidate = new int[N];
            selected = new int[M];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                candidate[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(candidate);
        }
    }

    public static void combination(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            selected[depth] = candidate[i];
            combination(i + 1, depth + 1);
        }
    }
}
