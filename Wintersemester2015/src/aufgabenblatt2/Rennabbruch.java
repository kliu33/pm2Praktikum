package aufgabenblatt2;

import java.util.List;

/**
 * Dieser Thread kann zu einer bestimmten Wahrscheinlichkeit ein Rennabruch
 * verusachen.
 * 
 * @author Wilhelm und Mona
 *
 */
public class Rennabbruch extends Thread {

  /**
   * Liste der Rennautothreads
   */
  private List<Rennauto> threadliste;

  /**
   * Wahrscheinlichkeit eines Rennabbruches von 0-100%
   */
  private int wahrscheinlichkeit = 0;

  /**
   * Konstruktor
   * 
   * @param liste
   *          ein Liste von Rennautos wahrscheinlichkeit Wahrscheinlichkeit
   *          eines Rennabbruches
   */
  public Rennabbruch(List<Rennauto> liste, int wahrscheinlichkeit) {
    threadliste = liste;
    if (wahrscheinlichkeit > 0) {
      this.wahrscheinlichkeit = wahrscheinlichkeit;
    }
  }

  /**
   * kann jede Sekunde einen Rennabbruch verursachen
   */
  @Override
  public void run() {

    while (!isInterrupted()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        currentThread().interrupt();
      }

      int zufallszahl = (int) (Math.random() * 100);
      if (zufallszahl < wahrscheinlichkeit) {
        threadliste.stream().forEach((Rennauto auto) -> auto.interrupt());
        System.err.println("Rennabbruch!!!!!!!!!!!!!!!");
        interrupt();
      }
    }
  }
}
