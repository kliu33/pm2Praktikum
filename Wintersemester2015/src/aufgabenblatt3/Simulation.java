package aufgabenblatt3;

/**
 * Die Simulation erstellt einen Bahnhof und erzeugt jede Sekunde Lokführer.
 * 
 * @author Mona und Wilhelm
 *
 */
public class Simulation implements Runnable {

  /**
   * Ein Bahnhof
   */
  private Rangierbahnhof bahnhof;

  /**
   * Konstruktor
   * 
   * @param anzahlDerGleise
   *          Anzahl der Gleise des Bahnhofes
   * @throws IllegalArgumentException
   */
  public Simulation(int anzahlDerGleise) throws IllegalArgumentException {
    if (anzahlDerGleise < 1 || anzahlDerGleise > 6) {
      throw new IllegalArgumentException();
    }
    bahnhof = new Rangierbahnhof(anzahlDerGleise);
  }

  /**
   * Erzeugt jede Sekunde Lokführer, die entweder einen Zug einfahren oder
   * ausfahrern.
   */
  @Override
  public void run() {

    int gleisnummer = 0;
    LokFuehrer lokfuehrer;

    while (true) {

      //setzt die Gleisnummmer wieder auf 0, wenn alle Gleise durch sind.
      if (gleisnummer == bahnhof.getAnzahlDerGleise()) {
        gleisnummer = 0;
      }

      //zufällig, ob der Lokführer ein- oder ausfährt.
      int zufallszahl = (int) (Math.random() * 2);
      if (zufallszahl == 0) {
        lokfuehrer = new LokFuehrer(new Einfahren(gleisnummer, bahnhof));
      } else {
        lokfuehrer = new LokFuehrer(new Ausfahren(gleisnummer, bahnhof));
      }
      lokfuehrer.start();
      gleisnummer++;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // Exception - (wird nicht interrupted)
      }
    }
  }

  /**
   * Getter
   * @return einen Bahnhof
   */
  public Rangierbahnhof getBahnhof() {
    return bahnhof;
  }

}
