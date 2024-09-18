/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: (Give a brief description for each Class)
 * Due: 09/17/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Alejandro Palacio
*/

import java.util.*;
import java.io.*;
public class ESPGame {

	public static void main(String[] args) throws FileNotFoundException {
		String chosen = "";
		int correct = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		System.out.print("Enter the filename: ");
		String filename = scanner.nextLine();
		Scanner inputFile = new Scanner(new File(filename));
		System.out.print("\n");
		
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			System.out.println(line);
		}
		
		inputFile.close();
		
		System.out.print("\n\n");
		
		for (int i = 1; i < 4;i++) {
			
			Random rand = new Random();
			int n = rand.nextInt(16);
			n += 1;
			
			switch(n) {
			
				case 1:
					chosen = "black";
					break;
				case 2:
					chosen = "white";
					break;
				case 3:
					chosen = "gray";
					break;
				case 4:
					chosen = "silver";
					break;
				case 5:
					chosen = "maroon";
					break;
				case 6:
					chosen = "red";
					break;
				case 7:
					chosen = "purple";
					break;
				case 8:
					chosen = "fuchsia";
					break;
				case 9:
					chosen = "green";
					break;
				case 10:
					chosen = "lime";
					break;
				case 11:
					chosen = "olive";
					break;
				case 12:
					chosen = "yellow";
					break;
				case 13:
					chosen = "navy";
					break;
				case 14:
					chosen = "blue";
					break;
				case 15:
					chosen = "teal";
					break;
				case 16:
					chosen = "aqua";
					break;
				
			}
			
			System.out.println("Round " + i + "\n");
			System.out.println("I am thinking of a color.\nIs it one of the ones in the list above?\nEnter your guess:");
			String color = scanner.nextLine();
			System.out.print("\n\n");
			System.out.println("I was thinking of " + chosen);
			if (color.equalsIgnoreCase(chosen)){
				correct++;
			}
			
		}
		System.out.println("Game Over");
		System.out.println("You guessed " + correct + " out of 3 colors correctly.\n");
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Describe yourself: ");
		String description = scanner.nextLine();
		System.out.print("Due date: ");
		String dueDate = scanner.nextLine();
		System.out.println("User Name: " + name);
		System.out.print("User description: " + description);
			}
}