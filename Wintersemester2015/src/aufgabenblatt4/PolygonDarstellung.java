package aufgabenblatt4;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.awt.Point;

/**
 * Die Klasse represätiert die Zeichenkomponente.
 * 
 * @author wilhelm und Mona
 *
 */
public class PolygonDarstellung extends Canvas implements Observer {

  /**
   * Das Modell
   */
  private PolygonModell polymodell;

  /**
   * Die Zeichenfläche
   */
  private GraphicsContext gc;

  /**
   * Konstruktor
   * 
   * @param modell
   *          das zugehörige modell
   */
  public PolygonDarstellung(PolygonModell modell) {
    super(300, 300);
    polymodell = modell;
    polymodell.addObserver(this);
    gc = getGraphicsContext2D();
    gc.clearRect(0, 0, getWidth(), getHeight());
    addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

      /**
       * Wenn mit der Maus geklickt wird, wird der Punkt hinzugefügt.
       */
      @Override
      public void handle(MouseEvent event) {
        polymodell.punkthinzufuegen((int) event.getSceneX(), 
            (int) event.getSceneY());
      }
    });
  }

  /**
   * Zeichnet das ganze PolygonModell und das aktuelle Polygon mit roter Frabe.
   */
  public void polygonModellZeichnen() {
    if (polymodell != null) {
      for (Polygon p : polymodell.getPolygonListe()) {
        polygonZeichnen(p, Color.BLACK);
      }
      polygonZeichnen(polymodell.getAktutellesPolygon(), Color.INDIANRED);
    }
  }

  /**
   * Zeichnet ein Polygon in das ZeichenFeld.
   * 
   * @param p
   *          ein Polygon
   */
  public void polygonZeichnen(Polygon p, Color farbe) {
    gc.setStroke(farbe);
    Point letzterPunkt = null;
    if (p != null) {
      List<Point> liste = p.getPunkte();
      for (Point punkt : liste) {
        gc.strokeOval(punkt.getX() - 2, punkt.getY() - 2, 4, 4);
        if (letzterPunkt != null) {
          gc.strokeLine(letzterPunkt.getX(), letzterPunkt.getY(),
              punkt.getX(), punkt.getY());
        }
        letzterPunkt = punkt;
      }
    }
  }

  /**
   * updatet die Zeichnung
   */
  @Override
  public void update(Observable o, Object arg) {
    gc.clearRect(0, 0, getWidth(), getHeight());
    polygonModellZeichnen();
  }
}
