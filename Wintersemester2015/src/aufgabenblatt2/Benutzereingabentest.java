package aufgabenblatt2;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

/**
 * Testklasse für den Stream
 * @author Mona und Wilhelm
 */
public class Benutzereingabentest {
  
  @Test
  public void streamTest(){
   Benutzereingabenfilter filter= new Benutzereingabenfilter();
   filter.worthinzufuegen("Eingabe");
   filter.bearbeiten();
   assertEquals("Fehler",filter.getWort(0),"EINGABE");
   filter.worthinzufuegen("Äußeres ");
   filter.bearbeiten();
   assertEquals("Fehler",filter.getWort(1),"AEUSSERE");
   filter.worthinzufuegen(null);
   filter.worthinzufuegen("Strassen-Feger");
   filter.bearbeiten();
   assertEquals("Fehler",filter.getWort(2),"STRASSEN");
   filter.worthinzufuegen("ein Haus");
   filter.bearbeiten();
   assertEquals("Fehler",filter.getWort(3),"EIN HAUS");
  }
}
