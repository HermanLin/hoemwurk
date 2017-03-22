/*Herman Lin
APCS2 - pd3
HW22 -- Stacks on Stacks on Stacks...
2017-3-22*/


/***
 * class Latkes
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    }

    //means of removal
    public String pop( ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	if (_stackSize == 0)
	    return true;
	return false;
    }

    //chk for fullness
    public boolean isFull() 
    {
	if (_stackSize == _stack.size)
	    return true;
	return false;
    }

}//end class Latkes

