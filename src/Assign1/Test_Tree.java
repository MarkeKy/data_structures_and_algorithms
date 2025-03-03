package Assign1;

public class Test_Tree {
	public static void main(String[] args) {
		BST_ADT Tree = new BST_ADT();
		for (int i = 1; i<16; i++) {
			Tree.TreeInsert(i);
		}
		Tree.inOrder(Tree.root);
		System.out.println();//So that a new line is added
		//Perform search(1) 100000 and record the time
		long start = System.nanoTime();
		for (int i = 0; i<100000;i++) {
			Tree.TreeSearch(1, Tree.root);//Search for 1 100000 times
		}
		long end = System.nanoTime();
		long duration = end - start;
		System.out.println("Running time of search(1) in nanoseconds: " + duration);
		//Perform search(15) 100000 and record the time
		long start1 = System.nanoTime();
		for (int i = 0; i<100000;i++) {
			Tree.TreeSearch(15, Tree.root);//Search for 1 100000 times
		}
		long end1 = System.nanoTime();
		long duration1 = end1 - start1;
		System.out.println("Running time of search(15) in nanoseconds: " + duration1);
		System.out.println("Removing 5");
		Tree.remove(5);
		Tree.inOrder(Tree.root);
		System.out.println();
		System.out.println("Removing 15");
		Tree.remove(15);
		Tree.inOrder(Tree.root);
		System.out.println();
		System.out.println("Removing 1");
		Tree.remove(1);
		Tree.inOrder(Tree.root);
		System.out.println();
		System.out.println("Inserting 2");
		Tree.TreeInsert(2);
		Tree.inOrder(Tree.root);
		System.out.println();
		
		BST_ADT Tree_2 = new BST_ADT();
		int[] a = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 
				13, 15};
		for (int i = 0; i<a.length;i++) {
			Tree_2.TreeInsert(a[i]);
		}
		System.out.println("Second list");
		Tree_2.inOrder(Tree_2.root);
		System.out.println();
		//Perform search(1) 100000 and record the time
				long start2 = System.nanoTime();
				for (int i = 0; i<100000;i++) {
					Tree_2.TreeSearch(1, Tree_2.root);//Search for 1 100000 times
				}
				long end2 = System.nanoTime();
				long duration2 = end2 - start2;
				System.out.println("Running time of search(1) in nanoseconds: " + duration2);
				//Perform search(15) 100000 and record the time
				long start3 = System.nanoTime();
				for (int i = 0; i<100000;i++) {
					Tree_2.TreeSearch(15, Tree_2.root);//Search for 1 100000 times
				}
				long end3 = System.nanoTime();
				long duration3 = end3 - start3;
				System.out.println("Running time of search(15) in nanoseconds: " + duration3);		
				System.out.println("Removing 8");
				Tree_2.remove(8);
				Tree_2.inOrder(Tree_2.root);
		
	}
}
