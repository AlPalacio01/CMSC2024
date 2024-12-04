import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

	
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		

		
		Scanner scanner1 = new Scanner(file);
		int numRows = 0;
		
		while (scanner1.hasNextLine()) {
			numRows++;
			scanner1.nextLine();
		}
		scanner1.close();
		
		double[][] tempData = new double[numRows][];
		Scanner scanner2 = new Scanner(file);
		
		for(int i = 0; i < numRows; i++) {
			int columnCount = 0;
			
			while(scanner2.hasNextDouble()) {
				tempData[i][columnCount] = scanner2.nextDouble();
				columnCount++;
			}
		}
		scanner2.close();
		
		double[][] data = new double[numRows][];
		for(int i = 0; i < numRows; i++) {
			int columns = 0;
			while (columns < 10 && tempData[i][columns] !=0) {
				columns++;
			}
			data[i] = new double[columns];
			for(int k = 0; k < columns; k++) {
				data[i][k] = tempData[i][k];
			}
		}
		
		return data;
	}
	
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter(outputFile);
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				writer.print(data[i][k]);
				if(k < data[i].length -1) {
					writer.print(" ");
				}
			}
			writer.print("\n");
		}
		writer.close();
		
	}
	
	public static double getTotal(double[][] data) {
		double total = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				
				total += data[i][k];
			}
		}
		
		return total;
	}
	
	public static double getAverage(double[][] data) {
		double numberOfItems = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				
				numberOfItems++;
			}
		}
		return getTotal(data)/numberOfItems;
		
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			rowTotal += data[row][i];
		}
		return rowTotal;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double highestInRow = data[row][0];
		
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] > highestInRow) {
				highestInRow = data[row][i];
			}
		}
		return highestInRow;
		
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowestInRow = data[row][0];
		
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] < lowestInRow) {
				lowestInRow = data[row][i];
			}
		}
		return lowestInRow;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal = 0;
		
		for(int i = 0; i < data.length; i++) {
			
			if (col < data[i].length) {
				colTotal += data[i][col];
			}
		}
		return colTotal;
		
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowestIndex = 0;
		double lowestValue = 0;
		
		for(int col = 0; col < data[row].length; col++) {
			if (lowestValue > data[row][col]) {
				
				lowestValue = data[row][col];
				lowestIndex = col;
				
			}
		}
		return lowestIndex;
	}
	
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highestIndex = 0;
		double highestValue = 0;
		
		for(int col = 0; col < data[row].length; col++) {
			if (highestIndex < data[row][col]) {
				
				highestValue = data[row][col];
				highestIndex = col;
				
			}
		}
		return highestIndex;
	}
	
	
	public static double getHighestInColumn(double[][] data, int col) {
		double highestInCol = 0;
		
		for(int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] > highestInCol) {
					highestInCol = data[i][col];
				}
			}
		}
		return highestInCol;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		double lowestInCol = 10;
		
		for(int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowestInCol) {
					lowestInCol = data[i][col];
				}
			}
		}
		return lowestInCol;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lowestIndex = -1;
		double lowestValue = 10;
		
		for(int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowestValue) {
					lowestValue = data[i][col];
					lowestIndex = i;
				}
			}
		}
		return lowestIndex;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int highestIndex = 0;
		double highestValue = 0;
		
		for(int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] > highestValue) {
					highestValue = data[i][col];
					highestIndex = i;
				}
			}
		}
		return highestIndex;
	}
	
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if (data[i][k] > highest) {
					highest = data[i][k];
				}
			}
		}
		return highest;
		
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if (data[i][k] < lowest) {
					lowest = data[i][k];
				}
			}
		}
		return lowest;
		
	}

}








