package aufgabenblatt4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Die Darstellung ist verantwortlich für die grafische Benutzeroberfläche.
 * @author wilhelm und Mona
 *
 */
public class Darstellung extends Application {
  
  /**
   * die Tabelle
   */
  private TableView<Polygon> tableview;
  
  /**
   * Das Modell
   */
  private PolygonModell modell;
  
  /**
   * Eine Observablelist für die Tabbelle
   */
  private ObservableList<Polygon> polygone;

  /**
   * Initialisierung der Gui und erstellen des Modells
   */
  @Override
  public void start(Stage primaryStage) throws Exception {

    primaryStage.setTitle("Polygone zeichnen");

    // Szenengraph
    StackPane root = new StackPane();
    GridPane gridpane = new GridPane();
    root.getChildren().add(gridpane);
    
    //PolygonModell erstellen
    modell = new PolygonModell();

    // Button
    ToggleButton button = new ToggleButton();
    button.setPrefSize(150, 50);
    button.setText("Setzen/Neu");
    button.setOnAction(new EventHandler<ActionEvent>() {

      /**
       * setzt das fertige Polygon in die Tabelle
       */
      @Override
      public void handle(ActionEvent event) {
         modell.bearbeitungAbschließen();
         tabelleUpdaten();
      }
    });

    // Tabelle
    tableview = new TableView<>();
    tableview.setPrefWidth(250);
    tableview.setPrefHeight(300);
    tableview.setColumnResizePolicy(
        TableView.CONSTRAINED_RESIZE_POLICY );
    TableColumn<Polygon, String> firstNameCol = new TableColumn<>("Polygone");
    firstNameCol.setCellValueFactory(
        new PropertyValueFactory<Polygon, String>("beschreibung"));

    polygone= FXCollections.<Polygon>observableArrayList(modell.getPolygonListe());
    tableview.setItems(polygone);
    tableview.getColumns().add(firstNameCol);


    // Textfeld
    TextField kommandofeld = new TextField("bewege -> x,y");
 
    // Button
    ToggleButton button2 = new ToggleButton();
    button2.setPrefSize(150, 50);
    button2.setText("Auswerten");
    button2.setOnAction(new EventHandler<ActionEvent>() {
      
      /**
       * Überprüft das eingegebene Kommando und fügt Punkte hinzu.
       */
       @Override
       public void handle(ActionEvent arg0) {
         PolygonSkripting skript = new PolygonSkripting(kommandofeld.getText());
         skript.bearbeiten();
         if(skript.getKommando().equalsIgnoreCase("bewege") && skript.gueltig()){
           modell.punkthinzufuegen(skript.getX(),skript.getY());
         }
       }
       });
    
    // PolygonDarstellung
    PolygonDarstellung zeichenflaeche = 
        new PolygonDarstellung(modell);

    // Dem Szenengraphen übergeben
    gridpane.add(zeichenflaeche, 0, 0);
    gridpane.add(kommandofeld, 4, 1);
    gridpane.add(tableview, 4, 0);
    gridpane.add(button, 0, 1);
    gridpane.add(button2, 4, 4);

    primaryStage.setScene(new Scene(root, 600, 500));
    primaryStage.show();
  }
  
  /**
   * Tabelle aktualisieren
   */
  private void tabelleUpdaten(){
    polygone= FXCollections.<Polygon>observableArrayList(modell.getPolygonListe());
    tableview.setItems(polygone);
  }

  /**
   * Main
   * @param args Kommandozeilenparameter
   */
  public static void main(String[] args) {
    launch(args);
  }
}
