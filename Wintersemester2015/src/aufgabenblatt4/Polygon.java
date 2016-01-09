package aufgabenblatt4;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Die Klasse repräsentiert ein Polygon aus Punkten.
 * 
 * @author Wilhelm und Mona
 *
 */
public class Polygon extends Observable {

  /**
   * Eine Liste aus Punkten
   */
  private List<Point> punktListe;

  /**
   * Beschreibung des Polygons
   */
  private String beschreibung;

  /**
   * Konstruktor
   */
  public Polygon() {
    punktListe = new ArrayList<Point>();
    beschreibung = "Es wurden 0 Punkte hinzugefuegt.";
  }

  /**
   * fügt dem Polygon einen neuen Punkt hinzu und informiert die Beobachter.
   * 
   * @param a
   *          x-Koordinate
   * @param b
   *          y-Koordinate
   */
  public void punkthinzufuegen(int a, int b) {
    punktListe.add(new Point(a, b));
    setChanged();
    notifyObservers();
    beschreibung = "Es wurden " + punktListe.size() + " Punkte hinzugefuegt.";
  }

  /**
   * Getter
   * @return eine Liste aus Punkten
   */
  public List<Point> getPunkte() {
    return punktListe;
  }

  /**
   * Getter
   * @return eine Beschreibung des Polygons
   */
  public String getBeschreibung() {
    return beschreibung;
  }
}
