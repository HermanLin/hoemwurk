/*Herman Lin
APCS2 - pd3
HW39 -- Heaping Piles of Sordidness
2017-5-10*/


import java.util.ArrayList;

public class HeapSort {


    public static ALHeap heapify (ALHeap heapArray, int index) {
	int left = 2 * index + 1;
	int right = 2 * index + 2;
	int min, store;	
	
	if ( (left < heapArray.getSize() - 1) &&
	     heapArray.getValue(left) < heapArray.getValue(index) )
	    min = left;
	else
	    min = index;

	if ( (right < heapArray.getSize() - 1) &&
	     heapArray.getValue(right) < heapArray.getValue(min) )
	    min = right;

	if (min != index) {
	    heapArray.swap(index, min);
	    heapify(heapArray, min);
	}
    }
    
    public static ALHeap sort (ALHeap heapArray) {

	int notSort = heapArray.getSize();

	while (notSort > 1) {

	    notSort--;

	    if (
	}
    }



}
