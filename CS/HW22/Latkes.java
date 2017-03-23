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
	if (this.isFull())
	    System.out.println("stack is full");
	
	else {
	    String[] _stor = new String[_stackSize + 1];
	    _stor[0] = s;
	    for (int i = 0; i < _stackSize; i ++)
		_stor[i + 1] = _stack[i];
	}
    }

    //means of removal
    public String pop( ) 
    {
	if (this.isEmpty())
	    return null;
       
        String[] _stor = new String[_stackSize - 1];
	String retStr = _stack[0];
	for (int i = 1; i < _stackSize; i ++)
	    _stor[i-1] = _stack[i];
	_stack = _stor;
	return retStr;
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
	if (_stackSize == _stack.length)
	    return true;
	return false;
    }

}//end class Latkes

