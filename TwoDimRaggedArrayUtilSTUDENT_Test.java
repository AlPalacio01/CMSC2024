import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.*;

public class TwoDimRaggedArrayUtilSTUDENT_Test {
	
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTotal() {
		double total = TwoDimRaggedArrayUtility.getTotal(dataSet1);
		assertEquals(45.0, total, 0.001);
	}
	
	@Test
	public void testGetAverage() {
		double average = TwoDimRaggedArrayUtility.getAverage(dataSet1);
		assertEquals(5.0, average, 0.001);
	}
	
	@Test
	public void testGetRowTotal() {
		double firstRow = TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0);
		assertEquals(6.0, firstRow, 0.001);
		
		double secondRow = TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1);
		assertEquals(9.0, secondRow, 0.001);
		
		double thirdRow = TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2);
		assertEquals(30.0, thirdRow, 0.001);
	}
	
	@Test
	public void testGetHighestInRow() {
		double firstRow = TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0);
		assertEquals(3.0, firstRow, 0.001);
		
		double secondRow = TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1);
		assertEquals(5.0, secondRow, 0.001);
		
		double thirdRow = TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2);
		assertEquals(9.0, thirdRow, 0.001);
	}

	@Test
	public void testGetLowestInRow() {
		double firstRow = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0);
		assertEquals(1.0, firstRow, 0.001);
		
		double secondRow = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1);
		assertEquals(4.0, secondRow, 0.001);
		
		double thirdRow = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2);
		assertEquals(6.0, thirdRow, 0.001);
	}

	@Test
	public void testGetColumnTotal() {
		double firstCol = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0);
		assertEquals(11.0, firstCol, 0.001);
		
		double secondCol = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1);
		assertEquals(14.0, secondCol, 0.001);
		
		double thirdCol = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2);
		assertEquals(11.0, thirdCol, 0.001);
		
		double fourthCol = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3);
		assertEquals(9.0, fourthCol, 0.001);
	}

	@Test
	public void testGetLowestInRowIndex() {
		double firstRow = TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0);
		assertEquals(0.0, firstRow);
		
		double secondRow = TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1);
		assertEquals(0.0, secondRow);
		
		double thirdRow = TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2);
		assertEquals(0.0, thirdRow);
	}

	@Test
	public void testGetHighestInRowIndex() {
		double firstRow = TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0);
		assertEquals(2.0, firstRow, 0.001);
		
		double secondRow = TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1);
		assertEquals(1.0, secondRow, 0.001);
		
		double thirdRow = TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2);
		assertEquals(3.0, thirdRow, 0.001);
	}

	@Test
	public void testGetHighestInColumn() {
		double firstCol = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0);
		assertEquals(6.0, firstCol, 0.001);
		
		double secondCol = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1);
		assertEquals(7.0, secondCol, 0.001);
		
		double thirdCol = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2);
		assertEquals(8.0, thirdCol, 0.001);
		
		double fourthCol = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 3);
		assertEquals(9.0, fourthCol, 0.001);
	}

	@Test
	public void testGetLowestInColumn() {
		double firstCol = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0);
		assertEquals(1.0, firstCol, 0.001);
		
		double secondCol = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1);
		assertEquals(2.0, secondCol, 0.001);
		
		double thirdCol = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2);
		assertEquals(3.0, thirdCol, 0.001);
		
		double fourthCol = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 3);
		assertEquals(9.0, fourthCol, 0.001);
	}
	
	@Test
	public void testGetLowestInColumnIndex() {
		double firstCol = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0);
		assertEquals(0.0, firstCol);
		
		double secondCol = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1);
		assertEquals(0.0, secondCol);
		
		double thirdCol = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2);
		assertEquals(0.0, thirdCol);
		
		double fourthCol = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 3);
		assertEquals(2.0, fourthCol);
	}
	
	@Test
	public void testGetHighestInColumnIndex() {
		double firstCol = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0);
		assertEquals(2.0, firstCol);
		
		double secondCol = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1);
		assertEquals(2.0, secondCol);
		
		double thirdCol = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2);
		assertEquals(2.0, thirdCol);
		
		double fourthCol = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 3);
		assertEquals(2.0, fourthCol);
	}
	
	@Test
	public void testGetHighestInArray() {
		double highestInArray = TwoDimRaggedArrayUtility.getHighestInArray(dataSet1);
		assertEquals(9.0, highestInArray, 0.001);
	}
	
	@Test
	public void testGetLowestInArray() {
		double lowestInArray = TwoDimRaggedArrayUtility.getLowestInArray(dataSet1);
		assertEquals(1.0, lowestInArray, 0.001);
	}




}
