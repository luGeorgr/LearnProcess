package leetcode;

public class LeetCode1528 {
    public String restoreString(String s, int[] indices) {
        final char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }
}
