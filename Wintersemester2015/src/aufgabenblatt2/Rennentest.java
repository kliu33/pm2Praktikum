package aufgabenblatt2;

/**
 * simuliert ein Autorennen
 * 
 * @author Wilhelm und Mona
 *
 */
public class Rennentest {

  /**
   * main
   * @param args
   *          Kommandozeilenparameter
   */
  public static void main(String[] args) {

    Rennsimulation simu = new Rennsimulation(10);
    simu.autoHinzufuegen("Alonso", 10);
    simu.autoHinzufuegen("Vettel", 1);
    simu.autoHinzufuegen("Button", 1);
    simu.autoHinzufuegen("Hamilton", 2);
    simu.rennstart();
  }
}
