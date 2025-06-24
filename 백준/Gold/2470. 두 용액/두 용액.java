import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N을 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // list 생성 후 N개의 특성 값 저장
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(token.nextToken()));
        }
        // 오름차순 정렬
        Collections.sort(list);
        // binarySearch 메서드를 통해 가장 작은 두 특성값 가져오기
        int[] minAndMax = twoPointers(list);
        System.out.print(minAndMax[0] + " " + minAndMax[1]);
    }

    public static int[] twoPointers(ArrayList<Integer> array) {
        int leftIndex = 0; // 왼쪽 포인터 위치를 저장할 변수
        int rightIndex = array.size() - 1; // 우측 포인터 위치를 저장할 변수

        int leftValue = 0; // 왼쪽 포인터에 담길 값
        int rightValue = 0; // 우측 포인터에 담길 값

        int min = Integer.MAX_VALUE; // 현재까지의 최솟값을 저장할 변수
        int sum = 0; // 지금 조합의 합을 구할 변수

        // 최종적으로 구한 용액의 특성값 2개를 구합니다.
        int targetLeft = array.get(leftIndex);
        int targetRight = array.get(rightIndex);
        min = Math.abs(targetLeft + targetRight);

        // 두 포인터가 교차될 때까지 수행합니다.
        while(leftIndex < rightIndex) {
            // 왼쪽 포인터가 가리키는 값과 오른쪽 포인터가 가리키는 값을
            // 각각 Value 변수에 저장합니다.
            leftValue = array.get(leftIndex);
            rightValue = array.get(rightIndex);

            // 조건 검사

            // 그 두개의 값을 더해서 sum을 구합니다.
            sum = leftValue + rightValue;

            // 이 sum이 0과 떨어진 거리가 min보다 작으면 갱신합니다.
            if (Math.abs(sum) < min) {
                targetLeft = leftValue;
                targetRight = rightValue;
                min = Math.abs(sum);
            }

            // 이동
            // 합이 0보다 작으면 왼쪽 인덱스를 키워주고,
            // 합이 0보다 크다면 오른쪽 인덱스를 줄여줍니다.
            // 합이 0이라면 해당 두 수를 담고 종료합니다.
            if (sum < 0) leftIndex++;
            else if (sum > 0) rightIndex--;
            else {
                targetLeft = leftValue;
                targetRight = rightValue;
                break;
            }
        }

        int[] answer = new int[2];
        answer[0] = targetLeft;
        answer[1] = targetRight;
        return answer;
    }
}
