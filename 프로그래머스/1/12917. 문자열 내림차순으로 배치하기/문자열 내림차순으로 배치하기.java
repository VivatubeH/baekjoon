import java.util.Arrays;
class Solution {
    public String solution(String s) {
        // 문자열의 길이를 개수로 하는 int 배열 생성
        int[] array = new int[s.length()];
        // charAt()을 통해 해당 문자의 코드값을 int[]에 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(i);
        }
        // 배열을 오름차순 정렬한다.
        Arrays.sort(array);
        StringBuilder builder = new StringBuilder();
        // 정렬된 코드값을 문자열로 반환해야하는데 내림차순으로 붙여야함.
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append((char)(array[i]));
        }
        // StringBuilder를 String으로 변환 후 반환
        return builder.toString();
    }
}