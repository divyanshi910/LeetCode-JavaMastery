/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //approach 1 recursive
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root,list);
        return list;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root==null){
            return ;
        }
        helper(root.left,list);
        helper(root.right,list);
        list.add(root.val);
    }
    //iterative approach
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            list.add(0,currentNode.val);//for reverse so using index 0 to always add elements a 0 position
            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
             if(currentNode.right!=null){
                stack.push(currentNode.right);
            }
        }
        return list;
    }
    }