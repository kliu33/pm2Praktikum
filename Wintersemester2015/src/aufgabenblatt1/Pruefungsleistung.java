package aufgabenblatt1;
/**
 * Eine Klasse, die eine Pruefungsleistung( Note und Modul) repräsentiert.
 * @author wilhelm
 *
 */
public class Pruefungsleistung {

  /**
   * Ein Modul
   */
  private String modul;
  
  /**
   * Die erhaltene Note in dem Modul
   */
  private int note;
  
  /**
   * Konstruktor
   * @param Note und Modul
   */
  public Pruefungsleistung(String modul,int note){
    this.modul=modul;
    this.note=note;
  }

  public String getModul() {
    return modul;
  }

  public int getNote() {
    return note;
  }
  
}
