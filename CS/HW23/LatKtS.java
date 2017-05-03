/*Herman Lin
APCS2 - pd3
HW23 -- Stack: What Is It Good For?
2017-3-23*/

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	int length = s.length();
	String reversed = "";
	String word = s;
	
	Latkes rev = new Latkes(length);
	for (int i = 0; i < length; i ++) {
	    rev.push(word.substring(i, i + 1));
	}
	while (!rev.isEmpty())
	    reversed += rev.pop();
	return reversed;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    { 
	Latkes stack = new Latkes(s.length());
        for(int i = 0; i < s.length(); i++) {
            String paren = s.substring(i, i + 1);
	    //System.out.println(" " + s.substring(i,i+1));

	    //if you have an opening parens, push to stack
            if(paren.equals("(") || paren.equals("[") || paren.equals("{")) {
                stack.push(paren);
            }

	    //if you have a closing parens...
	    else if(paren.equals(")")) {
                if(stack.isEmpty()) return false;
		//if closing parens doesn't match with opening...
                if(!stack.pop().equals("(")) return false;	       
            }
	    //if you have a closing bracket...
	    else if(paren.equals("]")) {
                if(stack.isEmpty()) return false;
		//if closing bracket doesn't match with opening...
                if(!stack.pop().equals("[")) return false;
            }
	    //if you have a closing curly...
	    else if(paren.equals("}")) {
                if(stack.isEmpty()) return false;
		//if closing curly doesn't match with opening...
                if(!stack.pop().equals("{")) return false;
            }
        }
        return stack.isEmpty();
    }//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
