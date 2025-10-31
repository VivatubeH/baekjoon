import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[][] painting;
    public static boolean[][] isVisited;
    public static int count = 0;
    public static int maxSize = 0;

    public static void main(String[] args) throws IOException {
        input();
        service();
        System.out.println(count);
        System.out.println(maxSize);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            painting = new int[N + 1][M + 1];
            isVisited = new boolean[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    painting[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Axis> queue = new ArrayDeque<>();
        int size = 0;
        // 방문 체크를 한다.
        isVisited[startX][startY] = true;
        // 큐에 넣는다.
        queue.offer(new Axis(startX, startY));
        size++; // 첫칸의 크기를 더한다.

        // 2차원 탐색을 편하게 하기 위한 dx, dy 배열 생성
        // 0 -> 상, 1 -> 하, 2 -> 좌, 3 -> 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1 ,1};

        // 큐에 뭐가 있다 == 탐색할 칸이 남아있음.
        while (!queue.isEmpty()) {
            // 해당 칸을 꺼냅니다.
            Axis axis = queue.poll();
            // 해당 칸에 대한 상하좌우 탐색을 합니다.
            for (int i = 0; i < 4; i++) {
                int x = axis.x + dx[i];
                int y = axis.y + dy[i];

                // 상하좌우 좌표가 유효하지 않으면 체크하지 않습니다.
                if (x < 1 || x > N || y < 1 || y > M) {
                    continue;
                }
                // 그림이 있으면서 방문한적이 없는 칸이라면
                // 방문 체크를 하고 크기 계산을 한 뒤
                // 다음 번 탐색을 위해 큐에 넣습니다.
                if (painting[x][y] == 1 && !isVisited[x][y]) {
                    isVisited[x][y] = true;
                    size++;
                    queue.offer(new Axis(x, y));
                }
            }
        }
        // bfs 탐색이 끝날 때 체크된 칸 수가 연결된 길이입니다.
        if (size > maxSize) maxSize = size;
        // 한 번의 탐색 당 그림 한 개입니다.
        count++;
    }

    // 그림이 그려져 있고, 방문한 적 없는 칸에 대해서는 bfs 탐색을 수행합니다.
    public static void service() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (painting[i][j] == 1 && !isVisited[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }
}

class Axis {
    int x;
    int y;

    public Axis(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
