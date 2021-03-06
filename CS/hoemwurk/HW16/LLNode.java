/*Herman Lin
APCS2 - pd3
HW16a -- We Got a Little Ol' Convoy...
2017-3-12*/

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class LLNode
{

    private String _cargo;    //cargo may only be of type String
    private LLNode _nextNode; //pointer to next LLNode

    // constructor -- initializes instance vars
    public LLNode() {
    }
    
    public LLNode( String value, LLNode next ) 
    {
	_cargo = value;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public LLNode getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) 
    {
	String old = _cargo;
	_cargo = newCargo;
	return old;
    }

    public LLNode setNext( LLNode newNext ) 
    {
	LLNode old = _nextNode;
	_nextNode = newNext;
	return old;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    public static void main( String[] args ) 
    {

	//Below is an exercise in creating a linked list...

	//Create a node
	LLNode first = new LLNode( "cat", null );
	//System.out.println(first);

	//Create a new node after the first
	first.setNext( new LLNode( "dog", null ) );
	//System.out.println(first);

	//Create a third node after the second
	first.getNext().setNext( new LLNode( "cow", null ) );
	//System.out.println(first);

	// A naive list traversal:
	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	

	//Q: When head ptr moves to next node in list,
	//   what happens to the node it just left?
	//A: it sets first to the next node

    }//end main
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

}//end class LLNode
