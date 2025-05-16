import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 난이도 의견의 개수가 첫째 줄에 정수로 주어짐.
        if (n == 0) { // 아무 의견도 안 주어지면 어차피 문제의 난이도는 0입니다.
            System.out.print(0);
            return; // 별도 작업 없이 난이도인 0을 출력하고 종료합니다.
        }
        // 제외해야 하는 사람 수를 구합니다.
        // 필요로 하는 수는 정수형이기 때문에 반올림한 결과를 구해야 합니다.
        // Math.round는 long을 반환하므로 int로 변환합니다.
        int people = (int)Math.round((double)n * 0.15);

        // 그 다음으로는 배열에 추가합니다.
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 각 줄마다 정수를 입력받습니다.
            list.add(Integer.parseInt(br.readLine()));
        }
        // 오름차순으로 정렬합니다.
        Collections.sort(list, (s1, s2) ->{
            return s1 - s2;
        });
        // 이제 앞에서부터 people개를 제외하고, 뒤에서부터 people개를 제외해야 합니다.
        // 즉, 0번부터 시작해서 people개가 되려면
        // people이 2라고 치면 0, 1이므로 people - 1까지를 제외해야 하고
        // 결국 people부터 세면 됩니다.
        // 끝으로 보면 마지막 size()가 20이라고 가정하고 people이 3이라면
        // size() - people이 17이고, 17, 18, 19번째를 제외하면 딱 맞기 때문에
        // size() - people - 1까지만 포함시키면 됩니다.
        int count = 0; // 현재까지 포함된 사람의 수를 셉니다.
        int sum = 0; // 그 사람들의 합을 누적합니다.

        for(int i = people; i <= list.size() - people - 1; i++) {
            sum += list.get(i);
            count++;
        }

        int answer = (int)Math.round((double)sum / count);
        System.out.print(answer);
    }
}
