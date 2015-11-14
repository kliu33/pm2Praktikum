package aufgabenblatt2;

/**
 * Eine Klasse die ein Rennauto als Thread implementiert.
 * 
 * @author Mona und Wilhelm
 *
 */
public class Rennauto extends Thread implements Comparable<Rennauto> {

  /**
   * Gibt die Geschwindigkeit des Rennautos in Meter pro Sekunde an.
   */
  private int durchschnittGeschwindigkei;

  /**
   * Name des Rennautos
   */
  private String fahrer;

  /**
   * Laenge der Strecke
   */
  private int streckenlaenge;

  /**
   * Endzeit
   */
  private double endzeit;

  /**
   * Konstruktor
   * 
   * @param tempo
   *          geschwindigkeit des Rennautos streckenlaenge Laenge der
   *          Rennstrecke name Name des Rennautos
   */
  public Rennauto(int tempo, int streckenlaenge, String name) {
    this.fahrer = name;
    durchschnittGeschwindigkei = tempo;
    this.streckenlaenge = streckenlaenge;
    endzeit = 0;
  }

  /**
   * Getter
   * 
   * @return fahrername
   */
  public String getFahrer() {
    return fahrer;
  }

  /**
   * Getter
   * 
   * @return endzeit des Autos
   */
  public double getEndzeit() {
    return endzeit;
  }

  /**
   * Das Auto legt in einer Zeitspanne von (0,8sek-1,2sek) eine bestimmte
   * Strecke zurück. Sobald das Auto die Strecke komplett gefahren ist,
   * speichert es seine Endzeit.
   */
  @Override
  public void run() {

    double startzeit = System.currentTimeMillis();

    // eine Zufallszahl zwischen 800 und 1200(inklusive 800 und 1200)
    int zufallszahl = (int) (Math.random() * 401) + 800;

    int zaehler = 0;
    while (zaehler < streckenlaenge && !isInterrupted()) {
      zaehler = zaehler + durchschnittGeschwindigkei;
      try {
        Thread.sleep(zufallszahl);
      } catch (InterruptedException e) {
        currentThread().interrupt();
      }
      if (!isInterrupted()) {
        System.err.println(fahrer + " " + zaehler + "/" + streckenlaenge);
      }
    }
    endzeit = System.currentTimeMillis() - startzeit;
  }

  /**
   * @param auto
   *          das Vergleichsobjekt
   * @return 1 wenn Endzeit des Arguments kleiner -1 wenn größer 0 wenn gleich
   */
  @Override
  public int compareTo(Rennauto auto) {
    if (endzeit < auto.endzeit) {
      return -1;
    }
    if (endzeit > auto.endzeit) {
      return 1;
    }
    return 0;
  }
}