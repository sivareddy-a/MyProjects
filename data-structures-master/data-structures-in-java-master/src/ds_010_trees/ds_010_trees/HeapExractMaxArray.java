package ds_010_trees;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HeapExractMaxArray {
	
	public static void main(String[] ar) {
		int[] a = {29,20,10,15,18,9,5,13,2,4,15};
		int max = extractMax(a);
		System.out.println("max = "+max);
		IntStream.of(a).forEach(System.out::println);
	}

	private static int extractMax(int[] a) {
		// TODO Auto-generated method stub
		int max = a[0];
		a[0] = Integer.MIN_VALUE;
		moveDown(a,0);
		return max;
	}

	private static void moveDown(int[] a, int i) {
		int len = a.length;
		int[] t = new int[len-1];
		int curr = i;
		int l,r;
		while(curr <= len/2-1) {
			l = 2*curr+1;
			r = 2*curr+2;
			if(a[l]>=a[r]) { swap(a,curr,l); curr=l;}
			else
				{ swap(a,curr,r); curr = r; }			
		}
		for(int x = 0; x<len-1; x++)
			t[x] = a[x];		
		a = Arrays.copyOf(a, len-1);
	}

	private static void swap(int[] a, int i, int j) {
		a[i]  = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
		
	}

}
