/*Herman Lin
APCS2 - pd3
HW13 -- We Be Dem
2017-3-6*/

public class Mysterion {

    /*
      mysterion
      @pre: takes an int array and integers a, b, and c
      @post: 
     */
    public static int mysterion (int[] arr, int a, int b, int c) {
	int v = arr[c];
	int store = arr[c];
	arr[c] = arr[b];
	arr[b] = store;
	int s = a;
	for (int i = a; i < b-1; i ++) {
	    if (arr[i] < v) {
		store = arr[s];
		arr[s] = arr[i];
		arr[i] = store;
		s += 1;
	    }	    
	}
	store = arr[b];
	arr[b] = arr[s];
	arr[s] = store;
	System.out.println("v = " + v);
	System.out.println("Array after run: " + printArr(arr));
	return s;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      randArr
      @pre: takes an integer 'size'
      @post: returns an integer array of size with random elements
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static int[] randArr (int size) {
	int[] retArr = new int[size];
	for (int x = 0; x < size; x ++) {
	    retArr[x] = (int)(Math.random() * 25);

	    /*============================================
	    //Testing cases with unique elements
	    for (int y = 0; y < x; y ++) {
		while (retArr[x] == retArr[y])
		    retArr[y] = (int)(Math.random() * 25);		
	    }

	    ============================================*/
	}
	return retArr;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      printArr
      @pre: takes an integer array
      @post: returns a stringified version of the array
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static String printArr (int[] arr) {
	String retStr = "[";
	for (int x = 0; x < arr.length; x ++)
	    retStr += arr[x] + ",";
	retStr = retStr.substring(0, retStr.length() - 1);
	retStr += "]";
	return retStr;
    }
    
    public static void main (String[] args) {

	//Testing array from class...
	int[] classA = {1, 28, 33, 4982, 37};
	System.out.println("classArray: " + printArr(classA));
	System.out.println("a = 0, b = 4, c = 2");
	System.out.println("s = " + mysterion(classA, 0, 4, 2) + "\n");
	
	//testing 5 randomly filled arrays...
	for (int x = 0; x < 5; x ++) {
	    int[] retArr = randArr(7);
	    System.out.println("Array: " + printArr(retArr));
	    
	    //random integers for a b c within the range for retArr
	    int p, q, r;
	    p = (int)(Math.random() * 7);
	    q = (int)(Math.random() * 7);
	    r = (int)(Math.random() * 7);

	    //testing same a, b, c
	    //p = 0; q = 4; r = 2;
	    System.out.println("a: " + p + ", b: " + q + ", c: " + r);

	    System.out.println("s = " + mysterion(retArr, q, p, r));
	    System.out.println("");
	}
	/*============================================================
	=============================================================*/
    }
}
