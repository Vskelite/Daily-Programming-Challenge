// Problem : Check if a Binary Tree is Symmetric
// You are given the root of a binary tree. Your task is to determine whether the tree is symmetric. A binary tree is symmetric if the left and right subtrees are mirror images of each other.

// Input : [1, 2, 2, 3, 4, 4, 3]

// Output : true


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
    
    public static void main(String[] args) {
        Day28 obj = new Day28();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        System.out.println(obj.isSymmetric(root)); 
        
    }
}
