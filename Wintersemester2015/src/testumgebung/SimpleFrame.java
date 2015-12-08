package testumgebung;

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

public class SimpleFrame extends Application {
  

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {

    stage.setTitle("Simple Frame with a Button");
    StackPane root = new StackPane();

    // Szenengraph
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(12));
    gridPane.setHgap(20);
    gridPane.setVgap(20);
    

    // Wurzel


    for (int i = 0; i < 6; i++) {
      // Bild mit Zug
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
      path.getElements().add(moveTo);
      path.getElements().add(lineTo1);
      path.getElements().add(lineTo2);
      path.getElements().add(lineTo3);
      path.getElements().add(moveTo2);
      path.getElements().add(lineTo4);
      path.getElements().add(lineTo5);
      path.getElements().add(lineTo6);
      path.getElements().add(lineTo7);
      path.setTranslateY(30);
      path.setStroke(Color.BLACK);
      path.setStrokeWidth(2);
      gridPane.add(path, 0, i);

   
    }

    root.getChildren().add(gridPane);

    // Szene erstellen und in die Stage einfügen
    Scene szene = new Scene(root, 600, 600);
    stage.setScene(szene);
    stage.show();

  }

}
