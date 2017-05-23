/*Herman Lin
APCS2 - pd3
HW35 -- 
2017-5-4*/


/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    TreeNode root;


    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	if (root == null)
	    root = new TreeNode(newVal, null, null);
	else {
	    TreeNode store = root;
	    while ( (store.getLeft() != null) || (store.getRight() != null) ) {
		if (store.getValue() < newVal) {
		    if (store.getRight() == null)
			break;
		    else 
			store = store.getRight();		    
		}
		else if (store.getValue() > newVal) {
		    if (store.getLeft() == null)
			break;
		    else
			store = store.getLeft();
		}
	    }
	    if (store.getValue() < newVal)
		store.setRight(new TreeNode(newVal, null, null));
	    else if (store.getValue() > newVal)
		store.setLeft(new TreeNode(newVal, null, null));
	}
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!v~~HELPERS~~v!!!!!!!!!!!!!!!!!!
    public void preOrderHelper( TreeNode currentNode ) {
	if (currentNode == null)
	    return;
	System.out.print(currentNode.getValue() + " ");
	preOrderHelper(currentNode.getLeft());
	preOrderHelper(currentNode.getRight());
    }
    public void inOrderHelper( TreeNode currentNode ) {
	if (currentNode == null)
	    return;
	inOrderHelper(currentNode.getLeft());
	System.out.print(currentNode.getValue() + " ");
	inOrderHelper(currentNode.getRight());
    }
    public void postOrderHelper( TreeNode currentNode ) {
	if (currentNode == null)
	    return;
	postOrderHelper(currentNode.getLeft());
	postOrderHelper(currentNode.getRight());
	System.out.print(currentNode.getValue() + " ");
    }
    //!!!!!!!!!!!!!!!!!!!^~~HELPERS~~^!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
	preOrderHelper(root);	
    }

    public void inOrderTrav() 
    {
	inOrderHelper(root);
    }

    public void postOrderTrav() 
    {
	postOrderHelper(root);
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	return searchHelper(root, target);
    }
    TreeNode searchHelper( TreeNode currentNode, int target ) {
	TreeNode answer = null;
	if (currentNode == null)
	    return null;
	else if (currentNode.getValue() == target)
	    return currentNode;
	else if (currentNode.getValue() > target)
	    answer = searchHelper(currentNode.getLeft(), target);
	else if (currentNode.getValue() < target)
	    answer = searchHelper(currentNode.getRight(), target);
	return answer;
    }

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
	return findHeight(root);
    }
    public int findHeight( TreeNode currentNode ) {        
	int leftTree = 0;
	int rightTree = 0;
	if (currentNode == null)
	    return 0;
	else {
	    leftTree = findHeight(currentNode.getLeft());
	    rightTree = findHeight(currentNode.getRight());
	    return 1 + Math.max(leftTree, rightTree);
	}
    }
    
    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return findLeaves(root);
    }
    public int findLeaves( TreeNode currentNode ) {
	if (currentNode == null)
	    return 0;
	else if ((currentNode.getLeft() == null) && (currentNode.getRight() == null))
	    return 1;
	else 
	    return findLeaves(currentNode.getLeft()) + findLeaves(currentNode.getRight());
    }



    //main method for testing
    public static void main( String[] args ) 
    {
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~

	  System.out.println( "\npre-order traversal:" );
	  System.out.println( "expected traversal: 421356" );
	  arbol.preOrderTrav();

	  System.out.println( "\n\nin-order traversal:" );
	  System.out.println( "expected traversal: 123456" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\n\npost-order traversal:" );
	  System.out.println( "expected traversal: 132654" );
	  arbol.postOrderTrav();	
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	  //insert your new test calls here...
	  System.out.println( "\n\n\nsearching for..." );
	  System.out.println( "3: " + arbol.search(3) ); //return TreeNode
	  System.out.println( "5: " + arbol.search(5) ); //return TreeNode
	  System.out.println( "7: " + arbol.search(7) ); //return null

	  System.out.println( "\n\nheight of tree: " + arbol.height() ); //3
	  System.out.println( "inserting a leaf of 7..." );
	  arbol.insert( 7 ); 
	  System.out.println( "height of tree: " + arbol.height() ); //4

	  System.out.println( "\n\nnumber of leaves: " + arbol.numLeaves() );
	  System.out.println( "inserting a leaf of 0..." );
	  arbol.insert( 0 );
	  System.out.println( "number of leaves: " + arbol.numLeaves() );
    }

}//end class
