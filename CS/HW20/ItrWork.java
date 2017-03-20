/*Herman Lin
APCS2 - pd3
HW20 -- DeIteratour
2017-3-19*/

/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork 
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
        for (Integer i: L) 
	    if (i.equals(key))
		return true;	
	return false;
    }


    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    {
	Iterator k = L.iterator();
	while (k.hasNext()) {
	    if (k.next().equals(key))
		return true;
	    k.remove();
	}
	return false;
    }


    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    {
	List<Integer> retL = new ArrayList<Integer>();
        for (Integer i: L)
	    if (i % 2 == 1)
		retL.add(i);
	return retL;
    }


    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    {
        Iterator<Integer> k = L.iterator();
	List<Integer> retL = new ArrayList<Integer>();
	Integer number;
	while (k.hasNext()) {
	    number = k.next();
	    if (number % 2 == 1)
		retL.add(number);
	    //System.out.print(k.next() + " ");
	    k.remove();
	}
	return retL;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
	Iterator<Integer> k = L.iterator();
	while (k.hasNext())
	    if (k.next() % 2 == 1)
		k.remove();
    }
	

    public static void main( String [] args ) 
    {

	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...


	// a) using a FOREACH loop
	
	for (int i: L)
	    System.out.print(i + " ");
	System.out.println();
	
	// b) explicitly using an iterator
	Iterator k = L.iterator(); 
	while (k.hasNext()) {
	    System.out.print(k.next() + " ");
	    k.remove();
	}

	for( int i = 0; i < 10; i++ )
	    L.add(i);
	
	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	for( int i = 0; i < 10; i++ )
	    L.add(i);
	
	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.print(n + " ");       
	
	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.print(n + " ");

	for( int i = 0; i < 10; i++ )
	    L.add(i);
	
	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.print(n + " ");
	/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork

