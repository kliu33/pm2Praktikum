package aufgabenblatt3;

/**
 * Ein Lokfuehrer kann einen Zug in den Bahnhof einfahren oder ausfahren. Danach
 * macht der Lokfuehrer Feierabend.
 * 
 * @author wilhelm
 *
 */
public class LokFuehrer extends Thread {

  /**
   * Die Aufgabe die der Lokf�hrer erledigen soll.
   */
  private AufgabeStrategie aufgabe;

  /**
   * Konstruktor
   * 
   * @param aufgabe
   *          Die Aufgabe die der Lokf�hrer erledigen soll.
   * @throws IllegalArgumentException
   */
  public LokFuehrer(AufgabeStrategie aufgabe) throws IllegalArgumentException {
    if (aufgabe == null) {
      throw new IllegalArgumentException();
    }
    this.aufgabe = aufgabe;

  }

  /**
   * f�ngt an seine Aufgabe zu erledigen.
   */
  @Override
  public void run() {
    aufgabe.aufgabeAusf�hren();
  }
}
