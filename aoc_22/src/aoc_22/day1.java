package aoc_22;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class day1 {
	
	public static void main(String [] args) {
		day1_puzzle1();
		day1_puzzle2();	
		}
	public static void day1_puzzle1() {
		ArrayList<Integer> depths = getFileContentsInArr();
		
		int counter = 0;
		
		int max = depths.get(0);
		
		for(int i = 1; i < depths.size(); i++) {
			if (max < depths.get(i)) 
				counter++;
			max = depths.get(i);
		}
		
		System.out.println(counter);
		System.out.println(depths.size());
	}
	
	public static void day1_puzzle2() {
		ArrayList<Integer> depths = getFileContentsInArr();
		
		
		int counter = 0;
		//using assumption that there will be no array out of bounds due to size of input
		int first_window = depths.get(0) + depths.get(1)+depths.get(2);
		int second_window = -1;
		
		for(int i = 1; i+2 < depths.size(); i++) {
			second_window = depths.get(i) + depths.get(i+1)+depths.get(i+2);
			if(first_window < second_window)
				counter++;
			first_window = second_window;
		}
		
		System.out.println(counter);
	}
	
	public static ArrayList<Integer> getFileContentsInArr(){
		File file = new File("./src/input.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		//build array
		while(scan.hasNextLine()) {
			//add error handling?
			output.add(Integer.parseInt(scan.nextLine()));
		}
		
		return output;
	}
}
