import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int sequenceLength = Integer.parseInt(st1.nextToken()); // 수열의 길이를 저장할 변수입니다. ( 최대 100만 )
        int queryCount = Integer.parseInt(st1.nextToken()); // 쿼리의 개수를 저장할 변수입니다. ( 최대 300만 )

        int[] sequence = new int[sequenceLength + 1]; // sequence[i-1]을 이용하기 위해 +1로 만듭니다.
        int[] xorSum = new int[sequenceLength + 1]; // XOR을 누적하기 위한 xorSum을 만듭니다.

        xorSum[0] = 0; // 불필요한 조건 검사를 하지 않기 위해 0번 인덱스를 0으로 설정합니다.

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= sequenceLength; i++) { // 최대 연산은 100만입니다.
            sequence[i] = Integer.parseInt(st2.nextToken());
            xorSum[i] = xorSum[i - 1] ^ sequence[i]; // 어차피 0과 XOR 연산하면 해당 수가 그대로 나오기 때문에 조건 검사를 할 필요가 없습니다.
        }

        int xor = 0; // 현재까지의 XOR 연산값과 계속해서 XOR 연산을 해야 하므로 만든 변수입니다.

        for (int i = 0; i < queryCount; i++) { // 최대 연산은 300만입니다.
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st3.nextToken());
            int e = Integer.parseInt(st3.nextToken());

            xor = xor ^ (xorSum[e] ^ xorSum[s - 1]); // 얘도 처음은 0과의 xor 연산이므로 자기 자신이 나올 것이니 별도로 고려하지 않습니다.
        }

        System.out.println(xor); // 모든 쿼리를 XOR 한 값을 출력합니다.
    }
}
