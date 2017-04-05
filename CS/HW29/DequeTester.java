/*Herman Lin
APCS2 - pd3
HW29 -- Stress is the Best
2017-4-4*/

import java.util.Iterator;

public class DequeTester{

    public static void main(String[] args){
	Deque<String> test = new LLDeque<String>();

	//Adding to the Deque
	test.add("for");
	test.add("vive");
	test.add("zix");
	test.addFirst("tree");
	test.addFirst("too");
	test.addFirst("juan");


	//toString test
	System.out.println("\nNow printing the toString()");
	System.out.println(test);

	//Tests for peek()
	System.out.println("\nNow testing peek() methods");
	System.out.println(test.peek());
	System.out.println(test.peekLast());

	//Tests for get()
	System.out.println("\nNow testing get() methods");
	System.out.println(test.getFirst());	
	System.out.println(test.getLast());
	
	//Tests for Iterators
	System.out.println("\nNow printing ascending iterator");
	for(Iterator i = test.iterator(); i.hasNext(); ){
	    System.out.println(i.next());
	}

	System.out.println("\nNow printing descending iterator");
	for(Iterator k = test.descendingIterator(); k.hasNext(); ){
	    System.out.println(k.next());
	}
	
	
	//Test for contains() method
	System.out.println("\nNow testing contains() method");
	String inDeque = "weven";
	String notInDeque = "ate";

	test.add(inDeque);

	System.out.println("\n" + test.contains(inDeque));
	System.out.println("\n" + test.contains(notInDeque));


	//Tests for Remove Methods
	System.out.println("\nNow testing remove() method");
	//Juan 

	System.out.println("Now testing remove method");
	System.out.println("Now removing the first element");

	test.remove();
	System.out.println(test);

	//Too
	System.out.println("Now removing the first element");
	test.remove();
	System.out.println(test);

	//Tree
	System.out.println("Now removing the first element");
	test.remove();
	System.out.println(test);

	System.out.println("\nNow testing remove(object) method");
	//For 
	System.out.println("Now removing for");
	test.remove("for");
	System.out.println(test);

	System.out.println("Now removing zix");
	test.remove("zix");
	System.out.println(test);
	
	System.out.println("\nNow testing removeLast() method");
	//Weven
	System.out.println("Now removing the Last element");
	System.out.println(test.removeLast());
	System.out.println(test);
	//Vive
	System.out.println("Now removing the Last element");
	System.out.println(test.removeLast());
	System.out.println(test);

	System.out.println("Empty Deque Remove : SOP null");
	System.out.println(test.removeLast());
	System.out.println(test);

	//Remove Iterator Tests
	Deque<Integer> test2 = new LLDeque<Integer>();
	test2.add(1);
	test2.add(2);
	test2.add(3);
	test2.add(4);

	System.out.println(test2);
	
	Iterator it = test2.iterator();
	while(it.hasNext()){
	    if((int)it.next()%2 == 0){
		it.remove();
	    }
	}

	System.out.println(test2);

	Deque<Integer> test3 = new LLDeque<Integer>();
	test3.add(1);
	test3.add(2);
	test3.add(3);
	test3.add(4);

	System.out.println(test3);
	
	Iterator it2 = test3.descendingIterator();
	while(it2.hasNext()){
	    if((int)it2.next()%2 == 0){
		it2.remove();
	    }
	}

	System.out.println(test3);     
    }
}
