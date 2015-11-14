package aufgabenblatt2;

import java.util.Collections;
import java.util.List;

public class Rennsimulation {

  /**
   * Liste der Autos, die am Rennen teilnehmen.
   */
  private List<Rennauto> autoliste;

  /**
   * Konstruktor
   * 
   * @param eine
   *          Liste von Autos
   */
  public Rennsimulation(List<Rennauto> liste) {
    autoliste = liste;
  }

  /**
   * simuliert ein Rennen
   */
  public void rennstart() {
    Rennabbruch abbruch = new Rennabbruch(autoliste);

    // startet die Autos und den Abbruch-Thraed
    autoliste.stream().forEach(auto -> auto.start());
    abbruch.start();

    int imZiel = 0;
    while (autoliste.size() > imZiel) {
      imZiel = 0;
      for (Rennauto auto : autoliste) {
        if (!auto.isAlive()) {
          imZiel++;
        }
      }
    } 

    // Wenn es kein Rennabbruch gab, werden die Endzeiten ausgegeben
    if (abbruch.isAlive()) {
      System.err.println("Das Rennen ist zu Ende!!!");
      Collections.sort(autoliste);
      System.err.println("Ergebnis: ");
      autoliste.stream().forEach(
          (Rennauto auto) -> System.err.println(String.format(auto.getFahrer()
              + ": %2.1f sek", auto.getEndzeit() / 1000)));
    }
    abbruch.interrupt();
  }
}
