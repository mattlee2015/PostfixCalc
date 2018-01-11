
public class QueuesHw <AnyType> {

	private DoublyLinked<AnyType> dub;
	private int size = 0;
	
	public QueuesHw(){
		
		dub = new DoublyLinked<AnyType>();
		
	}
	
	public interface Queue<AnyType> {
		public boolean isEmpty();
		public void enqueue(AnyType x);
		public AnyType dequeue();
		public AnyType peek();
		}
	
	
	public void enqueue(AnyType x){
		
		
		dub.insertBeg(x);
		
		size++;
		
	}
	
	public boolean queIsEmpty(){
		
		return dub.isEmpty();
		
	}
	
	public AnyType dequeue(){
		
		if(queIsEmpty()){
			return null;
		}
		
		size--;
		return dub.deleteLast();
		
	}
	
	public void showQ(){
		
		dub.printList();
	}
	
	public AnyType peek(){
		
		if(queIsEmpty()){
			return null;
		}
		
		return dub.getHead().data;
		
	}
	
	
	public int qSize(){
		
		return size;
		
	}
	
	
	public static void main(String[] args) {
		
		QueuesHw que = new QueuesHw();
		
		if(que.queIsEmpty()){
			System.out.println("is empty...");
		}
		
		que.enqueue(1);
		que.enqueue(3);
		que.enqueue(5);
		que.enqueue(7);
		que.showQ();
		
		que.dequeue();
		que.showQ();
		que.dequeue();
		que.showQ();
		System.out.println("at the top of the queue is "+que.peek());
		
	}

}
