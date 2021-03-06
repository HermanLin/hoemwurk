/*Herman Lin
APCS2 - pd3
HW17 -- Give and Take
2017-3-13*/

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add (String x) {
	if (_head == null) {
	    _head = new LLNode(x, null);
	    _size ++;
	}
	else {
	    LLNode temp = _head;
	    while (temp.getNext() != null)
		temp = temp.getNext();
	    temp.setNext(new LLNode(x, null));
	    _size ++;
	}
	return true;
    }

    public String get (int i) {
	LLNode temp = _head;
	if (i > _size)
	    return "OUT OF BOUNDS";
	else {
	    for (int y = 0; y < i; y ++) 
		temp = temp.getNext(); 
	}
	return temp.getCargo();
    }

    public String set (int i, String x) {
	LLNode temp = _head;
	if (i > _size)
	    return "OUT OF BOUNDS";
	else {
	    for (int y = 0; y < i; y ++)
		temp = temp.getNext();
	    temp.setCargo(x);
	}
	return x;
    }

    //insert a node containing newVal at position index
    public void add (int index, String newVal) {
	if (index >= _size)
	    this.add(newVal);

	LLNode temp = _head;
	for (int i = 0; i < index - 1; i ++)
	    temp = temp.getNext();
	temp.setNext(new LLNode(newVal, temp.getNext()));
	_size ++;
    }

    //remove node at pos index, return its cargo
    public String remove (int index) {
	if (index >= _size || index < 0)
	    return "OUT OF BOUNDS";
	
	LLNode temp = _head;
	LLNode stor;
	String old;
	for (int i = 0; i < index - 1; i ++)
	    temp = temp.getNext();
	old = temp.getNext().getCargo();
	temp.setNext(temp.getNext().getNext());
	return old;
    }
    
    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	james.add( 1, "a" );
	System.out.println( "Adding 'a' as the 2nd item..." );
	System.out.println( james );

	System.out.println( "Removing " + james.remove(3));      
	//james.remove( 3 );
	System.out.println( james );
    }

}//end class LList



