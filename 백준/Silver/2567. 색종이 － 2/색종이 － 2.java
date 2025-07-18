import java.util.*;
import java.io.*;

public class Main {
    // 가로 100, 세로 100인 정사각형 모양 흰색 도화지
    // 색종이는 1 ~ 99번 칸에만 붙을 수 있다.
    // 즉 0번 칸과 100번칸은 경계조건으로 사용할 더미칸
    // 배열에서는 y, x 좌표로 돌아간다고 보면 됨.
    private static boolean[][] paper = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 수를 입력받는다.
        int testCase = Integer.parseInt(br.readLine());
        // 테스트 케이스의 수만큼 색칠한다.
        for (int i = 0; i < testCase; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(token.nextToken());
            int row = Integer.parseInt(token.nextToken());

            checkPaper(col, row);
        }
        // 모든 칸이 색칠이 다 되면 해당 칸이 둘레인지 판단한다.
        // 둘레 칸의 개수를 세주면 된다.
        System.out.print(checkPerimeter());
    }

    // 좌표 2개가 주어질 때, 좌표 2개를 토대로 10칸씩 색종이를 붙인다.
    public static void checkPaper(int col, int row) {
        // 행을 순회한다.
        for (int y = row; y <= row + 9; y++) {
            // 열을 순회한다.
            for (int x = col; x <= col + 9; x++) {
                // x, y를 2차원 배열로 옮기면 y, x 꼴이어야 한다.
                paper[y][x] = true;
            }
        }
    }

    // 색종이가 붙은 필드에서 둘레 칸의 개수를 구한다.
    public static int checkPerimeter() {
        // 색종이가 붙을 수 있는 칸만 검사한다.
        int count = 0;
        for (int row = 1; row <= 99; row++) {
            for (int col = 1; col <= 99; col++) {
                count += countPerimeter(col, row);
            }
        }
        return count;
    }

    // 해당 칸이 둘레 몇 칸을 차지하는 지 세는 메서드
    public static int countPerimeter(int x, int y) {
        int count = 0;
        // 해당칸이 빈칸이면 둘레가 될 수 없으니 0 반환
        if (!paper[y][x]) return count;

        // 해당칸의 상하좌우 하나라도 빈칸이면 둘레이다.
        // 열 기준 상, 하, 좌, 우
        int[] dcol = {0, 0, -1, 1};
        // 행 기준 상, 하, 좌, 우
        int[] drow = {-1, 1, 0, 0};
        // 해당 칸의 상하좌우를 검사한다.
        for (int i = 0; i <= 3; i++) {
            int newCol = x + dcol[i];
            int newRow = y + drow[i];

            // 이동한 칸이 빈칸이면 빈 칸의 개수만큼 둘레의 개수가 된다.
            // 몇 개의 변이 되는지 체크한다.
            if (!paper[newRow][newCol]) count++;
        }
        // 해당 칸의 검사가 끝나면 변의 개수 반환
        return count;
    }
}