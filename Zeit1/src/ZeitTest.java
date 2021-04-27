import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import totest.*;

class ZeitTest {
	ZeitIF zeit1, zeit2;
	public static double Epsilon=0.00006;
	@Test
	@BeforeEach
	public void set() {
		zeit1 = new Zeit(10);
		zeit2 = new Zeit(-1);
	}

	@AfterEach
	public void reset() {
		zeit1=null;
		zeit2=null;
		
	}
	
	@Test
	@DisplayName("Soll schauen, ob getMin() den richtigen Wert zurück gibt.")
	public void test_Min_Wert() {
		assertEquals(10,zeit1.getMin());
	}
	@Test
	@DisplayName("Soll schauen, ob getMin() eine IllegalArgumentException wirft wenn ein Wert < 0 übergeben wird")
	public void test_Min_IllArgException() {
		assertThrows(IllegalArgumentException.class,()->{zeit2.getMin();});
	}
	@Test
	@DisplayName("Soll den Minuten-Wert in stunden umrechnen.")
	public void test_Stunden_Wert() {
		
		assertEquals(0.16666666666,zeit1.getStunde(),Epsilon);
	}
	@Test
	@DisplayName("Soll eine IllegalArgumentException werfen, gdw. getStuden() einen Wert kleiner 1 bekommt hat")
	public void test_getStunden_Exception() {
		assertThrows(IllegalArgumentException.class,()->{zeit2.getStunde();});
	}
	
	@Test
	@DisplayName("Methode addMinuten() soll neue Minuten hinzu addieren")
	public void test_addMinuten() {
		zeit1.addMinuten(5);
		assertEquals(15,zeit1.getMin());
	}
	
	@Test
	@DisplayName("Testet ob add() eine Exception wirft wenn minuten+übergebenerwert kleiner null ist")
	public void test_add_Exception() {
		assertThrows(IllegalArgumentException.class,()->{zeit1.addMinuten(-11);});
	}
	
	
	

}
