package leetCode;

public class InvertTheTrees {
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = new TreeNode(root.val);
        if(root.left == null && root.right == null) return temp;
        if(root.right == null){
            temp.left = null;
            temp.right = invertTree(root.left);
            return temp;
        }
        if(root.left == null){
            temp.right = null;
            temp.left = invertTree(root.right);
            return temp;
        }
        temp.left = invertTree(root.right);
        temp.right = invertTree(root.left);
        return temp;
    }
}
