/*Herman Lin
APCS2 - pd3
HW13 -- We Be Dem
2017-3-6*/

public class Mysterion {

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
	//System.out.println(printArr(arr));
	return s;
    }

    public static int[] randArr (int size) {
	int[] retArr = new int[size];
	for (int x = 0; x < size; x ++)
	    retArr[x] = (int)(Math.random() * 25);
	return retArr;
    }

    public static String printArr (int[] arr) {
	String retStr = "[";
	for (int x = 0; x < arr.length; x ++)
	    retStr += arr[x] + ",";
	retStr = retStr.substring(0, retStr.length() - 1);
	retStr += "]";
	return retStr;
    }
    
    public static void main (String[] args) {

	int[] classA = {1, 28, 33, 4982, 37};
	System.out.println("classArray: " + printArr(classA));
	System.out.println("a = 0, b = 4, c = 2");
	System.out.println("s = " + mysterion(classA, 0, 4, 2) + "\n");
	
	/*============================================================
	for (int x = 0; x < 10; x ++) {
	    int[] retArr = randArr(10);
	    System.out.println("Array: " + printArr(retArr));

	    int p, q, r;
	    p = (int)(Math.random() * 9);
	    q = (int)(Math.random() * 9);
	    r = (int)(Math.random() * 9);
	    System.out.println("a: " + p + ", b: " + q + ", c: " + r);

	    System.out.println("s = " + mysterion(retArr, q, p, r));
	    System.out.println("");
	}
	=============================================================*/
    }
}
