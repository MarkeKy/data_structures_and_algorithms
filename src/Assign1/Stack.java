package Assign1;


	public class Stack {
		Linked_List<Character> list = new Linked_List<>();
	    //public Stack(int size){//Initializes the Stack class
	    
	    //}
	    
	    public void push(char element){
	        list.addFirst(element);//adds to the front of the list
	    }
	    public boolean isEmpty(){
	        return list.size() == 0;
	    }   
	    public char pop(){
	        if(isEmpty()){
	            System.out.println("Stack is empty");
	            return '\0';//return NULL to indicate stack is empty, use that in checks when using pop()
	        }
	        return list.removeFirst();   
	    }
	    public char top(){
	        if(isEmpty()){
	            System.out.println("Stack is empty, nothing to display");
	            return '\0';
	        }
	        return list.getFirst();
	    }
	    public int size(){
	        return list.size();//size of stack
	    }
	}

