package sbu.mad.gridbox;

import java.util.Scanner;


public class Driver {
	public static void main(String[] args){
		Grid grid = new Grid(4,4);
		Scanner scan = new Scanner(System.in);
		String input = "h";
		while(!input.toLowerCase().equals("q"))
		{
			if(inputQuery(input,"u")){
				grid.moveUp();
			}
			else if(inputQuery(input,"d")){
				grid.moveDown();
			}
			else if(inputQuery(input,"l")){
				grid.moveLeft();
			}
			else if(inputQuery(input,"r")){
				grid.moveRight();
			}
			else if(inputQuery(input,"h"))
			{
				printHelp();
			}else{
				
			}
			System.out.println(grid.printGrid());
			input = scan.nextLine();
		}
		
		scan.close();
	}
	public static boolean inputQuery(String i, String o){
		boolean result = false;
		if(i.toLowerCase().equals(o.toLowerCase()))
		{
			result = true;
		}
		return result;
	}
	public static void printHelp(){
		System.out.println("q\tto quit");
	}
}
