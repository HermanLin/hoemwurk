/*Herman Lin
APCS2 - pd3
HW12 -- Thinkers of the Corn
2017-03-05*/


/***
 * SKEELTON for class 
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 * 
 * ALGORITHM for finding exit from starting position:
 * 1) Choose a starting position (manually or automatically) on the maze path
 * 2) Check if you can move to the goal
 * 3) Check for a valid path to move on (including turns)
 * 4) If there is a valid path, move to that path
 * 5) If there is no valid path to move, backtrack to an intersection
 * 6) Repeat from step 2 until solved
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver 
{
    private char[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;

    //initialize constants for map component symbols
    final private char HERO =         '@';
    final private char PATH =         '#';
    final private char WALL =         ' ';
    final private char EXIT =         '$';
    final private char VISITED_PATH = '.';


    public MazeSolver( String inputFile ) 
    {
	// init 2D array to represent maze 
	// (80x25 is default terminal window size)
	maze = new char[80][25];
	h = 0;
	w = 0;

	//transcribe maze from file into memory
	try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

		String line = sc.nextLine();

		if ( w < line.length() ) 
		    w = line.length();

		for( int i=0; i<line.length(); i++ )
		    maze[i][row] = line.charAt( i );

		h++;
		row++;
	    } 

	    for( int i=0; i<w; i++ )
		maze[i][row] = WALL;
	    h++;
	    row++;

	} catch( Exception e ) { System.out.println( "Error reading file" ); }

	//at init time, maze has not been solved:
	solved = false;
    }//end constructor


    public String toString() 
    {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	//String retStr = "[0;0H";  
	String retStr = "";
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC

	int i, j;
	for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
		retStr = retStr + maze[j][i];
	    retStr = retStr + "\n";
	}
	return retStr;
    }


    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) 
    {
	try {
	    Thread.sleep(n);
	} catch( InterruptedException e ) {
	    System.exit(0);
	}
    }


    /*********************************************
     * void solve(int x,int y) -- recursively finds maze exit (depth-first)
     * @param x starting x-coord, measured from left
     * @param y starting y-coord, measured from top
     *********************************************/
    public void solve( int x, int y ) {

	delay(50); //slow it down enough to be followable

	//primary base case
	if ( solved ) {
	    System.out.println(this);
	    System.exit(0);
	} 
	//other base case(s)...
	else if ( x < 0 || x > h || y < 0 || y > w ) {
	    return;
	}
	else if ( maze[x][y] == EXIT ) {
	    solved = true;
	    return;
	}
	else if ( !onPath(x, y) ) {
	    //maze[x][y] = HERO;
	    return;
	}
	//recursive reduction
	else {
	    maze[x][y] = HERO;
	    
	    System.out.println(this);
	    //maze[x][y] = PATH;
	    solve(x, y + 1); //up
	    //System.out.println("Recursing...");
	    solve(x, y - 1); //down
	    //System.out.println("Recursing...");	    
	    solve(x - 1, y); //left
	    //System.out.println("Recursing...");
	    solve(x + 1, y); //right
	    //System.out.println("Recursing...");
	    
	    maze[x][y] = VISITED_PATH;

	    System.out.println(this);
	}
    }

    //accessor method to help with randomized drop-in location
    public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

}//end class MazeSolver


public class Maze 
{
    public static void main( String[] args ) 
    {
	try {
	    String mazeInputFile = args[0];

	    MazeSolver ms = new MazeSolver( mazeInputFile );
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 
	    System.out.println( ms );

	    //drop hero into the maze (coords must be on path)
	    //comment next line out when ready to randomize startpos
	    //ms.solve( 3, 4 ); 


	    //drop our hero into maze at random location on path
	    //the Tim Diep way:
	    Random r = new Random();
	    int startX = r.nextInt( 80 );
	    int startY = r.nextInt( 25 );
	    while ( !ms.onPath(startX,startY) ) {
		//System.out.println("Checking for valid pos...");
		startX = r.nextInt( 80 );
		startY = r.nextInt( 25 );
		//System.out.println("X: " + startX);
		//System.out.println("Y: " + startY);
	    }

	    ms.solve( startX, startY );
	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	} catch( Exception e ) { 
	    System.out.println( "Error reading input file." );
	    System.out.println( "Usage: java Maze <filename>" ); 
	}
    }

}//end class Maze
