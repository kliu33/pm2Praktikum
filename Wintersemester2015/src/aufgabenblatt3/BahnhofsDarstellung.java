package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * 
 * Die Klasse ist für die Visualisierung des Bahnhofes zuständig.
 * 
 * @author Mona und Wilhelm
 *
 */
public class BahnhofsDarstellung extends Application implements Observer {

  /**
   * eine Stage
   */
  private Stage stage;

  /**
   * Anzahl der Gleise des Bahnhofes
   */
  private int anzahlDerGleise;

  /**
   * Zeichnet den Bahnhof und startet die Simulation.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    anzahlDerGleise = 5;
    init(primaryStage);
    simuStarten();

  }

  /**
   * Startet die Simulation und fügt die Bahnhofsdarstellung dem Bahnhof als
   * Beobachter hinzu.
   */
  private void simuStarten() {
    Simulation simu = new Simulation(anzahlDerGleise);
    simu.getBahnhof().addObserver(this);
    Thread thread = new Thread(simu);
    thread.start();
  }

  /**
   * Zeichnet den Anfangszustand.(einen leeren Bahnhof)
   * 
   * @param stage
   */
  public void init(Stage stage) {
    stage.setTitle("Simple Frame with a Button");
    StackPane root = new StackPane();

    // Szenengraph
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(12));
    gridPane.setHgap(20);
    gridPane.setVgap(20);
    root.getChildren().add(gridPane);

    // zeichnet die Gleise
    for (int i = 0; i < anzahlDerGleise; i++) {
      gridPane.add(zeichneGleis(), 0, i);
    }

    // Szene erstellen und in die Stage einfügen
    Scene szene = new Scene(root, 600, 600);
    stage.setScene(szene);
    stage.show();
  }

  /**
   * erstellt eine neue Stage.
   * 
   * @param gleisarray
   *          Ein array aus Zügen
   */
  private void bahnhofzeichnen(Zug[] gleisarray) {
    StackPane root = new StackPane();
    // Szenengraph
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(12));
    gridPane.setHgap(20);
    gridPane.setVgap(20);
    root.getChildren().add(gridPane);

    for (int i = 0; i < gleisarray.length; i++) {
      if (gleisarray[i] == null) {
        gridPane.add(zeichneGleis(), 0, i);
      } else {
        gridPane.add(zeichneGleisMitZug(), 0, i);

      }
    }
    Scene szene = new Scene(root, 600, 600);
    stage.setScene(szene);
    stage.show();
  }

  /**
   * Zeichnet ein Gleis ohne Zug.
   * 
   * @return ein Path-Objekt
   */
  private Path zeichneGleis() {
    Path path = new Path();

    MoveTo moveTo = new MoveTo();
    moveTo.setX(100);
    moveTo.setY(0);

    LineTo lineTo1 = new LineTo();
    lineTo1.setX(0);
    lineTo1.setY(0);

    LineTo lineTo2 = new LineTo();
    lineTo2.setX(0);
    lineTo2.setY(50);

    LineTo lineTo3 = new LineTo();
    lineTo3.setX(100);
    lineTo3.setY(50);

    path.getElements().add(moveTo);
    path.getElements().add(lineTo1);
    path.getElements().add(lineTo2);
    path.getElements().add(lineTo3);
    path.setTranslateY(30);
    path.setStroke(Color.BLACK);
    path.setStrokeWidth(2);
    return path;
  }

  /**
   * Zeichnet ein Gleis mit Zug.
   * 
   * @return ein Path-Objekt
   */
  private Path zeichneGleisMitZug() {
    Path andererPath = new Path();

    MoveTo moveTo = new MoveTo();
    moveTo.setX(100);
    moveTo.setY(0);

    LineTo lineTo1 = new LineTo();
    lineTo1.setX(0);
    lineTo1.setY(0);

    LineTo lineTo2 = new LineTo();
    lineTo2.setX(0);
    lineTo2.setY(50);

    LineTo lineTo3 = new LineTo();
    lineTo3.setX(100);
    lineTo3.setY(50);

    MoveTo moveTo2 = new MoveTo();
    moveTo2.setX(8);
    moveTo2.setY(8);

    LineTo lineTo4 = new LineTo();
    lineTo4.setX(8);
    lineTo4.setY(42);

    LineTo lineTo5 = new LineTo();
    lineTo5.setX(100);
    lineTo5.setY(42);

    LineTo lineTo6 = new LineTo();
    lineTo6.setX(100);
    lineTo6.setY(8);

    LineTo lineTo7 = new LineTo();
    lineTo7.setX(8);
    lineTo7.setY(8);

    andererPath.getElements().add(moveTo);
    andererPath.getElements().add(lineTo1);
    andererPath.getElements().add(lineTo2);
    andererPath.getElements().add(lineTo3);
    andererPath.getElements().add(moveTo2);
    andererPath.getElements().add(lineTo4);
    andererPath.getElements().add(lineTo5);
    andererPath.getElements().add(lineTo6);
    andererPath.getElements().add(lineTo7);
    andererPath.setTranslateY(30);
    andererPath.setStroke(Color.BLACK);
    andererPath.setStrokeWidth(2);
    return andererPath;
  }

  /**
   * wird aufgefufen um die Bahfhofdarstellung zu updaten.
   * 
   * @param arg0
   *          das Ereignis das die Methode aufgerufen hat array das Zugarray
   */
  @Override
  public void update(Observable arg0, Object array) {
    if (array instanceof Zug[]) {
      Zug[] gleisarray = (Zug[]) array;
      Platform.runLater(() -> bahnhofzeichnen(gleisarray));
    }

  }

  /**
   * Zentraler Programmeinstieg.
   * 
   * @param args
   *          Kommandozeilenparameter.
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
}