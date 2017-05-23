/*Herman Lin, Jeffrey Lin
  Team maet - pd3
  HW02 -- I Am Still Searching
  2017-02-02*/


/*||||||||||||||||||||||||||||||||||||||||||||||||||||||
  matrixSearch
  @pre: takes an N by N matrix and a value to search for
  @post: returns the coordinates of the target value, 
         (-1, -1) if the target is not there

  matrixSearch searches for a target integer within a 
  matrix starting from the top right. If the element 
  being checked in the Matrix is larger than the target, 
  it checks the element to the left of the previous index. 
  If the element being checked is smaller than the target, 
  it checks the element below the previous index. If the 
  target is equal to the index being checked, it will 
  return the index. If either the row or column being 
  checked is out of bounds, it will return (-1, -1).
  ||||||||||||||||||||||||||||||||||||||||||||||||||||*/

public class MatrixFinder {

    public static String matrixSearch( int[][] Matrix, int target ) {
	int x = 0;
	int y = Matrix[0].length - 1;

        if ( Matrix.length == 0 )
	    return "(-1, -1)";		

	boolean isThere = true;
	while( isThere ) {
	    //System.out.println("Row: " + x);
	    //System.out.println("Column: " + y);
	    if ( Matrix[x][y] == target )
		return "(" + x + ", " + y + ")";
	    else if (x >= 0 && y >= 0) {
		if ( Matrix[x][y] > target ) {
		    y--;
		    //System.out.println("New Column: " + y);
		    if ( y < 0 )
			return "(-1, -1)";
		}
		else {
		    x++;
		    //System.out.println("New Row: " + x);
		    if ( x > Matrix.length - 1 )
			return "(-1, -1)";
		}
	    }
	    else
		return "(-1, -1)";		
	}
	return "";
    }
    
    public static void main(String[] args) {

	int[][] bey = {
	    { 1,  3,  5 },
	    { 3,  7,  8 },
	    { 5, 12, 15 }
	};
	System.out.println("SEARCHING FOR 3 IN bey");
	System.out.println(matrixSearch(bey, 3));
	System.out.println("SEARCHING FOR 7 IN bey");
	System.out.println(matrixSearch(bey, 7));
	System.out.println("SEARCHING FOR 12 IN bey");
	System.out.println(matrixSearch(bey, 12));
	System.out.println("SEARCHING FOR 15 IN bey");
	System.out.println(matrixSearch(bey, 15));
	System.out.println("SEARCHING FOR 4 IN bey");
	System.out.println(matrixSearch(bey, 4));
	System.out.println("SEARCHING FOR 0 IN bey");	
	System.out.println(matrixSearch(bey, 0));
	/*==========================================
	=========================================*/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	int maet[][] = {
	    {1, 2, 3, 4},
	    {5, 6, 7, 8},
	    {9, 10, 11, 12},
	    {13, 14, 15, 16}
	};
	System.out.println("SEARCHING FOR 14 IN maet");
	System.out.println(matrixSearch(maet, 14));
	System.out.println("SEARCHING FOR 7 IN maet");
	System.out.println(matrixSearch(maet, 7));
	System.out.println("SEARCHING FOR 1 IN maet");
	System.out.println(matrixSearch(maet, 1));
	System.out.println("SEARCHING FOR 10 IN maet");
	System.out.println(matrixSearch(maet, 10));
	System.out.println("SEARCHING FOR -1 IN maet");
	System.out.println(matrixSearch(maet, -1));
	System.out.println("SEARCHING FOR 0 IN maet");	
	System.out.println(matrixSearch(maet, 0));
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/*_________________________________________
	int[][] arr = new int[3][3];
	arr[0][0] = 1; arr[0][1] = 3; arr[0][2] = 5;
	arr[1][0] = 3; arr[1][1] = 7; arr[1][2] = 8;
	arr[2][0] = 4; arr[2][1] = 12; arr[2][2] = 15;
	System.out.println(matrixSearch(arr,1));
	System.out.println(matrixSearch(arr,3));
	System.out.println(matrixSearch(arr,4));
	System.out.println(matrixSearch(arr,5));
	System.out.println(matrixSearch(arr,7));
	System.out.println(matrixSearch(arr,8));
	System.out.println(matrixSearch(arr,12));
	System.out.println(matrixSearch(arr,15));
	System.out.println("============");
	System.out.println(matrixSearch(arr,2));
	System.out.println(matrixSearch(arr,6));
	System.out.println(matrixSearch(arr,10));
	System.out.println(matrixSearch(arr,11));
	System.out.println(matrixSearch(arr,13));
	_________________________________________*/
    }   
}
