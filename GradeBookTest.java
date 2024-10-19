import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook gb1, gb2;

	@BeforeEach
	void setUp() throws Exception {
		
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		gb1.addScore(79.3);
		gb1.addScore(81.5);
		gb1.addScore(90.7);
		gb1.addScore(95.1);
		gb1.addScore(72.1);
		
		gb2.addScore(99.9);
		gb2.addScore(82.7);
		gb2.addScore(76.5);
		gb2.addScore(90.1);
		gb2.addScore(67.9);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {
		
		assertTrue(gb1.toString().equals("79.3 81.5 90.7 95.1 72.1 "));
		assertTrue(gb2.toString().equals("99.9 82.7 76.5 90.1 67.9 "));
		
	}

	@Test
	void testSum() {
		
		assertEquals(418.7, gb1.sum(), 0.0001);
		assertEquals(417.1, gb2.sum(), 0.0001);
		
	}

	@Test
	void testMinimum() {
		
		assertEquals(72.1, gb1.minimum(), 0.001);
		assertEquals(67.9, gb2.minimum(), 0.001);
		
	}

	@Test
	void testFinalScore() {
		
		assertEquals(346.6, gb1.finalScore(), 0.0001);
		assertEquals(349.2, gb2.finalScore(), 0.0001);
		
	}


}
