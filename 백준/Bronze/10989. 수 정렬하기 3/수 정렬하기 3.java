import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 1000만개의 수를 일반적으로 정렬하려고 하면 각 수를 전부 비교해야 합니다.
        // 그렇게 되면 O(N^2)의 시간 복잡도가 되어서 시간 초과가 나게 됩니다.

        // 그래서 이중 for문이 아닌 방법으로 N개의 수를 정렬할 방법을 찾습니다.
        // 문제의 요구사항을 보면 수는 중복이 허용되고, 오름차순으로 정렬한 결과를 단순히
        // 출력만 하면 되는 문제입니다.

        // 이런 경우 수를 입력받을 때 index에 맞게 저장하고
        // index에 맞게 출력하면 O(1)의 시간 복잡도를 가질 수 있는데
        // 같은 수가 여러 개 입력될 수 있기 때문에 counting 하면 됩니다.

        // int의 범위가 최대 1만개가 들어오기 때문에
        // 4바이트 x 1만개를 하면 4000바이트 x 10이기 때문에 40킬로바이트라
        // 메모리도 여유 있고 시간 복잡도도 괜찮을 것입니다.
        int[] array = new int[10001]; // 1부터 10000까지 인덱스를 그대로 사용하기 위해서입니다.
        for (int i = 0; i < N; i++) { // N개의 숫자를 입력받습니다.
            array[Integer.parseInt(br.readLine())]++; // 해당 index의 숫자를 counting 합니다.
        }

        for (int i = 1; i < 10001; i++) {
            int count = array[i]; // 해당 숫자의 개수를 counting 하고
            for(int j = 0; j < count; j++) {
                bw.write(i + "\n");
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
