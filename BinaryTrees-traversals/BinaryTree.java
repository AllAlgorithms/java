/**
 * Binary Tree Traversals implementation in Java
 * 
 * @author: {Sudheer Reddy T}
 * @github: {tadipatrisudheerreddy}
 */


public class BinaryTree {
	
	 public static TreeNode mirrorTree(TreeNode node){
		if(node == null) 
			return node;
		
		TreeNode left = mirrorTree(node.left);
		TreeNode right = mirrorTree(node.right);
		node.left = right;
		node.right = left;
		 
		return node;
	}
	 
	 public static void main(String[] args){
		 
		TreeNode root = new TreeNode(8);
		TreeNode.insert(root, new TreeNode(31));
		TreeNode.insert(root, new TreeNode(45));
		TreeNode.insert(root, new TreeNode(16));
		TreeNode.insert(root, new TreeNode(24));
		TreeNode.insert(root, new TreeNode(19));
		TreeNode.insert(root, new TreeNode(29));
		TreeNode.insert(root, new TreeNode(7));
		
		StringBuffer inorderbuf=new StringBuffer();
		StringBuffer preorderbuf=new StringBuffer();
		StringBuffer postorderbuf=new StringBuffer();
		

		TreeTraversal.getInorder(root,inorderbuf);
		TreeTraversal.getPreorder(root, preorderbuf);
		TreeTraversal.getPostorder(root, postorderbuf);
		
		System.out.println("Before mirroring,In order tree is: "+inorderbuf);
		
		BinaryTree.mirrorTree(root);
		
		StringBuffer inorderbufAfter = new StringBuffer();
		TreeTraversal.getInorder(root, inorderbufAfter);
		System.out.println("After mirroring,In order tree is: "+inorderbufAfter);
		
		System.out.println("Post order traversal:" + postorderbuf);
		System.out.println("Pre order traversal:"+ preorderbuf);
		
		System.out.println("Nodes with no siblings:");
		TreeWithNoSiblings.printOnlyLeaves(root);
		
	 }
}
