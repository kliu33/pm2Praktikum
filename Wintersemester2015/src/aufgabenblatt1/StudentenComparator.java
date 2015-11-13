package aufgabenblatt1;

import java.util.Comparator;

/**
 * Vergleicht zwei Studenten.
 * 
 * @author Mona Lüdemann und Wilhelm Schumacher
 *
 */
public class StudentenComparator implements Comparator<Student> {

  /**
   * Vergleicht zwei Studenten nach Nachname und Vorname.
   * 
   * @return ein Wert kleiner 0 wenn erstes Argument im Lexikon vor dem zweiten
   *         Argument 0 wenn gleich ein Wert größer 0 wenn zweites Argument vor
   *         dem ersten
   */
  @Override
  public int compare(Student student, Student andererStudent)
      throws IllegalArgumentException {

    if (student == null || andererStudent == null) {
      throw new IllegalArgumentException();
    }

    int eingabe=student.getNachname().compareTo(andererStudent.getNachname());
    if (eingabe != 0) {
      return eingabe;
    }
    return student.getVorname().compareTo(andererStudent.getVorname());
  }
}
