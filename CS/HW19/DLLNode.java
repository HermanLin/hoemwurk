/*Herman Lin
  APCS2 - pd3
  HW18a -- On The DLL
  2017-3-15*/

/**********************************************
 * class DLLNode
 * Implements a doubly-linked node
 * For use in lists and other container classes
 **********************************************/

public class DLLNode <T> {

    //INST VARS
    private T _cargo;
    private DLLNode<T> _prevNode;
    private DLLNode<T> _nextNode;

    //CONSTRUCTOR   
    public DLLNode (T value, DLLNode<T> prev, DLLNode<T> next) {
	_cargo = value;
	_prevNode = prev;
	_nextNode = next;
    }

    //ACCESSORS
    public T getCargo() {return _cargo;}
    public DLLNode<T> getPrev() {return _prevNode;}
    public DLLNode<T> getNext() {return _nextNode;}

    //MUTATORS
    public T setCargo (T newCargo) {
	T old = _cargo;
	_cargo = newCargo;
	return old;
    }

    public DLLNode<T> setPrev (DLLNode<T> newPrev) {
	DLLNode<T> old = _prevNode;
	_prevNode = newPrev;
	return old;
    }

    public DLLNode<T> setNext (DLLNode<T> newNext) {
	DLLNode<T> old = _nextNode;
	_nextNode = newNext;
	return old;
    }

    //TOSTRING
    public String toString() {return _cargo.toString();}

    /*
    //MAIN METHOD for testing
    public static void main (String[] args) {
    DLLNode<T> first = new DLLNode<T>("a", null, null);

    first.setNext(new DLLNode<T>("b", first, null));

    first.setPrev(new DLLNode<T>("z", null, first));

    first.getNext().setNext(new DLLNode<T>("c", first.getNext(), null));

    }
    */
}
					 
