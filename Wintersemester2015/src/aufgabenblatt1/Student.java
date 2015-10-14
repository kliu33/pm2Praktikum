package aufgabenblatt1;

import java.util.ArrayList;

/**
 * Eine Klasse, die einen Studenten repräsentiert.
 * @author wilhelm
 *
 */
public class Student implements Comparable<Student> {
  
  /**
   * Vorname des Studenten
   */
  private String vorname;
  
  /**
   * Nachname der Studenten
   */
  private String nachname;
  
  public String getVorname() {
    return vorname;
  }

  public String getNachname() {
    return nachname;
  }

  /**
   * Matrikelnummer des Studenten
   */
  private int matrikelnummer;
  
  /**
   * Eine Liste aus Noten und dem zugehörigen Modul.
   */
  private ArrayList<Pruefungsleistung> notenliste = 
      new ArrayList<Pruefungsleistung>();
  
  /**
   * Konstruktor
   * @param
   * ..
   */
  public Student(String vorname,String nachname,int matrikelnummer){
    this.vorname= vorname;
    this.nachname=nachname;
    this.matrikelnummer= matrikelnummer;
    notenliste = null;
  }

  /**
   * Vergleicht zwei Stundenten nach Matrikelnumer
   * @return
   */
  @Override
  public int compareTo(Student andererStudent) {
    if (matrikelnummer > andererStudent.matrikelnummer){
      return 1;
    }
     if (andererStudent.matrikelnummer> matrikelnummer) {
       return -1;
    }
     return 0;
  }
  

}
