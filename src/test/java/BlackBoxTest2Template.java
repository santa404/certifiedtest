import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class BlackBoxTest2_Template {

	@Test
	void test() {
		/* Colors: YELLOW, GREEN, RED */ 
//		Color expected = Color.YELLOW;
//		int x = 5;
//		int y = 1;
//		boolean b = false;
//		Color actual = BlackBox.G(x, y, b);
//		assertEquals(expected, actual);
//		fail("not implemented yet");
	}



	/**
	 * Es werden Systematisch einmal alle 25 verschiedenen Tests durchgeführt.
	 * Zu erwarten ist eine Testüberdeckung von 100%
	 */
	@Test
	void testAllCases2True() {
		Color expected;                    //Erwartete Farbe
		boolean b = true;
		final int[] repX = {7, 12, -8, 22};    //Array fuer unsere "X" Repraesentanten
		final int[] repY = {1, 0, -7, 5};    //Array fuer unsere "Y" Repraesentanten

		/* Durchiterieren durch beide Arrays der Repräsentanten*/
		for (int i = 0; i <= repX.length - 1; i++) {
			for (int j = 0; j <= repY.length - 1; j++) {

				/* Case: Farbe ist Rot */
				if ((repX[i] == 7) && (repY[j] == 1)) {
					expected = Color.RED;
				}
				/* Case: null */
				else if ((repX[i] == -8) || (repX[i] == 22) || (repY[j] == -7) || (repY[j] == 5)) {
					expected = null;
				}
				/* Case: Farbe ist Gelb */
				else {
					expected = Color.YELLOW;
				}

				Color actual = BlackBox2.F(repX[i], repY[j], b);        //Testen der Repraesentanten
				assertEquals(expected, actual);                        //Überprüfen des Ergebnisses
			}
		}
	}
		/**
		 * Es werden Systematisch einmal alle 25 verschiedenen Tests durchgeführt.
		 * Zu erwarten ist eine Testüberdeckung von 100%
		 */
		@Test
		void testAllCases2False() {
			Color expected2;					//Erwartete Farbe
			boolean b = false;
			final int [] repX2 = {7, 12, -8, 22};	//Array fuer unsere "X" Repraesentanten
			final int [] repY2 = {1, -1, -7,  5};	//Array fuer unsere "Y" Repraesentanten

			/* Durchiterieren durch beide Arrays der Repräsentanten*/
			for (int i = 0; i <= repX2.length - 1; i++) {
				for (int j = 0; j <= repY2.length - 1; j++) {
					/* Case: Farbe ist Gruen */
					if (( 10 <= repX2[i] && repX2[i]<=17) && (-2 <= repY2[j] && repY2[j]<=2)) {
						expected2 = Color.GREEN;
					}
					/* Case: null */
					else if ((repX2[i] == -8) || (repX2[i] == 22) || (repY2[j] == -7) || (repY2[j] == 5)) {
						expected2 = null;
					}
					/* Case: Farbe ist Gelb */
					else {
						expected2 = Color.YELLOW;
					}
					Color actual = BlackBox2.F(repX2[i], repY2[j], b);		//Testen der Repraesentanten
					assertEquals(expected2, actual);						//Überprüfen des Ergebnisses
				}
			}
	}




	
	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(BlackBox2.evalEqClasses(), "Not all equivalence classes covert!");
	}

}
