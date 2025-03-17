import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // BufferedReader를 쓰기 위해 IOException을 throws 합니다.
        // 알파벳 소문자로 이루어진 N개의 단어를 입력받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 먼저 첫째 줄에 단어 개수 N을 입력받아야 합니다.
        int N = Integer.parseInt(br.readLine());
        // 이후 N개의 줄에 거쳐 소문자로 이루어진 단어가 한 줄씩 주어져야 합니다.
        // 중복이 없는 문자를 단어를 입력받기 위해서 Set 자료구조를 활용하겠습니다.
        // Set은 인터페이스이기 때문에 HashSet<String> 객체를 생성하겠습니다.
        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) { // index 사용을 위해 0부터 N보다 작은 값으로 제한합니다.
            words.add(br.readLine());
        }
        // 정렬을 위해 HashSet를 List로 변환합니다.
        // 이런 변환이 가능한 이유는, 생성자가 Collection 인터페이스를 받기 때문입니다.
        ArrayList<String> lists = new ArrayList<>(words);

        // 정렬을 위해 Compartor<> 익명 클래스를 생성하겠습니다.
        Collections.sort(lists, new Comparator<String>() {
            int order = 0;
            @Override
            public int compare(String o1, String o2) {
                order = o1.length() - o2.length();
                if (o1.length() == o2.length()) {
                    order = o1.compareTo(o2);
                }
                return order;
            }
        });
        for(String str : lists) {
            System.out.println(str);
        }
    }
}
