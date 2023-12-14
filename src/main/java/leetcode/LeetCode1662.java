package leetcode;

public class LeetCode1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0, index1 = 0, index2= 0;
        while (i < word1.length && j < word2.length) {
            String a = word1[i];
            String b = word2[j];
            for (;index1 < a.length() && index2 < b.length(); index1++, index2++) {
                if (a.charAt(index1) != b.charAt(index2)) {
                    return false;
                }
            }
            if (index1 >= a.length()) {
                i++;
                index1 = 0;
            }
            if (index2 >= b.length()) {
                j++;
                index2 = 0;
            }
        }
        return i >= word1.length && j >= word2.length;
    }
}
