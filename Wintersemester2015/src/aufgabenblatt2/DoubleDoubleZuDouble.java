package aufgabenblatt2;

/**
 * Funktionales Interface
 * @author Wilhelm und Mona
 *
 */
@FunctionalInterface
public interface DoubleDoubleZuDouble {
  /**
   * 
   * @param zahl1 eine Zahl
   * @param zahl2 auch eine Zahl
   * @return ein berechnetes Ergebnis
   */
  public double werteAus(double zahl1, double zahl2);
}
