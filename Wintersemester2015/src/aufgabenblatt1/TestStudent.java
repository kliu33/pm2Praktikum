package aufgabenblatt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStudent {
  
  Student student1 = new Student("Peter", "Platzhalter",87654321);
  Student student2 = new Student("Max", "Mustermann",12345678);

  @Test
  public void TestCompareto(){
    assertEquals("Fehler beim Sortieren",student1.compareTo(student2),1);
  }
  
  @Test
  public void TestComparator(){
    assertTrue("132",new StudentenComparator().compare(student1, student2)>0);
  }
}
