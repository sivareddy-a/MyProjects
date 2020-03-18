package com.siva.strings.problems;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args)
	{
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";

		KMP(text, pattern);
	}

	private static void KMP(String text, String pattern) {
		int[] lps = new int[pattern.length()];
		constructLPS(lps,pattern);
		Arrays.stream(lps).forEach((x) -> System.out.print(x+" "));
		
	}

	private static void constructLPS(int[] lps, String pattern) {
		int l = pattern.length();
		if(l == 0)
			System.out.println("pattern is empty");
		else {
			for(int i =0; i<l; i++) {
				int count = 0;
				String curr = pattern.substring(0, i+1);
				int halflen = curr.length()/2;
				String firstHalf = curr.substring(0, halflen);
				String seconHalf = (curr.length()%2 == 0) ? curr.substring(halflen) : curr.substring(halflen+1);
				for(int j= 0,k=halflen-1; j<halflen && k>=0; j++,k--) {
					if(firstHalf.charAt(j) != seconHalf.charAt(k))
						break;
					count++;
				}
				lps[i] = count;
			}
		}	
		
	}

}
