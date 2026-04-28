import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        // 정렬 메서드를 사용한다.
        Arrays.sort(strings, (s1, s2) -> {
            // n번째 알파벳이 같으면 사전순 정렬
           if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
            // n번째 알파벳이 다르면, 알파벳 기준 오름차순 정렬
            else return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }
}