

public class StacksHw<AnyType>{
	
	private linkedL<AnyType> link; 
	
	


	
	public StacksHw(){
		
	
		link = new linkedL<AnyType>();
		
	}
	
	public interface Stack<AnyType> {
		public boolean isEmpty();
		public void push(AnyType x);
		public AnyType pop();
		public AnyType peek();
		}




	public void push(AnyType x){
		
		link.insert(x);
	}
	
	
	
	public boolean stackIsEmpty(){
		
		return link.isEmpty();
		
	}
	
	
	public AnyType pop(){
		
		if(stackIsEmpty()){
			return null;
		}
		
		return link.deleteFirst();
		
		
	}
	
	
	public void showStack(){
		link.printList();
	}
	
	public AnyType peek(){
		
		if(stackIsEmpty()){
			return null;
		}
		
		return link.getFirst().data;
	}
	
	
	public static void main(String[] args) {
		
		StacksHw stk = new StacksHw();
		
		if(stk.stackIsEmpty()){
			System.out.println("is empty...");
		}
		
		stk.push(1);
		stk.push(3);
		stk.push(5);
		stk.push(7);
		stk.showStack();
		
		stk.pop();
		stk.showStack();
		stk.pop();
		stk.showStack();
		System.out.println("at the top of the stack is "+stk.peek());
	}
	

}
