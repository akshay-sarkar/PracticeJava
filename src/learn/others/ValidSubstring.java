package learn.others;

import java.util.Stack;

// https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
public class ValidSubstring {
	
	static int findMaxLen(String str) 
    { 
        int n = str.length(); 
       
        Stack<Character> stk = new Stack<>();  
       
        // Initialize result 
        int result = 0; 
       
        // Traverse all characters of given string 
        for (int i=0; i<n; i++) 
        { 
            if (str.charAt(i) == '(') {
              stk.push(str.charAt(i)); 
            } else if(!stk.isEmpty())
            { 
                if(stk.peek().equals('(')) { 
                	result+=2;
                	stk.pop();
                } 
            } 
        } 
       
        return result; 
    } 
	
	public static void main(String[] args) {
		String str = "((()()"; 
        System.out.println(findMaxLen(str)); 
       
        str = "()(()))))"; 
        System.out.println(findMaxLen(str)); 

	}

}
