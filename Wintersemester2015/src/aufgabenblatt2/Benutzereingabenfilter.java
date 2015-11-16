package aufgabenblatt2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Eine Klasse die Eingaben filtert.
 * @author Wilhelm und Mona 
 *
 */
public class Benutzereingabenfilter {

  /**
   * Eine Liste zur Repäsentation von Worten.
   */
  private List<String> liste = new LinkedList<String>();

  /**
   * Bearbeitet die Liste mit Hilfe eines Stream.
   */
  public void bearbeiten() {
    liste = liste
        .stream()
        .filter(name -> name != null)
        .map(name -> name.trim().toUpperCase())
        .map(
            name -> name.replaceAll("Ä", "AE").replaceAll("Ö", "OE")
                .replaceAll("Ü", "UE").replaceAll("ß", "SS"))
        .map(name -> name.length() > 8 ? name.substring(0, 8) : name)
        .collect(Collectors.toList());
    // liste.forEach(System.out::print);
  }

  /**
   * Wörter hinzufuegen
   * 
   * @param wort
   *          ein Wort
   */
  public void worthinzufuegen(String wort) {
    if (wort != null) {
      liste.add(wort);
    }
  }

  /**
   * Getter zum Testen
   * 
   * @param index
   *          des Elementes
   * @return ein Wort
   */
  public String getWort(int index) {
    if (liste.size() > index) {
      return liste.get(index);
    }
    return null;
  }
}
