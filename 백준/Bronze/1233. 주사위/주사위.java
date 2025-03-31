import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백을 기준으로 사용자로부터 주사위의 면수 S1, S2, S3를 입력받겠습니다.
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        // s1, s2, s3를 입력받겠습니다.
        int s1 = Integer.parseInt(tokenizer.nextToken());
        int s2 = Integer.parseInt(tokenizer.nextToken());
        int s3 = Integer.parseInt(tokenizer.nextToken());

        int sum = 0; // 세 눈금의 합을 구하기 위한 변수입니다.
        int[] frequency = new int[81]; // 합의 출연 빈도를 구하기 위한 배열입니다.
        // index 80까지 이용을 위해 크기를 81로 선언했습니다.

        // 세 눈금의 합을 각각 구해서 더할 텐데, 입력은 20 x 20 x 40이 최대이므로
        // 시간 복잡도가 O(n^3)이지만 입력이 20 x 20 x 40개가 최대이므로
        // 1초 내로 무조건 들어옵니다.
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    sum = i + j + k;
                    frequency[sum]++; // 합에 해당하는 index를 늘려서 빈도수를 구해줍니다.
                }
            }
        }

        int max = 0; // 최대 빈도수를 구하기 위한 변수 max를 선언하고 0으로 초기화합니다.
        int maxSum = 0; // 최대 빈도수에 해당하는 합을 구해야합니다.

        for (int i = 3; i <= s1+s2+s3; i++) { // 최소 3부터, 최대 s1+s2+s3까지만 탐색하면 됩니다.
            if (frequency[i] > max) { // 이렇게 하면 최대 빈도는 최초 1회만 할당됩니다.
                // 이후 같은 값이 나와도 해당 값은 할당되지 않습니다.
                max = frequency[i]; // 빈도를 저장해야지..
                maxSum = i;
            }
        }

        System.out.println(maxSum);
    }
}
