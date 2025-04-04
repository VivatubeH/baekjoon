import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // sum은 0으로 초기화가 되고,
        // i는 1부터 n-2까지
        // j는 i+1부터 n-1까지
        // k는 j+1부터 n까지가 후보가 되고
        // 이 A[i] x A[j] x A[k]가 경우의 수가 되어버립니다.

        // 규칙성을 찾기 위해 한 사이클만 돌려보면
        // k = 5라고 가정했을 때
        // (1,2,3), (1,2,4), (1,2,5), (1,3,4), (1,3,5), (1,4,5)
        // (2,3,4), (2,3,5), (2,4,5)
        // (3,4,5) 이렇게 10가지 가짓수가 가능하고

        // 이는 1,2,3,4,5 5개의 숫자 중 3개의 숫자를 선택하는 조합과 같습니다.
        // 만약 수열이 되려면 (1,5,2)처럼 순서가 바뀐 것도 가능해야 하는데 중복이 허용되지 않기
        // 때문에 조합입니다.
        // 서로 다른 n개에서 k개를 고르는 조합의 경우의 수는 n!/k!(n-k)!인데

        // 문제에서는 서로 다른 n개에서 항상 3개만을 고르는 조합이기 때문에
        // k가 3이되어서
        // n!/6/(n-2)!이 되고 이를 변형하면
        // (n)(n-1)(n-2)/6이 됩니다.
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        System.out.println(n*(n-1)*(n-2)/6);
        System.out.println(3);
    }
}