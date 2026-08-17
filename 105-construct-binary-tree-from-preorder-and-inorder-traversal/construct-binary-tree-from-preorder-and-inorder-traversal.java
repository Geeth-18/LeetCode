class Solution{
    private int i = 0;
    private int p = 0;
    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        return build(preOrder, inOrder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preOrder, int[] inOrder,int stop){
        if(p>=preOrder.length){
            return null;
        }
        if(inOrder[i]==stop){
            ++i;
            return null;
        }
        TreeNode node = new TreeNode(preOrder[p++]);
        node.left=build(preOrder,inOrder,node.val);
        node.right=build(preOrder,inOrder,stop);
        return node;
    }
}