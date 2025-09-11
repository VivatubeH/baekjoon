import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        // 먼저 입력받은 숫자를 저장합니다.
        // O(n) -> 최대 100만회의 연산
        int[] numbers = new int[N];
        int originalIndex = 0;
        while (tokenizer.hasMoreTokens()) {
            numbers[originalIndex++] = Integer.parseInt(tokenizer.nextToken());
        }

        // 기존 인덱스는 유지해야 하기 때문에, 배열을 복사해서 정렬합니다.
        // O(n log n) -> 최대 100만 x 6, 600만회의 연산
        int[] sortedArray = Arrays.copyOf(numbers, N);
        Arrays.sort(sortedArray);

        // HashMap에 중복을 제거해서 담습니다.
        // HashMap에 값 저장 -> O(1) x n회 -> 최대 100만회의 연산
        HashMap<Integer, Integer> answer = new HashMap<>();
        int answerIndex = 0; // 정답이 될 인덱스를 담습니다.
        for (int i = 0; i < sortedArray.length; i++) {
            if (!(answer.containsKey(sortedArray[i]))) { // 해당 숫자를 키로 가지고 있지 않아야 값을 대입합니다. ( 중복 제거 )
                answer.put(sortedArray[i], answerIndex++); // 이렇게 해주면 ArrayList에 있는 정렬된 순서대로 값을 hashMap에 담습니다.
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 꺼낼 때는 원래 배열의 순서대로 map의 value ( 인덱스 ) 를 꺼내면 됩니다.
        // 단순히 꺼냄 최대 100만회의 연산
        // 1회째 대량 출력 때, 시간 초과가 났으니 BufferedWriter로 변경
        for (int num : numbers) {
            bw.write(answer.get(num) + " ");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
