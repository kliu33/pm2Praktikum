package aufgabenblatt1;

/**
 * Die Klasse repräsentiert eine Arrayliste.
 * 
 * @author wilhelm
 *
 * @param <T>
 *          generischer Typ
 */
public class ArrayListe<T> {

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
   * @param ein Element,dass zur Liste hinzugefügt werden soll.
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
  public T get(int index) {
    try {
      return (T) elemente[index];
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Ungültiger Index!+\n");
      return null;
    }
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
      System.err.println("Ungültiger Index!\n");
    }
  }

  /**
   * Getter
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
   * einem Element)
   */
  public T getKleinstesElement() {

    Integer kleinstesElement = 0;

    switch (elemente.length) {
    case 0:
      return null;
    case 1:
      return (T) elemente[0];
    default:
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
  }

  /**
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
    ArrayListe<String> list = new ArrayListe<String>();
    list.hinzufuegen("Bayern");
    list.hinzufuegen("Bayern");
    list.hinzufuegen("Bayer");
    list.hinzufuegen("Dortmund");
    System.out.println(list.getAnzahlElemente());
    System.out.println(list.toString());

    list.entferneElementAnIndex(0);
    list.entferneElementAnIndex(1);
    System.out.println(list.getAnzahlElemente());

    System.out.println(list.toString());
    ArrayListe<Integer> liste = new ArrayListe<Integer>();
    liste.hinzufuegen(123);
    liste.hinzufuegen(345);
    liste.hinzufuegen(3);
    System.out.println(liste.toString());
    System.out.println(liste.getKleinstesElement());

  }
}
