package leetcode;

public class LeetCode824 {
    public static void main(String[] argv) {
        LeetCode824 leetCode824 = new LeetCode824();
        leetCode824.toGoatLatin("I speak Goat Latin");
    }

    public String toGoatLatin(String S) {
       String[] list =  S.split(" ");
       StringBuilder builder = new StringBuilder();
       for (int i = 0; i < list.length; i++) {
            if (!vowel(list[i].charAt(0))) {
                builder.append(list[i].substring(1))
                        .append(list[i].charAt(0));
            } else {
                builder.append(list[i]);
            }
            builder.append("ma");
            for (int j = 0; j <= i; j++) {
                builder.append('a');
            }
            builder.append(' ');
       }
       return builder.toString().substring(0, builder.length() - 2);
    }

    private boolean vowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' ||  c == 'u' || c == 'U';
    }
}
