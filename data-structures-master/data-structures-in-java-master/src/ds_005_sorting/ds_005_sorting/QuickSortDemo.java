package ds_005_sorting;

public class QuickSortDemo {

	public static void main(String[] args) {
		
//		int[] array = { 2, 1, 3, 4, 5, 7, 6 };
//		int[] array = { 5, 3, 4, 4, 8, 6, 7 };
//		int[] array = { 5, 3, 4, 4, 8, 6, 7, 1 };
//		int[] array = { 5, 4, 3, 2, 1 };
		int[] array = { 1 ,2, -5, 3, 2 } ;
		
//		int[] array = { 1, 2, 3, 4, 5 };
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
//		int[] array = { 5, 1, 2, 3, 4 };
//		int[] array = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
//		int[] array = { 5, 4, 3, 2, 1 };
//		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		printArray(array);
		
		quicksort(array,0,array.length-1);
		
		printArray(array);
	}
	
	private static void quicksort(int[] array, int i, int j) {
		if(i>j) return;
	
		int pivot = array[j];
		int x = i, y = i-1;
		while(x <= j-1) {
			if(array[x] <= pivot) {
				y++;
				if(x!=y)
				swap(array,x,y);
			}
			x++;
		}
		swap(array,y+1,j);
		quicksort(array, i, y);
		quicksort(array, y+2, j);
	}

	private static void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
		
	}

	/*
	 * Worst Case, Best Case, Random Case are all equal = O(N^2)
	 */
	private static void selectionSort(int[] array) {
		int times = 0;
		
		for(int i = 0; i < array.length; i++) {
			int smallest = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[smallest]) {
					smallest = j;
				}
				times++;
			}
			if(smallest != i) {
				int temp = array[i];
				array[i] = array[smallest];
				array[smallest] = temp;
			}
		}
		
		System.out.println("Times : " + times);
	}

	private static void printArray(int[] array) {
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%2d ", array[i]);
		}
		System.out.print("\n");
	}

}
