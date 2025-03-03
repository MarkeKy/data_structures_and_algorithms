package Assign1;

public class Node<T> {
	
	private T Element; //Data stored in the node
	Node<T> Next; //Pointer to the next node. Defined as another Node Object
	
	Node(){//Constructor
		Element = null;//initializes Node with data value set to null
		Next = null; // Set the pointer to null
	}
    
	//Accessor and mutator methods
	public T getElement() {
		return Element;
	}

	public void setElement(T element) {
		Element = element;
	}

	public Node<T> getNext() {
		return Next;
	}

	public void setNext(Node<T> next) {
		Next = next;
	}
	
	
	

}