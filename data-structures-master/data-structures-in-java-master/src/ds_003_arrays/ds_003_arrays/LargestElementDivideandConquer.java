package ds_003_arrays;

public class LargestElementDivideandConquer {

	public static void main(String[] args) {
		int[] a = {12,3,5,78,0,-21,34};
		int largest = findLargest(a,0,a.length-1);
		System.out.println("largest = "+largest);
	}

	private static int findLargest(int[] a, int i, int j) {
		if(i == j) return a[i];
		else {
			int m = (i+j)/2;
			int leftLargest = findLargest(a,i,m);
			int rightLargest = findLargest(a,m+1,j);
			return (leftLargest >= rightLargest ? leftLargest : rightLargest);
		}
	}

}
