import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fieldLength = Integer.parseInt(st.nextToken()); // 연병장의 길이를 저장합니다.
        int soilders = Integer.parseInt(st.nextToken()); // 조교의 수를 저장합니다.

        st = new StringTokenizer(br.readLine());

        int[] field = new int[fieldLength + 1]; // 인덱스를 1부터 활용하기 위해 연병장 길이보다 1크게 만듭니다.
        for (int i = 1; i <= fieldLength; i++) { // 최대 10만번의 연산이 필요합니다.
            field[i] = Integer.parseInt(st.nextToken()); // 높이가 공백을 기준으로 주어집니다.
        }

        int[] diff = new int[fieldLength + 2]; // 누적합을 이용하기 위해 차이 배열을 이용하겠습니다.
        // 차이 배열은 시작 요소에 k를 더하고, 끝 다음 요소에 k를 빼야하므로
        // index 1부터 사용하고 싶다면 크기를 +2로 설정해야 합니다.
        // 배열의 특정 구간에 대해서 연산이 반복되는 경우이기 때문에 차이 배열이 효율적일 수 있습니다.
        int[] prefixSum = new int[fieldLength + 1]; // 누적합은 마지막 요소는 필요 없습니다. (마지막에선 멈출 필요가 없습니다.)

        for (int i = 0; i < soilders; i++) { // 최대 연산 10만
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken()); // 명령의 시작 인덱스입니다.
            int endIndex = Integer.parseInt(st.nextToken()); // 명령의 끝 인덱스입니다.
            int k = Integer.parseInt(st.nextToken()); // 삽질을 할 높이입니다.

            diff[startIndex] += k; // 시작 인덱스에 k를 더합니다.
            diff[endIndex + 1] -= k; // 끝 인덱스의 다음 인덱스에는 k를 뺍니다.
        }

        StringBuilder sb = new StringBuilder();

        // 차이 배열이 설정되면 누적합을 구합니다. ( 최대 연산 10만 )
        for (int i = 1; i <= fieldLength; i++) {
            // 누적합을 구하고
            prefixSum[i] = prefixSum[i - 1] + diff[i];
            // 해당 수에 누적합을 더합니다.
            field[i] = field[i] + prefixSum[i];
            sb.append(field[i] + " ");
        }

        System.out.println(sb);
    }
}
