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
    public static void sort( int[] arr ) {
	for (int i = 0; i < arr.length; i ++) {
	    int pos = i;
	    while (arr[pos] > arr[(pos - 1) / 2]) {
		swap((pos - 1) / 2, pos, arr);
		pos = (pos - 1) / 2;
	    }
	}
	for (int i = arr.length - 1; i > 0; i --) {
	    int big = arr[0];
	    arr[0] = arr[i];
	    int pos = 0;
	    while(maxChildPos(pos, i, arr) != -1 && arr[pos] < arr[maxChildPos(pos, i, arr)]) {
		int mcp = maxChildPos(pos, i, arr);
		swap(pos, mcp, arr);
		pos = mcp;
	    }
	    arr[i] = big;
	}
    }

    private static int maxChildPos( int pos, int last, int[] arr ) {
        if (pos < 0 || pos >= last || (pos * 2) + 1 >= last)
	    return -1;
        if ((pos * 2) + 2 >= last)
	    return (pos * 2) + 1;
        if (arr[(pos * 2) + 1] > arr[(pos * 2) + 2])
	    return (pos * 2) + 1; 
        return (pos * 2) + 2;
    }

    public static void swap( int x, int y, int[] arr ) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
    }

    public static void printArr( int[] arr ) {	
	for ( int z : arr )
	    System.out.print( z + " " );
	System.out.println();
    }

    public static int[] randArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i ++)
	    arr[i] = (int)(Math.random() * 100); 
        return arr;
    }

    public static void main(String[] args) {
        int[] heep = randArr(10);
	
        System.out.println("Unsorted Array...");
        printArr(heep);
	
        sort(heep);
	
        System.out.println("Sorted Array...");
        printArr(heep);
    }
}
