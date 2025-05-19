import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 국가의 수 N
        int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가번호 K

        // 이후 N개의 줄에는 국가 번호, 금, 은, 동 숫자가 빈칸을 사이에 두고 주어진다.
        ArrayList<Olympic> nations = new ArrayList<>();

        // 클래스를 nations 배열에 하나씩 담는다.
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            int no = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            Olympic olympic = new Olympic(no, gold, silver, bronze);
            nations.add(i, olympic);
        }

        // 자체 정렬 기준을 만들어서 정렬하는데, 금, 은, 동 순서로 내림차순 정렬합니다.
        Collections.sort(nations, (o1, o2) -> {
            // 금이 다르면 금 우선, 은이 다르면 은 우선, 동이 다르면 동 우선으로 정렬한다.
            if (o1.gold != o2.gold) return o2.gold - o1.gold;
            if (o1.silver != o2.silver) return o2.silver - o1.silver;
            // 금, 은이 같으면 동 기준으로 정렬합니다. ( 같은 경우는 다른 정렬 기준이 없이 공동이기 때문에 이렇게 작성합니다. )
            else return o2.bronze - o1.bronze;
        });

        // 국가 K의 현재 인덱스, 금, 은, 동 개수를 구해옵니다.
        int kIndex = 0;
        int kGold = 0;
        int kSilver = 0;
        int kBronze = 0;

        for (int i = 0; i < N; i++) {
            if (nations.get(i).no == K) {
                kIndex = i;
                kGold = nations.get(i).gold;
                kSilver = nations.get(i).silver;
                kBronze = nations.get(i).bronze;
            }
        }

        // 이제 내림차순 정렬된 배열에서 kIndex전까지 돌면서 상위 국가의 수를 세되,
        // 이 때 kGold, kSilver, kBronze가 모두 같은 국가는 제외해야 합니다.
        int count = 0;
        for (int i = 0; i < kIndex; i++) {
            int iGold = nations.get(i).gold;
            int iSilver = nations.get(i).silver;
            int iBronze = nations.get(i).bronze;

            // 하나라도 달라야
            if (iGold != kGold || iSilver != kSilver || iBronze != kBronze) {
                count++; // count를 셉니다.
            }
        }

        // 출력해야 할 등수는 count + 1이 되야 합니다. ( 자기보다 잘한 나라 수 + 1)
        System.out.print(count + 1);
    }

}

// 해당 국가의 번호, 금메달 수, 은메달 수, 동메달 수로 하나의 클래스를 만듭니다.
class Olympic {
    int no;
    int gold;
    int silver;
    int bronze;

    Olympic(int no, int gold, int silver, int bronze) {
        this.no = no;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}

