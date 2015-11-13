package aufgabenblatt2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Benutzereingabenfilter {

  public void bearbeiten() {

    Scanner scan = new Scanner(System.in);
    String eingabe = "";
    List<String> liste = new LinkedList<String>();

    while (!(eingabe.equals("ende"))) {
      System.out.println("Geben Sie ein Wort ein");
      eingabe = scan.nextLine();
      liste.add(eingabe);
    }

    scan.close();

    liste = liste
        .stream()
        .filter(name -> name != null)
        .map(name -> name.trim().toUpperCase())
        .map(name -> name.replaceAll("Ä", "AE").replaceAll("Ö","OE").
            replaceAll("Ü", "UE").replaceAll("ß", "SS"))
        .map(name ->  name.length() > 8 ? name.substring(0,8) : name)
        .collect(Collectors.toList());
    liste.forEach(System.out::print);
  }

  public static void main(String[] args) {
    Benutzereingabenfilter filter = new Benutzereingabenfilter();
    filter.bearbeiten();
  }
}
