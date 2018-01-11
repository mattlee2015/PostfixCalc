
public class linkedL <AnyType>{

	private MyNode<AnyType> first;
	
	public class MyNode<AnyType>{
		
		public MyNode<AnyType> next;
		public AnyType data;
		
	}
	
	public linkedL(){
		
		
		
	}
	
	
	
	public MyNode<AnyType> getFirst() {
		return first;
	}



	public void setFirst(MyNode<AnyType> first) {
		this.first = first;
	}



	public boolean isEmpty(){
		
		return first == null;
		
	}
	
	
	public void insert(AnyType x){
	
		MyNode<AnyType> current = new MyNode<AnyType>();
		current.data = x;
		
		
		if(isEmpty()){
			
			first = current;
		}else{
			
			current.next = first;
			first = current;
		}
		
	}
	
	
	
	public void printList(){
		
		MyNode<AnyType> current = first;
		
		while(current!=null){
			
			System.out.print(current.data+" ");
			current = current.next;
		}
		
		System.out.println();
	}
	
	
	
	 public AnyType deleteFirst() {
	        MyNode<AnyType> oldFirst = first;
	        first = first.next;
	        return oldFirst.data;
	    }
		
	
	
	
	public static void main(String[] args) {
		
		linkedL<Integer> list = new linkedL<Integer>();
		list.insert(3);
		list.insert(1);
		
		list.printList();
		
	}

}
