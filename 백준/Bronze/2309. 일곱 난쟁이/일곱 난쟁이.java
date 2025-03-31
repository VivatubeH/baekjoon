import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 난쟁이 9명의 키 저장을 Integer[]를 사용합니다.
        Integer[] heights = new Integer[9];

        for (int i = 0; i < 9; i++) {
            // 아홉 난쟁이의 키가 주어집니다.
            int height = Integer.parseInt(br.readLine());
            heights[i] = height;
        }

        // ArrayList를 오름차순으로 정렬하겠습니다.
        Arrays.sort(heights);

        // 정답이 되는 키의 조합을 저장하기 위한 변수입니다.
        int[] answers = new int[7];

        // 이후 일곱 난쟁이의 키를 더해가면서 찾는데
        // 얼핏보면 10^9 = 10억이므로 시간 복잡도를 초과할 것 같지만
        // 서로 다른 9명의 난쟁이 중 7명을 선택해서 출력하는 경우이고
        // 이 때 순서는 고려할 필요가 없으므로 사실상 9C7의 조합입니다. ( 순서는 이미 오름차순 정렬되어 있습니다. )
        // 그래서 그냥 for문을 돌려버립니다.
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                for(int k = j+1; k < 9; k++) {
                    for (int l = k+1; l < 9; l++) {
                        for (int m = l+1; m < 9; m++) {
                            for (int n = m+1; n < 9; n++) {
                                for (int o = n+1; o < 9; o++) { // 각각의 요소가 바로 앞 요소보다 1을 더 크게 해서 중복제거 / 순서유지를 합니다.
                                    // 키가 100이 되는 경우에만
                                    if (heights[i] + heights[j] + heights[k] + heights[l] + heights[m] + heights[n] + heights[o] == 100) {
                                        System.out.println(heights[i]);
                                        System.out.println(heights[j]);
                                        System.out.println(heights[k]);
                                        System.out.println(heights[l]);
                                        System.out.println(heights[m]);
                                        System.out.println(heights[n]);
                                        System.out.println(heights[o]);
                                        return; // 종료합니다.
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
