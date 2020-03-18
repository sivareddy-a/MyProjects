package ds_008_recursion;

public class PermutationCombinations {

	public static void main(String[] args) {
		char[] choices = {'X','Y','Z'};
		int selectionSize = 2;
		char[] selection = new char[2];
		int index = 0;
		boolean[] used = new boolean[choices.length];
		System.out.println("all combinations ::::");
		printAllCombinations(index,choices,selection,selectionSize,used);
		System.out.println("All permutations with rep :::: ");
		printAllPermutationsWithRepitition(index,choices,selection,selectionSize);
		System.out.println("All permutations without rep ::::");
		printAllPermutationsWithputRep(index,choices,selection,selectionSize,used);
	}

	private static void printAllPermutationsWithRepitition(int index, char[] choices, char[] selection,int selectionSize) {
		if(index == selectionSize)
			printarray(selection);
		else {
			// char start = selection[index];
			for(int i = 0; i< choices.length; i++) {
				selection[index] = choices[i];
				printAllPermutationsWithRepitition(index+1,choices,selection,selectionSize);
			}
			
		}		
	}

	private static void printAllPermutationsWithputRep(int index, char[] choices, char[] selection, int selectionSize, boolean[] used) {
		if(index == selectionSize)
			printarray(selection);
		else {
			for(int i = 0; i< choices.length; i++) {
				if(!used[i]) {
				used[i] = true;
				selection[index] = choices[i];
				printAllPermutationsWithputRep(index+1,choices,selection,selectionSize,used);
				used[i] = false;
				}
			}
			
		}	
	}

	private static void printAllCombinations(int index, char[] choices, char[] selection, int selectionSize, boolean[] used) {
		if(index == selectionSize)
			printarray(selection);
		else {
			for(int i = 0; i< choices.length; i++) {
			 if(!contains(selection,choices[i])) {
				selection[index] = choices[i];
				printAllCombinations(index+1,choices,selection,selectionSize,used);
			 }
			}			
		}	
	}

	private static boolean contains(char[] selection, char c) {
		for(int i = 0; i<selection.length;i++)
			if(selection[i] == c)
				return true;
		return false;
	}

	private static void printarray(char[] selection) {
		for(int i=0; i<selection.length; i++)
			System.out.print(selection[i]+" ");
		System.out.println();		
	}

}
