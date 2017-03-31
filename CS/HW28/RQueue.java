/*Herman Lin
APCS2 - pd3
HW28 -- Now Let's Consider You Lot at Fake Terry's
2017-3-30*/

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    { 
	_front = _end = null;
	_size = 0;
    }
    

    public void enqueue( T enQVal ) 
    {
	if (_size == 0) 
	    _front = _end = new LLNode<T>(enQVal, null);
	else {
	    _end.setNext(new LLNode<T>(enQVal, null));
	    _end = _end.getNext();	    
	}
	_size ++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    {
	if (_size == 0)
	    return null;
	else {
	    sample();
	    T old = _front.getValue();	
	    if ( _front == null )
		_end = null;
	    _front = _front.getNext();
	    _size --;	
	    return old;
	}
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /*****************************************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * 1. Get a random index correlating to a random node in the queue
     *    If (random == 0) stepTwo;
     *    Else stepThreeTo;
     * 2. Remove the first node by setting _front to its nextNode
     * 3. Move the node you want to remove to the front and remove it
     *    from its old position. Then set the node to _front with a
     *    nextNode as the old _front
     *****************************************************************/
    public void sample () 
    {
	LLNode<T> temp = _front;
	LLNode<T> cake = null;
	
	int rand = (int)(Math.random() * _size);		
	if (rand == 0) {
	    temp.setNext(temp.getNext()); //remove first node
	}
	else {
	    for (int i = 0; i < rand - 1; i ++) 
		temp = temp.getNext(); //get node before rand node	    
	    cake = temp.getNext(); //cake = rand node
	    temp.setNext(temp.getNext().getNext()); //remove cake from Q
	    _front = new LLNode<T>(cake.getValue(), _front); //cake = new _front
	} 
    }

    public boolean isEmpty() 
    { 
	return _size == 0;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retQ = "";
        LLNode<T> temp = _front;
	while (temp != null) {
	    retQ += temp.getValue() + " ";
	    temp = temp.getNext();
	}
	return retQ;	   
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...
	  
	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( "QUEUE: " + PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( "QUEUE: " + PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( "QUEUE: " + PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( "QUEUE: " + PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( "QUEUE: " + PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( "QUEUE: " + PirateQueue );
	  
	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
