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
 class Pair{
    TreeNode node;
    int currentSum;
    Pair(TreeNode node, int currentSum){
        this.node = node;
        this.currentSum = currentSum; 
    }
 }
class Solution {
    //recursive sol O(N)
    public boolean hasPathSumR(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }
    boolean helper(TreeNode root, int targetSum, int sum){
        if(root == null){
            return false;
        }
        sum = sum + root.val;
        //if leaf node
        if(root.left==null && root.right==null){
            return targetSum==sum;
        }
        boolean leftS = helper(root.left, targetSum, sum);
        boolean rightS = helper(root.right, targetSum, sum);
        return leftS || rightS ;
    }
    //iterative sol Tc O(N)
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int currentSum = pair.currentSum;
            currentSum = currentSum + node.val;
            //leaf node
            if(node.left==null && node.right==null){
                if(targetSum==currentSum){
                    return true;
                }
            }
            if(node.left!=null){
                stack.push(new Pair(node.left,currentSum));
            }
            if(node.right!=null){
                stack.push(new Pair(node.right,currentSum));
            }
        }
        return false;
    }
    //approach 3
    public boolean hasPathSum(TreeNode root, int targetSum){
         if(root==null){
            return false;
        }
        targetSum = targetSum - root.val;
        //if leaf node
        if(root.left==null && root.right==null){
            if(targetSum==0) return true;
        }
        boolean leftS = hasPathSum(root.left, targetSum);
        boolean rightS = hasPathSum(root.right, targetSum);
        return leftS || rightS ;
    }
}