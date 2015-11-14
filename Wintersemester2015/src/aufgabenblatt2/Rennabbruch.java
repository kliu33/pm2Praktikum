package aufgabenblatt2;

import java.util.List;

/**
 * Dieser Thread kann zu einer bestimmten Wahrscheinlichkeit ein Rennabruch
 * verusachen.
 * 
 * @author wilhelm
 *
 */
public class Rennabbruch extends Thread {

  private List<Rennauto> threadliste;

  /**
   * Konstruktor
   */
  public Rennabbruch(List<Rennauto> liste) {
    threadliste = liste;
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
      if (zufallszahl < 10) {
        threadliste.stream().forEach((Rennauto auto) -> auto.interrupt());
        System.err.println("Rennabbruch!!!!!!!!!!!!!!!");
        interrupt();
      }
    }
  }
}
