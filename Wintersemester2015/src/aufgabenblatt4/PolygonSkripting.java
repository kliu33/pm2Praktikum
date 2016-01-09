package aufgabenblatt4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wertet Kommandos aus.
 * @author Wilhelm und Mona
 *
 */
public class PolygonSkripting {

  /**
   * Die X-Koordinate aus dem Befehl
   */
  private int x;

  /**
   * Die y-Koordinate aus dem Befehl
   */
  private int y;

  /**
   * Der zu untersuchende Text
   */
  private String text;

  /**
   * Der reguläre Ausdruck
   */
  private Pattern pattern;

  /**
   * Das Kommando aus dem Befehl.
   */
  private String kommando;

  /**
   * Konstruktor
   * 
   * @param text
   *          Der zu untersuchende Text
   */
  public PolygonSkripting(String text) {
    pattern = Pattern.compile("([A-Za-z]+)\\s->\\s([0-9]+),([0-9]+)");
    this.text = text;
    kommando = "Kein Kommando";
  }

  /**
   * Wertet den Text aus.
   */
  public void bearbeiten() {
    Matcher matcher = pattern.matcher(text);

    if (matcher.matches()) {
      x = Integer.parseInt(matcher.group(2));
      y = Integer.parseInt(matcher.group(3));
      kommando = matcher.group(1);
    } else {
      System.out.println("Kein Gültiges Kommando " + text);
    }
  }

  /**
   * überprüft den text
   * 
   * @return true wenn der text zum regex passt
   */
  public boolean gueltig() {
    return pattern.matcher(text).matches();
  }

  /**
   * Getter
   * 
   * @return das kommando
   */
  public String getKommando() {
    return kommando;
  }

  /**
   * Getter
   * 
   * @return x
   */
  public int getX() {
    return x;
  }

  /**
   * Getter
   * 
   * @return y
   */
  public int getY() {
    return y;
  }
}
