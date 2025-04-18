import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String originalString = br.readLine(); // 정수로서 처리하려고 하면 시간 초과, 문자열로 처리합니다.
        int originalLength = originalString.length(); // 원래 숫자의 자릿수

        // 왼쪽 파트가 있어야 팰린드롬을 생성할 수 있습니다.
        String leftPart = originalString.substring(0, originalLength / 2);
        String leftPartReversed = new StringBuilder(leftPart).reverse().toString();
        // 홀수 길이일 때는 가운데 파트도 필요합니다.
        String middlePart = String.valueOf(originalString.charAt(originalLength / 2));

        String firstCandidate = null; // 최초로 생성한 팰린드롬 수를 담습니다.

        String answer = null; // 정답이 될 팰린드롬 수를 담습니다.

        // 짝수 길이 일때는 단순히 왼쪽 파트를 뒤집어서 붙이면 됩니다.
        if (originalLength % 2 == 0) {
            firstCandidate = leftPart + leftPartReversed;
        } else { // 홀수 길이일 때는 왼쪽 파트 + 가운데 파트 + 왼쪽 파트 뒤집기를 붙입니다.
            firstCandidate = leftPart + middlePart + leftPartReversed;
        }

        if (firstCandidate.compareTo(originalString) > 0) { // 해당수보다 큰 팰린드롬수면
            System.out.println(firstCandidate); // 출력 후에
            return; // 종료합니다.
        }

        // 여기까지 왔다면 해당 수를 키워줘야 하므로
        // 이 때는 짝수 길이면 왼쪽에다가 1을 더하고
        if (originalLength % 2 == 0) {
            BigInteger bigInt = new BigInteger(leftPart); // 왼쪽을 만들고
            BigInteger newBigint = bigInt.add(new BigInteger("1")); // 1을 더합니다.
            String newLeft = String.valueOf(newBigint); // 새로 만든 왼쪽 수입니다.
            if (newLeft.length() != leftPart.length()) { // 새로 만든 왼쪽수가 자릿수가 달라지면
                // 가장 왼쪽 1, 가장 오른쪽 1, 가운데에 0이 처음 숫자 길이 -1 만큼 붙어야 합니다.
                answer = "1";
                for (int i = 1; i <= originalLength - 1; i++) {
                    answer += "0";
                }
                answer += "1";
            } else {
                // 자릿수가 같으면 단순히 더해서 결합하면 됩니다.
                answer = newLeft + new StringBuilder(newLeft).reverse();
            }
        } else { // 홀수 길이면 왼쪽 + 중간에다가 1을 더해야 합니다.
            BigInteger bigInt = new BigInteger(leftPart + middlePart);
            BigInteger newBigint = bigInt.add(new BigInteger("1"));
            String newLeftMiddle = String.valueOf(newBigint);
            if (newLeftMiddle.length() != leftPart.length() + 1) {
                answer = "1";
                for (int i = 1; i <= originalLength - 1; i++) {
                    answer += "0";
                }
                answer += "1";
            } else { // 길이가 같은데
                // 왼쪽이 바뀔 수 있으니 왼쪽을 다시 찍어야 합니다.
                // 가운데가 제일 뒷자리이니 가운데를 제외하면
                // substring(0, 해당 길이)로 하면 자동으로 마지막 인덱스가 제외됩니다.
                String newLeftAfterChange = newLeftMiddle.substring(0, newLeftMiddle.length() - 1);
                answer = newLeftMiddle + new StringBuilder(newLeftAfterChange).reverse();
            }
        }

        System.out.println(answer);
    }

}
