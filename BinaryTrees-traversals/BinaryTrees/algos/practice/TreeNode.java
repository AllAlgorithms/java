package algos.practice;

public class TreeNode {
	
	 int value;
	 TreeNode left;
	 TreeNode right;
	 
	 public TreeNode(int i) {
		 value = i;
		 left = right = null;
	 }
	 
	 public static boolean insert(TreeNode root,TreeNode n){
		if(n!=null){
			if(n.value >= root.value){
				if(root.right==null){
					root.right=n;
					return true;
				}
				else
					return insert(root.right,n);
			}
			else if(root.left==null){
				root.left=n;
				return true;
			}
			else
				return insert(root.left,n);
		} 
		 return false;
		 
	 }
	 
}
