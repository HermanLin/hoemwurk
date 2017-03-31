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
	_front = null; //first node
	_end = null; 
	_size = 0;
    }
    

    public void enqueue( T enQVal ) 
    {
	if (_size == 0) {
	    _end = new LLNode<T>(enQVal, null);
	    _front = _end;
	}
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
	sample();
	LLNode<T> temp = _front;
	System.out.println("front: " + temp);
	T old = _end.getValue();	
	if ( _front == null )
	    _end = null;
	while (temp != _end)
	    temp = temp.getNext();
	System.out.println("end?: " + temp);
	_size --;
	return old;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * 
     * 
     ******************************************/
    public void sample () 
    {
	LLNode<T> temp = _front;
	LLNode<T> cake = null;
	
	int rand = (int)(Math.random() * _size);
	while (rand == _size - 1)
	    rand = (int)(Math.random() * _size);	
	System.out.println("rand = " + rand);
	
	for (int i = 0; i < rand - 1; i ++) {
	    if (rand == 0) break;
	    else temp = temp.getNext(); //get node before rand node
	}
	cake = temp.getNext(); //cake = rand node
	temp.setNext(temp.getNext().getNext()); //remove cake from Q
        enqueue(cake.getValue());
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
	  System.out.println( PirateQueue );
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue );
	  
	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
