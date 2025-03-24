import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 크기 n이 주어집니다.
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        // 수열에 포함되는 수가 공백 단위로 주어집니다.
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        // 모든 토큰을 수집해가면서 int형 배열 arr에 저장합니다.
        while(tokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(tokenizer.nextToken());
            arr[num]++; // 정렬을 하려고 하면 O(n^2)으로 시간초과가 날테니
            // 입력을 arr로 받아버립니다. ( 메모리는 여유가 있는 문제입니다. )
        }

        // ai + aj = x인 x가 주어집니다.
        int x = Integer.parseInt(br.readLine());

        // 쌍의 개수를 구하기 위한 변수 count를 선언합니다.
        int count = 0;

        // 반복문을 돌면서 이제 합을 만족하는 순서쌍을 구해야하는데,
        // 서로 다른 양의 정수이고, 이중 반복문은 시간 초과가 되기 때문에
        // 1중 for문을 사용하겠습니다.

        // 이 때, arr 배열의 요소가 1인 경우, 해당 인덱스의 숫자를 활용해서 연산을 하면 되고
        // 요소가 1이 아니라면 
        // 만약 왼쪽 인덱스와 오른쪽 인덱스의 합이 x가 되면 만족하는 것이고
        // 양 인덱스의 합이 x보다 크다면 오른쪽 인덱스를 왼쪽으로 이동시켜야 하고
        // 양 인덱스의 합이 x보다 작다면 왼쪽 인덱스를 오른쪽으로 이동시켜야 합니다.
        // 그렇게 하다가 왼쪽 인덱스가 오른쪽 인덱스와 만나는 순간 반복문을 종료해야 합니다.

        int leftIndex = 0; // 왼쪽 시작 인덱스는 0
        int rightIndex = arr.length - 1; // 오른쪽 시작 인덱스는 배열 크기 - 1입니다.

        while(true) {
            if (leftIndex >= rightIndex) { // 두 인덱스가 역전되는 순간
                break; // 종료합니다.
            }
            if (arr[leftIndex] == 0) {
                leftIndex++;
            }
            else if (arr[rightIndex] == 0) {
                rightIndex--;
            } else { // 둘다 0이 아닐때만 실행되는 코드입니다.
                if (leftIndex + rightIndex < x) { // 두 인덱스의 합이 x보다 작으면
                    leftIndex++; // 왼쪽 인덱스를 우측으로 이동합니다.
                } else if (leftIndex + rightIndex > x) { // 두 인덱스의 합이 x보다 크면
                    rightIndex--; // 우측 인덱스를 좌측으로 이동합니다.
                } else { // 두 인덱스의 합이 x가 되어버리면
                    count++; // 순서쌍을 세준다음
                    leftIndex++; // 왼쪽 인덱스는 우측으로
                    rightIndex--; // 우측 인덱스는 왼쪽으로 옮겨줍니다.
                }
            }
        }

        System.out.println(count);
    }
}
