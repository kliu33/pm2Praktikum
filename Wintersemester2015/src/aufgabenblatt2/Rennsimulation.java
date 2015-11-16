package aufgabenblatt2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * kann ein Rennen simulieren.
 * 
 * @author Mona und Wilhelm
 *
 */
public class Rennsimulation {

  /**
   * Liste der Autos, die am Rennen teilnehmen.
   */
  private List<Rennauto> autoliste = new LinkedList<Rennauto>();

  /**
   * Laenge der Strecke
   */
  private int streckenlaenge = 0;

  /**
   * Konstruktor
   * 
   * @param streckenlaenge
   *          Laenge
   */
  public Rennsimulation(int streckenlaenge) {
    if (streckenlaenge > 0) {
      this.streckenlaenge = streckenlaenge;
    }
  }

  /**
   * simuliert ein Rennen
   */
  public void rennstart() {

    if (!(autoliste.size() > 0)) {
      // ohne Autos kein Rennen
    } else {
      Rennabbruch abbruch = new Rennabbruch(autoliste, 5);

      // startet die Autos und den Abbruch-Thraed
      autoliste.stream().forEach(auto -> auto.start());
      abbruch.start();

      for (Rennauto auto : autoliste) {
        try {
          auto.join();
        } catch (InterruptedException e) {
          // Exception
        }
      }

      // Wenn alle Autos im Ziel sind und es kein Rennabbruch gab
      if (abbruch.isAlive()) {
        System.err.println("Das Rennen ist zu Ende!!!");
        Collections.sort(autoliste);
        System.err.println("Ergebnis: ");
        autoliste.stream().forEach(
            (Rennauto auto) -> System.err.println(String.format(
                auto.getFahrer() + ": %2.1f sek", auto.getEndzeit() / 1000)));
      }

      if (abbruch.isAlive()) {
        abbruch.interrupt();
      }
    }
  }

  /**
   * Fügt ein Auto zum Rennen hinzu.
   * 
   * @param name
   *          Fahrer des Autos int tempo geschwindigkeit des Autos
   */
  public void autoHinzufuegen(String name, int tempo)
      throws IllegalArgumentException {
    if (tempo < 1) {
      throw new IllegalArgumentException();
    }
    autoliste.add(new Rennauto(tempo, streckenlaenge, name));
  }
}
