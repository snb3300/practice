package graph;

import java.util.List;
import java.util.ArrayList;

public class SunRootToLeaf {

public static void dfs(TreeNode node, StringBuffer buffer, List<String> numbers) {
		buffer.append(node.val);
        if(node.left == null && node.right == null) {
            numbers.add(buffer.toString());
            buffer.deleteCharAt(buffer.length() - 1);
            return;
        }
        
        if(node.left != null)
            dfs(node.left, buffer, numbers);
            
        if(node.right != null)
            dfs(node.right, buffer, numbers);
        buffer.deleteCharAt(buffer.length() - 1);
    }
    
    public static int sumNumbers(TreeNode root) {
        int sum = 0;
    	if(root == null)
            return sum;
            
        List<String> numbers = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        dfs(root, buffer, numbers);
        for(String num : numbers) {
        	sum += new Integer(num);
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = null;
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.left.right.left = new TreeNode(8);
//		root.left.right.left.right = new TreeNode(9);
		
		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(7);
//		root.right.right = new TreeNode(6);
		
		System.out.println(sumNumbers(root));
	}

}
