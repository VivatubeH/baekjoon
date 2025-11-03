import java.io.*;
import java.util.*;

public class Main {
    // N x M 크기의 미로판
    public static int N;
    public static int M;
    public static boolean[][] isVisited; // 방문 여부를 체크하기 위한 배열
    public static int[][] maze; // 원래 미로의 상태를 저장할 배열
    public static int[][] distance; // (0,0)에서 떨어진 거리를 재기 위한 배열

    public static void main(String[] args) throws IOException {
        input();
        bfs(1, 1); // (1, 1)에서 bfs 탐색을 시작해서, (N, M)에 닿으면 종료
        System.out.print(distance[N][M]); // (N, M)까지 이동 칸수를 출력합니다.
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 좌표는 (1,1)부터 시작이므로 1싹 크게 만듭니다.
            isVisited = new boolean[N + 1][M + 1];
            maze = new int[N + 1][M + 1];
            distance = new int[N + 1][M + 1];
            // N줄에 걸쳐 maze의 상태를 기록합니다.
            for (int i = 1; i <= N; i++) {
                String input = br.readLine();
                for (int j = 1; j <= M; j++) {
                    maze[i][j] = input.charAt(j - 1) - '0';
                }
            }
        }
    }

    // 단, (1, 1) 고정일 때 가능합니다.
    // 그게 아니라면 매번 distance를 초기화 해야 합니다.
    public static void bfs(int x, int y) {
        if (x != 1 && y != 1) {
            System.out.print("시작점인 (1, 1) 좌표는 고정입니다.");
            return;
        }

        Queue<int[]> queue = new ArrayDeque<>(); // int 배열을 저장할 큐
        queue.add(new int[]{x, y}); // 시작점을 큐에 넣습니다.
        isVisited[x][y] = true; // 시작점에 대해 방문 체크를 합니다.
        distance[x][y] = 1; // 시작칸도 세야 합니다.

        // 2차원 배열에 대한 bfs 탐색을 시작합니다.
        while (!queue.isEmpty()) {
            // 큐에서 해당 칸을 꺼냅니다.
            int[] current = queue.poll();

            // 상하좌우 이동을 빠르게 하기 위한 방향 배열입니다.
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            // 현재칸에서 상하좌우 이동을 해봅니다.
            for (int i = 0; i < 4; i++) {
                // 다음칸입니다.
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                // 다음칸이 범위 밖이면 무시합니다.
                if (nextX < 1 || nextX > N || nextY < 1 || nextY > M) {
                    continue;
                }
                // 방문하지 않은 칸 + 이동할 수 있는 칸이어야
                // 이동하고 거리를 측정하고, 다음 bfs 탐색을 위해 큐에 넣습니다.
                if (!isVisited[nextX][nextY] && maze[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = true; // 이동
                    // 현재 칸에서 1칸 이동입니다.
                    distance[nextX][nextY] = distance[current[0]][current[1]] + 1;
                    // 다음 bfs 탐색을 위해 큐에 넣습니다.
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
