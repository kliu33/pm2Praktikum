package aufgabenblatt3;

import java.util.Observable;

/**
 * Ein Bahnhof mit Gleisen, in den Züge ein und ausfahren können.
 * 
 * @author wilhelm
 *
 */
public class Rangierbahnhof extends Observable {

  /**
   * Ein Array das die Gleise repräsentiert.
   */
  private Zug[] gleisarray;

  /**
   * Konstruktor
   * 
   * @param anzahlDerGleise
   *          gültige Eingabe eins bis 6;
   */
  public Rangierbahnhof(int anzahlDerGleise) throws IllegalArgumentException {
    if (anzahlDerGleise < 1 || anzahlDerGleise > 6) {
      throw new IllegalArgumentException();
    }
    gleisarray = new Zug[anzahlDerGleise];
  }

  /**
   * kann einen Zug einfahren lassen
   * 
   * @param gleisnummer
   *          Gleis zum Einfahren
   * @throws IllegalArgumentException
   */
  public synchronized void zugEinfahren(int gleisnummer)
      throws IllegalArgumentException {
    
    if (gleisnummer >= gleisarray.length) {
      throw new IllegalArgumentException();
    }

    // wenn das Gleis besetzt ist, kann kein Zug einfahren
    while (gleisarray[gleisnummer] != null) {
      try {
        wait();
      } catch (InterruptedException e) {
        // Exception
      }
    }
    gleisarray[gleisnummer] = new Zug();
    System.err
        .println("Ein Zug ist auf Gleis " + gleisnummer + " eingefahren.");
    
    //Visualisierung aktualisieren
    setChanged();
    notifyObservers(gleisarray);
    
    //fahrgäste müssen aus dem Zug aussteigen bevor er wieder abfahren kann
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      // Exception - (wird nicht interrupted)
    }
    notify();
  }

  /**
   * kann einen Zug ausfahren lassen
   * 
   * @param gleisnummer
   */
  public synchronized void zugAusfahren(int gleisnummer)
      throws IllegalArgumentException {
    
    if (gleisnummer >= gleisarray.length) {
      throw new IllegalArgumentException();
    }
    
    //wenn kein Zug da ist, kan  kein Zug ausfahren
    while (gleisarray[gleisnummer] == null) {
      try {
        wait();
      } catch (InterruptedException e) {
        // Exception
      }
    }

    gleisarray[gleisnummer] = null;
    System.err
        .println("Ein Zug ist auf Gleis " + gleisnummer + " ausgefahren.");
    //Visualisierung aktualisieren
    setChanged();
    notifyObservers(gleisarray);
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      // Exception - (wird nicht interrupted)
    }
    notify();
  }

  /**
   * Getter
   * @return Anzahl der Gleise
   */
  public int getAnzahlDerGleise() {
    return gleisarray.length;
  }

}
