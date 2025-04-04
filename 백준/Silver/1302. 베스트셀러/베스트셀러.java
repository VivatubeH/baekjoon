import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 총 N권의 책을 입력받아야 합니다.
        int N = Integer.parseInt(br.readLine());

        // 책의 제목과 권수가 들어가야 하므로, Key-Value 구조를 가진 HashMap을 선택합니다.
        // 여기서 Key는 책 제목이니 문자열, Value는 판매량이니 정수로 갑니다.

        HashMap<String, Integer> books = new HashMap<>();

        // 1번째 로직: 책 및 판매량 저장하기.
        // 시간 복잡도 -> O(n) = 책 제목 입력받기 O(n), 값 저장하기 O(n), 값 검색하기 O(n)
        for (int i = 0; i < N; i++) { // N권의 책 제목을 입력받습니다.
            // 만약 이미 그 책 제목이 존재한다면 value인 Integer를 높여주면 됩니다.
            String title = br.readLine();
            if (!books.containsKey(title)) { // 해당 키가 존재하지 않으면
                books.put(title, 1); // 판매량을 1로 만들어주고
            } else { // 해당 책이 존재하는 경우에는
                books.put(title, books.get(title) + 1); // 판매량을 증가시킵니다.
            }
        }

        // 2번째 로직: 사전순으로 단어 정렬하기를 위해 TreeMap으로 변환합니다.
        // 이러면 자동으로 사전순 오름차순 정렬이 됩니다.
        // HashMap을 TreeMap으로 정렬 및 삽입하는데는 총 데이터가 N개이므로 O(N log N)의 시간복잡도가 걸립니다.
        TreeMap<String, Integer> treeBooks = new TreeMap<>(books);

        // 3번째 로직 : 최대 판매량을 가진 책을 찾아냅니다.
        // 오름차순으로 정렬이 되어 있으니 최댓값에 해당하는 인덱스만 찾아내면 됩니다.
        // 검색은 O(n)의 시간 복잡도가 걸립니다.

        int maxSales = 0; // 최대 판매량을 찾아냅니다. ( 이것보다 많이 팔아야 최대 판매량이 됩니다. )
        String maxBookTitle = null; // 최대 판매량을 가진 책 제목을 찾아냅니다.
        // Map에서는 index 활용이 불가능하니 Entry를 활용하겠습니다.
        for (Map.Entry<String, Integer> entry : treeBooks.entrySet()) {
            // 최대 판매량보다 많으면 걔가 최대판매량이니 이름과 판매량을 갱신합니다.
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                maxBookTitle = entry.getKey();
            }
        }
        // 완료된 이후에 책 제목이 최대 판매된 책의 제목이므로 출력합니다.
        System.out.println(maxBookTitle);
    }
}
