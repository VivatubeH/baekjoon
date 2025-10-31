import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> tree = new ArrayList<>();
    public static int N; 
    public static int R; 
    public static int Q; 
    public static boolean[] isVisited; 
    public static int count; 
    public static int[] subTree; 

    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(answer);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N + 1; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                tree.get(U).add(V);
                tree.get(V).add(U);
            }

            subTree = new int[N + 1];
            dfs(R, -1);

            for (int i = 0; i < Q; i++) {
                int U = Integer.parseInt(br.readLine());
                answer.append(subTree[U]).append("\n");
            }
        }
    }

    public static int dfs(int current, int parent) {
        int size = 1; 

        for (int next : tree.get(current)) {
            if (next != parent) {
                size += dfs(next, current);
            }
        }
        subTree[current] = size;
        return size;
    }
}
