package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MaxCheeseInRow {
	public static void main(String[] args) throws Exception {
		//List of Lists- This will contain array multiple test cases
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		try {
			//To take user input
			Scanner sc=new Scanner(System.in);
			//noOfTestCases - Number of Test cases
		    int noOfTestCases = sc.nextInt();
		  //noOfTestCases - Constraints:1<=T<=200
		    if(noOfTestCases<1 || noOfTestCases>200) {
		    	throw new InputMismatchException("Number of TestCase should be Minimum 1 and Maximum 200");
		    }
		    // Loop added to collect the user input data
		    while(noOfTestCases>=1) {
		    	// arrLen - Length of the Cheese blocks line
		    	int arrLen = sc.nextInt();
		    	//arrLen - Constraints:1<=n<=1000
		    	if(arrLen<1 || arrLen>1000) {
		    		throw new InputMismatchException("Number of elements in array should be Minimum 1 and Maximum 1000");
				}
		    	// arrTest - Array of weight of the Cheese blocks in the line
		    	Integer[] arrTest=new Integer[arrLen];
		    	for(int i=0;i<arrLen;i++){ 
		    		arrTest[i]=sc.nextInt();
		    		//arrTest[i] - Constraints:1<=a[i]<=10000
		    		if(arrTest[i]<1 || arrTest[i]>10000) {
			    		throw new InputMismatchException("Allowed value should be Minimum 1 and Maximum 10000");
					} 
		    	}
		    	// Array will be converted to test	
		    	List<Integer> aList = Arrays.asList(arrTest);
		    	// Converted list will be added to List of Lists
		    	list.add(aList);
		    	noOfTestCases--;
		    }
		}catch(InputMismatchException e) {
			// in case of exception i.e invalid input or if the constraint conditions is not satisfied the exception will be thrown.
			if(e.getMessage() != null )
				System.out.println("Invalid input provided. " + e.getMessage());
			else {
				System.out.println("Invalid input provided. Please provide 'int'" );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	    //List will be iterated and call findMaxCheeseWt() to calculate maximum weight cheese.
		list.stream().forEach(e-> System.out.println(findMaxCheeseWt(e)));
	    

	}

	public static int findMaxCheeseWt(List<Integer> list) {
		/*
		 * How calculation will work?
		 * eg. int[]{7,3,5,9,99,100,3}
		 */
		/*
		 * Step 1 - newVal=7, oldVal=0
		 * Step 2 - newVal=3, OldVal=7
		 * Step 3 - newVal=12, OldVal=7
		 * Step 4 - newVal=16, OldVal=12
		 * Step 5 - newVal=111, OldVal=16
		 * Step 6 - newVal=116, OldVal=111
		 */
		int newVal=list.get(0);
		int oldVal=0;
		for(int i=1;i<list.size();i++){
			/*
			 * Step 1 - newVal=0+3=3, OldVal= 7>0=7
			 * Step 2 - newVal=7+5=12, OldVal= 3>7=7
			 * Step 3 - newVal=7+9=16, OldVal= 12>7=12
			 * Step 4 - newVal=12+99=111, OldVal= 16>12=16
			 * Step 5 - newVal=16+100=116, OldVal= 111>16=111
			 * Step 5 - newVal=111+3=114, OldVal= 116>111=116
			 */
			int newVal1=oldVal+list.get(i);
			int oldVal1=newVal>oldVal? newVal:oldVal;
			newVal=newVal1;
			oldVal=oldVal1;
		}
		//Final evaluation - newVal=114, OldVal=116 - 114>116= 116
		return newVal>oldVal? newVal:oldVal;
	}
	
	

}
