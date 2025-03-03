package Assign1;


public class Linked_List<T> {//Java Generic
	Node<T> head; //Pointer to the first node in the linked list
	Node<T> tail; //Pointer to the last node in the linked list
	private int size;
	
	Linked_List(){ //Constructor
		head = null;//Initializes the linked list. Empty list has a null pointer
		tail = null;
		size = 0; //size of list is zero
	}
	
	public void addFirst(T e) {//Adds node to front of list, returns the new Node
		Node<T> v = new Node<>(); //New node name v
		v.setElement(e);
		v.setNext(head);//v now points to the previous head
		if (head == null) {
			tail = v;//v also becomes the new tail, since list was previously empty
		}
		head = v;//v becomes the new head
		size++;//linked list increases in size
	}
	
	public T removeFirst() {//removes first node in list, returns the element if successful, or null if empty list
		if (head == null) {
			return null;//List is empty, can't remove
		}
		else {
			T element = head.getElement();
			if (head.getNext() == null) {//removing the only element in the list
				tail = null;
			}
			Node<T> temp = head;
			head = head.getNext();//Points to what the head is pointing to. If null, then list is empty
		    temp.setNext(null);//So that previous head points to null 
		    size--;//size of list decreases
		    return element;//First element has been successfully removed
		}// Since the old head is no longer referenced, the garbage collector will remove it
		
	} //O(1) complexity because we keep track of the head
	
	public void addLast(T e) {// O(1) cause we are keeping track of the tail
		Node<T> v = new Node<>();
		v.setElement(e);//set element to e
		if (head == null) {
			head = v;
			tail = v;
		}
		else {
			tail.setNext(v);
			tail = v;// tail also now points to v
		}
		size++;//size increments, list has increased in size
	}
	
	public T removeLast() {//Returns element if there is one, else null
		if (head == null) {
			return null;//Can't remove from empty list, return null
		}
		else if(head.getNext()== null) {//only one element in list
			T element = head.getElement();
			head = null;
			tail = null;
			size--;
			return element;
		}
		else {
			Node<T> temp = head;
			Node<T> temp_2 = temp;
			while (temp.getNext()!= null) {
				temp_2 = temp;
				temp = temp.getNext();
			}
			T element = temp.getElement();
			temp_2.setNext(null);//The node that points to the last node now points to null
	        size--;//size of list decreases	
	        tail = temp_2; //tail now points to the node that pointed to the previous tail
		    return element;
		}
	}
	
	public T getFirst() {
		if (head != null)
		return head.getElement();//Returns element of node at the front of the list
		else 
			return null;
		
	}
	
	public T getLast() {
		if (head != null)
		return tail.getElement();//Returns element of node at the end of the list
		else 
			return null;//List is empty
	}
	
	public int size() {
		return size; //returns the size of the list
	}
	
	
}
