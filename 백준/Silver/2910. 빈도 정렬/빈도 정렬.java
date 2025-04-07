import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        // 수열의 길이 messageLength
        int messageLength = Integer.parseInt(st1.nextToken());
        // 해당 수열의 수들 중 최댓값 maxNumber
        int maxNumber = Integer.parseInt(st1.nextToken());

        // 수열을 입력받고 저장하기 위한 토큰2
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        // 입력 순서를 기억하면서, 빈도수를 체크하기 위한 LinkedHashMap 객체 생성
        // O(n) -> 연산횟수 누적 1000회
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        while (st2.hasMoreTokens()) {
            // 토큰에 있는 숫자를 number에 미리 저장합니다. ( nextToken 중복 호출 방지 )
            int number = Integer.parseInt(st2.nextToken());
            // map에 값을 저장합니다.
            // 이 때, 이미 존재하는 key이라면 value를 증가시키고
            // 존재하지 않는 key라면, value를 1로 할당해야 합니다.
            linkedHashMap.put(number, linkedHashMap.getOrDefault(number, 0) + 1);
        }

        // 위 단계를 거치고 나면 입력한 순서대로 값이 할당되어 있습니다.
        // 이제 정렬하면 이 값들을 value 기준 내림차순 정렬하겠습니다.
        // O(n) -> 연산횟수 누적 2000회 
        ArrayList<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(linkedHashMap.entrySet());
        // O(n log n) -> 연산횟수 누적 5000회 정도
        Collections.sort(sortedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 이렇게 정렬된 후 key를 value만큼 출력하면 됩니다.
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey() + " ");
            }
        }

        // 이후 출력합니다.
        System.out.println(sb);
    }
}
