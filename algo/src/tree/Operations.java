package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Operations {
	public static Stack<Node> nodesVisited = new Stack<Node>();
	
	public static void main(String[] args) {
		Node root = null;
		int exit = 1;
		while(exit!=0){
			System.out.println("\n\nPlease enter the operation you want to perform");
			System.out.println("1: add a node \n2: traverse \n3:hieght calculation "
					+ "\n4:check if balanced \n5.find common ancestor \n6: exit");
			Scanner scanIn = new Scanner(System.in);
			String entry = scanIn.nextLine();
			int option = Integer.parseInt(entry);
			Node rootDup = root;
			String val = "";
			switch(option){
				case 1: System.out.println("Enter new node value");
						//Scanner scanIn1 = new Scanner(System.in);
						val = scanIn.nextLine();
						//scanIn1.close();
						int value = Integer.parseInt(val);
						Node n = new Node();
						n.value = value;
						n.left = null;
						n.right = null;
						root = addNewNode(rootDup,n);
						if(root==null){
							System.out.println("root is null");
						}
						break; 
				case 2: System.out.println("\nwant to go: \n1.breadth first \n2.depth first \n\n OR \n\n 3. Pre-Order traversal \n4.in-Order");
						val = scanIn.nextLine();
						int trace = Integer.parseInt(val);
						switch(trace){
						case 1: Queue<Node> bfsQ = new LinkedList<Node>();
								dobreadthFirst(rootDup,bfsQ);
								break;
						case 2:	
								if(rootDup==null){
									System.out.println("root is null");
								}
								doDepthFirst(rootDup);
								break;
						case 3: preOrderTraversal(rootDup);
								break;
						case 4: inOrderTraversal(rootDup);
								break;
						}
						break;
				case 3: int depth = calculateHeight(rootDup);
						System.out.println("depth of tree is " + depth);
						break;
				case 4: if(isBalanced(rootDup)){
							System.err.println("yes the trees are balanced");
						}else{
							System.err.println("nope!!! the trees are not balanced");
						}
						break;
				case 5: System.out.println("ENter the first value");
						val = scanIn.nextLine();
						int val1 = Integer.parseInt(val);
						val = scanIn.nextLine();
						int val2 = Integer.parseInt(val);
						findCommonAncestor(val1,val2,rootDup);
					
						break;
				case 6: exit = 0;
						scanIn.close();
						System.out.println("have a nice day!!!");
						break;
			}
		}
	}

	private static void findCommonAncestor(int val1, int val2, Node root) {
		Node n1 = dfs(val1,root);
		if(n1!=null){
			
		}else{
			System.out.println("n1 is not found on the tree");
		}
	}
	
	private static Node dfs(int val1, Node root) {
		if(root!=null){
			if(root.value!=val1){
				nodesVisited.push(root);
				if(root.left.value != val1){
					doDepthFirst(root.left);
				}else{
					return root.left;
				}
				if(root.right.value != val1){
					doDepthFirst(root.right);
				}else{
					return root.right;
				}
				//System.out.println("value is : " + root.value);
			}else{
				return root;
			}
		}
		return null;
	}

	private static void preOrderTraversal(Node root) {
		if(root!=null){
			System.out.println("value is " + root.value);
			if(root.left != null){
				preOrderTraversal(root.left);
			}
			if(root.right!= null){
				preOrderTraversal(root.right);
			}
		}else{
			
		}
	}
	
	private static void inOrderTraversal(Node root) {
		if(root!=null){
			if(root.left != null){
				preOrderTraversal(root.left);
			}
			System.out.println("value is " + root.value);
			if(root.right!= null){
				preOrderTraversal(root.right);
			}
		}else{
			
		}
	}

	private static boolean isBalanced(Node root) {
		int left_height=0,right_height=0;
		
			if(root==null && root==null){
				return true;
			}else{
				if(root.left!=null){
					left_height = 1+calculateHeight(root.left);
				}
				if(root.right!=null){
					right_height = 1+calculateHeight(root.right);
				}
				if(Math.abs(left_height - right_height)<=1 && isBalanced(root.left) && isBalanced(root.left)){
					return true;
				}
			}
			return false;
		
	}

	private static int calculateHeight(Node root) {
		int left_height=0,right_height=0;
		if(root.left==null && root.right==null){
			return 0;
		}else{
			if(root.left!=null){
				left_height = 1+calculateHeight(root.left);
			}
			if(root.right!=null){
				right_height = 1+calculateHeight(root.right);
			}
			return Math.max(left_height,right_height);
		}
	}

	private static void dobreadthFirst(Node root, Queue<Node> bfsQ) {
		if(root!=null){
			bfsQ.add(root);
		}
		while(!bfsQ.isEmpty()){
			Node top = bfsQ.remove();
			System.out.println("value is : " + top.value);
			if(top.left!=null){
				bfsQ.add(top.left);
			}
			if(top.right!=null){
				bfsQ.add(top.right);
			}
		}
	}

	private static void doDepthFirst(Node root) {
		if(root!=null){
			if(root.left != null){
				doDepthFirst(root.left);
			} 
			if(root.right != null){
				doDepthFirst(root.right);
			} 
			System.out.println("value is : " + root.value);
		}
	}

	private static Node addNewNode(Node root, Node newNode) {
		if(root==null){
			root = newNode;
			System.out.println("new node added as root");
		}else{
			if(root.value < newNode.value){
				System.out.println("going to right of "+root.value);
				root.right = addNewNode(root.right, newNode);
			}else if(root.value >= newNode.value){
				System.out.println("going to left");
				root.left = addNewNode(root.left, newNode);
			}
		}
		return root;
	}
}
