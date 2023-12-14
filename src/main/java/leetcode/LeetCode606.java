package leetcode;

public class LeetCode606 {
    public String tree2str(TreeNode root) {
        final StringBuilder builder = new StringBuilder();
        visit(root, builder);
        return builder.toString();
    }

    public void visit(TreeNode root, StringBuilder builder) {
        builder.append(root.val);
        if (root.left != null && root.right != null) {
            builder.append('(');
            visit(root.left, builder);
            builder.append(')');
            builder.append('(');
            visit(root.right, builder);
            builder.append(')');
        } else if (root.left != null) {
            builder.append('(');
            visit(root.left, builder);
            builder.append(')');
        } else if (root.right != null) {
            builder.append('(');
            builder.append(')');
            builder.append('(');
            visit(root.right, builder);
            builder.append(')');
        }
    }
}
