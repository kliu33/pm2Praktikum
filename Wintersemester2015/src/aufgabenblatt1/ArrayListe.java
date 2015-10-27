package aufgabenblatt1;

/**
 * Die Klasse repräsentiert eine Arrayliste.
 * 
 * @author wilhelm
 *
 * @param <T>
 *          generischer Typ
 */
public class ArrayListe<T extends Comparable<T>> {

  /**
   * Anzahl der Elemente in der Liste.
   */
  private int anzahlElemente;

  /**
   * Ein Array, dass die Lsite repräsentiert.
   */
  private Object[] elemente;

  /**
   * Konstruktor
   */
  public ArrayListe() {
    anzahlElemente = 0;
    elemente = new Object[0];
  }

  /**
   * Die Methode fügt ein Element zur Liste hinzu. Null wird nicht zur Liste
   * hinzugefügt.
   * 
   * @param ein
   *          Element,dass zur Liste hinzugefügt werden soll.
   */
  public void hinzufuegen(T element) {

    if (element != null) {
      Object[] hilfsarray = new Object[elemente.length + 1];

      for (int i = 0; i < elemente.length; i++) {
        hilfsarray[i] = elemente[i];
      }
      hilfsarray[elemente.length] = element;
      elemente = hilfsarray;
      anzahlElemente = elemente.length;
    }
  }

  /**
   * Getter
   * 
   * @param index
   *          Index von den Element
   * @return Objekt des Types T
   */
  public T get(int index) throws IndexOutOfBoundsException {
    if (elemente.length < index) {
      throw new IndexOutOfBoundsException();
    }
    return (T) elemente[index];
  }

  /**
   * Entfernt die Elemente aus der Liste und verkleinert auch das Array wieder.
   * 
   * @param element
   *          Das Element das gelöscht werden soll.
   */
  public void entfernen(T element) {
    if (element != null) {
      for (int i = 0; i < elemente.length; i++) {
        if (elemente[i].equals(element)) {
          elemente[i] = null;
        }
      }
      nullEntfernen();
    }
  }

  /**
   * Entfernt Element aus der Liste und verkleinert die Liste.
   * 
   * @param index
   *          Index des Elementes,dass gelöscht werden soll.
   */
  public void entferneElementAnIndex(int index) {

    try {
      elemente[index] = null;
      nullEntfernen();
    } catch (IndexOutOfBoundsException e) {
    //  System.err.println("Ungültiger Index!\n");
    }
  }

  /**
   * Getter
   * 
   * @return Anzahl der Elemente in der Liste.
   */
  public int getAnzahlElemente() {
    return anzahlElemente;
  }

  /**
   * Informationen über die Liste
   * 
   * @return ein String, der die Liste beschreibt
   */
  public String toString() {
    String ausgabe = "";

    for (Object t : elemente) {
      if (t != null) {
        ausgabe = ausgabe + t.toString() + "\n";
      }
    }
    return ausgabe;
  }

  /**
   * funktioniert nur mit Zahlen.
   * 
   * @return liefet das kleinste Element bei Zahlen. ansonsten null(außer bei
   *         einem Element)
   */
  public T getKleinstesElement() {

    Integer kleinstesElement = 0;

    try{
     get(0); 
    }catch(Exception e){
      return null;
    }

    if (elemente[0] instanceof Number) {
      kleinstesElement = (int) elemente[0];
      for (int i = 0; i < elemente.length; i++) {
        if (((int) elemente[i]) < (int) kleinstesElement) {
          kleinstesElement = (int) elemente[i];
        }
      }
      return (T) kleinstesElement;
    }
    return (T) null;
  }

  /**
   * Liefert das kleinste Element für alle Klassen die Comparable
   * implementieren.
   * 
   * @return das kleinste Element in der Liste
   */
  public T getKleinstesElementUpperbound() {

    try{
      get(0);
     }catch(Exception e){
       return null;
     }

      T kleinstesElement = (T) elemente[0];
      for (int i = 0; i < elemente.length; i++) {
        if (kleinstesElement.compareTo((T) elemente[i]) > 0) {
          kleinstesElement = (T) elemente[i];
        } 
    }
      return kleinstesElement;
  }

  /**
   * Berechnet für eine Liste aus Integer-Zahlen die Summe.
   * 
   * @return die Summe aus Integern.
   */
  public int summeBerechnen() {
    
    try{
      get(0);
     }catch(Exception e){
       return 0;
     }
    
    int summe = 0;
    if (elemente[0] instanceof Integer) {
      for (int i = 0; i < elemente.length; i++) {
        summe = (int) elemente[i] + summe;
      }
      return summe;
    }
    System.err.println("Die Liste besteht nicht aus Integer-Zahlen.");
    return summe;
  }

  /**
   * interne Hilfsmethode
   * Verkleinert das Array an den Stellen mit null.
   */
  private void nullEntfernen() {

    int nullZaehler = 0;
    int arrayzaehler = 0;

    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i] == null) {
        nullZaehler++;
      }
    }
    Object[] hilfsarray = new Object[elemente.length - nullZaehler];

    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i] != null) {
        hilfsarray[arrayzaehler] = elemente[i];
        arrayzaehler++;
      }
    }
    elemente = hilfsarray;
    anzahlElemente = elemente.length;
  }

  /**
   * zum Testen
   * 
   * @param args
   *          Kommandozeilenparameter
   */
  public static void main(String[] args) {
//    ArrayListe<String> list = new ArrayListe<String>();
//
//    list.hinzufuegen("aachen");
//    list.hinzufuegen("aayern");
//    list.hinzufuegen("alachen");
//    list.hinzufuegen("ab");
//    // System.out.println(list.getAnzahlElemente());
//    System.out.println(list.toString());
//
//    // System.out.println(list.getAnzahlElemente());
//    System.out.println(list.toString());
//
//    // System.out.println(list.toString());
//    ArrayListe<Integer> liste = new ArrayListe<Integer>();
//    System.out.println(list.getKleinstesElementUpperbound());
//    liste.hinzufuegen(123);
//
//    liste.hinzufuegen(345);
//    liste.hinzufuegen(3);
//    // System.out.println(liste.toString());
//
//    // System.out.println(list.summeBerechnen());
//
//    // System.out.println(liste.getKleinstesElement());

  }
}
