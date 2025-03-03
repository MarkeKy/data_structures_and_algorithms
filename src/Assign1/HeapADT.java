package Assign1;

public class HeapADT {
	public int[] H;//Heap implemented on an array
	public int size;//Keeps track of size of heap (number of nodes)
	public HeapADT(int size) {
		H = new int[size+1];//initialize size of heap array
		this.size = 0;//initialize size to zero
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void insert(int e) {//insert operation
		if (size == H.length -1) {
			System.out.println("Error, heap is full and cannot add any more elements");
			return;
		}
		size++;//increment the size
		H[size] = e;//size the first index is zero, use n+1
		//Upheap if needed
		int c = size;//rank of current node
		int p = c/2;//rank of parent. n+1 is rank of new node
		while (p>0) {
			if (H[p]>H[c]) {
				//Swap the parent and child
				int temp = H[p];
				H[p] = H[c];
				H[c] = temp;
				//Update ranks
				c = p;
				p = c/2;
			}
			else
				break;//no need to do Upheap
		}
	}
	public int removeMin() {
		if(isEmpty()) {
			System.out.println("Error, heap is empty, can't remove anymore");
			return -1;
		}
		int min = H[1];//Min is the first element of the Heap array (root)
		H[1] = H[size];//Root now becomes first element of the array
		H[size] = 0;//Set last element to zero
		size--;//Decrease the size of heap
		//Downheap if needed
		
		int p = 1;//Rank of parent
		
		while (p<size) {//So that we go through the whole heap and not get out of bounds
			int L = 2*p;//Rank of left child = 2xrank of parent
			int R  = L +1;//Rank of right child = 2xrank of parent + 1
			int s = p;//Keeps track of the rank of the element that's smallest between parent and 2 children
			if (L<= size && H[L]<H[s]) {//L<=size means that there is a left child
				s = L;//Current smallest is left child. Thus, s becomes rank of left child (L)
			}
			if (R<=size && H[R]<H[s]) {//R<=size means that there is a right child and thus check if it's less than the smallest of right and parent
				s = R;//The smallest of Parent/Left child and Right child is right child
			}
			if (p==s)
				break;//Then the parent is the smallest thus no swapping, break out of loop
			//Swap smallest of children 
			int temp = H[p];
			H[p]= H[s];
			H[s] = temp;
			p = s;//Swap prior parent's rank with it's smallest child so that further downheap can be done
		}
		
		return min;//Return the original root (the smallest element in the min heap)
		
	}
}
