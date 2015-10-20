package aufgabenblatt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStudent {

  /**
   * Teststudent
   */
  Student student1 = new Student("Peter", "Platzhalter", 87654321);
  
  /**
   * Teststudent
   */
  Student student2 = new Student("Max", "Mustermann", 12345678);
  
  /**
   * Teststudent
   */
  Student student3 = new Student("Anna", "Mustermann", 42345678);

  /**
   * Matrikelnummer des Arguments kleiner
   */
  @Test
  public void TestCompareto() {
    assertEquals("Fehler beim Vergleichen", student1.compareTo(student2), 1);
  }

  /**
   * Matrikelnummer des Arguments größer
   */
  @Test
  public void TestCompareto_2() {
    assertEquals("Fehler beim Vergleichen", student2.compareTo(student1), -1);
  }

  /**
   * Max alphabetisch vor Peter
   */
  @Test
  public void TestComparator() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student1, student2) > 0);
  }

  /**
   * Argumente vertauscht
   */
  @Test
  public void TestComparator_2() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student2, student1) < 0);
  }

  /**
   * gleicher Nachname
   */
  @Test
  public void TestComparator_3() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student2, student3) > 0);
  }

  /**
   * null
   */
  @Test
  public void TestComparator_4() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(null, null) == 0);
  }

}
