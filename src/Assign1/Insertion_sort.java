package Assign1;

import java.util.Random;

public class Insertion_sort {
	public static void insertion_sort(int a[]) {
		int n = a.length;
		for (int i = 1; i< n; i++) {
			int value = a[i];//value for last element in 'unsorted' portion. The value we're trying to store in the 'sorted' portion
		    int j = i-1;//the index for the last element in the 'sorted' portion of the array
	        while(j>=0 && a[j]>value) {
	        	a[j+1] = a[j];//shift right, make space for the value
	        	j--;//for checking the next element in the 'sorted' portion
	        }
	        a[j+1] = value;//insert into correct position. j+1 because prior loop decremented and lost track of position by 1
		}
	}
	public static void quicksort(int S[], int a, int b) {// a = 0, b = n-1
		if (a>= b)
			return;//base case, the ranks are the same or have swapped
		int p = S[b];//pivot, last element of the array
		int l = a;// position of the first element in the array (end of list)
		int r = b-1;//Place where pivot element will be placed (position)
		int temp = 0;
		while (l<=r) {
			while (l<=r && S[l]<=p) {
				l = l+1;
			}
			while (l<=r && S[r]>=p) {
				r = r-1;
			}
			if (l<r) {
				temp = S[l];
				S[l] = S[r];
				S[r] = temp;
			}
		}
		temp = S[l];
		S[l] = S[b];
		S[b] = temp;//place pivot in correct place
		quicksort(S,a,l-1);//recursive calls
		quicksort(S,l+1,b);	
	}
	public static void main(String[] args) {
//		int a[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//		int b[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		int c[] = {1, 2, 4, 5, 3, 7, 8, 10, 11, 9, 6};
//		System.out.println("Insertion sort");
//		insertion_sort(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]);
//		}
//		System.out.println();
//		insertion_sort(b);
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(b[i]);
//		}
//		System.out.println();
//		insertion_sort(c);
//		for (int i = 0; i < c.length; i++) {
//			System.out.print(c[i]);
//		}
//		System.out.println();
//		int a1[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//		int b1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		int c1[] = {1, 2, 4, 5, 3, 7, 8, 10, 11, 9, 6};
//		System.out.println("Quicksort");
//		quicksort(a1,0,a1.length - 1);
//		for (int i = 0; i < a1.length; i++) {
//			System.out.print(a1[i]);
//		}
//		System.out.println();
//		quicksort(b1,0,b1.length - 1);
//		for (int i = 0; i < b1.length; i++) {
//			System.out.print(a1[i]);
//		}
//		System.out.println();
//		quicksort(c1,0,c1.length - 1);
//		for (int i = 0; i < c1.length; i++) {
//			System.out.print(c1[i]);
//		}
		int[] sizes = {8, 16, 32, 64, 128, 256, 512, 1024};
        Random random = new Random();

        System.out.println("Quicksort Array Size, Time");
        
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            int[] array = new int[size];
            
            // Fill the array with random integers
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(1000); //Random numbers (0-999)
            }
            
            // Measure the sorting time
            long startTime = System.nanoTime();
            quicksort(array,0,array.length-1);
            long endTime = System.nanoTime();
            
            long elapsedTime = endTime - startTime;
            
            // Print the results
            System.out.println(size + ", " + elapsedTime);
        }
        System.out.println("Insertion Sort Array Size, Time");
        
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            int[] array = new int[size];
            
            // Fill the array with random integers
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(1000); //Random numbers (0-999)
            }
            
            // Measure the sorting time
            long startTime = System.nanoTime();
            insertion_sort(array);
            long endTime = System.nanoTime();
            
            long elapsedTime = endTime - startTime;
            
            // Print the results
            System.out.println(size + ", " + elapsedTime);
        }
        
        
		
	}
}
