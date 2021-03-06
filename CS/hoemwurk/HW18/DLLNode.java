/*Herman Lin
APCS2 - pd3
HW18a -- On The DLL
2017-3-15*/

/**********************************************
 * class DLLNode
 * Implements a doubly-linked node
 * For use in lists and other container classes
 **********************************************/

public class DLLNode {

    //INST VARS
    private String _cargo;
    private DLLNode _prevNode;
    private DLLNode _nextNode;

    //CONSTRUCTOR   
    public DLLNode (String value, DLLNode prev, DLLNode next) {
	_cargo = value;
	_prevNode = prev;
	_nextNode = next;
    }

    //ACCESSORS
    public String getCargo() {return _cargo;}
    public DLLNode getPrev() {return _prevNode;}
    public DLLNode getNext() {return _nextNode;}

    //MUTATORS
    public String setCargo (String newCargo) {
	String old = _cargo;
	_cargo = newCargo;
	return old;
    }

    public DLLNode setPrev (DLLNode newPrev) {
	DLLNode old = _prevNode;
	_prevNode = newPrev;
	return old;
    }

    public DLLNode setNext (DLLNode newNext) {
	DLLNode old = _nextNode;
	_nextNode = newNext;
	return old;
    }

    //TOSTRING
    public String toString() {return _cargo.toString();}

    /*
    //MAIN METHOD for testing
    public static void main (String[] args) {
	DLLNode first = new DLLNode("a", null, null);

	first.setNext(new DLLNode("b", first, null));

	first.setPrev(new DLLNode("z", null, first));

	first.getNext().setNext(new DLLNode("c", first.getNext(), null));

    }
    */
}
					 
