package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfCompleteTree {
	public Boolean checkIfComplete(Node root){
		if(root == null) return true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Boolean checkIfLeaf = false;
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			if(checkIfLeaf){
				if(!checkIfLeafNode(temp)){
					return false;
				}
			}
			if(checkIfFullNode(temp)){
				queue.add(temp.left);
				queue.add(temp.right);
			}
			else if(checkIfLeafNode(temp)){
				checkIfLeaf = true;
			}
			else{
				if(temp.right != null){
					return false;
				}
				else{
					queue.add(temp.left);
					checkIfLeaf = true;
				}
			}
		}
		return true;
	}
	
	public Boolean checkIfCompleteRecursive(Node root,Boolean checkIfLeaf){
		if(root == null) return true;
		if(checkIfLeaf && !checkIfLeafNode(root)) return false;
		if(checkIfLeafNode(root)) return true;
		if(checkIfFullNode(root)){
			return checkIfCompleteRecursive(root.left,checkIfLeaf) && checkIfCompleteRecursive(root.right,checkIfLeaf);
		}
		if(root.right!=null) return false;
		else return checkIfCompleteRecursive(root.left, true);
	}
	
	public Boolean checkIfLeafNode(Node root){
		if(root.left == null && root.right == null){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean checkIfFullNode(Node root){
		if(root.left != null && root.right != null){
			return true;
		}else{
			return false;
		}
	}
}
