import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] field = new boolean[101][101]; // 1번부터 100까지 인덱스를 조작없이 활용하기 위해 1크게 만듭니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) { // 4개의 줄에 걸쳐서 직사각형의 좌표를 입력받습니다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            print(x1, x2, y1, y2);
        }

        int size = size();
        System.out.print(size);
    }

    // 색칠할 때 끝을 빼줘야 꼭짓점까지 색칠하는 불상사가 방지됩니다.
    public static void print(int x1, int x2, int y1, int y2) {
        for (int i = y1; i < y2; i++) { // y좌표가 행이 되고
            for (int j = x1; j < x2; j++) { // x좌표가 열이 되도록
                field[i][j] = true; // 해당 칸을 색칠합니다.
            }
        }
    }

    // 넓이를 구합니다.
    public static int size() {
        int size = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (field[i][j]) {
                    size++;
                }
            }
        }
        return size;
    }
}
