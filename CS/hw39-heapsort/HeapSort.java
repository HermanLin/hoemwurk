/*Herman Lin
APCS2 - pd3
HW39 -- Heaping Piles of Sordidness
2017-5-10*/


import java.util.ArrayList;

public class HeapSort {

    /*
      ALGORITHM
      1) heapifty input ArrayList into a max heap
      2) move heap[0] to the end by swapping with the value at heap[size-1]
      3) heapify the rest of the heap
     */
    public static ArrayList<Integer> sort (ArrayList<Integer> array) {

	int parentIndex = (array.size() - 2) / 2;
	int childIndex = array.size() - 1;
	
	for (int i = 0; i < array.size() - 1; i ++) {
	    while (array.get(parentIndex) < array.get(childIndex)) {
		int max = maxChildPos(
		swap(array, childIndex, parentIndex);
	    }
	    childIndex = parentIndex;
	    parentIndex = (childIndex - 1) / 2;
	}
	return array;
    }

    //=======HELPER METHODS=======
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    private int maxChildPos( int pos, int last, ArrayList arr ) 
    {
	if (((2 * pos) + 1) > (last - 1) ||
	    ((2 * pos) + 2) > (last - 1))
	    return -1;
	else {
	    int aVal = arr.get((2 * pos) + 1);
	    int bVal = arr.get((2 * pos) + 2);
	    int min = minOf(aVal, bVal);
	    
	    if (min == bVal)
		return (2 * pos) + 1;
	    else
		return (2 * pos) + 2;
	}
    }   

    public static void swap ( ArrayList arr, int pos1, int pos2 ) {
	arr.set(pos1, array.set(pos2, arr.get(pos1)));
    }
    //============================

    public static void main (String[] args) {

	ArrayList<Integer> heep = new ArrayList<Integer>();

	for (int i = 0; i < 10; i++) {
	    int rand = (int)(Math.random() * 100);
	    while (heep.contains(rand))
		rand = (int)(Math.random() * 100);
	    heep.add(rand);
	}

	System.out.println("Random Array of Ints: " + heep);
	System.out.println("Heapified Array: " + sort(heep));
    }
}
