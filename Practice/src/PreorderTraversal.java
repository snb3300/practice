import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class PreorderTraversal {

	public static List<Integer> iterative(TreeNode root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		List<TreeNode> queue = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root != null) {
			TreeNode node = root;
			do {
				if(!queue.isEmpty()) {
					node = queue.remove(0);
				} else if(!stack.isEmpty()) {
					node = stack.pop();
				}
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					stack.push(node.right);
				preOrder.add(node.val);
			} while(!queue.isEmpty() || !stack.isEmpty());
		}
		return preOrder;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tree = {6,2,1,4,3,5,7,9,8};
		TreeNode root = new TreeNode(3);
		
		// left sub tree
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(5);
		
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(9);
		
		System.out.println(iterative(root));
	}

}
