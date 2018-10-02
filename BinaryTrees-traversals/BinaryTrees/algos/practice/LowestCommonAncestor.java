package algos.practice;

public  class LowestCommonAncestor {

	TreeNode root;
	
	public TreeNode LCA(int p,int q){
		return findLCA(root,p,q);
	}
	
	private TreeNode findLCA(TreeNode root, int p, int q) {
		if(root == null)
			return null;
		if(root.value == p || root.value == q)
			return root;
		
		TreeNode left = findLCA(root.left,p,q);
		TreeNode right = findLCA(root.right,p,q);
		
		if(left!=null && right!=null)
			return root;
		
		return left!=null? left : right;
	}

			
	
	public static void main(String[] args){
		
		LowestCommonAncestor lca = new LowestCommonAncestor(); 
 		
		TreeNode root	 = new TreeNode(1);
		root.left		 = new TreeNode(2);
        root.right 		 = new TreeNode(3);
        root.left.left   = new TreeNode(4);
        root.left.right  = new TreeNode(5);
        root.right.left  = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        	
		System.out.println("Lowest Common Ancestor of (4,5): "+ lca.findLCA(root, 4, 5).value);
		System.out.println("Lowest Common Ancestor of (4,6): "+ lca.findLCA(root, 4, 6).value);
		System.out.println("Lowest Common Ancestor of (3,4): "+ lca.findLCA(root, 3, 4).value);
	}
}
