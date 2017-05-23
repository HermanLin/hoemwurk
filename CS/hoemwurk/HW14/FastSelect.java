/*Herman Lin
ACPS2 - pd3
HW14 -- So So Fast
2017-3-7*/

/*=======================ALGORITHM======================
 * For my algorithm I found out that to ensure that
 * the yth smallest value you want is in the correct
 * spot in the array, you need to run the partition
 * method yth + 1 times. After doing so, you can 
 * ensure that arr[yth] will be the yth smallest number.
 =====================================================*/

public class FastSelect {
	
	/*|||||||||||||||||||||||||||||||||||||||||
	partition
	pre: takes an int array, a left bound and 
		 right bound integers and a pivot point
	pst: returns the position
	|||||||||||||||||||||||||||||||||||||||||*/
	public static int partition(int arr[], int left, int right, int pvtPos) {
		int pvtVal = arr[pvtPos];
		swap(arr, pvtPos, right);
		int storVal = left;
	
		for (int i = left; i < right; i++) {
			if (arr[i] <= pvtVal) {
				swap(arr, i, storVal);
				storVal++;
			}
		}	
		swap(arr, storVal, right);
		return storVal;
  }
	
	/*||||||||||||||||||||||||||||||||||||||||||||||
	swap
	pre: takes int array u and two indexes to switch
	pst: switches indexes a and b
	||||||||||||||||||||||||||||||||||||||||||||||*/
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
		String subfix = "";
		int[] newArrOne = randArr(8);
		
		for (int i = 0; i < 5; i ++) {
			if (i == 0) subfix = "st";
			else if (i == 1) subfix = "nd";
			else if (i == 2) subfix = "rd";
			else subfix = "th";
			
			System.out.println("Testing for " + (i+1) + subfix + " smallest number...");
			
			System.out.println("Array: " + printArr(newArrOne));
			for (int yth = 0; yth <= i+1; yth++) {
				partition(newArrOne, 0, 7, yth);
				System.out.println(printArr(newArrOne));
			}
			System.out.println((i+1) + subfix + " smallest number is " + newArrOne[i] + "\n");
		}
	}
}