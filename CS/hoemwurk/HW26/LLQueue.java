/*Herman Lin
APCS2 - pd3
HW26 -- The English Do Not Wait In Line
2017-3-29*/

/*****************************************************
 * class LLQueue
 * uses a singly-linked nodes to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
    { 
	_end = null; //first node
	_front = null; //last node
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	if (_end == null) {
	    _end = new LLNode<T>(enQVal, null);
	    _front = _end;
	}	
	_end = new LLNode<T>(enQVal, _end);
    }//O(?)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
	LLNode<T> temp = _end;
	T old;

	while (temp.getNext() != _front)
	    temp = temp.getNext();
	old = temp.getValue();
	_front = temp;
	return old;
    }//O(?)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	return _front.getValue();
    }//O(?)


    public boolean isEmpty() 
    {
	if (_end == null)
	    return true;
	return false;
    }//O(?)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retQ = "END-> ";
	LLNode<T> temp = _end;

	while (temp != _front) {
	    retQ += temp.getValue() + " ";
	    temp = temp.getNext();
	}
	retQ += "->FRONT";
	return retQ;
    }//O(?)



    public static void main( String[] args ) {

	  Queue<String> LLQueuelJ = new LLQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...

	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ );
	  
	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
