package leetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> paths = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        allTreePaths(root,"");
        return paths;
    }
    
    public void allTreePaths(TreeNode root,String path){
        if(root == null){
            return;
        }
        if(root.left== null && root.right == null){
            path = path + String.valueOf(root.val);
            paths.add(path);
            return;
        }
        
        if(root.left!=null){
            String newPath = path + String.valueOf(root.val) + "->";
            allTreePaths(root.left,newPath);
        }
        
        if(root.right!=null){
            String newPath = path + String.valueOf(root.val) + "->";
            allTreePaths(root.right,newPath);
        }
    }
}
