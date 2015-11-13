package aufgabenblatt1;
/**
 * Praktikum BTI2-PMP/01 WS 2015/2016
 * Gruppe: Wilhelm Schumacher(wilhelm.schumacher@haw-hamburg.de),
 *         Mona Lüdemann(mona.lüdemann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1-4   
 * Verwendete Quellen: keine     
 */

import java.util.ArrayList;

/**
 * Eine Klasse, die einen Studenten repräsentiert.
 * 
 * @author Mona Lüdemann und Wilhelm Schumacher
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
  
  /**
   * Matrikelnummer des Studenten blala
   */
  private int matrikelnummer;
  
  /**
   * Eine Liste aus Noten und dem zugehörigen Modul.
   */
  private ArrayList<Pruefungsleistung> notenliste = 
      new ArrayList<Pruefungsleistung>();
  
  /**
   * Konstruktor
   * @param vorname nachname matrikelnummer
   */
  public Student(String vorname,String nachname,int matrikelnummer){
    this.vorname= vorname;
    this.nachname=nachname;
    this.matrikelnummer= matrikelnummer;
  }
  
  /**
   * Konstruktor
   * @param vorname nachname matrikelnummer
   */
  public Student(String vorname,String nachname,int matrikelnummer,
      Pruefungsleistung leistung){
    this.vorname= vorname;
    this.nachname=nachname;
    this.matrikelnummer= matrikelnummer;
    notenliste.add(leistung);
  }
    
  /**
   * Getter
   * @return vorname
   */
  public String getVorname() {
    return vorname;
  }

  /**
   * Getter
   * @return nachname
   */
  public String getNachname() {
    return nachname;
  }
  
  /**
   * Fügt eine Pruefungsleistung zur Liste hinzu.
   * @param eine Pruefungsleistung
   */
  public void leistungHinzufuegen(Pruefungsleistung leistung){
    notenliste.add(leistung);
  }

  /**
   * Vergleicht zwei Stundenten nach Matrikelnumer
   * @return 0, wenn Matrikelnummer gleich
   *  1 wenn Matrikelnummer des Arguments kleiner
   *  -1 wenn Matrikelnummer des Arguments größer
   */
  @Override
  public int compareTo(Student andererStudent) throws IllegalArgumentException {
    
    if (andererStudent == null){
      throw new IllegalArgumentException();
    }
    
    if (matrikelnummer > andererStudent.matrikelnummer){
      return 1;
    }
     if (andererStudent.matrikelnummer> matrikelnummer) {
       return -1;
    }
     return 0;
  }
}
