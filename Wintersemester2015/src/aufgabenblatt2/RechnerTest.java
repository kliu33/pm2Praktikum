package aufgabenblatt2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testklasse
 * 
 * @author wilhelm
 *
 */
public class RechnerTest {

  @Test
  public void operationAdditionTest() {
    Rechner rech = new Rechner();
    assertEquals("Fehler bei Addition",
        rech.berechne(Operation.ADDITION, 12, 14), 26, 1e-4);
  }

  @Test
  public void operationSubtraktionTest() {
    Rechner rech = new Rechner();
    assertEquals("Fehler bei Subtraktion",
        rech.berechne(Operation.SUBTRAKTION, 12, 14), -2, 1e-4);
  }

  @Test
  public void operationMultiplikationTest() {
    Rechner rech = new Rechner();
    assertEquals("Fehler bei Multiplikation",
        rech.berechne(Operation.MULTIPLIKATION, 12, 14), 168, 1e-4);
  }

  @Test
  public void operationDivisionTest() {
    Rechner rech = new Rechner();
    assertEquals("Fehler bei Division",
        rech.berechne(Operation.DIVISION, 10, 8), 1.25, 1e-4);
  }

  @Test
  public void werteAusMulti() {

    DoubleDoubleZuDouble lambda1 = (double x, double y) -> x * y;
    assertEquals("Fehler bei Multi", lambda1.werteAus(3.0, 4.0), 12, 1e-10);
    assertEquals("Fehler bei Multi", lambda1.werteAus(6.0, 4.0), 24, 1e-10);
    assertEquals("Fehler bei Multi", lambda1.werteAus(0, 8.5), 0, 1e-10);
  }

  @Test
  public void werteAusNullstelle() {
    // durch 0 teilen ist nicht erlaubt
    DoubleDoubleZuDouble lambda2 = (double x, double y) -> {
      if (x != 0) {
        return -(y / x);
      }
      return 0;
    };
    assertEquals("Fehler bei Nullstelle", lambda2.werteAus(4.0, 3.0), -0.75,
        1e-10);
    assertEquals("Fehler bei Nullstelle", lambda2.werteAus(6.0, -6.0), 1, 1e-10);
    assertEquals("Fehler bei Nullstelle", lambda2.werteAus(0, 8.5), 0, 1e-10);
  }
}
