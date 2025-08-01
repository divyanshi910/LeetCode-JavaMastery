/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializerHelper(root, sb);
        return sb.toString();
    }
    void serializerHelper(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializerHelper(root.left,sb);
        serializerHelper(root.right,sb);
    }

   TreeNode deserializeHelper(Queue<String> queue){
        String nodeData = queue.poll(); //null or data of a node
        if(nodeData.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeData));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(arr));
        return deserializeHelper(queue);
       
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));