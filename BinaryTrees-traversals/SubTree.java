/**
 * Binary Tree Identical implementation in Java
 * 
 * @author: {Sudheer Reddy T}
 * @github: {tadipatrisudheerreddy}
 */
public class SubTree {

	TreeNode root1, root2;
	
	public boolean isIdentical(TreeNode root1,TreeNode root2){
		
		//Since every null tree is also subset of main tree
		if(root1==null&&root2==null)
			return true;
		//Need to check the null condition only once,since we are using recursion at second time it should not be null 
		if(root1==null&&root2==null)
			return false;		
			
	return (root1.value==root2.value)&& (isIdentical(root1.left,root2.left))
			&&((isIdentical(root1.right,root2.right)) );
	}
	
	public boolean isSubTree(TreeNode p, TreeNode q){
		
		//Since every null tree is also subset of main tree
		if(q==null)
			return true;
		
		if(p==null)
			return false;
		
		if(isIdentical(p,q))
			return true;
	
	return isSubTree(p.left,q)||isSubTree(p.right,q);
	}
	
	
	public static void main(String[] args) {
		
		SubTree tree = new SubTree();
		
		TreeNode root1 = new TreeNode(26);
		root1.right    = new TreeNode(3);
		root1.right.right = new TreeNode(3);
		root1.left = new TreeNode(10);
		root1.left.left = new TreeNode(4);
		root1.left.left.right = new TreeNode(30);
		root1.left.right = new TreeNode(6);
		
		TreeNode root2 = new TreeNode(10);
		root2.right = new TreeNode(6);
		root2.left  = new TreeNode(4);
		root2.left.right = new TreeNode(30);
		
		if(tree.isSubTree(tree.root1,tree.root2))
			System.out.println("Tree2 is subtree of Tree1");
		else
			System.out.println("Tree2 is not a subtree of Tree1");
		
	}

}
