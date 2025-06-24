import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N이 최대 10^5개의 숫자이므로 숫자로서 처리하는 건 안됨.
        // 문자열로서 처리해야겠다.
        String N = scanner.nextLine();

        // 30의 배수에 대한 판단이 가장 중요.
        // 가장 뒤의 숫자가 0으로 끝나고
        // 그 앞의 숫자들의 합이 3의 배수이면 가능.
        // 가장 큰 수 출력이니깐 내림차순 정렬
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        if (!N.contains("0")) {
            System.out.print(-1);
        } else {
            int sum = 0;
            for (int i = 0; i < N.length(); i++) {
                int num = N.charAt(i) - '0';
                list.add(num);
                sum += num;
            }
            // 3의 배수일 때만
            if (sum % 3 == 0) {
                Collections.sort(list, (n1, n2) -> {
                   return n2 - n1; // 내림차순 정렬
                });
                // 0을 포함하고 3의 배수면 내림차순된 리스트에서
                // 순서대로 하나씩 출력하면 된다.
                for (Integer integer : list) {
                    answer.append(integer);
                }
                System.out.print(answer);
            } else { // 3의 배수가 아니면 얘도 -1 출력 후 끝
                System.out.print(-1);
            }
        }
    }
}
