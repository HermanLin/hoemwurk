/*Herman Lin
APCS2 - pd3
<<<<<<< HEAD
HW24 -- 
=======
HW24 -- Leon Leonwood Stack
2017-3-26*/

>>>>>>> fc5c81b2789673b1bfa86e95857d58660752d1f3

/*****************************************************
 * class LLStack
 * Implements ADT stack as specified in local Stack.java
 * Generically typed
 * Uses a LinkedList as underlying container
 *****************************************************/

import java.util.LinkedList;

public class LLStack<T> implements Stack<T> 
{
<<<<<<< HEAD


=======
    //INSTANCE VARIABLES
    private LinkedList<T> _llist = new LinkedList<T>();
    private int _size;

    //CONSTRUCTOR
    public LLStack ( ) {
	
    }
    
    //METHODS
    public boolean isEmpty() {
	return _size == 0;
    }

    public T peek() {
	return _llist.peekLast();
    }

    public T pop() {	
	T stor = null;
	if (_size == 0) return null;
	else {
	    _size --;
	    stor = _llist.removeLast();
	}
	return stor;
    }

    public void push( T x ) {
	_llist.add(x);
	_size ++;
    }
>>>>>>> fc5c81b2789673b1bfa86e95857d58660752d1f3


    //main method for testing
    public static void main( String[] args ) 
{
<<<<<<< HEAD
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
=======
>>>>>>> fc5c81b2789673b1bfa86e95857d58660752d1f3
	Stack<String> tastyStack = new LLStack<String>();

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coocoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//joo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//ioo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//hoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//goo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//foo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//eoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//doo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//boo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//aoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	System.out.println( tastyStack.pop() );
<<<<<<< HEAD
=======
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
>>>>>>> fc5c81b2789673b1bfa86e95857d58660752d1f3
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/   
    }//end main()

}//end class LLStack
