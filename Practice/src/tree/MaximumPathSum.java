package tree;

public class MaximumPathSum {
	
	private int MAX = Integer.MIN_VALUE;
	
	private int maxSumUtil(TreeNode node, int cur) {
		if(node == null)
			return 0;
		
		int l = maxSumUtil(node.left, cur);
		int r = maxSumUtil(node.right, cur);
		
		int x = Integer.max(Integer.max(l, r) + node.data, node.data);
		int y = Integer.max(l+r+node.data, x);
		
		MAX = Integer.max(MAX, y);
		return x;
	}
	
	public int maxPathSum(TreeNode root) {
		maxSumUtil(root, MAX);
		return MAX;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		
		root.right.right = new TreeNode(-25);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(3);
		
		System.out.println(new MaximumPathSum().maxPathSum(root));
	}

}
