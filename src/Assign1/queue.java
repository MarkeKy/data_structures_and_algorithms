package Assign1;

public class queue {//I
Linked_List<Integer> list = new Linked_List<>();//Object of the linked list class, type int
	
	public void enqueue(int e) {
		list.addLast(e);//adds element to the back of the queue
	}
	
	public int dequeue() {
		if (isEmpty()) {
			return -1;// prevents exception for empty queue, return negative 1
		}
		else
		return list.removeFirst();//Removes first node and return the value
	}
	public boolean isEmpty() {
		if (list.size()==0) 
			return true;//List is empty
		else
			return false;//list is not empty
	}
	public int size() {
		return list.size();//Returns the size of the list
	}
	public int front() {
		return list.getFirst();//returns the first node in the queue without removing it
	}
	
}
