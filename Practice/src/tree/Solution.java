package tree;

public class Solution {
	private class pIndex {
		int index;
	}
	 private int searchInorder(int[] arr, int start, int end, int val) {
	        for(int i = start; i <= end; i++) {
	            if(arr[i] == val)
	                return i;
	        }
	        return -1;
	    }
	    
	    private TreeNode buildUtil(int[] in, int[] post, int start, int end, pIndex pIndex) {
	        if(start < 0 || end < 0 || pIndex.index < 0)
	        	return null;
	    	
	    	if(start > end)
	            return null;
	            
	        TreeNode n = new TreeNode(post[pIndex.index--]);
	        if(start == end)
	            return n;
	            
	        int index = this.searchInorder(in, start, end, n.data);
	        n.right = this.buildUtil(in, post, index + 1, end, pIndex);
	        n.left = this.buildUtil(in, post, start, index - 1, pIndex);
	        return n;
	    }
	    
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        int n = postorder.length;
	        pIndex idx = new pIndex();
	        idx.index = n-1;
	        return this.buildUtil(inorder, postorder, 0, n-1, idx);
	    }
	    
	    private static void printTree(TreeNode root) {
	    	if(root == null)
	    		return;
	    	System.out.print(root.data + " ");
	    	printTree(root.left);
	    	printTree(root.right);
	    }
	    
	    
	    public static void main(String[] args) {
	    	Solution s = new Solution();
	    	int[] in = {2,1,3};
	    	int[] po = {2,3,1};
	    	TreeNode n = s.buildTree(in, po);
	    	printTree(n);
	    	
	    }
}
