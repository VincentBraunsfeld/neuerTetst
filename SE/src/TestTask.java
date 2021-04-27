import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestTask {
	TaskIF task = null;
	TaskIF task1 =null;
	TaskIF task2 =null;
	TaskIF task3 =null;
	String[] sequenz0 = null;
	String[] sequenz1 = null;
	String[] sequenz2 = null;
	String[] sequenz3 = null;
	String[] sequenz4= null;
	String[] sequenz5= null;
	String[] sequenz6= null;
	

	@BeforeEach
	public void setUp() {
		sequenz0 = new String[] { "A", "B", "C", "D" };
		sequenz1 = new String[] { "A", "B", "D", "C" };
		sequenz2 = new String[] { "A", "C", "C", "D" };
		sequenz3 = new String[] { "A", "C", "E", "A" };
		sequenz4 = new String[] { "A", "C", "A", "A" };
		sequenz5 = new String[] { "A", "D" };
		sequenz6 = new String[] { "C", "A" };
		task = new Task(new String[][] { { "A", "C" }, { "C", "D" }, { "B", "C" } });
		task1 = new Task(new String[][] { { "A", "C" }, { "C", "D" }, { "B", "C" }, {"A","D"}});
		task2 = new Task(new String[][] { { "A", "A" }, { "A", "D" }});
		task3 = new Task(new String[][] { { "A", "B" }, { "B", "C" }});
	}

	@AfterEach
	public void reset() {
		task = null;
		task1 = null;
		task2 = null;
		task3=null;
		sequenz0 = null;
		sequenz1 = null;
		sequenz2 = null;
		sequenz3 = null;
		sequenz4 = null;
		sequenz5 = null;
		
	}

	@Test
	@DisplayName("Soll false ergeben, gdw. ein String in der Sequenz doppelt vorkommt.")
	public void testTruekommtJederStringNurEinmanlVor() {
		assertEquals(false, task.kommtJederStringNurEinmalVor(sequenz2));
	}

	@Test
	@DisplayName("Soll true ergeben, gdw. ein String in der Sequenz nicht doppelt vorkommt.")
	public void test_isWellSortedFalseWeilStringDoppelt() {
		assertEquals(true, task.kommtJederStringNurEinmalVor(sequenz0));
	}

	@Test
	@DisplayName("Soll false ergeben, wenn die Sequenz einen String enthät, der nicht im 2D array enthalten ist.")
	public void testsindAlleWerteDerSequenzErlaubtFalse() {
		assertEquals(false, task.sindAlleWerteDerSequenzErlaubt(sequenz3));

	}
	@Test
	@DisplayName("Soll true ergeben, wenn die Sequenz einen String enthät, der nicht im 2D array enthalten ist.")
	public void testsindAlleWerteDerSequenzErlaubtTrue() {
		assertEquals(true, task.sindAlleWerteDerSequenzErlaubt(sequenz2));
		assertEquals(true, task.sindAlleWerteDerSequenzErlaubt(sequenz4));
	}


	@Test
	@DisplayName("Testet ob isWellSorted den Wert true ausgibt")
	public void test_isWellSort1() {
		assertEquals(true, task.isWellSorted(sequenz0));
	}

	
	@Test
	@DisplayName("Testet ob isWellSorted den Wert false ausgibt")
	public void test_isWellSortedFalse() {
		assertEquals(false, task.isWellSorted(sequenz1));
	}
	@Test
	@DisplayName("Testet ob isWellSorted trotz Kreis in den Abhängigkeiten True ist")
	public void test_isWellSortedMitKreis() {
		assertEquals(true, task1.isWellSorted(sequenz0));
	}

	@Test
	@DisplayName("Testet ob bei unsinnigen Abhängikeiten wie {A,A} false zurückgegeben wird")
	public void test_isWellSortedMit() {
		assertEquals(false, task2.isWellSorted(sequenz5));
	}
	@Test
	@DisplayName("Soll isWellSorted auf Transitivität prüfen")
	public void test_isWellSorted() {
		assertEquals(false, task3.isWellSorted(sequenz6));
	}

}
