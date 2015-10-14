package aufgabenblatt1;

import java.util.Comparator;

/**
 * Vergleicht zwei Studenten.
 * @author wilhelm
 *
 */
public class StudentenComparator implements Comparator<Student> {

  /**
   * Vergleicht zwei Studenten nach Nachname und Vorname.
   * @return 1 wenn erstes Argument im Lexikon vor dem zweiten Argument
   * 0 wenn gleich
   * -1 wenn zweites Argument vor dem ersten
   */
  @Override
  public int compare(Student student, Student andererStudent) {
    if (student.getNachname().compareTo(andererStudent.getNachname())!=0){
      return student.getNachname().compareTo(andererStudent.getNachname());
    }
    return student.getVorname().compareTo(andererStudent.getVorname());
  }

}
