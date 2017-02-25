/*Herman Lin
  APCS2 - pd3
  HW08 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
  2017-02-24*/


/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * [...]
     */
    public boolean solve()
    {
	if (solveH(0)) {
	    //System.out.println(this);
	    return true;
	}
	//System.out.println("no solution");
	return false;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	if (col == _board.length)
	    return true;
	for(int row = 0; row < _board.length; row ++) {
	    //System.out.println("Trying " + row + " " + col);
	    if (_board[row][col] == 0) {
		addQueen(row, col);
		if(solveH(col + 1))
		    return true;
	    }
	    removeQueen(row, col);
	}
	return false;
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	if (solve()) {
	    for (int x = 0; x < _board.length; x ++) {
		for (int y = 0; y < _board.length; y ++) {
		    if (_board[x][y] == 1)
			System.out.print("Q ");
		    else
			System.out.print("_ ");
		}
		System.out.println();
	    }
	}
	else if(!solve()) {
	    for (int x = 0; x < _board.length; x ++) {
		for (int y = 0; y < _board.length; y ++) {
		    System.out.print("0 ");
		}
		System.out.println();
	    }
	}
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * addQueen
     * precondition: takes a row and a column
     * postcondition: places a queen in [row, col] and replaces
     * the invalid locations with a negative numberr
     */
    private boolean addQueen(int row, int col)
    {
	// if this square of the board is occupied...
	if(_board[row][col] != 0){
	    return false;
	}

	// if this square of the board is not occupied...
	_board[row][col] = 1;

	// counter to mark squares that a queen can attack
	int offset = 1;

	// while the col+offset is !> the row length
	while(col+offset < _board[row].length) {
	    // subtract one from bottom right square
	    _board[row][col+offset]--;

	    // subtract one from the bottom left square
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    // subtract one from the top right square
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // inccrease the offset to accomodate for the
	    // next diagonal squares
	    offset++;
	}
	return true;
    }


    /***
     * removeQueen
     * precondition: takes a row and a column 
     * postcondition: removes a queen from the square
     */
    private boolean removeQueen(int row, int col)
    {
	// if there is no queen at [row, col]
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// "remove" the queen from [row, col]
	int offset = 1;	        // set offset to 1 so you can remove invalid locations

	// while col+offset !> the row length, traverse the diagonals, removing the
	// invalid locations as you move along
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * toString
     * precondition: 
     * postcondition: prints out the board with invalid locations as neg numbers 
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard a = new QueenBoard(1);
	QueenBoard b = new QueenBoard(2);
	QueenBoard c = new QueenBoard(3);
	QueenBoard d = new QueenBoard(4);
	QueenBoard e = new QueenBoard(5);
	QueenBoard f = new QueenBoard(6);
	QueenBoard g = new QueenBoard(7);
	QueenBoard h = new QueenBoard(8);
	
	//QueenBoard i = new QueenBoard(20);
	/*
	  System.out.println(b);
	  b.addQueen(3,0);
	  b.addQueen(0,1);
	  System.out.println(b);
	  b.removeQueen(3,0);
	  System.out.println(b);
	*/
	System.out.println();
	System.out.println("1x1 Board");
	a.printSolution();
	System.out.println();
	System.out.println("2x2 Board");
	b.printSolution();
	System.out.println();
	System.out.println("3x3 Board");
	c.printSolution();
	System.out.println();
	System.out.println("4x4 Board");
	d.printSolution();
	System.out.println();
	System.out.println("5x5 Board");
	e.printSolution();
	System.out.println();
	System.out.println("6x6 Board");
	f.printSolution();
	System.out.println();
	System.out.println("7x7 Board");
	g.printSolution();
	System.out.println();
	System.out.println("8x8 Board");
	h.printSolution();
	
	//System.out.println();
	//System.out.println("20x20 Board");
	//i.printSolution();
    }//end main()
    
}//end class
