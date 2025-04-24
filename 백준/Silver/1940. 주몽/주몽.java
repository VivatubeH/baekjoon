import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 입력한 정수를 미리 정렬해둡니다. ( 크기를 빠르게 찾기 위해 )
        Collections.sort(list);

        int count = 0; // 만들 수 있는 갑옷의 수를 카운팅할 변수입니다.
        int sum = 0; // 양 끝의 합을 구하기 위한 변수입니다.

        int startIndex = 0;
        int endIndex = list.size() - 1;
        // 정렬된 상태에서 양끝을 잡고 양끝의 합을 구합니다.
        // 그 합이 갑옷을 만드는데 필요한 수와 같으면 count를 늘립니다.
        // 그 합이 필요한 수보다 작으면 왼쪽 인덱스를 키웁니다.
        // 그 합이 필요한 수보다 크면 오른쪽 인덱스를 줄입니다.

        // 이러한 방식으로 왼쪽 인덱스가 오른쪽 인덱스가 교차하면
        // 즉 왼쪽 인덱스가 더 커지거나 같으면 종료합니다.
        while (true) {
            sum = list.get(startIndex) + list.get(endIndex);
            if (sum == M) {
                startIndex++;
                endIndex--;
                count++;
            } else if (sum < M) {
                startIndex++;
            } else if (sum > M) {
                endIndex--;
            }

            if (startIndex >= endIndex) break;
        }

        System.out.println(count);
    }
}
