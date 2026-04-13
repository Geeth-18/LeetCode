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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        Queue<TreeNode> Q1 = new LinkedList<>();
        List<List<Integer>> iRet = new ArrayList<>();
        boolean iflag = false;

        if(root == null) return iRet;

        Q1.offer(root);

        while(!Q1.isEmpty())
        {
            int size = Q1.size();
            List<Integer> L1 = new ArrayList<>();
            iflag = !iflag;

            while(size > 0)
            {
                TreeNode temp = Q1.poll();
                if(temp.left != null) Q1.offer(temp.left);

                if(temp.right != null) Q1.offer(temp.right);

                if(iflag == true)
                {
                    L1.add(temp.val);
                }
                else
                {
                    L1.add(0,temp.val);
                }
                size--;
            }
            iRet.add(L1);
        }
        return iRet;
    }
}