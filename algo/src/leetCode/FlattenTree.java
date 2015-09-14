package leetCode;

public class FlattenTree {
	public void flatten(TreeNode root) {
        if(root == null) return;
	    while(root!=null){
	        if(root.left!= null){
    	        TreeNode temp = root.left;
        	    while(temp.right != null){
        	        temp = temp.right;
        	    }
        	    if(root.right!=null){
        	        temp.right = root.right;
        	    }
        	    root.right = root.left;
        	    root.left = null;
        	    root = root.right;
	        }else{
	            root.left = null;
	            root = root.right;
	        }
	    }
    }
}
