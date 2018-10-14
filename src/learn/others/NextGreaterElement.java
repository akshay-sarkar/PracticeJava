package learn.others;
// https://www.geeksforgeeks.org/next-greater-element/
import java.util.Iterator;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ar = {12,3,5,9};
		Stack<Integer> stack = new Stack<>(); 
		
		stack.push(ar[0]);
		
		for (int i = 1; i < ar.length; i++) {
			int next = ar[i];
			while(!stack.empty() && stack.peek()<next) {
				System.out.println(stack.pop()+ " next greater element is "+ next);
			}
			stack.push(next);
		}
		
		for (Iterator iterator = stack.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer+ " next greater element is -1");
		}
	}

}
