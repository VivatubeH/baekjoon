import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalAttendants = Integer.parseInt(br.readLine()); // 전체 참가자 수
        int totalStaffs = Integer.parseInt(br.readLine()); // 전체 스태프 수 
        
        // 최소 득표수를 저장합니다.
        double minimumVotes = totalAttendants * 0.05;
        // 이름과 점수를 저장하기 위한 ALPS의 배열을 생성합니다.
        ArrayList<ALPS> lists = new ArrayList<>();
        // 득표율이 5% 넘는 알파벳의 인덱스를 저장합니다.
        int[] over5 = new int[26];

        // 26개의 알파벳의 등장 빈도를 counting 하기 위한 변수입니다.
        int[] counting = new int[26];

        // 해당되는 문자의 인덱스를 찾아서, counting 하겠습니다.
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // totalStaffs 줄에 걸쳐 이름과 득표수가 주어집니다.
        for (int i = 0; i < totalStaffs; i++) {
            // 공백 기준으로 입력되는 이름과 숫자를 구분하기 위해 StringTokenizer로 토큰화합니다.
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            String name = tokenizer.nextToken(); // 이름을 입력받습니다.
            Double vote = Double.parseDouble(tokenizer.nextToken()); // 점수를 입력받습니다.
            if (vote < minimumVotes) continue; // 만약 득표수가 최소치에 미달되면 건너뜁니다. ( 입력 x )

            // 만약 득표수가 5% 이상인 스태프라면 출력을 해야 하므로 해당 알파벳에 대한 표시가 필요합니다.
            over5[alphabets.indexOf(name)]++;

            for (int j = 1; j <= 14; j++) { // 득표수를 1~14까지라 나눈 값을 점수로서 스태프마다 할당합니다.
                lists.add(new ALPS(name, vote/j)); // double / int는 double이므로 따로 변환은 안 하겠습니다.
            }
        }

        // 이제 득점순으로 정렬하기 위해 Comparator를 정의하겠습니다.
        Collections.sort(lists, new Comparator<ALPS>() {
            @Override
            // 점수 순으로 정렬하기 위해 o1.getScore - o2.getScore를 하겠습니다.
            // 둘은 무조건 다르다고 문제 조건에 주어지기 때문에 같은 경우는 생각하지 않겠습니다.
            public int compare(ALPS o1, ALPS o2) {
                return Double.compare(o2.getScore(), o1.getScore());
            }
        });

        // 상위 14개의 문자에 대해 카운팅합니다.
        for (int i = 0; i < 14; i++) {
            String name = (String) lists.get(i).getName();
            int index = alphabets.indexOf(name); // 해당 알파벳의 index를 찾아서
            counting[index]++; // 해당 알파벳을 세줍니다.
        }

        // 이제 알파벳 순으로 개수와 함께 출력합니다.
        for (int i = 0; i < 26; i++) {
            // 득표율이 5% 이상인 스태프에 대해 출력합니다.
            if (over5[i] != 0) {
                System.out.println((char) (i + 'A') + " " + counting[i]);
            }
        }
    }
}

class ALPS { // 이름과 점수를 저장하기 위한 제네릭 클래스를 만듭니다.

    public String name;
    private Double score;

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    ALPS(String name, Double score) {
        this.name = name;
        this.score = score;
    }
}