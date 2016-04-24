/*  Question 2)​ Implement insert and delete in a tri­nary tree in Java. A tri­nary tree is much like a binary tree
but with three child nodes for each parent instead of two ­­ with the left node being values less than the
parent, the right node values greater than the parent, and the middle nodes values equal to the parent.
For example, suppose I added the following nodes to the tree in this order: 5, 4, 9, 5, 7, 2, 2.
The resulting tree would look like this:

     5
   / | \
  4  5  9
 /     /
2     7
|
2

*/
public class TrinaryTree
{
    Node root;

    // This is an inner class that provides a structure for the Trinary nodes
    class Node
    {
        private int value;
        Node left, right, middle;

        public Node(final int value)
        {
            this.value = value;
        }
    }

    /*
     * This method is used to insert a node in the Trinary tree.
     *
     * @param value value of the node to be inserted.
     */
    public void insert(final int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            insert(root, value);
        }
    }

    private void insert(final Node node, final int value)
    {
        // traverse left subtree
        if (value < node.value)
        {
            if (node.left == null)   // check if it is a leaf node. If yes, then add the node, else go deep. 
            {
                node.left = new Node(value); 
            }
            else
            {
                insert(node.left, value);
            }
        }
        // traverse right subtree
        else if (value > node.value)
        {
            if (node.right == null)   // check if it is a leaf node. If yes, then add the node, else go deep. 
            {
                node.right = new Node(value); 
            }
            else
            {
                insert(node.right, value);
            }
        }
        else
        {
            if (node.middle == null)   // check if it is a leaf node. If yes, then add the node, else go deep. 
            {
                node.middle = new Node(value); 
            }
            else
            {
                insert(node.middle, value);
            }
        }
    }

    /*
     * This method is used to delete a node in the Trinary tree.
     *
     * @param value value of the node to be deleted.
     */
    public Node delete (final int value)
    {
        if (root == null)
        {
            return null;
        }
        return delete(root, value); 
    }

    private Node delete (Node node, final int value)
    {
        //traverse left subtree
        if (value < node.value)
        {
            node.left = delete (node.left, value);
        }
        //traverse right subtree
        else if (value > node.value)
        {
            node.right = delete (node.right, value);
        }
        else
        {
            if (node.middle != null)
            {
                node.middle = delete (node.middle, value);
            }
            else if (node.right != null)
            {
                node.value = findLeftmost(node.right).value;
                node.right = delete (node.right, node.value);
            }
            else
            {
                node = node.left;
            }
        }

        return node;
    }

    /*
     * This method is used to find the leftmost node of the given node.
     */
    private Node findLeftmost(final Node node)
    {
        if (node != null)
        {
            while(node.left != null)
            {
                return findLeftmost (node.left);
            }
        }
        return node;
    }
}

