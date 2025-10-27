import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] candidate;
    public static boolean[] isSelected;
    public static int[] selected;
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        permutation(0);
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer firstLine = new StringTokenizer(br.readLine());
            N = Integer.parseInt(firstLine.nextToken());
            M = Integer.parseInt(firstLine.nextToken());
            candidate = new int[N];
            isSelected = new boolean[N];
            selected = new int[M];

            StringTokenizer secondLine = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                candidate[i] = Integer.parseInt(secondLine.nextToken());
            }
            Arrays.sort(candidate);
        }
    }

    public static void permutation(int depth) {
        // M개를 다 뽑았으면
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                selected[depth] = candidate[i];
                permutation(depth + 1);
                isSelected[i] = false;
            }
        }
    }
}
