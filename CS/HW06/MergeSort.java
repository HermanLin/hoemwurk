/*Herman Lin
  APCS2 - pd3
  HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
  2017-02-10*/

/*=======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  sort(int[])
  1) if the input arr has a length of 1,
     return the arr
  2) else split the input arr in half and
     return the merged halves

  merge(int[],int[])
  1) creates a new retArr with length of
     array a and array b
  2) if x reaches the length of array a,
     add b[y] to retArr and increment y
     if y reaches the length of array b,
     add a[y] to retArr and increment x
     if a[x] is less than b[y], add a[x]
     to the retArr and increment x
     else add b[y] to retArr and 
     increment y
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] retArr = new int[a.length + b.length];
	int x = 0;
	int y = 0;
        while(x + y < retArr.length) {
	    if (x == a.length) {
		retArr[x + y] = b[y];
		y ++;
	    }
	    else if (y == b.length) {
		retArr[x + y] = a[x];
		x ++;
	    }
	    
	    else if (a[x] <= b[y]) {
		retArr[x + y] = a[x];
		x ++;		
	    }
	    else {
		retArr[x + y] = b[y];
		y ++;
	    }
	}
	return retArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length <= 1)
	    return arr;
	else {
	    int mid = arr.length / 2;
	    int[] first = new int[mid];
	    int[] second = new int[arr.length - mid];
	    for (int x = 0; x < mid; x ++)
		first[x] = arr[x];
	    for (int y = 0; y < arr.length - mid; y ++)
		second[y] = arr[y + mid];
	    //printArray(first);
	    //printArray(second);
	    return merge(sort(first), sort(second));
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	String retStr = "[";	
	for( int i : a )
	    retStr +=  i + ",";
	retStr = retStr.substring(0, retStr.length() - 1);
	retStr += "]";
	System.out.println(retStr);
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr6_1 = {0,9,17,23,42,63,512};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	
	System.out.println("\nMerging arr4 and arr6_1: ");
	printArray( merge(arr4,arr6_1) );

	System.out.println("\nSorting arr4-7...");
	printArray( arr4 );
	printArray( sort( arr4 ) );
	System.out.println("");
	printArray( arr5 );
	printArray( sort( arr5 ) );       
	System.out.println("");
	printArray( arr6 );
	printArray( sort( arr6 ) );
	System.out.println("");
	printArray( arr7 );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

