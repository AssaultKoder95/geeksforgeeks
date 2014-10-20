public class stack {
	dllNode head;
	dllNode mid;
	int count;
	public stack() {
		head = null;
		mid = null;
		count = 0;
	}
	public void push(int data) {
		if(head == null) {
			head = new dllNode(data);
			head.prev = null;
			head.next = null;
		}
		else {
		    dllNode n = new dllNode(data);
		    n.prev = null;
		    n.next = head;
		    head = n;
		}
		count++;
		if(count == 1) {
			mid = head;
		}
		else {
			if(count % 2 == 0) {
				mid = mid.prev;
			}
		}
	}
	public int pop() {
		if(head == null) {
			throw new Exception("stack is empty!");
		}
		else {
			int n = head.data;
			head.next.prev = null;
			head = head.next;
			count--;
			if(count % 2 == 1) {
			    mid = mid.next;
			}
			return n;
		}
	}
	public int middle() {
		if(mid == null) {
			throw new Exception("stack is empty");
		}
		return mid.data;
	}
	public static void main(String[] args) {
	    StackDLL stack = new StackDLL();
		stack.pop();
		stack.push(1);
		System.out.println(stack.middle());
		stack.push(2);
		stack.push(3);
		System.out.println(stack.middle());
		stack.push(4);
		System.out.println(stack.middle());
		stack.pop();
		System.out.println(stack.middle());
		stack.pop();
		System.out.println(stack.middle());
	}
}