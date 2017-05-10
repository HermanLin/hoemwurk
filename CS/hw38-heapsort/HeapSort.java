/*Herman Lin
  APCS2 - pd3
  HW38 -- Sort of Like Magic
  2017-5-10*/



import java.util.ArrayList;

public class HeapSort {

    /*
      ALGORITHM
      removeMin() n times while adding to return heapArr
    */
    public static ALHeap sort (ALHeap heapArray) {
	
	ALHeap ret = new ALHeap();

	while (!heapArray.isEmpty()) 
	    ret.add(heapArray.removeMin());	
	return ret;
    }

    public static void main (String[] args) {
	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("\nSORTING HEAP...");
	System.out.println(sort(pile));
    }
}
