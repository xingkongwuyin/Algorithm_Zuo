package Lesson17;

import java.util.Stack;

public class Code05_ReverseStackUsingRecursive {
	// reverse: 逆序整个栈
	// 实现：将栈底元素弹出，然后上面的元素覆盖下来，将栈中的元素逆序，最后将弹出元素压栈
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i = f(stack);
		reverse(stack);
		stack.push(i);
	}
	
	// f: 返回栈底元素，且将栈底元素上面所有元素改下来
	// 实现： 弹出栈顶元素，弹出剩下元素的栈底元素，最后将弹出的栈底元素压栈，返回栈底元素
	public static int f(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}
		int last = f(stack);
		stack.push(result);
		return last;
		
	}
}
