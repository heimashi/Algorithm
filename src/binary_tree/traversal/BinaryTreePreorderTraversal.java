


public class BinaryTreePreorderTraversal{
	
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        res.add(root.val);
        if(root.left!=null){
            res.addAll(preorderTraversal(root.left));
        }
        if(root.right!=null){
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }

    public static void main(String args[]){
    	
    }

}