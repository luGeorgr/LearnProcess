package leetcode;

public class LeetCode541 {
    public String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder(s.length());
        boolean flag = true;
        for (int i = 0; i < s.length(); ) {
            int last = i + k - 1 >= s.length() ? s.length() - 1 : i + k - 1;
            if (flag) {
                for (int j = last; j >= i; j--) {
                    builder.append(s.charAt(j));
                }
            } else {
                for (int j = i; j <= last; j++) {
                    builder.append(s.charAt(j));
                }
            }
            flag = !flag;
            i = last + 1;
        }
        return builder.toString();
    }
}
