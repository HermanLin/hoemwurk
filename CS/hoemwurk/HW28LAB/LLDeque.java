//Stacked Deque: James Smith, Queenie Xiang, Herman Lin
//APCS2 pd3
//Lab02: All Hands on Deque
//2017-04-01

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LLDeque<T> implements Deque<T>{
    DLLNode<T> _front, _end;
    int _size;

    public LLDeque(){
        _front = _end = null; 
	_size = 0;
    }
    /**
      *Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
      *@param value Desired value to be inserted at the end
      *@return boolean stating the success of the operation
     */
    public boolean add(T value) {

	if (_size == 0) {
	    addFirst(value);
	    return true; 
	}
	
	else {
	    _end.setNext( new DLLNode (value, _end, null) ); 
	    _end = _end.getNext();
	}
	
	_size ++;
	return true;
    }

    /**
     *Inserts the specified element at the front of this deque
     *@param value Desired value to be inserted in the front
     */
    public void addFirst(T value) {

	if (_size == 0) 
	    _front = _end = new DLLNode<T>(value, null, _end);
    
	else {
	    _front.setPrev( new DLLNode (value, null, _front) );
	    _front = _front.getPrev(); 
	}
	_size ++;
    }

    /**
     *Returns true if this deque contains the specified element
     *@param Object Target object
     *@return boolean
     */
    public boolean contains(Object o){
	DLLNode currentNode = new DLLNode(null, null, null);
	Iterator it = new AscendingIterator();
	while(it.hasNext()){
	    currentNode.setValue(it.next());
	    System.out.println(currentNode.getValue());
	    if( currentNode.getValue().equals(o) ){
		return true;
	    }
	}
	
	return false;
    }

    /**
     *Returns an iterator over the elements in this deque in proper sequence.
     *@return Iterator
     */
        public Iterator<T> iterator(){
    	return (new AscendingIterator());
    }

    /**
     *Returns an iterator over the elements in this deque in reverse sequential order.
     *@return Iterator
     */
    public Iterator<T> descendingIterator(){
	return (new DescendingIterator());
    }

    /**
     *Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     *@return T
     */
    public T peek(){
	if (isEmpty()){
	    return null;
	}
	return (_front.getValue());
    }

    /**
     *Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     *@return T
     */
    public T peekLast(){
	if(isEmpty()){
	    return null;
	}
	
	return (_end.getValue());
    }
    
    /**
     *Retrieves, but does not remove, the first element of this deque.
     *@return T
     */
    public T getFirst() {
	return peek();
    }

    /**
     *Retrieves, but does not remove, the last element of this deque.
     *@return T
     */
    public T getLast() {
	return peekLast();
    }

    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
     *@return T The removed element
     */
    public T remove(){
	if(isEmpty()){
	    return null;
	}
	
	else{
	    T retVal = _front.getValue(); 
	    _front = _front.getNext();
	    _front.setPrev(null); 
	    _size--;
	    return retVal;
	}
    }
	    

    /**
     *Removes the first occurrence of the specified element from this deque.
     *@param Object Desired Object to be removed
     *@return boolean
     */
    public boolean remove(Object o) {
	if (isEmpty()) {
	    return false;
	}
	
	DLLNode temp = _front;
	
	while (temp.getNext() != null){


	    /*
	    System.out.println("==============");
	    System.out.println(temp.getValue());
	    System.out.println(temp.getValue().equals(o));
	    System.out.println("==============");
	    */
	    
	    if (temp.getValue().equals(o)){
		if (temp.getPrev() != null ) {
		    temp.getPrev().setNext(temp.getNext());
		    temp.getNext().setPrev(temp.getPrev());


		    //System.out.println(temp.getPrev().getNext());
		    //System.out.println(temp.getNext().getPrev()); 
		}

		else {
		    _front = temp.getNext();
		}

		_size--;
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    } 

    /**
     *Retrieves and removes the last element of this deque.
     *@return T Removed element
     */
    public T removeLast() {
	if (isEmpty()) {
	    return null;
	}
	
	T retVal = _end.getValue();
	_end = _end.getPrev();
	if (_end == null) {
	    _front = null;
	    _size --;
	    return retVal;
	}
	else 
	    _end.setNext(null);	
	_size--;
	return retVal;
    } 
	

    /**
     *Returns the number of elements in this deque.
     *@return int
     */
    public int size() {	
	return _size;
    }
	
    /**
     *Returns if the deque is empty.
     *@return boolean
     */
    public boolean isEmpty() {
	return (_size == 0);
    } 

    public String toString(){
	DLLNode temp = _front; 
	String retStr = "";
	while(temp != null){
	    retStr += temp.getValue() + " ";
	    temp = temp.getNext();
	}
	return retStr;
    }
	    

    /******************************************************
    -------------------ITERATORS---------------------------
    ******************************************************/
    
    private class AscendingIterator implements Iterator<T>{

	private DLLNode<T> _dummy;
	private boolean _okToRemove;

	public AscendingIterator(){
	    _dummy = new DLLNode(null, null, _front);
	    _okToRemove = false;
	}
	
	public boolean hasNext(){
	    return (_dummy.getNext() != null);
	}

	public T next(){
	    if ( hasNext() ) {
		_dummy = _dummy.getNext();
	    }
	    
	    else {
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;
	    return _dummy.getValue(); 
	}

	
	public void remove(){
	    if(! _okToRemove ){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		if(_size == 1){
		    remove();
		}

		else if( _dummy.equals(_front)) {
		    remove();
		}
		
		else if(_dummy.equals(getLast())) {
		    removeLast();
		}
		
		else{
		    _dummy.getPrev().setNext((_dummy.getNext()));
		    _dummy.getNext().setPrev(_dummy.getPrev());
		}
		_size--;
	    }
	}
    }

    private class DescendingIterator implements Iterator<T>{
	private DLLNode<T> _dummy;
	private boolean _okToRemove;

	public DescendingIterator(){
	    _dummy = new DLLNode(null, _end, null);
	    _okToRemove = false;
	}
	
	public boolean hasNext(){
	    return (_dummy.getPrev() != null);
	}

	public T next(){
	    _dummy = _dummy.getPrev();
	    if(_dummy == null){
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;
	    return _dummy.getValue();
	}

	public void remove(){
	    if(! _okToRemove ){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		if(_size == 1){
		    remove();
		}
		if(_dummy.equals(getLast())){
		    removeLast();
		}
		else{
		    _dummy.getPrev().setNext((_dummy.getNext()));
		    _dummy.getNext().setPrev(_dummy.getPrev());
		}
		_size--;
	    }
	}
    }
    
}
