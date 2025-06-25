import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받을 원소의 개수인 N이 주어진다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N개의 수를 리스트에 입력받는다.
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        // 이진 탐색을 위해 list를 오름차순 정렬한다.
        Collections.sort(list);

        // x + y + z = k 는 3중 for문으로 시간 초과가 나므로
        // x + y = k - z로 각각을 이중 for문으로 전환한다.
        // 이렇게 하면, 두 수의 x + y들을 만들고
        // K를 list에서 큰수부터 선택해가면서
        // k - z = x + y를 만족하는 지 찾으면 된다.

        // x + y의 조합을 만드는데, x, y가 뭔지는 중요하지가 않다.
        // 단지 이 합이 k - z와 같기만 하면 되므로 HashSet을 이용한다.
        HashSet<Integer> sumSet = new HashSet<>();
        // 같은 수를 선택할 수 있으므로 인덱싱을 동일하게 돌 수 있도록 한다.
        // 이 때의 시간 복잡도는 100만회 정도 예상
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = list.get(i) + list.get(j);
                sumSet.add(sum);
            }
        }

        // 리스트의 뒤에서부터 k를 탐색한다.
        boolean isChecked = false;
        StringBuilder answer = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            int k = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                int z = list.get(j);

                if (sumSet.contains(k - z)) {
                    isChecked = true;
                    answer.append(k);
                }
                if (isChecked) break;
            }
            if (isChecked) break;
        }
        System.out.print(answer);
    }
}
