import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사용자로부터의 입력을 받기 위한 BufferedReader 클래스를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 수의 개수 N( 1과 50만 사이 )를 입력받습니다. ( 단, N은 홀수 )
        int N = Integer.parseInt(br.readLine());

        // 산술평균은 sum을 통해 마지막에 구하면 됩니다.
        int sum = 0;
        // 중앙값은 ArrayList로 오름차순 정렬하면 됩니다.
        List<Integer> list = new ArrayList<>();
        // 최빈값은 Map을 통해서 빈도를 저장하면 됩니다.
        Map<Integer, Integer> map = new HashMap<>();

        // 이후 N개의 줄에 정수들이 주어지는데 정수의 절댓값은 4000 이하입니다.
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 산술평균을 위해 sum을 누적합니다.
            sum += num;
            // 중앙값을 추후 구하기 위해 list에 정수를 추가합니다.
            list.add(num);
            // 최빈값을 추후 구하기 위해 map에 빈도를 같이 저장합니다.
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 중앙값을 구하기 위해 오름차순 정렬합니다.
        Collections.sort(list, (l1, l2) -> {
           return l1 - l2;
        });
        // 최대 빈도를 가진 값을 저장하기 위한 ArrayList를 별도로 생성합니다.
        List<Integer> mostFrequencyValueList = new ArrayList<>();
        // 최대 빈도를 저장하기 위한 변수 maxFrequency를 생성합니다.
        int maxFrequency = -1;

        // map을 탐색하면서 최대 value를 구하고, 그에 맞는 key를 저장합니다.
        // 그리고 최대 value이면서 같은 key가 여러 개 존재한다면 ArrayList에 저장을 합니다.
        // 기존의 최대 value보다 크게 되면 ArrayList를 비우고 새롭게 저장합니다.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxFrequency) { // 최대 빈도보다 크면 최빈값은 1개가 되는 상황이므로
                // 기존의 mostFrequencyValueList를 비우고
                mostFrequencyValueList.clear();
                maxFrequency = value; // 최대 빈도를 변경하고
                // 최대 빈도를 저장하는 게 아닌, 최대 빈도를 갖는 값을 저장합니다.
                mostFrequencyValueList.add(key);
            } else if (value == maxFrequency) { // 최대 빈도와 같은 값이 존재하면
                // 기존의 mostFrequencyValueList에 추가해주면 됩니다.
                mostFrequencyValueList.add(key);
            }
        }

        // 최빈값 중에서 2번째로 작은 값을 출력하기 위해서 오름차순 정렬합니다.
        Collections.sort(mostFrequencyValueList, (l1, l2) -> {
           return l1 - l2;
        });
        // 최빈값을 저장하기 위한 변수 mostFrequencyValue를 생성합니다.
        int mostFrequencyValue = 0;

        // mostFrequencyValueList에는 한 개의 수 또는 여러개의 수가 있는데 1개의 수라면 그 수를, 여러개의 수라면 두 번째로 작은 수가 출력해야 할 최빈값이 됩니다.
        if (mostFrequencyValueList.size() == 1) {
            mostFrequencyValue = mostFrequencyValueList.get(0);
        } else { // 어차피 최빈값이 0개일 수는 없습니다.
            mostFrequencyValue = mostFrequencyValueList.get(1);
        }

        // 이제 순서대로 출력합니다.
        // 산술평균을 구할 때 음수의 경우 Math.random() 사용 시 반올림이 잘 되지 않기 때문에 자체적으로 메서드를 만듭니다.
        System.out.println(round((double)sum / N));
        System.out.println(list.get(N/2)); // 중앙값 -> N개의 수를 증가하는 순으로 나열했을 때 중앙에 위치하는 값
        System.out.println(mostFrequencyValue); // 최빈값 -> 가장 많이 나타나는 값 중 2번째로 작은 숫자
        System.out.println(list.get(N-1) - list.get(0)); // 범위 -> 최댓값과 최솟값의 차이
    }

    public static int round(double d) {
        // 가장 먼저 절댓값을 구합니다.
        double k = Math.abs(d);
        // 소수점이 0.5보다 크든 작든 Math.round()로 처리한 다음 부호만 붙여줍니다.
        // 그렇게 하면 양수일 때 2.5 -> 3.0 -> 3 , 2.4 -> 2.0 -> 2
        // 음수일 때 -2.5 -> -3.0 -> -3, -2.4 -> -2.0 -> -2로 음수처리도 가능합니다.
        double answer = Math.round(k);
        if (d >= 0) return (int)answer;
        return (int)(answer * -1);
    }
}