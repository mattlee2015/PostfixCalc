

public class DoublyLinked <AnyType>{
	
	
	private Dnode<AnyType> head;
	private Dnode<AnyType> tail;
	
	
	
	public class Dnode <AnyType>{
		public AnyType data;     // the “data”
		public Dnode<AnyType> prev;      // the “link” 
		public Dnode<AnyType> next;      // the “link”
	
		
	}
	
	
	public DoublyLinked() {
		 head = null;  
		
	}
	
	
	
	
	
	
	public Dnode<AnyType> getHead() {
		return head;
	}


	public void setHead(Dnode<AnyType> head) {
		this.head = head;
	}

	public Dnode<AnyType> getTail() {
		return tail;
	}

	public void setTail(Dnode<AnyType> tail) {
		this.tail = tail;
	}






	public boolean isEmpty(){
		
		return head == null;
		
	}
	
	public void insertBeg(AnyType x){
		
		
		Dnode<AnyType> newNode = new Dnode<AnyType>();
		newNode.data = x;
		if(head==null){
			
			head = newNode;
			tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		}else{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		
		
		
	}
	
	
	
	public AnyType deleteLast(){
		
		Dnode<AnyType> oldTail = tail;
		
		tail = tail.prev;
		tail.next = null;
		return oldTail.data;
		
		
	}
	
	
	public void printList(){
		
		Dnode<AnyType> current = head;
		if(!isEmpty()){
			while(current != null){
				System.out.print(current.data+" ");
				current = current.next;
			}
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		
		DoublyLinked<Integer> list = new DoublyLinked<Integer>();
		
		
		
		list.insertBeg(100);
		list.printList();
		list.insertBeg(20);
		list.printList();
		list.deleteLast();
		list.printList();
		
		
		
		
		
		
	}

}
