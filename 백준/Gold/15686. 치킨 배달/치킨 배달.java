import java.io.*;
import java.util.*;

public class Main {
    public static int[][] city;
    public static ArrayList<Chicken> chickens = new ArrayList<>();
    // 조합을 통해 선택된 치킨집을 저장할 변수입니다.
    public static ArrayList<Chicken> selection = new ArrayList<>();
    // 집의 좌표를 저장할 변수입니다.
    public static ArrayList<House> houses = new ArrayList<>();

    // 최소 거리를 저장할 변수입니다.
    public static int minDistance = Integer.MAX_VALUE;
    public static int N = 0;
    public static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 N과 M이 공백을 기준으로 주어집니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N+1][N+1]; // 인덱스를 1부터 활용하기 위해 크기를 1크게 만듭니다.

        // 이 때 행, 열 모두 (1,1)부터 활용할 수 있게 주의해서 반복문을 사용해야 합니다.
        for (int i = 1; i <= N; i++) { // 행을 1부터 N까지 활용합니다.
            st = new StringTokenizer(br.readLine()); // 매 줄마다 입력을 받은 걸 토큰화 해야 합니다.
            for (int j = 1; j <= N; j++) { // 열도 1부터 N까지 활용합니다.
                int current = Integer.parseInt(st.nextToken()); // 각 토큰에 있는 숫자를 int로 변환해서 담습니다.
                city[i][j] = current;

                // 현재 치킨집의 좌표를 미리 저장해두면 이후에 계산하기 수월합니다.
                if (current == 2) { // 만약에 치킨집이라면
                     chickens.add(new Chicken(i, j)); // 좌표로 치킨집을 생성해서 ArrayList에 담습니다.
                }
                // 마찬가지로 집의 좌표도 미리 저장해두면 이후 계산하기 수월합니다.
                if (current == 1) {
                    houses.add(new House(i, j));
                }
            }
        }

        // 조합 내부에서 고른 조합에 대한 최소 치킨 거리 갱신이 이루어집니다.
        combination(0, 0);

        System.out.print(minDistance); // 최소 치킨 거리를 출력합니다.
    }

    // 서로 다른 치킨집 개수에서 M개를 고르는 조합을 구현합니다.
    // start는 조합의 시작하는 수, depth는 뽑은 개수를 나타냅니다.
    public static void combination(int start, int depth) {
        // M개의 치킨집을 다 고르면
        if (depth == M) {
            // 치킨집과의 거리를 치킨거리를 구한 다음
            int currentChickenDistance = getChickenDistance(selection);
            // 현재까지의 최소 거리와 비교해서 최소거리를 구하고
            if (currentChickenDistance < minDistance) { // 최소 치킨거리보다 작으면 걔가 최소 치킨 거리가 되므로
                minDistance = currentChickenDistance; // 갱신합니다.
            }
            // 재귀를 종료합니다.
            return;
        }
        // start 인덱스부터 마지막 치킨집ㄱ까지를 탐색합니다.
        for (int i = start; i < chickens.size(); i++) {
            // 원래 치킨집에서 i번째 치킨집을 선택합니다.
            selection.add(chickens.get(i));
            // 선택했으니 다음 치킨집을 선택합니다.
            combination(i + 1, depth + 1);
            // 종료되고 돌아오면 1개를 더 뽑아야 하므로 마지막 요소를 비워줍니다.
            selection.remove(selection.size() - 1);
        }
    }

    // 치킨집의 좌표를 전달받아서 집과의 최소 거리를 구합니다.
    public static int getChickenDistance(ArrayList<Chicken> current) {
        // 최소 거리를 구해서 누적하기 위한 변수
        int sum = 0;
        // 집을 하나씩 돌아가면서 선택합니다.
        for (int i = 0; i < houses.size(); i++) {
            int minDistance = Integer.MAX_VALUE; // 각 집에 대한 최소 치킨거리를 구하기 위한 변수입니다.
            int rHouse = houses.get(i).row; // 집의 행입니다.
            int cHouse = houses.get(i).col; // 집의 열입니다.
            // 집과 각 치킨집과의 거리를 각각 구해가면서 최소 거리를 구합니다.
            for(int j = 0; j < current.size(); j++) {
                int rChicken = current.get(j).row;
                int cChicken = current.get(j).col;
                // 집과 선택된 치킨집과의 치킨 거리를 구해서
                int distance = Math.abs(rHouse - rChicken) + Math.abs(cHouse-cChicken);
                if (distance < minDistance) { // 최소거리보다 작다면
                    minDistance = distance; // 최소 거리를 갱신합니다.
                }
            }
            // 해당 집에서의 최소 치킨거리를 구하고 나면 변수 sum에 누적합니다.
            sum += minDistance;
        }
        return sum;
    }
}

class Chicken {
    int row;
    int col;

    public Chicken(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class House {
    int row;
    int col;

    public House(int row, int col) {
        this.row = row;
        this.col = col;
    }
}