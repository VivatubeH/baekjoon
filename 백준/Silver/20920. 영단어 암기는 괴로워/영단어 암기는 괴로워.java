import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int M = Integer.parseInt(firstLine.nextToken());

        // 단순 입력 -> 10만회 연산 예상.
        for (int i = 0; i < N; i++) {
            String currentStr = br.readLine();
            if (currentStr.length() < M) {
                continue; // 길이가 M이하이면 아예 고려도 X
            }
            // map에 currentStr에 해당하는 문자열이 존재하면
            // 그 개수에 1을 더해서 담고,
            // 존재하지 않으면 1개로 초기화
            map.put(currentStr, map.getOrDefault(currentStr, 0) + 1);
        }

        // Map을 ArrayList에 담을 수가 없으니 Entry 객체를 뽑아내서 담는다.
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        // 이제 3가지 정렬 기준으로 정렬한다.
        // NlogN으로 가정해도 3개의 정렬이면 1000만회 이내로 떨어짐.
        Collections.sort(list, (e1, e2) -> {
            String e1Key = e1.getKey();
            int e1Value = e1.getValue();
            String e2Key = e2.getKey();
            int e2Value = e2.getValue();

            // 여러 개의 정렬기준에 우선순위를 두려면
            // 정렬이 가능하면 그대로 정렬을 하고 끝내야 함.
            if (e1Value != e2Value) return e2Value - e1Value;
            if (e1Key.length() != e2Key.length()) return e2Key.length() - e1Key.length();
            // 1, 2번으로 정렬이 안되면 3번으로 정렬하고 끝
            return e1Key.compareTo(e2Key);
        });

        // 정답을 모아서 한 번에 출력합니다.
        StringBuilder answer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            answer.append(entry.getKey()).append("\n");
        }

        System.out.print(answer);
    }
}
