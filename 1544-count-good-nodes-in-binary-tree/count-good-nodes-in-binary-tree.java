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
    public int goodNodes(TreeNode root) {
        int count =helper(root,Integer.MIN_VALUE);
        return count;
    }
    int helper(TreeNode root,int max){
        if(root==null){
            return 0;
        }
        int left=helper(root.left, Math.max(root.val,max));
        int right=helper(root.right, Math.max(root.val,max));
        int result = left+right;
        if(root.val>=max){
            result=result+1;
        }
        return result;
    }
}