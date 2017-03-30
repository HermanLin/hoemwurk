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
	_front = null;
	_end = null; //first node
	_size = 0;
    }
    

    public void enqueue( T enQVal ) 
    {
	_end = new LLNode<T>(enQVal, _end);
	_size ++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    {
	LLNode<T> temp = _end;
	T old;

	while (temp.getNext() != _front)
	    temp = temp.getNext();
	old = temp.getValue();
	_size --;
	sample();
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
	int rand = (int)(Math.random() * _size);
	LLNode<T> temp = _end;
	for (int i = 0; i < rand - 1; i ++)
	    temp = temp.getNext();
	//System.out.println(temp);
	//System.out.println(rand);	       

	LLNode<T> hold = new LLNode<T>(temp.getNext().getValue(), null);
	//System.out.println(hold);
	
    }

    public boolean isEmpty() 
    { 
	return _size == 0;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retQ = "";
        LLNode<T> temp = _end;
	while (temp != null) {
	    retQ += temp.getValue() + " ";
	    temp = temp.getNext();
	}
	return retQ;	   
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	  RQueue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...
	  System.out.println("\ntesting sample()...");
	  PirateQueue.sample();
	  System.out.println( PirateQueue );
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
