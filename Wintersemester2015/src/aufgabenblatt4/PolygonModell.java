package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Ein Polygonmodell, das aus mehreren Polygonen besteht.
 * 
 * @author Wilhelm und Mona
 *
 */
public class PolygonModell extends Observable implements Observer {

  /**
   * Eine Liste der Polygone.
   */
  private List<Polygon> polygonliste;

  /**
   * Das Polygon, das aktuell bearbeitet wird.
   */
  private Polygon aktutellesPolygon;

  /**
   * Konstruktor registriert den Beobachter
   */
  public PolygonModell() {
    polygonliste = new ArrayList<Polygon>();
    aktutellesPolygon = new Polygon();
    aktutellesPolygon.addObserver(this);
  }

  /**
   * Erstellt ein neues Polygon und fügt das alte zur Liste hinzu. Außerdem
   * werden die Beobachter informiert.
   */
  public void bearbeitungAbschließen() {
    polygonliste.add(aktutellesPolygon);
    aktutellesPolygon = new Polygon();
    aktutellesPolygon.addObserver(this);
    setChanged();
    notifyObservers();
  }

  /**
   * Dem aktuellen Polygon einen Punkt hinzufuegen.
   * 
   * @param x
   *          x-Koordinate
   * @param y
   *          y-Koordinate
   */
  public void punkthinzufuegen(int x, int y) {
    aktutellesPolygon.punkthinzufuegen(x, y);
    // System.out.println("Der Punkt " + x + " " + y + " wurde hinzugefügt.");
  }

  /**
   * Liefert die PolygonListe.(Getter)
   * 
   * @return die PolygonListe
   */
  public List<Polygon> getPolygonListe() {
    return polygonliste;
  }

  /**
   * Liefert das aktuelle Polygon
   */
  public Polygon getAktutellesPolygon() {
    return aktutellesPolygon;
  }

  /**
   * Informiert die Darstellung über eine Änderung des Polygonmodells.
   */
  @Override
  public void update(Observable o, Object arg) {
    setChanged();
    notifyObservers();
  }
}
