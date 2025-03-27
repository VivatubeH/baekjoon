import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 보드 크기 size가 주어집니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        // 보드 크기를 기반으로 보드를 만듭니다.
        char[][] candy = new char[size][size];

        // 줄 별 사탕이 주어집니다.
        for (int i = 0; i < size; i++) {
            // 각 사탕들을 배열에 저장합니다.
            candy[i] = br.readLine().toCharArray();
        }

        // 2개의 인접한 사탕을 바꾸면서 최대 사탕의 개수를 세야하는데,
        // 이 때 2중 for문이 돌더라도 50 x 50 = 2500개의 사탕에 대해서
        // 좌우 변경, 상하 변경을 하더라도 시간 복잡도가 그렇게 커지지 않기 때문에

        // 1. 기존의 최대 연속 사탕 count 세기
        // 2. 좌우 변경을 해가면서 최대 연속 사탕 count 세기
        // 3. 상하 변경을 해가면서 최대 연속 사탕 count 세기

        // 3가지 방식을 하면서 최대 연속 사탕 개수를 count 하겠습니다.
        int originalMaxCount = 0; // 기존 최대 사탕 개수를 저장하기 위한 변수입니다.
        int leftRightMaxCount = 0; // 좌우 변경을 하면서 최대 사탕 개수를 저장하기 위한 변수입니다.
        int upDownMaxCount = 0; // 상하 변경을 하면서 최대 사탕 개수를 저장하기 위한 변수입니다.

        // 1. 기존의 최대 연속 사탕 개수 count 하기
        originalMaxCount = checkMaxLength(candy);
        
        // 2. 좌우 변경을 해가면서 최대 연속 사탕 count 하기
        leftRightMaxCount = changeLeftRightAndGetMaxCandy(candy);

        // 3. 상하 변경을 해가면서 최대 연속 사탕 count 하기
        upDownMaxCount = changeUpDownAndGetMaxCandy(candy);

        // 셋 중에 최대 연속 사탕 개수를 출력하겠습니다.
        int answerMaxCount = 0;
        if (originalMaxCount > answerMaxCount) answerMaxCount = originalMaxCount;
        if (leftRightMaxCount > answerMaxCount) answerMaxCount = leftRightMaxCount;
        if (upDownMaxCount > answerMaxCount) answerMaxCount = upDownMaxCount;

        System.out.println(answerMaxCount);
    }

    // 주어진 사탕에서 최대 연속 사탕의 개수를 세는 메서드입니다.
    public static int checkMaxLength(char[][] candy) {
        int max = 1; // 최대 연속 사탕의 개수를 저장할 변수입니다.
        int count = 1; // 현재 연속 사탕의 개수를 저장할 변수입니다. ( 최소 1개부터 시작합니다. )

        // 열 단위 세기
        for (int i = 0; i < candy.length; i++) {
            count = 1; // 각 줄이 끝나면 count를 다시 1로 초기화합니다.
            for (int j = 0; j < candy.length - 1; j++) {
                if (candy[i][j] == candy[i][j+1]) {
                    count++;
                    if (count > max) max = count; // count가 max보다 커지면 max를 갱신합니다.
                }
                else { // 두 개가 다르면 count를 초기화합니다.
                    count = 1;
                }
            }
        }

        // 행 단위 세기 ( 열 단위 세기와 같은 로직입니다. )
        for (int j = 0; j < candy.length; j++) {
            count = 1;
            for (int i = 0; i < candy.length - 1; i++) {
                if (candy[i][j] == candy[i+1][j]) {
                    count++;
                    if (count > max) max = count;
                }
                else {
                    count = 1;
                }
            }
        }

        return max;
    }

    // 사탕을 입력받아서 좌우를 계속해서 변경해나갑니다.
    public static int changeLeftRightAndGetMaxCandy(char[][] candy) {
        int max = 1;
        int count = 1;

        for (int i = 0; i < candy.length; i++) {
            for (int j = 0; j < candy.length - 1; j++) {
                // 좌우를 변경합니다.
                char temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j+1] = temp;

                // 좌우를 변경한 다음 연속 candy의 최대 수를 셉니다.
                count = checkMaxLength(candy);

                // 다시 원래대로 돌립니다. ( 원복은 똑같이 하면 됩니다. )
                temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j+1] = temp;

                // 지금 candy 수가 max보다 크다면 max를 갱신합니다.
                if (count > max) max = count;
            }
        }

        // 최대 연속 캔디수를 반환합니다.
        return max;
    }

    public static int changeUpDownAndGetMaxCandy(char[][] candy) {
        int max = 1;
        int count = 1;

        for (int j = 0; j < candy.length; j++) {
            for (int i = 0; i < candy.length-1; i++) {
                // 상하를 변경합니다.
                char temp = candy[i][j];
                candy[i][j] = candy[i+1][j];
                candy[i+1][j] = temp;

                // 상하를 변경한 다음 연속 candy의 최대 수를 셉니다.
                count = checkMaxLength(candy);

                // 다시 원래대로 돌립니다. ( 원복은 똑같이 하면 됩니다. )
                temp = candy[i][j];
                candy[i][j] = candy[i+1][j];
                candy[i+1][j] = temp;

                // 지금 candy 수가 max보다 크다면 max를 갱신합니다.
                if (count > max) max = count;
            }
        }

        // 최대 연속 캔디수를 반환합니다.
        return max;
    }
}
