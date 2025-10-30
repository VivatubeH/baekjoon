import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] parent;
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                graph.get(num1).add(num2);
                graph.get(num2).add(num1);
            }
        }
    }

    public static void bfs() {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        // 1. 루트 노드 방문처리 ( 문제에서 1번 노드를 루트노드라 함 )
        queue.offer(1);
        isVisited[1] = true;

        // 2. BFS 탐색
        while (!queue.isEmpty()) {
            // 3. 현재 방문한 노드에 대한 방문 처리
            int current = queue.poll();
            isVisited[current] = true;

            // 4. 현재 노드와 이웃한 노드 체크
            for (int next : graph.get(current)) {
                // 5. 방문한 적이 없으면 현재 노드가 부모노드
                if (!isVisited[next]) {
                    parent[next] = current;
                    isVisited[next] = true; // 현재 노드 방문 처리
                    queue.offer(next); // 다음 번 bfs 탐색을 위해 큐에 추가
                }
            }
        }
    }

    public static void output() throws IOException {
        StringBuilder answer = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            answer.append(parent[i]).append("\n");
        }

        System.out.print(answer);
    }
}