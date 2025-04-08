import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 안테나로부터 거리가 최소가 되게 하려면, 집이 있는 위치들을 정렬했을 때 그 값이 중앙값이 되어야 합니다.
        // 동일한 위치에 여러 개의 집이 존재할 수 있다면 그것도 거리 계산에 들어가야 하므로 중복은 허용되어야 합니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseCount = Integer.parseInt(br.readLine()); // 집의 개수를 저장하기 위한 변수입니다.
        ArrayList<Integer> houses = new ArrayList<>(); // 집의 위치를 저장하기 위한 변수입니다.

        // 단순한 입력의 경우 최대 시간 복잡도는 O(n)이므로 여유 있습니다.
        StringTokenizer tokenizer = new StringTokenizer(br.readLine()); // 이 때 공백을 기준으로 각 집의 좌표를 입력받습니다.
        while (tokenizer.hasMoreTokens()) { // 집의 위치가 있는 동안은 계속헤서 위치를 배열에 저장해야 합니다.
            houses.add(Integer.parseInt(tokenizer.nextToken()));
        }

        // 이후 중앙값을 찾아내기 위해서 오름차순 정렬을 합니다.
        // 시간 복잡도는 O(n log n)이므로 시간 내에는 들어옵니다.
        Collections.sort(houses); // Integer의 경우 기본 정렬이 오름차순 정렬이므로 기본 정렬을 합니다.

        // 중앙값은 주어진 배열에서 중간에 위치한 값, 즉 배열에서 중간 인덱스에 저장된 값을 말하므로
        // 홀수인 경우 2로 나누고 ( 인덱스는 0부터이므로 성립함 )
        // 짝수인 경우 가장 작은 값을 출력하라고 했으므로 2로 나눈 뒤, 더 작은 값인 -1번 인덱스를 사용합니다.
        int index = 0;

        if (houseCount % 2 != 0) { // 홀수인 경우
            index = houseCount / 2;
            System.out.println(houses.get(index));
        } else { // 짝수인 경우
            index = (houseCount / 2) - 1;
            System.out.println(houses.get(index));
        }
    }
}
