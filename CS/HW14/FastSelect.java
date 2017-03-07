/*Herman Lin
ACPS2 - pd3
HW14 -- So So Fast
2017-3-7*/

public class FastSelect {
	
	/*|||||||||||||||||||||||||||||||||||||||||
	partition
	pre: takes an int array, a left bound and 
		 right bound integers and a pivot point
	pst: returns the position
	|||||||||||||||||||||||||||||||||||||||||*/
	public static int partition (int[] arr, int left, int right, int pvtPos) {
		int pvtVal = arr[pvtPos];
		swap(arr, pvtPos, right);
		int storVal = left;
		
		for (int z = left; z < right; z ++) {
			if (arr[z] <= pvtVal) {
				swap(arr, z, storVal);
				storVal++;
			}
		}
		swap(arr, storVal, right);
		
		return storVal;
	}
	
	/*|||||||||||||||||||||||||||||||||||||||||||||||
	swap
	pre: takes an int array and two indexes to switch
	pst: switches indexes a and b
	|||||||||||||||||||||||||||||||||||||||||||||||*/
	public static void swap (int[] u, int a, int b) {
		int store = u[a];
		u[a] = u[b];
		u[b] = store;
	}
	
	/*||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	randArr
	pre: takes an int size
	pst: returns an int array of size with random elements [0, 25)
	||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
	public static int[] randArr (int size) {
		int[] retArr = new int[size];
		for (int x = 0; x < size; x ++) {
			retArr[x] = (int)(Math.random() * 25);
			for (int y = 0; y < x; y ++) {
				while (retArr[x] == retArr[y])
					retArr[y] = (int)(Math.random() * 25);
			}
		}
		return retArr;
	}
	
	/*|||||||||||||||||||||||||||||||||||||||||||||||
	printArr
	pre: takes an int array
	pst: returns the stringified version of the array
	|||||||||||||||||||||||||||||||||||||||||||||||*/
	public static String printArr (int[] arr) {
		String retStr = "[";
		for (int i: arr)
			retStr += i + ",";
		retStr = retStr.substring(0, retStr.length() - 1);
		return retStr + "]";
	}
	
	//|||||||||||//
	//MAIN METHOD//
	//|||||||||||//
	public static void main (String[] args) {
		
		System.out.println("Testing 3rd smallest number...");
		int[] newArr = randArr(7);
		System.out.println("Array: " + printArr(newArr));
		
		for (int x = 0; x < 3; x ++) {
			//System.out.println("a = 0, b = 6, c = " + x);
			partition(newArr, 0, 6, x);
			//System.out.println("Array after run: " + printArr(newArr));
		}
		System.out.println("3rd smallest number is " + newArr[2]);
	}
}