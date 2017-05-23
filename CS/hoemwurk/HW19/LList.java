
/*Herman Lin
APCS2 - pd3
HW19 -- Generically Speaking
2017-3-16/

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNode<T>s.
 *****************************************************/

public class LList<T> implements List<T> 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private DLLNode<T> _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList() 
    {
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add (T x) {
	if (_head == null) {
	    _head = new DLLNode<T>(x, null, null);
	    _size ++;
	}
	else {
	    DLLNode<T> temp = _head;
	    while (temp.getNext() != null)
		temp = temp.getNext();
	    temp.setNext(new DLLNode<T>(x, temp.getPrev(), null));
	    _size ++;
	}
	return true;
    }

    public T get (int i) {
	DLLNode<T> temp = _head;
	if (i > _size)
	    return null;
	else {
	    for (int y = 0; y < i; y ++) 
		temp = temp.getNext(); 
	}
	return temp.getCargo();
    }

    public T set (int i, T x) {
	DLLNode<T> temp = _head;
	if (i > _size)
	    return null;
	else {
	    for (int y = 0; y < i; y ++)
		temp = temp.getNext();
	    temp.setCargo(x);
	}
	return x;
    }

    //insert a node containing newVal at position index
    public void add (int index, T newVal) {
	if (index >= _size) {
	    this.add(newVal);
	    _size ++;
	}

	DLLNode<T> temp = _head;
	for (int i = 0; i < index - 1; i ++)
	    temp = temp.getNext();
	temp.setNext(new DLLNode<T>(newVal, temp.getPrev(), temp.getNext()));
	_size ++;
    }

    //remove node at pos index, return its cargo
    public T remove (int index) {
	if (index >= _size || index < 0)
	    return null;
	
	DLLNode<T> temp = _head;
	DLLNode<T> stor;
	T old;
	for (int i = 0; i < index - 1; i ++)
	    temp = temp.getNext();
	old = temp.getNext().getCargo();
	temp.setNext(temp.getNext().getNext());
	_size --;
	return old;
    }
    
    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toT
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main(String[] args) {
        LList newList = new LList();
	LList gerbil = new LList();
	gerbil.add("physics");
	
        newList.add("a");
        newList.add("b");
        newList.add(3);
        newList.add(gerbil);
        newList.add(true);
        System.out.println(newList);
	newList.remove(1);
	newList.remove(3);
        System.out.println(newList);

	newList.set(0, "twentyone");
	System.out.println(newList);
    }
    /*
    public static void main( T[] args ) 
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


	james.add( 1, "a" );
	System.out.println( "Adding 'a' as the 2nd item..." );
	System.out.println( james );

	System.out.println( "Removing " + james.remove(3));      
	//james.remove( 3 );
	System.out.println( james );
    }
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    

}//end class LList



