/**
 * Binary Tree Traversals implementation in Java
 * 
 * @author: {Sudheer Reddy T}
 * @github: {tadipatrisudheerreddy}
 */

public class TreeTraversal {
	
	public static  void getInorder(TreeNode node,StringBuffer buf){
		if(node == null)
			return;
		getInorder(node.left,buf);
		buf.append(" "+node.value);
		getInorder(node.right,buf);
	}
	
	public static void getPreorder(TreeNode node,StringBuffer buf){
		if(node==null)
			return;
		buf.append(" "+node.value);
		getPreorder(node.left,buf);
		getPreorder(node.right,buf);
	}
	
	public static void getPostorder(TreeNode node,StringBuffer buf){
		if(node==null)
			return;
		getPostorder(node.left,buf);
		getPostorder(node.right,buf);
		buf.append(" "+node.value);
	}
}
