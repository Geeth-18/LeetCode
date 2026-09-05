/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node level=root;
        while(level!=null){
            Node nextLevel=new Node();
            Node nextLevelTail=nextLevel;
            Node curr=level;

            while(curr!=null){
                if(curr.left!=null){
                    nextLevelTail.next=curr.left;
                    nextLevelTail=nextLevelTail.next;
                }
                if(curr.right!=null){
                    nextLevelTail.next=curr.right;
                    nextLevelTail=nextLevelTail.next;
                }
                curr=curr.next;
            }

            level=nextLevel.next;
        }
        return root;
    }
}