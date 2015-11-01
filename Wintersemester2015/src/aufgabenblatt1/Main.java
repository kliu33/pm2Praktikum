package aufgabenblatt1;

/**
 * Eine Klasse für die static Methode.
 * 
 * @author Mona Lüdemann und Wilhelm Schumacher
 *
 */
public class Main {

  /**
   * Prüft ob das erste Element eine Zahl ist.
   * 
   * @param list
   *          eine Liste
   * @return true bei einer Zahl
   */
  public static boolean istDasErsteElementEineZahl(ArrayListe<?> list) {

    try{
      list.get(0);
     }catch(IndexOutOfBoundsException e){
       return false;
     }
    
    if (list.get(0) instanceof Number) {
      return true;
    }
    return false;
  }

}
