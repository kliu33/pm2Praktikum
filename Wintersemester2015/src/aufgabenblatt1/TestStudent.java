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
  public void TestCompareto2() {
    assertEquals("Fehler beim Vergleichen", student2.compareTo(student1), -1);
  }
  
  /**
   * null testen
   */
  @Test
  public void TestCompareto3() {
    try{
      student2.compareTo(null);
      assertTrue("Fehler bei NUll",false);
    }catch(NullPointerException e){
     // Alles richtig(Exception wurde geworfen)
    } 
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
  public void TestComparator2() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student2, student1) < 0);
  }

  /**
   * gleicher Nachname
   * student 3 alphabetisch vorne
   */
  @Test
  public void TestComparator3() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(student2, student3) > 0);
  }

  /**
   * null
   */
  @Test
  public void TestComparator4() {
    assertTrue("Fehler beim Vergleichen(Comparator)",
        new StudentenComparator().compare(null, null) == 0);
  }

}
