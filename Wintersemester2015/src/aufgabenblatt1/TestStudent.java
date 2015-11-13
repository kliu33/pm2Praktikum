package aufgabenblatt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testklasse
 * 
 * @author Mona Lüdemann und Wilhelm Schumacher
 *
 */
public class TestStudent {

  /**
   * Matrikelnummer des Arguments kleiner
   */
  @Test
  public void TestCompareto() {
    Student student1 = new Student("Peter", "Platzhalter", 87654321);
    Student student2 = new Student("Max", "Mustermann", 12345678);
    assertEquals("Fehler beim Vergleichen", student1.compareTo(student2), 1);
  }

  /**
   * Matrikelnummer des Arguments größer
   */
  @Test
  public void TestCompareto2() {
    Student student1 = new Student("Peter", "Platzhalter", 87654321);
    Student student2 = new Student("Max", "Mustermann", 12345678);
    assertEquals("Fehler beim Vergleichen", student2.compareTo(student1), -1);
  }

  /**
   * null testen
   */
  @Test
  public void TestCompareto3() {
    Student student2 = new Student("Max", "Mustermann", 12345678);
    try {
      student2.compareTo(null);
      assertTrue("Fehler bei NUll", false);
    } catch (IllegalArgumentException e) {
      // Alles richtig(Exception wurde geworfen)
    }
  }

  /**
   * Max alphabetisch vor Peter
   */
  @Test
  public void TestComparator() {
    Student student1 = new Student("Peter", "Platzhalter", 87654321);
    Student student2 = new Student("Max", "Mustermann", 12345678);
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student1, student2) > 0);
  }

  /**
   * Argumente vertauscht
   */
  @Test
  public void TestComparator2() {
    Student student1 = new Student("Peter", "Platzhalter", 87654321);
    Student student2 = new Student("Max", "Mustermann", 12345678);
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student2, student1) < 0);
  }

  /**
   * gleicher Nachname student 3 alphabetisch vorne
   */
  @Test
  public void TestComparator3() {
    Student student2 = new Student("Max", "Mustermann", 12345678);
    Student student3 = new Student("Anna", "Mustermann", 42345678);
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student2, student3) > 0);
  }

  /**
   * null
   */
  @Test
  public void TestComparator4() {
    try {
      new StudentenComparator().compare(null, null);
      assertTrue("Fehler beim Vergleichen(Comparator)", false);
    } catch (IllegalArgumentException e) {
    }
  }
}
