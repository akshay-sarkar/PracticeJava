package learn.others;

class SentenceReverse {
	public static void main (String[] args) {
		String line = "i like this program very much";
		StringBuilder stringBuilder = new StringBuilder();
        //1st Approach
        String[] words = line.split(" ");
        
        for(int i=words.length-1; i>=0; i--){
            stringBuilder.append(words[i]+" "); 
        }
            
          
        System.out.println("Reversed String 1st Approach :");
        System.out.println(stringBuilder);

	    //2nd Approach 
	    StringBuilder temp  = new StringBuilder(line), strBuilder = new StringBuilder();
	    words = temp.reverse().toString().split(" ");
	    for(int i=0; i<words.length; i++){
	        strBuilder.append(new StringBuilder(" "+words[i]).reverse());
	    }
	    System.out.println("Reversed String 2nd Approach :");
	     System.out.println(strBuilder);
	}
	
	
}