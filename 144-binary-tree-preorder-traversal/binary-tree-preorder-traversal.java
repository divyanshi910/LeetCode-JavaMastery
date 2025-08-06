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
     public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<>(); //EmptyList
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>(); //stack is keeping treenode complete

        stack.push(root);
        while(!stack.isEmpty()){
            //pick the last added
            TreeNode currentNode=stack.pop();
            list.add(currentNode.val);
            //push the right value in a stack first then push left in a stack
            if(currentNode.right!=null){
            stack.push(currentNode.right);
            }
            if(currentNode.left!=null){
            stack.push(currentNode.left);
            }
        }
        return list;
     }



     //approach 1 Recursive solution
    public List<Integer> preorderTraversalRecursiveSol(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preOrderHelper(root,list);
        return list;
    }
    //TC O(N) SC: O(N)
   void preOrderHelper(TreeNode root , List<Integer> result){
    if(root==null){
        return ;
    }
       result.add(root.val);
       preOrderHelper(root.left , result);
       //backtrack
       preOrderHelper(root.right , result);
    }
}