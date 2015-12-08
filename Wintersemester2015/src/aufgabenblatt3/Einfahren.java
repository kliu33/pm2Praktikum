package aufgabenblatt3;

/**
 * Einfahren eines Zuges.
 * @author wilhelm
 *
 */
public class Einfahren implements AufgabeStrategie {
  
  /**
   * Das Gleis auf dem der Zug einfahren soll.
   */
  private int gleis;

  /**
   * Der Bahnhof in den der Zug eingefahren werden soll.
   */
  private Rangierbahnhof bahnhof;

  /**
   * Konstruktor
   * 
   * @param gleis
   *          Das Gleis auf dem der Zug einfahren soll.
   * @param bahnhof
   *          Der Bahnhof in den der Zug eingefahren werden soll.
   */
  public Einfahren(int gleis, Rangierbahnhof bahnhof) {
    this.gleis = gleis;
    this.bahnhof = bahnhof;
  }

  @Override
  public void aufgabeAusführen() {
    bahnhof.zugEinfahren(gleis);
  }

}
