package Assign1;

import java.util.Random;

public class Merge {
	static queue A = new queue();
	static queue B = new queue();
	static queue A1 = new queue();
	static queue B1 = new queue();
	static queue A2 = new queue();
	static queue B2 = new queue();
	static queue A3 = new queue();
	static queue B3 = new queue();
	
	public static void show(queue A) {
		if (A.isEmpty()) {
			return;
		}
		System.out.println(A.dequeue());
		show(A);
	}
	
	public Merge(){
	
	}
	
	public static queue Merge_S(queue A, queue B, queue S) {
		
		while (!A.isEmpty() && !B.isEmpty()) {
			if (A.front()<B.front()) {
				S.enqueue(A.dequeue());
			}
			else {
				S.enqueue(B.dequeue());
			}
		}
		while (!A.isEmpty()) {
			S.enqueue(A.dequeue());
		}
		while (!B.isEmpty()) {
			S.enqueue(B.dequeue());
		}
		return S;
	}
	
	public static void mergeSort(queue S) {
		if (S.size()<=1)
			return;//base case reach, start popping
		queue S1 = new queue();//Partitions of the queue
		queue S2 = new queue();
		int n = S.size();
		for (int i = 0; i<n/2;i++) {
			S1.enqueue(S.dequeue());//Gets first half of queue
		}
		while(!S.isEmpty()) {
			S2.enqueue(S.dequeue());//Gets the remaining elements
		}
		mergeSort(S1);//Recursive call one
		mergeSort(S2);//Recursive call two
		Merge_S(S1,S2,S);//Final merging
	}

	
	public static void main(String[] args) {
		
//		int a[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//		int b[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		int c[] = {1, 2, 4, 5, 3, 7, 8, 10, 11, 9, 6};
//		for (int i =0; i<a.length; i++) {
//			A.enqueue(a[i]);
//		}
//		for (int i = 0; i<b.length; i++) {
//			B.enqueue(b[i]);
//		}
//		for (int i = 0; i<c.length; i++) {
//			A1.enqueue(c[i]);
//		}
//		mergeSort(A);
//		mergeSort(B);
//		mergeSort(A1);
//		System.out.print("The list S1 is: ");
//		while(!A.isEmpty())
//			System.out.print(A.dequeue());
//		System.out.print("\n");
//		System.out.print("The list S2 is: ");
//		while(!B.isEmpty())
//			System.out.print(B.dequeue());
//		System.out.print("\n");
//		System.out.print("The list S3 is: ");
//		while(!A1.isEmpty())
//			System.out.print(A1.dequeue());
//		System.out.print("\n");
		int[] sizes = {8, 16, 32, 64, 128, 256, 512, 1024};
        Random random = new Random();

        System.out.println("Merge Sort Array Size, Time");
        
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            int[] array = new int[size];
            
            // Fill the array with random integers
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(1000); //Random numbers (0-999)
            }
            for (int k =0; k<array.length; k++) {
   			    A.enqueue(array[i]);
     		}
            
            // Measure the sorting time
            long startTime = System.nanoTime();
            mergeSort(A);
            long endTime = System.nanoTime();
            
            long elapsedTime = endTime - startTime;
            
            // Print the results
            System.out.println(size + ", " + elapsedTime);
        }
		
		
	}
		
		
		
//		int a[] = {1,3,5,7,9};
//		int b[] = {2,3,6,8,10};
//		for (int i =0; i<a.length; i++) {
//			A.enqueue(a[i]);
//		}
//		for (int i = 0; i<b.length; i++) {
//			B.enqueue(b[i]);
//		}
//		int a1[] = {1,2,3,4,5};
//		int b1[] = {6,7,8,9,10};
//		for (int i =0; i<a1.length; i++) {
//			A1.enqueue(a1[i]);
//		}
//		for (int i = 0; i<b1.length; i++) {
//			B1.enqueue(b1[i]);
//		}
//		int a2[] = {2,4,8,16,32};
//		int b2[] = {1,3,5,7,9};
//		for (int i =0; i<a2.length; i++) {
//			A2.enqueue(a2[i]);
//		}
//		for (int i = 0; i<b2.length; i++) {
//			B2.enqueue(b2[i]);
//		}
//		int a3[] = {10,11,12,13};
//		int b3[] = {1,2,3,4};
//		for (int i =0; i<a3.length; i++) {
//			A3.enqueue(a3[i]);
//		}
//		for (int i = 0; i<b3.length; i++) {
//			B3.enqueue(b3[i]);
//		}
//		queue S1 = new queue();
//		Merge_S(A,B,S1);
//		System.out.print("The list S1 is: ");
//		while(!S1.isEmpty())
//			System.out.print(S1.dequeue());
//		System.out.print("\n");
//		queue S2 = new queue();
//		Merge_S(A1,B1,S2);
//		System.out.print("The list S2 is: ");
//		while(!S2.isEmpty())
//			System.out.print(S2.dequeue());
//		System.out.print("\n");
//		queue S3 = new queue();
//		Merge_S(A2,B2,S3);
//		System.out.print("The list S3 is: ");
//		while(!S3.isEmpty())
//			System.out.print(S3.dequeue());
//		System.out.print("\n");
//		queue S4 = new queue();
//		Merge_S(A3,B3,S4);
//		System.out.print("The list S4 is: ");
//		while(!S4.isEmpty())
//			System.out.print(S4.dequeue());
//		System.out.print("\n");
//		//Bonus
//		for (int i =0; i<a3.length; i++) {
//			A3.enqueue(a3[i]);
//		}
//		for (int i = 0; i<b3.length; i++) {
//			B3.enqueue(b3[i]);
//		}
//		show(A3);
//		int size = 100;
//	do {
//			for (int j = 0; j <size; j++) {
//				A.enqueue(1);
//			}
//			for (int j = 0; j <size; j++) {
//			B.enqueue(1);
//			}
//			long start = System.nanoTime();
//          Merge_S(A,B,S1);
//			long end = System.nanoTime();//Measure the end time
//			System.out.println(end-start);
//			size*=2;
//		}while(size <=51200);
//	}
		
		
		


}
