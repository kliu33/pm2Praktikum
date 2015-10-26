package aufgabenblatt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testklasse für ArrayListe.
 * @author wilhelm
 *
 */
public class ArraylisteTest {

  @Test
  public void hinzufuegenTest() {
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    zahlenliste.hinzufuegen(5);
    assertEquals("Fehler beim Hinzufuegen!", (int) zahlenliste.get(0), 5);

    ArrayListe<String> wortliste = new ArrayListe<String>();
    wortliste.hinzufuegen("Testwort");
    assertEquals("Fehler beim Hnzufuegen!", (String) wortliste.get(0),
        "Testwort");
  }

  @Test
  public void entfernenTest() {
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    zahlenliste.entfernen(15);
    try {
      zahlenliste.get(0);
      assertTrue("Es wurde keine Exception geworfen", false);
    } catch (IndexOutOfBoundsException e) {
      // Alles richtig Exception wurde geworfen
    } finally {
      zahlenliste.hinzufuegen(5);
      zahlenliste.hinzufuegen(8);
      zahlenliste.hinzufuegen(546);
      zahlenliste.entfernen(8);
      assertEquals("Entfernen funktioniert nicht", "5\n546\n",
          zahlenliste.toString());
    }
  }

  @Test
  public void entferneElementAnIndexTest() {
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    zahlenliste.entferneElementAnIndex(0);
    try {
      zahlenliste.get(0);
      assertTrue("Es wurde keine Exception geworfen", false);
    } catch (IndexOutOfBoundsException e) {
      // Alles richtig Exception wurde geworfen
    } finally {
      zahlenliste.hinzufuegen(5);
      zahlenliste.hinzufuegen(8);
      zahlenliste.hinzufuegen(546);
      zahlenliste.entferneElementAnIndex(1);
      assertEquals("Entfernen am Index funktioniert nicht", "5\n546\n",
          zahlenliste.toString());
    }
  }

  @Test
  public void getAnzahlElementeTest() {
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    assertEquals("Fehler bei Anzahl der Elemente!", 0,
        zahlenliste.getAnzahlElemente());
    zahlenliste.hinzufuegen(5);
    zahlenliste.hinzufuegen(8);
    zahlenliste.hinzufuegen(546);
    assertEquals("Fehler bei Anzahl der Elemente!", 3,
        zahlenliste.getAnzahlElemente());
  }

  @Test
  public void toStringTest() {
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    zahlenliste.hinzufuegen(5);
    zahlenliste.hinzufuegen(8);
    assertEquals("toString funktioniert nicht!", "5\n8\n",
        zahlenliste.toString());
  }

  @Test
  public void getKleinstesElementTest() {
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    assertEquals("Fehler bei getKleinstesElement!",
        zahlenliste.getKleinstesElement(), null);
    zahlenliste.hinzufuegen(5);
    zahlenliste.hinzufuegen(8);
    zahlenliste.hinzufuegen(546);
    assertEquals("Fehler bei getKleinstesElement!",
        (int) zahlenliste.getKleinstesElement(), 5);
  }
  
  @Test
  public void  getKleinstesElementUpperboundTest(){
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
        zahlenliste.getKleinstesElementUpperbound(), null);
    zahlenliste.hinzufuegen(213);
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
       (int) zahlenliste.getKleinstesElementUpperbound(), 213);
    zahlenliste.hinzufuegen(21);
    zahlenliste.hinzufuegen(2);
    zahlenliste.hinzufuegen(1);
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
        (int) zahlenliste.getKleinstesElementUpperbound(),1);
    
    ArrayListe<String> wortliste = new ArrayListe<String>();
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
        wortliste.getKleinstesElementUpperbound(), null);
    wortliste.hinzufuegen("Bayern");
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
       (String) wortliste.getKleinstesElementUpperbound(), "Bayern");
    wortliste.hinzufuegen("Dortmund");
    wortliste.hinzufuegen("Leverkusen");
    wortliste.hinzufuegen("Mainz");
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
        (String) wortliste.getKleinstesElementUpperbound(), "Bayern");
    wortliste.hinzufuegen("Aachen");
    assertEquals("Fehler bei getKleinstesElementUpperbound!",
        (String) wortliste.getKleinstesElementUpperbound(), "Aachen");
  }
  
  @Test
  public void summeBerechnenTest(){
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    assertEquals("Fehler beim Summe berechnen!",0,zahlenliste.summeBerechnen());
    zahlenliste.hinzufuegen(21);
    zahlenliste.hinzufuegen(2);
    zahlenliste.hinzufuegen(1);
    assertEquals("Fehler beim Summe berechnen!",24,
        zahlenliste.summeBerechnen());
  }
  
  @Test
  public void istDasErsteElementEineZahlTest(){
    ArrayListe<Integer> zahlenliste = new ArrayListe<Integer>();
    assertEquals("Fehler bei ist eine Zahl",
        Main.istDasErsteElementEineZahl(zahlenliste),false);
    zahlenliste.hinzufuegen(21);
    zahlenliste.hinzufuegen(2);
    zahlenliste.hinzufuegen(1);
    assertTrue("Fehler bei ist eine Zahl",
        Main.istDasErsteElementEineZahl(zahlenliste));
    
    ArrayListe<String> wortliste = new ArrayListe<String>();
    wortliste.hinzufuegen("Dortmund");
    wortliste.hinzufuegen("Leverkusen");
    assertEquals("Fehler bei ist eine Zahl",
        Main.istDasErsteElementEineZahl(wortliste),false);
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}
