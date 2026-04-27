class Solution {
    public boolean solution(String s) {
        // 길이가 4나 6이 아니면 false 반환
        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }
        // 숫자가 아닌 게 존재하면 false 반환
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        // 둘 다 해당 안되면 true
        return true;
    }
}