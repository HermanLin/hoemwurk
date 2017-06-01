// Clyde "Thluffy" Sinclair
// APCS2 pd0
// HW34 -- Algo as Data Structure
// 2017-05-04

/*****************************************************
 * class TreeNode
 * Implements a node for use in a binary tree.
 * Only holds Driver.Asteroid.Collider cargo.
 *****************************************************/

public class TreeNode 
{
    //instance variables / attributes of a TreeNode:
    Driver.Asteroid.Collider _cargo;     //this node's data
    TreeNode _lt, _rt; //poDriver.Driver.Asteroid.Colliderers to left, right subtrees


    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode(Driver.Asteroid.Collider initValue )
    {
	_cargo = initValue;
    }
          

    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified
     * value, left, and right subtrees.
     *****************************************************/
    TreeNode(Driver.Asteroid.Collider initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	this(initValue);
	_lt = initLeft;
	_rt = initRight;
    }
 

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	return _lt;
    }


    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	return _rt;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    Driver.Asteroid.Collider getValue() 
    {
	return _cargo;
    }


    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	_lt = theNewLeft;
    }


    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
	_rt = theNewRight;
    }


    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue(Driver.Asteroid.Collider theNewValue ) 
    {
	_cargo = theNewValue;
    }
 
}//end class