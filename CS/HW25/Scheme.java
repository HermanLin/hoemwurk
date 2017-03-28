/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
 * <<< YOUR PROCEDURE HERE >>>
 * 
 * STACK OF CHOICE: _____ by _____
 * b/c ...
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String retStr = "";
	String[] exprArr = expr.split("\\s+");
	Stack<String> pancake = new LLStack<String>();
	
	for (int x = exprArr.length - 1; x >= 0; x --) {
	    if (exprArr[x].equals("(")) {
		String oper = pancake.pop();
		if (oper.equals("+")) 
		    pancake.push(unload(1, pancake));
		else if (oper.equals("-"))
		    pancake.push(unload(2, pancake));
		else if (oper.equals("*"))
		    pancake.push(unload(3, pancake));		
	    }
	    else pancake.push(exprArr[x]);
	}
        retStr = pancake.pop();
	return retStr;
    }


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operand to
     *           sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {	
	int firstNumb = Integer.parseInt(numbers.pop());

	while(!(numbers.peek().equals(")"))) {
	    int secndNumb = Integer.parseInt(numbers.pop());
	    if ( op == 1 )
	        firstNumb = firstNumb + secndNumb;
	    else if ( op == 2 )
		firstNumb = firstNumb - secndNumb;
	    else if ( op == 3 )
		firstNumb = firstNumb * secndNumb;
	}
	if (numbers.peek().equals(")"))
	    numbers.pop();
	return firstNumb + "";
    }


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//main

}//end class Scheme
