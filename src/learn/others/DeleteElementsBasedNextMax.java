// https://www.geeksforgeeks.org/delete-array-elements-which-are-smaller-than-next-or-become-smaller/
package learn.others;
import java.util.Stack;

public class DeleteElementsBasedNextMax {
	
	
	public static Stack<Integer> deleteElements(int arr[], int n) {
		
		Stack<Integer> stack = new Stack<>(); 
		
		stack.push(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			int next = arr[i];
			while(n>0 && !stack.isEmpty() && stack.peek() < next) {
				stack.pop();
				--n;
			}
			stack.push(next);
		}
		return stack;
	}

	public static void main(String[] args) {

		int [] ar = {20, 10, 25, 30, 40};
		int n = 2;
		System.out.println(DeleteElementsBasedNextMax.deleteElements(ar, n));
	}
}
