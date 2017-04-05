import java.util.Iterator;

public class LLDequeDriver{

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
	//System.out.println("\nNow testing remove() method");
	//Juan 

	//System.out.println("Now testing remove method");
	//System.out.println("Now removing the first element");

	test.remove();
	//System.out.println(test);

	//Too
	//System.out.println("Now removing the first element");
	test.remove();
	//System.out.println(test);

	//Tree
	//System.out.println("Now removing the first element");
	test.remove();
	//System.out.println(test);

	//System.out.println("\nNow testing remove(object) method");
	//For 
	//System.out.println("Now removing for");
	test.remove("for");
	//System.out.println(test);

	//System.out.println("Now removing zix");
	test.remove("zix");
	
	
	System.out.println("\nNow testing removeLast() method");
	//Weven
	System.out.println("Now removing the Last element");
	System.out.println(test.removeLast());
	System.out.println(test);
	//Vive
	System.out.println("Now removing the Last element");
	System.out.println(test.removeLast());
	System.out.println(test);

	System.out.println("Empty List Remove : SOP null");
	System.out.println(test.removeLast());
	System.out.println(test);
	
    }
}
