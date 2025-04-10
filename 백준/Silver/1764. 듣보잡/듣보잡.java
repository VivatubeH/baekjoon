import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        // 듣도 못한 사람의 수 N과 보도 못한 사람의 수 M을 입력받습니다.
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        // 문제의 조건을 보면, 듣보잡의 수와 명단을 사전순으로 출력해야 합니다
        // 이 때는 입력부터가 사전 순으로 되는 것이 좋습니다.
        Set<String> noHeard = new HashSet<>();
        Set<String> noSeen = new HashSet<>();

        // 듣도 못한 사람과 보도 못한 사람을 순서대로 입력받습니다.
        for (int i = 0; i < N; i++) {
            noHeard.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            noSeen.add(br.readLine());
        }

        // 정답 명단을 저장합니다.
        Set<String> answer = new HashSet<>(noHeard);
        answer.retainAll(noSeen);

        // 오름 차순 정렬하겠습니다.
        ArrayList<String> lists = new ArrayList<>(answer);
        lists.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(lists.size());

        for(String name : lists) {
            System.out.println(name);
        }
    }
}
