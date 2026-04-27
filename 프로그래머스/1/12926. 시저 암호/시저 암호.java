class Solution {
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                builder.append(ch);
            } else if (ch >= 'a' && ch <= 'z') {
                int current = (ch - 'a' + n) % 26;
                builder.append((char)('a' + current));
            } else if (ch >= 'A' && ch <= 'Z') {
                int current = (ch - 'A' + n) % 26;
                builder.append((char)('A' + current));
            }
        }
        return builder.toString();
    }
}