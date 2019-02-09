package leetcode;

public class LeetCode984 {
    public String strWithout3a3b(int A, int B) {
        if (A > 2 * B + 2 || B > 2 * A + 2) {
            return "";
        }
        return A > B ? build(A, 'a', B, 'b') : build(B, 'b', A, 'a');
    }

    private String build(int A, char a, int B, char b) {
        final StringBuilder builder = new StringBuilder(A + B);
        while (A > B) {
            if (A >= 2) {
                builder.append(a);
                builder.append(a);
                A -= 2;
            } else {
                builder.append(a);
                A -= 1;
            }

            if (B >= 1) {
                builder.append(b);
                B -= 1;
            }
        }

        while (B  != 0) {
            if (A >= 1) {
                builder.append(a);
                A -= 1;
            }

            if (B >= 1) {
                builder.append(b);
                B -= 1;
            }
        }
        return builder.toString();
    }
}
