import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사용자의 입력을 받기 위해 BufferedReader 객체를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 세로 N, 가로 M, 현재 블럭의 수 B가 주어집니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int initialBlock = Integer.parseInt(st.nextToken()); // 초기 블럭의 개수

        // 초기 높이를 저장하기 위한 배열입니다.
        int[][] heights = new int[N][M];

        // N개의 줄에 걸쳐서 공백을 기준으로 정수들이 입력됩니다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                // 초기 높이를 배열에 저장합니다.
                heights[i][j] = height;
            }
        }

        // 블럭을 제거하는 데 걸리는 시간 2초, 블럭을 쌓는데 걸리는 시간은 고정입니다.
        final int REMOVE_TIME = 2;
        final int ADD_TIME = 1;

        int minTime = Integer.MAX_VALUE; // 땅을 고르는 데 걸리는 최소 시간을 저장하기 위한 변수입니다.
        int maxHeight = 0; // 최소 시간 중 최대 높이를 저장하기 위한 변수입니다.

        // 반복문을 돌면서 0 ~ 256초에 대해서 걸리는 시간을 구하면 됩니다.
        // 이 때 걸리는 시간이 최소인 걸 고르고, 최소인 게 여러개가 되면 가장 높은 땅의 높이를 고르면 되기 때문에
        // 반복문을 돌면서 최소인 게 또 나오면 최대 높이를 비교해야 합니다.
        // 단, 반복마다 초기 블럭의 개수는 동일해야 합니다.
        for (int height = 0; height <= 256; height++) { // 높이가 0부터 256까지 돌면서 테스트를 진행합니다.
            int timeSum = 0; // 현재까지 누적된 시간을 구하기 위한 변수입니다.
            int block = initialBlock; // 각 높이를 맞추는 케이스에 대해 초기 블럭 개수는 동일하게 할당합니다.

            // 중요한 점은 굳이 순서대로 빼거나 더할 필요가 없다는 점입니다.
            // 따라서 모든 작업을 마치고 블럭 개수가 음수가 되버리면 해당 작업은 수행이 불가능하다는 뜻입니다.
            // -> 즉 block이 음수가 아닐 때만 최소 시간, 최대 높이를 판단하고 아닌 경우 그냥 패스합니다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 목표 높이 height와 현재 높이와의 차이를 구합니다.
                    int diff = height - heights[i][j];

                    // 해당 높이가 0보다 크다는 건 블럭 쌓기가 필요하다는 말이고
                    if (diff > 0) {
                        // 차이만큼 블럭을 쌓습니다. -> diff만큼 인벤토리에서 블럭의 개수가 줄어들고, diff * ADD_TIME 만큼 시간이 걸립니다.
                        block -= diff; // 인벤토리에서 그만큼 블럭을 빼고
                        timeSum += diff * ADD_TIME; // 시간이 경과됩니다.
                    }
                    // 해당 높이가 0보다 작다는 건 블럭 빼기가 필요하다는 말입니다.
                    else if (diff < 0) {
                        // 차이가 음수니깐 차이를 양수로 바꾸고
                        diff *= -1;
                        // 차이만큼 블럭을 뺍니다. -> diff만큼 인벤토리에 블럭의 개수가 늘어나고, diff * REMOVE_TIME만큼 시간이 걸립니다.
                        block += diff;
                        timeSum += diff * REMOVE_TIME;
                    }
                }
            }

            // 해당 높이에 대해 모든 블럭에 대한 순회가 끝났을 때 블럭 개수가 음수가 아닐 때만 수행 가능한 케이스이므로
            if (block >= 0) {
                // 시간 및 높이 체크가 들어갑니다.
                if (timeSum <= minTime) { // 최소 시간일 때만, 이렇게 하면 최소 시간이 동점일 때 최대 높이로 보장됩니다.
                    minTime = timeSum; // 최소 시간임을 체크하고
                    maxHeight = height; // 현재 높이를 최대 높이로 반영합니다.
                }
            }
        }

        System.out.print(minTime + " " + maxHeight); // 최소 시간과 최대 높이를 출력합니다.
    }
}
