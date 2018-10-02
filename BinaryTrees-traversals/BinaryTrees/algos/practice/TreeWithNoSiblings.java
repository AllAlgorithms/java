package algos.practice;

public class TreeWithNoSiblings {
	public static void printOnlyLeaves(TreeNode node){
		if(node!=null){

			printOnlyLeaves(node.left);
			
			if ((node.left==null) && (node.right!=null))
				System.out.println("Node with no sibling in right side is: " + node.right.value);
			
			if((node.left!=null) && (node.right==null))
				System.out.println("Node with no sibling in left side is: " + node.left.value);
			
			printOnlyLeaves(node.right);
		}		
	}

	public static void main(String[] args){
	
		 TreeNode root = new TreeNode(50);
		 TreeNode.insert(root, new TreeNode(30)); 
		 TreeNode.insert(root, new TreeNode(60));
		 TreeNode.insert(root, new TreeNode(22)); 
		 TreeNode.insert(root, new TreeNode(38)); 
		 TreeNode.insert(root, new TreeNode(55));
		 TreeNode.insert(root, new TreeNode(34)); 
		
		 
		 TreeWithNoSiblings.printOnlyLeaves(root);
	}
	
}
