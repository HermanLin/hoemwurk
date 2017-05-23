/*Herman Lin
APCS2 - pd3
HW32 -- Getting Past the Velvet Rope
2017-4-19*/

import java.util.ArrayList;

public class ArrayPriorityQueue {

    //INSTANCE VARIABLES
    public ArrayList<Integer> _queue;   

    //CONSTRUCTOR
    public ArrayPriorityQueue() {
	_queue = new ArrayList<Integer>();
    }

    /****************************************
      isEmpty
      pre: takes a queue of ArrayList
      post: return true if the queue is empty
    ****************************************/
    public boolean isEmpty() {
	return _queue.size() == 0;
    }

    /***********************************************************
      add
      pre: takes a queue of ArrayList
      post: adds x to the queue based on priority (0 is highest)
    ***********************************************************/
    public void add (int x) {
	if (isEmpty())
	    _queue.add(x);
	else {
	    for (int i = _queue.size() - 1; i > 0; i --) {
		if (x > (int)(_queue.get(i)))
		    _queue.set(i++, (int)(_queue.get(i)));
		else
		    break;
	    }
	    _queue.set(_queue.size() - 1, x);
	}
    }

    /*******************************************************
      removeMin
      pre: takes a queue of ArrayList
      post: returns and removes the highest priority element
    *******************************************************/
    public int removeMin() {
	int VIP = peekMin();
	_queue.remove(_queue.size() - 1);
	return VIP;
    }

    /*******************************************
      peekMin
      pre: takes a queue of ArrayList
      post: returns the highest priority element
    *******************************************/
    public int peekMin() {
	return (int)(_queue.get(_queue.size() - 1));
    }
}
