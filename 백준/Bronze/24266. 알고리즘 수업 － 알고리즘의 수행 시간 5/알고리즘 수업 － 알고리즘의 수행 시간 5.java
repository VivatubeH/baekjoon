import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // sum의 초기값은 0이고, i, j, k가 각각 n에 따라 수행횟수가 결정되는
        // 3중 for문이기 대문에 수행 횟수는 n^3이 되고
        // 최고차항의 차수는 3이 됩니다.

        // 이 때, 최악의 경우 50만 x 50만 x 50만이 되어서
        // 자바의 long타입보다도 커져 버리니 자바에서는
        // BigInteger 클래스를 활용해주겠습니다.
        Scanner in = new Scanner(System.in);
        // 입력받는 숫자 문자열을 토대로 BigInteger 객체를 생성합니다.
        BigInteger bigInt = new BigInteger(in.next());
        // bigInt가 불변객체이기 때문에 pow의 결과는 새로운 BigInteger 객체를 생성후
        // bigInt 참조변수에 담는 것 뿐입니다. ( 가리키는 객체가 바뀜 )
        bigInt = bigInt.pow(3); // 해당 수를 세제곱합니다.
        // pow 메서드는 지정된 수만큼 거듭제곱하는 메서드입니다.
        System.out.println(bigInt);
        System.out.println(3);
    }
}

