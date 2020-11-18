import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.util.Random;


class BlackBoxTest1_Template {

	/**
	 * Es werden Systematisch einmal alle 25 verschiedenen Tests durchgeführt.
	 * Zu erwarten ist eine Testüberdeckung von 100%
	 */
	@Test
	void testAllCases() {
		Color expected;					//Erwartete Farbe
		final int [] repX = {-20, 60, 110, -22, 120};	//Array fuer unsere "X" Repraesentanten
		final int [] repY = {  -1,  5,  15,  -2, 111};	//Array fuer unsere "Y" Repraesentanten

		/* Durchiterieren durch beide Arrays der Repräsentanten*/
		for (int i = 0; i <= repX.length - 1; i++) {
			for (int j = 0; j <= repY.length - 1; j++) {

				/* Case: Farbe ist Rot */
				if ((repX[i] == -20) && (repY[j] == -1)){
					expected = Color.RED;
				}
				/* Case: Farbe ist Gruen */
				else if ((repX[i] == 110) && (repY[j] == 15)) {
					expected = Color.GREEN;
				}
				/* Case: null */
				else if ((repX[i] == -22) || (repX[i] == 120) || (repY[j] == -2) || (repY[j] == 111)) {
					expected = null;
				}
				/* Case: Farbe ist Gelb */
				else {
					expected = Color.YELLOW;
				}

				Color actual = BlackBox1.G(repX[i], repY[j]);		//Testen der Repraesentanten
				assertEquals(expected, actual);						//Überprüfen des Ergebnisses
			}
		}
	}






	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(BlackBox1.evalEqClasses(), "Not all equivalence classes covert!");
	}
}
