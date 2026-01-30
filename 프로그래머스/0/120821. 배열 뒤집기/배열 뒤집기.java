class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int[] answer = new int[length];
        // 0, 1, 2, 3, 4
        // 4, 3, 2, 1, 0
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = num_list[length - 1 - i];
        }
        return answer;
    }
}