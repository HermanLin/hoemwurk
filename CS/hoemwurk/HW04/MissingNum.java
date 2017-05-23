/*Eric Li, Herman Lin
  APCS2 - pd3
  HW04 -- Where In the Array is Carmen San Numero?
  2017-02-05*/

/*||||||||||||||||||||||||||||||||||||||||||||||||||||
  findMissing
  @precondition: takes an int array with 1 duplicate
                 and one missing number
  @postcondition: returns the missing number
  
  This algorithm uses "flagging" to find the missing
  number. It runs through the array and takes the 
  index of array[i] and negates that element, 
  essentially flagging the number. Because we know 
  that the array has n integers containing 1 to n, 
  the index of the number missing will not be negated 
  (We treat the indexes of the array as 1|2|3|... 
  instead of 0|1|2|...), leaving the job of the method 
  to return the index as the missing number.
  ||||||||||||||||||||||||||||||||||||||||||||||||||*/

public class MissingNum {

    public static int findMissing( int[] A ) {
	int num = 0;
	for ( int i = 0; i < A.length; i ++ ) 
	    A[Math.abs(A[i]) - 1] = 0 - Math.abs(A[Math.abs(A[i]) - 1]);	
	for ( int i = 0; 1 < A.length; i ++ ) {
	    if ( A[i] > 0 ) {
		num = i + 1;
		break;
	    }
	}
	return num;
    }
    
    public static void main(String[] args) {
	int[] carmen = {2, 1, 2, 4};
	System.out.println("The missing number is " + findMissing(carmen));
	int[] HE = {1, 4, 3, 5, 6, 5, 7};
	System.out.println("The missing number is " + findMissing(HE));
	int[] TomatoCale={6,3,5,4,5,2};
	System.out.println("The missing number is " + findMissing(TomatoCale));
	int[] boo = {5, 5, 2, 3, 1};
	System.out.println("The missing number is " + findMissing(boo));
	int[] edgecase = {1, 1};
	System.out.println("The missing number is " + findMissing(edgecase));
	int[] coffee = {6,2,10,27,49,21,5,16,34,50,31,2,11,38,14,25,28,36,12,1,3,43,22,40,4,44,7,17,18,29,41,8,33,19,46,9,45,20,13,23,24,42,39,30,15,35,26,32,37,47};
	System.out.println("The missing number is " + findMissing(coffee));
	int[] stitch ={6,2,1,3,3,4,7,8,9};
	System.out.println("The missing number is " + findMissing(stitch));
    }
}
