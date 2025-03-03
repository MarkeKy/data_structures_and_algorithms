package Assign1;
import java.util.Random;
public class HeapSortTest {
    public static void HeapSort(int[] S) {
    	HeapADT H = new HeapADT(S.length+1);//Create new heap ADT object
    	int n = S.length;
    	for (int i = 0; i<n;i++) {
    		H.insert(S[i]);
    	}
    	
    	for (int i =0; i<n;i++) {
    		S[i]=H.removeMin();
    	}
    }
    public static void printArray(int[] A) {
    	for (int i = 0; i<A.length;i++) {
			if (i==A.length-1)
				System.out.println(A[i]);
			else
				System.out.print(A[i]+",");
		}
    }
    
	public static void main(String[] args) {
		int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] B = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] C = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
		HeapSort(A);
		HeapSort(B);
		HeapSort(C);
		printArray(A);
		printArray(B);
		printArray(C);
		
		 int[] sizes = {8, 16, 32, 64, 128, 256, 512, 1024};
	        Random random = new Random();

	        System.out.println("Array Size, Time");
	        
	        for (int i = 0; i < sizes.length; i++) {
	            int size = sizes[i];
	            int[] array = new int[size];
	            
	            // Fill the array with random integers
	            for (int j = 0; j < size; j++) {
	                array[j] = random.nextInt(1000); //Random numbers (0-999)
	            }
	            
	            // Measure the sorting time
	            long startTime = System.nanoTime();
	            HeapSort(array);
	            long endTime = System.nanoTime();
	            
	            long elapsedTime = endTime - startTime;
	            
	            // Print the results
	            System.out.println(size + ", " + elapsedTime);
	        }

	}

}
